package patterns;

public class SingletonPattern {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.logError("Error occurred!");

        logger = Logger.getInstance();
        logger.logInfo("Some info!");

        logger = Logger.getInstance();
        logger.logWarning("Some warning!");
    }
}

class Logger {
    private static Logger logger;
    private Logger() {
    }
    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }
    public void logInfo(String log) {
        System.out.println("Info => " + log);
    }

    public void logError(String log) {
        System.out.println("Error => " + log);
    }

    public void logWarning(String log) {
        System.out.println("Warning => " + log);
    }
}
