package ir.fassih.subtitlehandler.subtitle.loader;


import static ir.fassih.subtitlehandler.utils.StringUtils.hasText;

class DetectSubtitleLineIdState implements SubtitleLoaderState {

    static final DetectSubtitleLineIdState INSTANCE = new DetectSubtitleLineIdState();

    private DetectSubtitleLineIdState() {
    }

    @Override
    public void writeToState(SubtitleLoaderContext context, String line) {
        if( hasText(line) ) {
            Integer i = parse(line.trim());
            if( i != null ) {
                context.getCurrentLine().setId(i);
                context.setState(DetectSubtitleLineTimeState.INSTANCE);
            }
        }
    }

    private Integer parse(String line) {
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException ex) {
            return null;
        }
    }
}
