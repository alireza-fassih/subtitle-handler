package ir.fassih.subtitlehandler.subtitle;

import ir.fassih.subtitlehandler.subtitle.model.Subtitle;
import ir.fassih.subtitlehandler.subtitle.model.SubtitleLine;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import static ir.fassih.subtitlehandler.subtitle.SubtitleConstants.TIME_FORMATTER;

@Slf4j
public class SubtitleExporter {

    private SubtitleExporter() {

    }

    public static void export(OutputStream stream, Subtitle subtitle) {
        try(OutputStreamWriter writer = new OutputStreamWriter(stream, StandardCharsets.UTF_8)) {
            writer.write('\ufeff');

            boolean start = true;
            for (SubtitleLine line: subtitle.getLines()) {
                if(start) {
                    start = false;
                } else {
                    writer.write("\n");
                }

                writer.write(line.getId() + "\n");
                writer.write(line.getStart().format(TIME_FORMATTER) + " --> " + line.getEnd().format(TIME_FORMATTER) + "\n");
                writer.write(line.getContent() + "\n");
            }

        } catch (IOException e) {
            log.error("cannot export subtitle", e);
            throw new IllegalArgumentException("cannot export subtitle", e);
        }
    }
}
