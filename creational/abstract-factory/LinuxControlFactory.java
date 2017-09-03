public class LinuxControlFactory extends ControlFactory {

    public Control createControl(Control.Type type) {
        switch (type) {
            case Button: return new LinuxButton();
            case ComboBox: return new LinuxComboBox();
            case ProgressBar: return new LinuxProgressBar();
            default: throw new IllegalStateException();
        }
    }
}

