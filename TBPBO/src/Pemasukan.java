// Kelas untuk transaksi pemasukan
import java.util.Date;

public class Pemasukan extends Keuangan {
    public Pemasukan(int id, String deskripsi, double jumlah, Date tanggal) {
        super(id, deskripsi, jumlah, tanggal); // Memanggil konstruktor superclass
    }

    @Override
    public void display() {
        // Menampilkan informasi pemasukan
        System.out.println("Pemasukan [ID: " + id + ", Deskripsi: " + deskripsi + ", Jumlah: " + jumlah + ", Tanggal: " + tanggal + "]");
    }
}
