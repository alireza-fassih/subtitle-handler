package ir.fassih.subtitlehandler.subtitle.loader;

import ir.fassih.subtitlehandler.subtitle.model.SubtitleLine;
import ir.fassih.subtitlehandler.utils.StringUtils;

class DetectSubtitleLineContent implements SubtitleLoaderState {

    private boolean firstLine;

    public DetectSubtitleLineContent() {
        firstLine = true;
    }

    @Override
    public void writeToState(SubtitleLoaderContext context, String line) {
        SubtitleLine currentLine = context.getCurrentLine();
        if(StringUtils.hasText(line)){
            if( firstLine ) {
                firstLine = false;
            } else {
                currentLine.appendContent("\n");
            }
            currentLine.appendContent(line);
        } else {
            context.captureCurrentLine();
            context.startNewLine();
            context.setState(DetectSubtitleLineIdState.INSTANCE);
        }
    }
}
