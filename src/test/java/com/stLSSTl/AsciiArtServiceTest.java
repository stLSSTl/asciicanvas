package com.stLSSTl;
import com.stLSSTl.asciicanvas.enums.BorderEnums;
import com.stLSSTl.asciicanvas.service.AsciiArtService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;

@Slf4j
public class AsciiArtServiceTest {

    @Test
    @DisplayName("测试生成ASCII艺术字")
    public void testGenerateAsciiArtWithStandardFont() throws IOException, NoSuchFieldException {
        String result1 = AsciiArtService.generateAsciiArt("AsciiCanvas", "larry3d", BorderEnums.THIN);
        log.info("\n【{}】\n{}",BorderEnums.THIN,result1);

        String result2 = AsciiArtService.generateAsciiArt("AsciiCanvas", "larry3d", BorderEnums.DOUBLE);
        log.info("\n【{}】\n{}",BorderEnums.DOUBLE,result2);

        String result3 = AsciiArtService.generateAsciiArt("AsciiCanvas", "larry3d", BorderEnums.BOLD);
        log.info("\n【{}】\n{}",BorderEnums.BOLD,result3);

        String result4 = AsciiArtService.generateAsciiArt("AsciiCanvas", "larry3d", BorderEnums.STAR);
        log.info("\n【{}】\n{}",BorderEnums.STAR,result4);

        String result5 = AsciiArtService.generateAsciiArt("AsciiCanvas", "larry3d", BorderEnums.ROUNDED);
        log.info("\n【{}】\n{}",BorderEnums.ROUNDED,result5);

        String result6 = AsciiArtService.generateAsciiArt("AsciiCanvas", "larry3d", BorderEnums.UNENABLED);
        log.info("\n【{}】\n{}",BorderEnums.UNENABLED,result6);
    }
}
