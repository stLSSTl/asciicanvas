package com.stLSSTl.asciicanvas;

import com.stLSSTl.asciicanvas.annotation.Ascii;
import com.stLSSTl.asciicanvas.annotation.Buddha;
import com.stLSSTl.asciicanvas.enums.BorderEnums;
import com.stLSSTl.asciicanvas.enums.ColorEnums;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Ascii(content = "shr1nk", font = "larry3d", border = BorderEnums.THIN, color = ColorEnums.RED)
//@Buddha
public class AsciiCanvasApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsciiCanvasApplication.class, args);
    }
}
