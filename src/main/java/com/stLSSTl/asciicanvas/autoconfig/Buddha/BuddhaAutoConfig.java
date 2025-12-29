package com.stLSSTl.asciicanvas.autoconfig.Buddha;

import com.stLSSTl.asciicanvas.annotation.Buddha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.util.Map;

@Configuration
@ConditionalOnClass(Buddha.class)
@EnableConfigurationProperties(BuddhaProperties.class)
@Slf4j
public class BuddhaAutoConfig {

    @Autowired
    private ApplicationContext applicationContext;
    /**
     * 定义一个事件监听器，监听ApplicationReadyEvent 事件，即Spring Boot应用完全启动并准备接收请求时触发
     */
    @EventListener(ApplicationReadyEvent.class)
    public void printBuddhaOnStartup()  {
        boolean hasBuddhaAnnotation = false;
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(Buddha.class);
        for (Object bean : beansWithAnnotation.values()) {
            // 获取Bean原始类（跳过Spring代理类），核心修复点
            Class<?> originalClass = ClassUtils.getUserClass(bean);
            Buddha buddhaAnnotation = originalClass.getAnnotation(Buddha.class);
            if (buddhaAnnotation != null) {
                hasBuddhaAnnotation = true;
                break;
            }
        }
        if (!hasBuddhaAnnotation) {
            return;
        }

        // 捕获异常，避免方法中断（无日志输出）
        String cyberBuddha =
                "                      _oo0oo_                     \n" +
                        "                     o8888888o                    \n" +
                        "                     88' . '88                    \n" +
                        "                     (| -_- |)                    \n" +
                        "                     0\\  =  /0                    \n" +
                        "                   ___/`---'\\___                  \n" +
                        "                 .' \\\\|     |// '.                \n" +
                        "                / \\\\|||  :  |||// \\               \n" +
                        "               / _||||| -:- |||||_ \\              \n" +
                        "              |   | \\\\\\  -  /// |   |             \n" +
                        "              | \\_|  ''\\---/''  |_/ |             \n" +
                        "              \\ .-\\__  '-'  ___/-. /             \n" +
                        "            ___'. .'  /--.--\\  `. .'___           \n" +
                        "          .'' '<  `.___\\_<|>_/___.' >'  ''.       \n" +
                        "        | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |       \n" +
                        "        \\  \\ `_.   \\_ __\\ /__ _/   .-` /  /       \n" +
                        "    =====`-.____`.___ \\_____/___.-`___.-'=====    \n" +
                        "                      `=---='                     \n" +
                        "    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~    \n" +
                        "              菩提本无树  明镜亦非台              \n" +
                        "              本来无BUG   何必常修改              \n" +
                        "                                                  \n" +
                        "==================================================\n" +
                        "     ┌──────────────────────────────────────┐\n" +
                        "     │             赛 博 真 经               │\n" +
                        "     ├──────────────────────────────────────┤\n" +
                        "     │         • 代码如禅，静心则明            │\n" +
                        "     │         • 需求如水，顺势而为            │\n" +
                        "     │         • Bug如尘，拂之即去            │\n" +
                        "     │         • 架构如山，稳固不移            │\n" +
                        "     │         • 屏前坐禅，代码修行            │\n" +
                        "     │         • 编译起飞，运行极乐            │\n" +
                        "     └──────────────────────────────────────┘";
        log.info("\n{}",  cyberBuddha);
        log.info("✅Cyber Buddha Bless Your Code Successfully!");
        log.info("==============================================\n");
    }
}
