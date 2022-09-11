package ir.fassih.subtitlehandler.subtitle.model;

import java.util.ArrayList;
import java.util.List;

public class Subtitle {

    List<SubtitleLine> lines;

    public Subtitle() {
        lines = new ArrayList<>();
    }

    public List<SubtitleLine> getLines() {
        return lines;
    }

    public void setLines(List<SubtitleLine> lines) {
        this.lines = lines;
    }

}
