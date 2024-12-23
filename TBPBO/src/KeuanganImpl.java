// Kelas implementasi untuk fitur CRUD
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class KeuanganImpl implements KeuanganInterface {
    private final Connection connection; // Objek koneksi ke database

    // Konstruktor untuk menginisialisasi koneksi
    public KeuanganImpl() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void create() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Masukkan jenis (1. Pemasukan, 2. Pengeluaran): ");
            int jenis = scanner.nextInt(); // Input jenis transaksi
            scanner.nextLine();
            System.out.print("Masukkan deskripsi: ");
            String deskripsi = scanner.nextLine(); // Input deskripsi
            System.out.print("Masukkan jumlah: ");
            double jumlah = scanner.nextDouble(); // Input jumlah transaksi
            scanner.nextLine();

            // Query SQL untuk menambahkan data keuangan
            String query = "INSERT INTO keuangan (jenis, deskripsi, jumlah, tanggal) VALUES (?, ?, ?, NOW())";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, jenis); // Menentukan jenis transaksi
                stmt.setString(2, deskripsi); // Menentukan deskripsi transaksi
                stmt.setDouble(3, jumlah); // Menentukan jumlah transaksi
                stmt.executeUpdate(); // Menjalankan query
                System.out.println("Catatan berhasil ditambahkan.");
            }
        } catch (Exception e) {
            System.out.println("Error saat menambahkan catatan: " + e.getMessage()); // Menangani kesalahan
        }
    }

    @Override
    public void read() {
        try {
            String query = "SELECT * FROM keuangan"; // Query untuk membaca semua data keuangan
            try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    int id = rs.getInt("id"); // Mendapatkan ID catatan
                    int jenis = rs.getInt("jenis"); // Mendapatkan jenis transaksi
                    String deskripsi = rs.getString("deskripsi"); // Mendapatkan deskripsi
                    double jumlah = rs.getDouble("jumlah"); // Mendapatkan jumlah
                    Date tanggal = rs.getDate("tanggal"); // Mendapatkan tanggal transaksi
                    
                    // Membuat objek berdasarkan jenis transaksi
                    if (jenis == 1) {
                        new Pemasukan(id, deskripsi, jumlah, tanggal).display();
                    } else {
                        new Pengeluaran(id, deskripsi, jumlah, tanggal).display();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error saat membaca catatan: " + e.getMessage()); // Menangani kesalahan
        }
    }

    @Override
    public void update() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Masukkan ID catatan yang akan diupdate: ");
            int id = scanner.nextInt(); // Input ID catatan
            scanner.nextLine();
            System.out.print("Masukkan deskripsi baru: ");
            String deskripsi = scanner.nextLine(); // Input deskripsi baru
            System.out.print("Masukkan jumlah baru: ");
            double jumlah = scanner.nextDouble(); // Input jumlah baru

            // Query SQL untuk mengupdate data keuangan
            String query = "UPDATE keuangan SET deskripsi = ?, jumlah = ? WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, deskripsi); // Mengatur deskripsi baru
                stmt.setDouble(2, jumlah); // Mengatur jumlah baru
                stmt.setInt(3, id); // Mengatur ID catatan
                stmt.executeUpdate(); // Menjalankan query
                System.out.println("Catatan berhasil diperbarui.");
            }
        } catch (Exception e) {
            System.out.println("Error saat memperbarui catatan: " + e.getMessage()); // Menangani kesalahan
        }
    }

    @Override
    public void delete() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Masukkan ID catatan yang akan dihapus: ");
            int id = scanner.nextInt(); // Input ID catatan

            // Query SQL untuk menghapus data keuangan
            String query = "DELETE FROM keuangan WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, id); // Mengatur ID catatan
                stmt.executeUpdate(); // Menjalankan query
                System.out.println("Catatan berhasil dihapus.");
            }
        } catch (Exception e) {
            System.out.println("Error saat menghapus catatan: " + e.getMessage()); // Menangani kesalahan
        }
    }
}
