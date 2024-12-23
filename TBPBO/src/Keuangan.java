// Kelas abstrak untuk mendefinisikan struktur data keuangan
import java.util.Date;

public abstract class Keuangan {
    protected int id; // ID catatan keuangan
    protected String deskripsi; // Deskripsi catatan keuangan
    protected double jumlah; // Jumlah transaksi
    protected Date tanggal; // Tanggal transaksi

    // Konstruktor untuk menginisialisasi atribut
    public Keuangan(int id, String deskripsi, double jumlah, Date tanggal) {
        this.id = id;
        this.deskripsi = deskripsi;
        this.jumlah = jumlah;
        this.tanggal = tanggal;
    }

    // Getter untuk ID
    public int getId() {
        return id;
    }

    // Getter untuk deskripsi
    public String getDeskripsi() {
        return deskripsi;
    }

    // Getter untuk jumlah
    public double getJumlah() {
        return jumlah;
    }

    // Getter untuk tanggal
    public Date getTanggal() {
        return tanggal;
    }

    // Metode abstrak untuk menampilkan data
    public abstract void display();
}