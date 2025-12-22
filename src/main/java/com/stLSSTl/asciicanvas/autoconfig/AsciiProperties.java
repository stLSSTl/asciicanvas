package com.stLSSTl.asciicanvas.autoconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "ascii")
public class AsciiProperties {
    /**
     * ASCII艺术字内容
     */
    private String content = "Spring Boot";

    /**
     * 字体类型
     */
    private String font = "standard";

    /**
     * 是否启用ASCII艺术字显示
     */
    private boolean enabled = true;

    /**
     * 颜色（未来扩展用）
     */
    private String color = "";

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}