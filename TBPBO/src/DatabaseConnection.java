// Kelas untuk mengatur koneksi database
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // URL koneksi ke database
    private static final String URL = "jdbc:mysql://localhost:3306/keuangan_db";
    private static final String USER = "root"; // Username database
    private static final String PASSWORD = ""; // Password database

    // Metode untuk mendapatkan koneksi ke database
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD); // Membuka koneksi ke database
        } catch (SQLException e) {
            throw new RuntimeException("Error saat koneksi ke database: " + e.getMessage()); // Menangani kesalahan koneksi
        }
    }
}