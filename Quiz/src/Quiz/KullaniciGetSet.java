
package Quiz;

/**
 *
 * @author Parthenia Nora
 */
public class KullaniciGetSet {
    
    //kullanıcıların sütunlarını tanımlanıyoruz.
    private int kid;
    private String kadi;
    private String sifre;

    public KullaniciGetSet(int kid, String kadi, String sifre) { //tanımladığımız sütunların constructor'ını tanımlıyoruz.
        this.kid = kid;
        this.kadi = kadi;
        this.sifre = sifre;
    }
    public int getkid() {
        return kid;
    }
    public void setkid(int kid) {
        this.kid = kid;
    }
    public String getkadi() {
        return kadi;
    }
    public void setkadi(String kadi) {
        this.kadi = kadi;
    }
    public String getsifre() {
        return sifre;
    }
    public void setsifre(String sifre) {
        this.sifre = sifre;
    } 
}
