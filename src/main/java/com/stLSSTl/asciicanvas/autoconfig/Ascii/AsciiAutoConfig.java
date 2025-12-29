package com.stLSSTl.asciicanvas.autoconfig.Ascii;

import com.stLSSTl.asciicanvas.annotation.Ascii;
import com.stLSSTl.asciicanvas.enums.BorderEnums;
import com.stLSSTl.asciicanvas.enums.ColorEnums;
import com.stLSSTl.asciicanvas.service.AsciiArtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.util.Map;

@Configuration
@ConditionalOnClass(Ascii.class)
@EnableConfigurationProperties(AsciiProperties.class)
@ConditionalOnProperty(prefix = "ascii", name = "enabled", havingValue = "true", matchIfMissing = true)
@Slf4j
public class AsciiAutoConfig {

    @Autowired
    private AsciiProperties asciiProperties;

    @Autowired
    private ApplicationContext applicationContext;

    @EventListener(ApplicationReadyEvent.class)
    public void printAsciiArtOnStartup() {
        // 检查功能是否启用
        if (!asciiProperties.isEnabled()) {
            return;
        }

        String content = asciiProperties.getContent();
        String font = asciiProperties.getFont();
        BorderEnums border = asciiProperties.getBorder();
        ColorEnums color = asciiProperties.getColor();

        boolean hasAsciiAnnotation = false;
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(Ascii.class);

        for (Object bean : beansWithAnnotation.values()) {
            // 获取Bean原始类（跳过Spring代理类），核心修复点
            Class<?> originalClass = ClassUtils.getUserClass(bean);
            Ascii asciiAnnotation = originalClass.getAnnotation(Ascii.class);

            if (asciiAnnotation != null) {
                // 覆盖配置文件属性
                content = !asciiAnnotation.content().isEmpty()
                        ? asciiAnnotation.content()
                        : content;

                font = !asciiAnnotation.font().isEmpty()
                        ? asciiAnnotation.font()
                        : font;

                border = asciiAnnotation.border() != BorderEnums.UNENABLED
                        ? asciiAnnotation.border()
                        : border;

                color = asciiAnnotation.color() != ColorEnums.DEFAULT
                        ? asciiAnnotation.color()
                        : color;

                hasAsciiAnnotation = true;
                break;
            }
        }

        if (!hasAsciiAnnotation) {
            return;
        }

        // 捕获异常，避免方法中断（无日志输出）
        try {
            String asciiArt = AsciiArtService.generateAsciiArt(content, font, border, color);
            // 仅保留核心ASCII打印和成功提示
            log.info("\n{}", asciiArt);
            log.info("✅Ascii Art Word Printed Successfully!");
            log.info("==============================================\n");
        } catch (IOException | NoSuchFieldException e) {
            // 异常静默处理（无日志输出）
        }
    }
}