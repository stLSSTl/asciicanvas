package com.stLSSTl.asciicanvas.annotation;

import com.stLSSTl.asciicanvas.enums.BorderEnums;
import org.springframework.context.annotation.Import;
import com.stLSSTl.asciicanvas.autoconfig.AsciiAutoConfig;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(AsciiAutoConfig.class)
public @interface Ascii {
    /**
     * ASCII艺术字内容
     */
    String content() default "";

    /**
     * 字体类型
     */
    String font() default "standard";

    /**
     *  边框类型，默认不启用
     */
    BorderEnums border() default BorderEnums.UNENABLED;

    /**
     * 是否启用，默认为true
     */
    boolean enabled() default true;
}