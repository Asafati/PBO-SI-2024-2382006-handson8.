import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private String dbName;
    private String username;
    private String password;
    private String host;
    private String port;
    private Connection connection;

    public Database(String dbName, String username, String password, String host, String port) {
        this.dbName = dbName;
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
    }

    public void setup() {
        try {
            // Memuat driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Menyusun URL koneksi
            String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;

            // Membuat koneksi
            this.connection = DriverManager.getConnection(url, username, password);

            System.out.println("Koneksi ke database berhasil!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
