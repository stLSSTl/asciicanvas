package com.stLSSTl.asciicanvas.service;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


public class AsciiArtService {

    private static final Map<String, String> FONT_MAP = new HashMap<>();

    static {
        FONT_MAP.put("standard", "standard");
        FONT_MAP.put("larry3d", "larry3d.flf");
        FONT_MAP.put("doh", "doh.flf");
    }

    /**
     * 生成ASCII艺术字
     */
    public static String generateAsciiArt(String text, String font) {
        try {
            String fontName = FONT_MAP.getOrDefault(font.toLowerCase(), "standard");
            // 使用类路径资源加载字体文件
            InputStream fontStream = AsciiArtService.class.getClassLoader()
                    .getResourceAsStream("fonts/" + fontName);
            if (fontStream != null) {
                String asciiArt = FigletFont.convertOneLine(fontStream, text);
                return decorateAsciiArt(asciiArt);
            } else {
                // 如果字体文件不存在，使用默认字体
                String asciiArt = FigletFont.convertOneLine(text);
                return decorateAsciiArt(asciiArt);
            }
        } catch (IOException e) {
            return generateSimpleAscii(text);
        }
    }

    /**
     * 装饰ASCII艺术字（添加边框等）
     */
    private static String decorateAsciiArt(String asciiArt) {
        StringBuilder decorated = new StringBuilder();
        String[] lines = asciiArt.split("\n");

        // 添加上边框
        decorated.append("╔");
        for (int i = 0; i < getMaxLineLength(lines) + 2; i++) {
            decorated.append("═");
        }
        decorated.append("╗\n");

        // 添加内容
        for (String line : lines) {
            decorated.append("║ ").append(line);
            int padding = getMaxLineLength(lines) - line.length();
            for (int i = 0; i < padding; i++) {
                decorated.append(" ");
            }
            decorated.append(" ║\n");
        }

        // 添加下边框
        decorated.append("╚");
        for (int i = 0; i < getMaxLineLength(lines) + 2; i++) {
            decorated.append("═");
        }
        decorated.append("╝\n");

        return decorated.toString();
    }

    private static int getMaxLineLength(String[] lines) {
        int max = 0;
        for (String line : lines) {
            if (line.length() > max) {
                max = line.length();
            }
        }
        return max;
    }

    /**
     * 生成简单的ASCII艺术字（备选方案）
     */
    private static String generateSimpleAscii(String text) {
        StringBuilder result = new StringBuilder("\n");
        result.append("┌─────────────────────────────┐\n");
        result.append("│                             │\n");
        result.append("│   ").append(text);

        int padding = 25 - text.length();
        for (int i = 0; i < padding; i++) {
            result.append(" ");
        }
        result.append("│\n");
        result.append("│                             │\n");
        result.append("└─────────────────────────────┘\n");

        return result.toString();
    }
}