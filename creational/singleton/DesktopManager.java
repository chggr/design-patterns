public final class DesktopManager {

    private static class Holder {
        static final DesktopManager INSTANCE = new DesktopManager();
    }

    private DesktopManager() {}

    public static DesktopManager getInstance() {
        return Holder.INSTANCE;
    }

    // All other DesktopManager methods...
}

