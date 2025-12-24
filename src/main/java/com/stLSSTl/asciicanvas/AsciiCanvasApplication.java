package com.stLSSTl.asciicanvas;

import com.stLSSTl.asciicanvas.annotation.Ascii;
import com.stLSSTl.asciicanvas.enums.BorderEnums;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Ascii(content = "AsciiCanvas",border = BorderEnums.DOUBLE)
public class AsciiCanvasApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsciiCanvasApplication.class, args);
    }
}
