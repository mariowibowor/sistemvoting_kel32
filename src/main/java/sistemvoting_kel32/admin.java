package sistemvoting_kel32;

public class admin {
    public static void mainadmin() {
        cekhasil();
    }

    static void cekhasil() {
        menu_utama main = new menu_utama();
        main.hasil();
    }
    static int ceknomor(Scanner nomor, String tipe) {
        int scan;
        Scanner cek = new Scanner(System.in);
        while (!cek.hasNextInt()) {
            System.out.println("Input yang anda masukkan tidak valid, coba lagi");
            System.out.print(tipe);
            cek.next();
        }
        scan = cek.nextInt();
        return scan;
    }
}
