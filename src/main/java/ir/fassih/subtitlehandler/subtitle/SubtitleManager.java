package ir.fassih.subtitlehandler.subtitle;

import ir.fassih.subtitlehandler.subtitle.loader.SubtitleLoaderFacade;
import ir.fassih.subtitlehandler.subtitle.model.Subtitle;
import ir.fassih.subtitlehandler.utils.DirectoryAndFileUtils;
import lombok.extern.slf4j.Slf4j;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;

@Slf4j
public class SubtitleManager {

    private SubtitleManager() {

    }

    public static void shiftAllSubtitleForward(String dirPath, Duration duration) {
        for (File f : DirectoryAndFileUtils.getFilesWithExtension(dirPath, "srt")) {
            log.debug("find {}", f.getAbsolutePath());
            try {
                Subtitle sub = SubtitleLoaderFacade.loadFromInputStream(new FileInputStream(f));
                SubtitleShifter.plusTimes(sub, duration);
                String newSrt = f.getAbsolutePath()
                        .replace(DirectoryAndFileUtils.getFileExtension(f.getAbsolutePath()), "-resynced.srt");
                SubtitleExporter.export(new FileOutputStream(newSrt), sub);
            } catch (Exception e) {
                log.error("cannot parse file {}", f.getAbsolutePath(), e);
                throw new IllegalArgumentException("cannot parse file", e);
            }
        }
    }
}
