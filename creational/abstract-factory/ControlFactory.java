public abstract class ControlFactory {

    public static ControlFactory getFactory(Style style) {
        switch (style) {
            case Windows: return new WindowsControlFactory();
            case Linux: return new LinuxControlFactory();
            case OSX: return new OSXControlFactory();
            default: throw new IllegalArgumentException();
        }
    }

    public abstract Control createControl(Control.Type type);
}

