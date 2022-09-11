package ir.fassih.subtitlehandler.utils;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DirectoryAndFileUtils {

    private DirectoryAndFileUtils() {

    }


    public static List<File> getFilesWithExtension(String path, String extension) {
        return DirectoryAndFileUtils.getFileList(path)
                .stream()
                .filter(f -> DirectoryAndFileUtils.hasExtension(f, extension))
                .collect(Collectors.toList());
    }


    public static List<File> getFileList(String path) {
        File file = new File(path);
        if( !file.isDirectory() ) {
            throw new IllegalArgumentException(path + " is not a directory");
        }

        return Arrays.asList(file.listFiles());
    }

    public static boolean hasExtension(File file, String extension) {
        return extension.equals(getFileExtension(file.getAbsolutePath()));
    }

    public static String getFileExtension(String path) {
        return  path.substring(path.lastIndexOf(".") + 1);
    }
}
