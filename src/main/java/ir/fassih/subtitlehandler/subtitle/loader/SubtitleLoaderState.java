package ir.fassih.subtitlehandler.subtitle.loader;


interface SubtitleLoaderState {

    void writeToState(SubtitleLoaderContext context, String line);

}
