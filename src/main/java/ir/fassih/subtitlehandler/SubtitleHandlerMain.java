package ir.fassih.subtitlehandler;

import ir.fassih.subtitlehandler.subtitle.SubtitleManager;

import java.time.Duration;

public class SubtitleHandlerMain {


    public static void main(String[] args) {

        SubtitleManager.shiftAllSubtitleForward("/hdd/movie/The Tale of Nokdu (2019) (copy)", Duration.ofSeconds(38));
    }
}
