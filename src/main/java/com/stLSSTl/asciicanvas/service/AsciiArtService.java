package com.stLSSTl.asciicanvas.service;

import com.github.lalyos.jfiglet.FigletFont;
import com.stLSSTl.asciicanvas.common.BorderDecoration;
import com.stLSSTl.asciicanvas.enums.BorderEnums;
import com.stLSSTl.asciicanvas.enums.ColorEnums;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


public class AsciiArtService {

    private static final Map<String, String> FONT_MAP = new HashMap<>();
    private static final Map<String, String> BORDER_MAP = new HashMap<>();

    static {
        FONT_MAP.put("standard", "standard");
        FONT_MAP.put("larry3d", "larry3d.flf");
        FONT_MAP.put("doh", "doh.flf");
    }

    /**
     * 生成ASCII艺术字
     * text -> 内容
     * font -> 字体
     * border -> 边框
     */
    public static String generateAsciiArt(String text,
                                          String font,
                                          BorderEnums border,
                                          ColorEnums color) throws IOException, NoSuchFieldException {

        String fontName = FONT_MAP.getOrDefault(font.toLowerCase(), "standard");
        // 使用类路径资源加载字体文件
        InputStream fontStream = AsciiArtService.class.getClassLoader()
                .getResourceAsStream("fonts/" + fontName);
        return fontStream != null
                ? addColorToAsciiArt(decorateAsciiArt(FigletFont.convertOneLine(fontStream, text),border), color)
                : addColorToAsciiArt(decorateAsciiArt(FigletFont.convertOneLine(text),border), color);
    }

    /**
     * 装饰ASCII艺术字（添加边框等）
     */
    private static String decorateAsciiArt(String asciiArt,BorderEnums border) throws NoSuchFieldException {
        BorderDecoration borderDecoration = new BorderDecoration();
        switch (border.toString()) {
            case "THIN":
                borderDecoration.setTOP_LEFT("╔");
                borderDecoration.setHORIZONTAL("═");
                borderDecoration.setTOP_RIGHT("╗");
                borderDecoration.setVERTICAL("║");
                borderDecoration.setBOTTOM_LEFT("╚");
                borderDecoration.setBOTTOM_RIGHT("╝");
                borderDecoration.setPADDING(2);
                break;
            case "DOUBLE":
                borderDecoration.setTOP_LEFT("╔");
                borderDecoration.setHORIZONTAL("═");
                borderDecoration.setTOP_RIGHT("╗");
                borderDecoration.setVERTICAL("║");
                borderDecoration.setBOTTOM_LEFT("╚");
                borderDecoration.setBOTTOM_RIGHT("╝");
                borderDecoration.setPADDING(4);
                break;
            case "BLOCK":
                borderDecoration.setTOP_LEFT("█");
                borderDecoration.setHORIZONTAL("█");
                borderDecoration.setTOP_RIGHT("█");
                borderDecoration.setVERTICAL("█");
                borderDecoration.setBOTTOM_LEFT("█");
                borderDecoration.setBOTTOM_RIGHT("█");
                borderDecoration.setPADDING(6);
                break;
            case "ROUNDED":
                borderDecoration.setTOP_LEFT("╭");
                borderDecoration.setHORIZONTAL("─");
                borderDecoration.setTOP_RIGHT("╮");
                borderDecoration.setVERTICAL("│");
                borderDecoration.setBOTTOM_LEFT("╰");
                borderDecoration.setBOTTOM_RIGHT("╯");
                borderDecoration.setPADDING(3);
                break;
            case "BOLD":
                borderDecoration.setTOP_LEFT("┏");
                borderDecoration.setHORIZONTAL("━");
                borderDecoration.setTOP_RIGHT("┓");
                borderDecoration.setVERTICAL("┃");
                borderDecoration.setBOTTOM_LEFT("┗");
                borderDecoration.setBOTTOM_RIGHT("┛");
                borderDecoration.setPADDING(3);
                break;
            case "STAR":
                borderDecoration.setTOP_LEFT("*");
                borderDecoration.setHORIZONTAL("═");
                borderDecoration.setTOP_RIGHT("*");
                borderDecoration.setVERTICAL("|");
                borderDecoration.setBOTTOM_LEFT("*");
                borderDecoration.setBOTTOM_RIGHT("*");
                borderDecoration.setPADDING(4);
                break;
            default:
                borderDecoration.setTOP_LEFT(" ");
                borderDecoration.setHORIZONTAL(" ");
                borderDecoration.setTOP_RIGHT(" ");
                borderDecoration.setVERTICAL(" ");
                borderDecoration.setBOTTOM_LEFT(" ");
                borderDecoration.setBOTTOM_RIGHT(" ");
                borderDecoration.setPADDING(4);
                break;
        }
            String tl = borderDecoration.getTOP_LEFT();
            String tr = borderDecoration.getTOP_RIGHT();
            String hor = borderDecoration.getHORIZONTAL();
            String vert =borderDecoration.getVERTICAL();
            String bl = borderDecoration.getBOTTOM_LEFT();
            String br = borderDecoration.getBOTTOM_RIGHT();

            StringBuilder decorated = new StringBuilder();
            String[] lines = asciiArt.split("\n");

            // 添加上边框
            decorated.append(tl);
            for (int i = 0; i < getMaxLineLength(lines); i++) {
                decorated.append(hor);
            }
            decorated.append(tr).append("\n");

            // 添加内容
            for (String line : lines) {
                decorated.append(vert).append(line);
                int padding = getMaxLineLength(lines) - line.length();
                for (int i = 0; i < padding; i++) {
                    decorated.append(" ");
                }
                decorated.append(vert).append("\n");
            }

            // 添加下边框
            decorated.append(bl);
            for (int i = 0; i < getMaxLineLength(lines) ; i++) {
                decorated.append(hor);
            }
            decorated.append(br).append("\n");

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

    /**
     * 为ASCII艺术字添加颜色
     */
    private static String addColorToAsciiArt(String asciiArt, ColorEnums colorEnums) {
        String color = colorEnums.name();
        if (colorEnums == ColorEnums.DEFAULT
                ||color.isEmpty()
                || color.trim().isEmpty()
                || "DEFAULT".equalsIgnoreCase(color)) {
            return asciiArt;
        }

        try {
            ColorEnums colorEnum = ColorEnums.valueOf(color.toUpperCase());
            if (colorEnum != ColorEnums.DEFAULT) {
                return colorEnum.getCode() + asciiArt + "\u001B[0m"; // ANSI重置代码
            }
        } catch (IllegalArgumentException e) {
            // 如果颜色名称无效，返回原字符串
            System.err.println("无效的颜色名称: " + color + ", 使用默认颜色");
        }

        return asciiArt;
    }
}