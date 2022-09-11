package ir.fassih.subtitlehandler.subtitle.loader;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;
import java.util.Arrays;

import static ir.fassih.subtitlehandler.subtitle.SubtitleConstants.TIME_FORMATTER;

@Slf4j
class DetectSubtitleLineTimeState implements SubtitleLoaderState {

    static final DetectSubtitleLineTimeState INSTANCE = new DetectSubtitleLineTimeState();

    private DetectSubtitleLineTimeState() {

    }

    @Override
    public void writeToState(SubtitleLoaderContext context, String line) {
        log.debug("detecting time from line {}", line);
        String[] lines = line.split("\\-\\->");
        if(lines.length != 2)
            throw new IllegalArgumentException("time line should be contain \"-->\"");

        if(log.isDebugEnabled())
            log.debug("find token {}", Arrays.toString(lines));

        LocalTime start = parseTime(lines[0]);
        LocalTime endTime = parseTime(lines[1]);

        context.getCurrentLine().setStart(start);
        context.getCurrentLine().setEnd(endTime);
        context.setState(new DetectSubtitleLineContent());
    }


    private LocalTime parseTime(String line) {
        return LocalTime.parse(line.trim(), TIME_FORMATTER);
    }
}
