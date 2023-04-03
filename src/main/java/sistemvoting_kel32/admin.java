package sistemvoting_kel32;

import java.util.Scanner;

public class admin {
    public static String[] Design = {
            "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~",
            "*************************************************************************",
            "-------------------------------------------------------------------------"};

    public static void mainadmin() {
        String keyusername = "admin";
        int keyPIN = 123;
        String username = "";
        int PIN = 0;
        int pilihan;
        int pilihan2 = 1;
        boolean ceklogin = login(PIN, keyPIN, username, keyusername);
        
        while (true) {
            if (ceklogin) {
                System.out.println(Design[2] + "\nApa yang akan Anda lakukan");
                System.out.println("1. Ubah username");
                System.out.println("2. Ubah PIN");
                System.out.println("3. Cek Hasil");
                System.out.println("4. Keluar Program");
                System.out.print("Input: ");
                Scanner pil = new Scanner(System.in);
                pilihan = ceknomor(pil, "Input: ");
                switch (pilihan) {
                    case 1:
                        System.out.print(Design[1] + "\nMasukkan username baru: ");
                        Scanner newusrnm = new Scanner(System.in);
                        keyusername = newusrnm.nextLine();
                        System.out.println("Username diubah menjadi " + keyusername);
                        break;
                    case 2:
                        keyPIN = newpin();
                        System.out.println("PIN diubah menjadi " + keyPIN);
                        break;
                    case 3:
                        cekhasil();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Pilihan Anda tidak valid, coba lagi");
                        break;
                }
            }
        }
    }

    static int newpin() {
        int newpin;
        System.out.print("Masukkan PIN baru: ");
        Scanner newp = new Scanner(System.in);
        while (!newp.hasNextInt()) {
            System.out.println("Input yang anda masukkan tidak valid, coba lagi");
            System.out.print("PIN baru: ");
            newp.next();
        }
        newpin = newp.nextInt();
        return newpin;
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

    static boolean login(int PIN, int keypin, String username, String keyusername) {
        System.out.println(Design[2] + "\nSelamat Datang Administrator");
        int percobaan = 2;
        while (true) {
            System.out.println(Design[2] + "\nSilahkan masukkan username dan PIN");
            System.out.print("Username: ");
            Scanner user = new Scanner(System.in);
            username = user.nextLine();
            System.out.print("PIN: ");
            Scanner pin = new Scanner(System.in);
            PIN = ceknomor(pin, "PIN: ");

            if (PIN == keypin && username.equals(keyusername)) {
                percobaan = 2;
                return true;
                } else {
                if (percobaan == 0) {
                    System.out.println(Design[2] + "\nKesempatan anda habis, program akan berhenti...\n" + Design[2]);
                    System.exit(0);
                    percobaan = 3;
                }
                System.out.println(Design[2] + "\nUsername/PIN salah, coba lagi, kesempatan anda " + percobaan + " kali lagi");
                percobaan--;
            }
        }
    }
}
