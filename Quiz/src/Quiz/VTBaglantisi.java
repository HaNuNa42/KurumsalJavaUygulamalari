package Quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VTBaglantisi {

    static ResultSet rs; //resultset: Sorgumuzun sonucunda dönen dataları almak için kullanılır.
    static PreparedStatement prs;
    static Connection bag;   //Connection: Bu interface, bütün metotları ile veritabanına irtibat kurmak için kullanılır.
    static String url = "jdbc:mysql://localhost:3306/vtdeneme"; //mysql bizim yerel saat düzenine göre istediği için böyle uzun bir dönüştürme kodu kullanıldı. internette var
    static String vtadi = "vtdeneme";
    static String driver = "com.mysql.cj.jdbc.Driver";  //Driver: Bu interface, veritabanı ile iletişimi ele alır.
    static String vtkullaniciadi = "root";
    static String vtsifre = "hatice";
    static DefaultTableModel model;
    static ArrayList<KullaniciGetSet> kgetset;

    public static Connection baglantiAc() { //veritabanına bağlanmak için kullanılan kod bloğu
        try {

            Class.forName(driver).newInstance(); //jdbc sürücüsü yüklendi
            bag = DriverManager.getConnection(url, vtkullaniciadi, vtsifre); //DriverManager: Bu sınıf, veritabanı sürücülerinin listesini yönetir. bağlantı oluşturuldu
            Statement st = bag.createStatement(); //Statement: sorguyu veritabanında çalıştırma işlemini gerçekleştirmektedir.
            System.out.println("veritabanına bağlanıldı");

        } catch (Exception e) {
            System.out.println(e + " veritabanına bağlantı başarısız");
        }
        return bag;
    }

    public static void baglantiKapat() throws Exception {
        bag.close();
    }

    public static boolean kullanicikontrol(String kadi, String sifre) {
        baglantiAc();
        try {
            Statement st = bag.createStatement();
            System.out.println("kullanıcı sorgulanıyor");
            rs = st.executeQuery("SELECT * FROM vtdeneme.kullanicilar WHERE kadi='" + kadi + "' and sifre='" + sifre + "';");
            System.out.println("kullanıcı sorgulandı");

            if (rs.next()) {
                System.out.println("kullanıcı doğrulandı");

                Hosgeldiniz ac = new Hosgeldiniz();
                ac.setVisible(true);
            } else {
                System.out.println("geçersiz kullanıcı veya şifre, tekrar dene");
                JOptionPane.showMessageDialog(null, "Kullanıcı adı veya şifre geçersiz... Lütfen tekrar deneyiniz...", "ilk uygulama", JOptionPane.PLAIN_MESSAGE);
            }
            rs.close();
            st.close();
            return false;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public static void KullaniciEkle(String kadi, String sifre) {
        baglantiAc();
        try {
            System.out.println("kayıt ekleme için veritabanına bağlanıldı");

            String sql = "INSERT INTO vtdeneme.kullanicilar (adi,soyadi,kadi,sifre) VALUES (?,?,?,?)";
            prs = bag.prepareStatement(sql);
            prs.setString(1, kadi);
            prs.setString(4, sifre);

            int sonuc = prs.executeUpdate();
            if (sonuc == 0) {
                System.out.println(" kullanıcı eklenemedi");
                JOptionPane.showMessageDialog(null, "Kullanıcı Eklenemedi", "ilk uygulama", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Kullanıcı Eklendi", "ilk uygulama", JOptionPane.PLAIN_MESSAGE);
                System.out.println("kullanıcı eklendi");
            }

            baglantiKapat();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static ArrayList<KullaniciGetSet> KullaniciListele() throws SQLException {

        baglantiAc();
        try {
            Statement st = bag.createStatement();
            rs = st.executeQuery("SELECT * FROM kullanicilar");
            kgetset = new ArrayList<KullaniciGetSet>();

            while (rs.next()) {
                kgetset.add(new KullaniciGetSet(
                        rs.getInt("kid"),
                        rs.getString("kadi"),
                        rs.getString("sifre")));
            }
            System.out.println("kullanıcılar listelendi");
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("kullanıcılar bulunamadı tekrar dene");
            JOptionPane.showMessageDialog(null, "kullanıcılar bulunamadı Lütfen tekrar deneyiniz...", "ilk uygulama", JOptionPane.PLAIN_MESSAGE);

        }
        return kgetset;
       
    }

    public static boolean KullaniciSil(String kadi) throws SQLException {
        baglantiAc();
        try {
            String sql = "DELETE FROM kullanicilar WHERE kadi =?;";
            prs = bag.prepareStatement(sql);
            prs.setString(1, kadi);

            int sonuc = prs.executeUpdate();
            if (sonuc == 0) {
                System.out.println("kullanici silinemedi");
                JOptionPane.showMessageDialog(null, "kullanıcı silinemedi", "ilk uygulama", JOptionPane.PLAIN_MESSAGE);
            } else {
                System.out.println("kullanici silindi");
                JOptionPane.showMessageDialog(null, "kullanıcı silindi", "ilk uygulama", JOptionPane.PLAIN_MESSAGE);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public static boolean SifreGuncelle(int kid, String yeni) throws SQLException {
        baglantiAc();
        try {
            System.out.println("güncellemek için veritabanı açıldı");

            String sql = "UPDATE vtdeneme.kullanicilar SET sifre =? WHERE kid=?";
            prs = bag.prepareStatement(sql);
            prs.setString(1, yeni);
            prs.setInt(2, kid);

            int sonuc = prs.executeUpdate();
            if (sonuc == 0) {
                System.out.println("şifre güncellenmedi");
                JOptionPane.showMessageDialog(null, "kullanıcı güncellenemedi", "ilk uygulama", JOptionPane.PLAIN_MESSAGE);
            } else {
                System.out.println("şifre güncellendi");
                JOptionPane.showMessageDialog(null, "şifre güncellendi", "ilk uygulama", JOptionPane.PLAIN_MESSAGE);
            }
            baglantiKapat();
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

}
