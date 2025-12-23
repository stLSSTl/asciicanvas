package com.stLSSTl.asciicanvas.autoconfig;

import lombok.Getter;
import lombok.Setter;
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

    private enum BorderStyle{
        THIN("╔", "═", "╗", "║", "╚", "╝", 2),      // 原始细边框
        DOUBLE("╔", "═", "╗", "║", "╚", "╝", 4),     // 加粗版
        BLOCK("█", "█", "█", "█", "█", "█", 6),      // 实心块
        ROUNDED("╭", "─", "╮", "│", "╰", "╯", 3),    // 圆角
        BOLD("┏", "━", "┓", "┃", "┗", "┛", 3),       // 粗线
        STAR("★", "═", "★", "│", "★", "★", 4);       // 星形装饰

        private final String topLeft;
        private final String horizontal;
        private final String topRight;
        private final String vertical;
        private final String bottomLeft;
        private final String bottomRight;
        private final int padding;

        BorderStyle(String tl, String h, String tr, String v, String bl, String br, int p) {
            this.topLeft = tl;
            this.horizontal = h;
            this.topRight = tr;
            this.vertical = v;
            this.bottomLeft = bl;
            this.bottomRight = br;
            this.padding = p;
        }

    }

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