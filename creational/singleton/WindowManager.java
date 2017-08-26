public final class WindowManager {

    private static final WindowManager INSTANCE = new WindowManager();

    private WindowManager() {}

    public static WindowManager getInstance() {
        return INSTANCE;
    }

    // All other WindowManager methods...
}
