package ir.fassih.subtitlehandler.subtitle.model;

import java.time.LocalTime;

public class SubtitleLine {

    private int id;
    private LocalTime start;
    private LocalTime end;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void appendContent(String content) {
        if( this.content == null ) {
            this.content = "";
        }
        this.content += content;
    }
}
