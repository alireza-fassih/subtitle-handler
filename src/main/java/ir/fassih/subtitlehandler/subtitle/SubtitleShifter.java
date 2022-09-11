package ir.fassih.subtitlehandler.subtitle;

import ir.fassih.subtitlehandler.subtitle.model.Subtitle;
import ir.fassih.subtitlehandler.subtitle.model.SubtitleLine;

import java.time.Duration;

public class SubtitleShifter {

    private SubtitleShifter() {

    }


    public static void plusTimes(Subtitle subtitle, Duration duration) {
        for (SubtitleLine line: subtitle.getLines()) {
            line.setStart(line.getStart().plus(duration));
            line.setEnd(line.getEnd().plus(duration));
        }
    }

}
