public class OSXControlFactory extends ControlFactory {

    public Control createControl(Control.Type type) {
        switch (type) {
            case Button: return new OSXButton();
            case ComboBox: return new OSXComboBox();
            case ProgressBar: return new OSXProgressBar();
            default: throw new IllegalStateException();
        }
    }
}

