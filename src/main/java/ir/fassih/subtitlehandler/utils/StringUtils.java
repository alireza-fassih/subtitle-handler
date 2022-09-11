package ir.fassih.subtitlehandler.utils;

public class StringUtils {

    private StringUtils() {

    }



    public static boolean hasText(String line) {
        return line != null && !"".equals(line.trim());
    }
}
