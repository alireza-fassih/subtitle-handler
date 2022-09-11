package ir.fassih.subtitlehandler.subtitle;

import ir.fassih.subtitlehandler.subtitle.loader.SubtitleLoaderFacade;
import ir.fassih.subtitlehandler.subtitle.model.Subtitle;
import ir.fassih.subtitlehandler.utils.ResourceUtil;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class SubtitleExporterTest {


    @Test
    void  test_export() throws FileNotFoundException {
        InputStream stream = ResourceUtil.loadResource("subtitle-2.srt");
        Subtitle subtitle = SubtitleLoaderFacade.loadFromInputStream(stream);
        SubtitleShifter.plusTimes(subtitle, Duration.ofSeconds(38));

        SubtitleExporter.export(new FileOutputStream("out.srt"), subtitle);
    }

}