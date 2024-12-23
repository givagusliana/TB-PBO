// Kelas utama untuk menjalankan program
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        KeuanganImpl keuanganService = new KeuanganImpl(); // Objek implementasi fitur CRUD
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                // Menu utama
                System.out.println("=== Sistem Pencatatan Keuangan ===");
                System.out.println("1. Tambah Catatan");
                System.out.println("2. Lihat Catatan");
                System.out.println("3. Update Catatan");
                System.out.println("4. Hapus Catatan");
                System.out.println("5. Keluar");
                System.out.print("Pilih menu: ");
                int menu = scanner.nextInt(); // Input menu pilihan
                scanner.nextLine(); // Membersihkan buffer

                // Eksekusi pilihan menu
                switch (menu) {
                    case 1 -> keuanganService.create(); // Tambah catatan
                    case 2 -> keuanganService.read(); // Lihat catatan
                    case 3 -> keuanganService.update(); // Update catatan
                    case 4 -> keuanganService.delete(); // Hapus catatan
                    case 5 -> {
                        System.out.println("Program selesai."); // Keluar program
                        return;
                    }
                    default -> System.out.println("Pilihan tidak valid."); // Pilihan tidak valid
                }
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage()); // Menangani kesalahan
        } finally {
            scanner.close(); // Menutup scanner
        }
    }
}