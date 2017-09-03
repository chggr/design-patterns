public class WindowsControlFactory extends ControlFactory {

    public Control createControl(Control.Type type) {
        switch (type) {
            case Button: return new WindowsButton();
            case ComboBox: return new WindowsComboBox();
            case ProgressBar: return new WindowsProgressBar();
            default: throw new IllegalStateException();
        }
    }
}

