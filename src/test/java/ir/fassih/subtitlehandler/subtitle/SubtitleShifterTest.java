package ir.fassih.subtitlehandler.subtitle;

import ir.fassih.subtitlehandler.subtitle.loader.SubtitleLoaderFacade;
import ir.fassih.subtitlehandler.subtitle.model.Subtitle;
import ir.fassih.subtitlehandler.utils.ResourceUtil;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class SubtitleShifterTest {


    @Test
    void test_shift_forward() {
        InputStream stream = ResourceUtil.loadResource("subtitle-2.srt");
        Subtitle subtitle = SubtitleLoaderFacade.loadFromInputStream(stream);
        SubtitleShifter.plusTimes(subtitle, Duration.ofSeconds(38));

        assertEquals(7, subtitle.getLines().size());
    }

}