package ir.fassih.subtitlehandler.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Slf4j
public class InputStreamUtils {

    private InputStreamUtils() {

    }

    public static void read(InputStream stream, LineByLineHandler handler) {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
            while(true) {
                String line = buffer.readLine();
                if (line == null) {
                    break;
                }
                log.trace("reading line {}", line);
                handler.handle(line);
            }
        } catch (IOException e) {
            log.error("cannot read inputStream ", e);
            throw new IllegalArgumentException("cannot read input stream", e);
        }
    }
}
