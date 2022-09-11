package ir.fassih.subtitlehandler.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;

@Slf4j
public class ResourceUtil {

    private ResourceUtil() {

    }

    public static InputStream loadResource(String path) {
        log.debug("loading resource from {}", path);
        return ResourceUtil.class.getClassLoader().getResourceAsStream(path);
    }

}
