// Kelas untuk transaksi pengeluaran
import java.util.Date;

public class Pengeluaran extends Keuangan {
    public Pengeluaran(int id, String deskripsi, double jumlah, Date tanggal) {
        super(id, deskripsi, jumlah, tanggal); // Memanggil konstruktor superclass
    }

    @Override
    public void display() {
        // Menampilkan informasi pengeluaran
        System.out.println("Pengeluaran [ID: " + id + ", Deskripsi: " + deskripsi + ", Jumlah: " + jumlah + ", Tanggal: " + tanggal + "]");
    }
}