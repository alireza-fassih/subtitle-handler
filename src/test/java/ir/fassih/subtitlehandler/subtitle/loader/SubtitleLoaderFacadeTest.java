package ir.fassih.subtitlehandler.subtitle.loader;

import ir.fassih.subtitlehandler.subtitle.model.Subtitle;
import ir.fassih.subtitlehandler.utils.ResourceUtil;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class SubtitleLoaderFacadeTest {


    @Test
    void test_loadSubtitle_simpleOneLineSubtitle() {
        InputStream stream = ResourceUtil.loadResource("subtitle-1.srt");
        Subtitle subtitle = SubtitleLoaderFacade.loadFromInputStream(stream);

        assertEquals(1, subtitle.getLines().size());
    }


    @Test
    void test_loadSubtitle_withMultiLine() {
        InputStream stream = ResourceUtil.loadResource("subtitle-2.srt");
        Subtitle subtitle = SubtitleLoaderFacade.loadFromInputStream(stream);

        assertEquals(7, subtitle.getLines().size());
    }
}