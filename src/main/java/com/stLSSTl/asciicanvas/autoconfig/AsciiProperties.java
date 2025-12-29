package com.stLSSTl.asciicanvas.autoconfig;

import com.stLSSTl.asciicanvas.enums.BorderEnums;
import com.stLSSTl.asciicanvas.enums.ColorEnums;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "ascii")
public class AsciiProperties {
    /**
     * ASCII艺术字内容
     */
    @Getter
    @Setter
    private String content = "Spring Boot";

    /**
     * 字体类型
     */
    @Getter
    @Setter
    private String font = "standard";

    /**
     * 边框类型
     */
    @Getter
    @Setter
    private BorderEnums border = BorderEnums.THIN;


    /**
     * 是否启用ASCII艺术字显示
     */
    @Getter
    @Setter
    private boolean enabled = true;

    /**
     * 颜色
     */
    @Getter
    @Setter
    private ColorEnums color = ColorEnums.DEFAULT ;// 默认不使用颜色

}