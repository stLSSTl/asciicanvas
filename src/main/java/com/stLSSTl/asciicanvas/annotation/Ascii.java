package com.stLSSTl.asciicanvas.annotation;

import com.stLSSTl.asciicanvas.autoconfig.Ascii.AsciiAutoConfig;
import com.stLSSTl.asciicanvas.enums.BorderEnums;
import com.stLSSTl.asciicanvas.enums.ColorEnums;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * ASCII艺术字自动配置注解
 * 标注该注解的Spring Bean会触发ASCII艺术字打印功能，同时自动导入对应的自动配置类
 */
@Target(ElementType.TYPE)          // 注解作用目标：类、接口、枚举等
@Retention(RetentionPolicy.RUNTIME) // 注解保留至运行时，支持反射获取属性值
@Documented                        // 生成JavaDoc文档时，包含该注解信息
@Import(AsciiAutoConfig.class)      // 保留：标注该注解时，自动导入自动配置类，无需手动扫描
public @interface Ascii {
    /**
     * ASCII艺术字核心内容
     * 说明：若该值不为空，会覆盖配置文件中ascii.content的配置
     */
    String content() default "";

    /**
     * 字体类型（默认：standard 标准字体）
     * 说明：若该值不为空，会覆盖配置文件中ascii.font的配置
     */
    String font() default "standard";

    /**
     * 边框类型（默认：UNENABLED 不启用边框）
     * 说明：若该值不是UNENABLED，会覆盖配置文件中ascii.border的配置
     */
    BorderEnums border() default BorderEnums.UNENABLED;

    /**
     * 功能启用开关（默认：true 启用功能）
     * 说明：该属性可覆盖配置文件中ascii.enabled的配置（需在AsciiAutoConfig中补充逻辑使用）
     */
    boolean enabled() default true;

    /**
     * 字体颜色（默认：DEFAULT 默认控制台颜色）
     * 说明：若该值不是DEFAULT，会覆盖配置文件中ascii.color的配置
     */
    ColorEnums color() default ColorEnums.DEFAULT;
}