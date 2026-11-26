
import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/db_mahasiswa",
            "root",
            ""
        );
    }
}
