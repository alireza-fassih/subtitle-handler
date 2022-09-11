package ir.fassih.subtitlehandler.subtitle.loader;

import ir.fassih.subtitlehandler.subtitle.model.Subtitle;
import ir.fassih.subtitlehandler.subtitle.model.SubtitleLine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class SubtitleLoaderContext  {

    private SubtitleLoaderState state;

    private Subtitle subtitle;
    private SubtitleLine currentLine;

    public SubtitleLoaderContext() {
        state = DetectSubtitleLineIdState.INSTANCE;
        subtitle = new Subtitle();
        startNewLine();
    }

    public void readToken(String line) {
        state.writeToState(this, line);
    }

    void setState(SubtitleLoaderState state) {
        this.state = state;
    }

    SubtitleLine getCurrentLine() {
        return currentLine;
    }

    public Subtitle getSubtitle() {
        return subtitle;
    }

    public void captureCurrentLine() {
        subtitle.getLines().add(currentLine);
    }

    public final void startNewLine() {
        currentLine = new SubtitleLine();
    }
}
