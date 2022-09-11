package ir.fassih.subtitlehandler.subtitle.loader;

import ir.fassih.subtitlehandler.subtitle.model.Subtitle;
import ir.fassih.subtitlehandler.utils.InputStreamUtils;

import java.io.InputStream;

public class SubtitleLoaderFacade {

    private SubtitleLoaderFacade() {

    }

    public static Subtitle loadFromInputStream(InputStream stream) {
        SubtitleLoaderContext context = new SubtitleLoaderContext();
        InputStreamUtils.read(stream, context::readToken);
        return context.getSubtitle();
    }

}
