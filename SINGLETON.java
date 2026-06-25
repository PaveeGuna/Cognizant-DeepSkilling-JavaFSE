public class Logger {
    private static Logger singleInstance;
    private Logger() {
        System.out.println("Logger initialized: Ready to record system events.");
    }
    public static Logger getInstance() {
        if (singleInstance == null) {
            singleInstance = new Logger();
        }
        return singleInstance;
    }
    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}