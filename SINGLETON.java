public class DatabaseManager {

    private static DatabaseManager singleInstance;

    private DatabaseManager() {
        System.out.println("Initializing connection to MongoDB...");
    }
    public static DatabaseManager getInstance() {
        if (singleInstance == null) {
            singleInstance = new DatabaseManager();
        }
        return singleInstance;
    }

    public void query(String sql) {
        System.out.println("Executing query: " + sql);
    }
}

public class Main {
    public static void main(String[] args) {

        DatabaseManager db1 = DatabaseManager.getInstance();
        db1.query("SELECT * FROM users");

        DatabaseManager db2 = DatabaseManager.getInstance();
        db2.query("SELECT * FROM leave_requests");

        if (db1 == db2) {
            System.out.println("Success: Only one database connection is active!");
        }
    }
}