package sistemvoting_kel32;

public class admin {
    public static void mainadmin() {
        cekhasil();
    }

    static void cekhasil() {
        menu_utama main = new menu_utama();
        main.hasil();
    }
}