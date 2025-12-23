package com.stLSSTl;
import com.stLSSTl.asciicanvas.service.AsciiArtService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
@Slf4j
public class AsciiArtServiceTest {

    @Test
    @DisplayName("测试生成ASCII艺术字")
    public void testGenerateAsciiArtWithStandardFont() {
        String result = AsciiArtService.generateAsciiArt("shr1nk", "larry3d");
        log.info("\n{}",result);
    }
}
