public enum Loggers implements Logger {

    FILE_LOGGER {
        public void debug(String message) {}
        public void info(String message) {}
        public void warning(String message) {}
        public void error(String message) {}
    },

    DATABASE_LOGGER {
        public void debug(String message) {}
        public void info(String message) {}
        public void warning(String message) {}
        public void error(String message) {}
    },

    NETWORK_LOGGER {
        public void debug(String message) {}
        public void info(String message) {}
        public void warning(String message) {}
        public void error(String message) {}
    }
}

