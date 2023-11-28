import java.util.Scanner;

// Class Karyawan
class Karyawan {
    private String nik;
    private String nama;
    private String jabatan;
    private int golongan;

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public int getGolongan() {
        return golongan;
    }

    public void setGolongan(int golongan) {
        this.golongan = golongan;
    }
}

// Class Manager yang merupakan subclass dari Karyawan
class Manager extends Karyawan {
    private int kehadiran;
    private float tunjanganGolongan;
    private float tunjanganJabatan;
    private float tunjanganKehadiran;

    public int getKehadiran() {
        return kehadiran;
    }

    public void setKehadiran(int kehadiran) {
        this.kehadiran = kehadiran;
    }

    public float tunjanganKehadiran(int hadir) {
        return hadir * 10000;
    }

    public float tunjanganJabatan(String jabatan) {
        if (jabatan.equals("Manager")) {
            return 2000000;
        } else if (jabatan.equals("Kabag")) {
            return 1000000;
        } else {
            return 0;
        }
    }

    public float tunjanganGolongan(int golongan) {
        switch (golongan) {
            case 1:
                return 500000;
            case 2:
                return 1000000;
            case 3:
                return 1500000;
            default:
                return 0;
        }
    }

    public float gajiTotal() {
        return tunjanganJabatan(getJabatan()) + tunjanganGolongan(getGolongan()) + tunjanganKehadiran(getKehadiran());
    }
}

public class PBOLat51 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input data karyawan dari user
        System.out.println("====Program Perhitungan Gaji Karyawan====");
        
        System.out.print("Masukkan NIK: ");
        String nik = scanner.nextLine();

        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan Golongan (1/2/3): ");
        int golongan = scanner.nextInt();

        // Membuang karakter baris baru yang tersisa
        scanner.nextLine();

        System.out.print("Masukkan Jabatan (Manager/Kabag): ");
        String jabatan = scanner.next();

        System.out.print("Masukkan Jumlah Kehadiran: ");
        int kehadiran = scanner.nextInt();

        // Membuat objek Manager
        Manager manager = new Manager();
        manager.setNik(nik);
        manager.setNama(nama);
        manager.setGolongan(golongan);
        manager.setJabatan(jabatan);
        manager.setKehadiran(kehadiran);

        // Menampilkan informasi karyawan
        System.out.println("\n====Hasil Perhitungan====");
        System.out.println("NIK         : " + manager.getNik());
        System.out.println("Nama        : " + manager.getNama());
        System.out.println("Golongan    : " + manager.getGolongan());
        System.out.println("Jabatan     : " + manager.getJabatan());

        // Menampilkan tunjangan golongan, tunjangan jabatan, tunjangan kehadiran, dan gaji total
        System.out.println("\n");
        System.out.println("TUNJANGAN GOLONGAN  : Rp. " + manager.tunjanganGolongan(manager.getGolongan()));
        System.out.println("TUNJANGAN JABATAN   : Rp. " + manager.tunjanganJabatan(manager.getJabatan()));
        System.out.println("TUNJANGAN KEHADIRAN : Rp. " + manager.tunjanganKehadiran(manager.getKehadiran()));
        System.out.println("\nGAJI TOTAL        : Rp. " + manager.gajiTotal());

        scanner.close();
    }
}
