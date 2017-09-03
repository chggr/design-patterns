public interface Control {

    enum Type {
        Button,
        ProgressBar,
        ComboBox
    }

    void draw();
}
