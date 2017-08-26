public final class DatabaseConnectionManager {

    private static volatile DatabaseConnectionManager INSTANCE;

    private DatabaseConnectionManager() {}

    public static DatabaseConnectionManager getInstance() {
        if (INSTANCE == null) {
            synchronized(DatabaseConnectionManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DatabaseConnectionManager();
                }
            }
        }
        return INSTANCE;
    }

    // All other DatabaseConnectionManager methods...
}
