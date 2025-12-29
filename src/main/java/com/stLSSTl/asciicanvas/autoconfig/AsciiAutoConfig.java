package com.stLSSTl.asciicanvas.autoconfig;
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

    /**
     * 定义一个事件监听器，监听ApplicationReadyEvent 事件，即Spring Boot应用完全启动并准备接收请求时触发
     */
    @EventListener(ApplicationReadyEvent.class)
    public void printAsciiArtOnStartup() throws IOException, NoSuchFieldException {
        //检查功能是否启用
        if (!asciiProperties.isEnabled()) {
            return;
        }

        String content = asciiProperties.getContent();
        String font = asciiProperties.getFont();
        BorderEnums border = asciiProperties.getBorder();
        ColorEnums color = asciiProperties.getColor();

        // 检查是否有@Ascii注解，如果有则覆盖配置
        //从Spring应用上下文中获取所有带有 @Ascii 注解的Bean，返回一个Map(spring容器Bean的名称 -> Bean实例对象)
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(Ascii.class);
        for (Object bean : beansWithAnnotation.values()) {
            Class<?> beanClass = bean.getClass();
            Ascii asciiAnnotation = beanClass.getAnnotation(Ascii.class);
            if (asciiAnnotation != null) {
                //如果注解中设置了 content 参数且不为空，则使用注解中的内容
                if (!asciiAnnotation.content().isEmpty()) {
                    content = asciiAnnotation.content();
                }
                if (!asciiAnnotation.font().isEmpty()) {
                    font = asciiAnnotation.font();
                }
                // 对边框进行处理
                if (asciiAnnotation.border() != BorderEnums.UNENABLED) {
                    border = asciiAnnotation.border();
                }
                // 新增颜色处理
                if (asciiAnnotation.color() != ColorEnums.DEFAULT) {
                    color = asciiAnnotation.color();
                }
                break;
            }
        }

        // 使用静态方法生成ASCII艺术字
        String asciiArt = AsciiArtService.generateAsciiArt(content, font, border,color);
        log.info("\n{}", asciiArt);
        log.info("✅Spring Boot Application Started Successfully!");
        log.info("==============================================\n");
    }
}