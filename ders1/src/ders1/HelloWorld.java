package ders1;

public class HelloWorld {

	public static void main(String[] args) {

		System.out.println("hello");
		System.out.println("world");

		
		// deðiþkenler
		String calisanlar = "hatice";
		System.out.println(calisanlar);

		
		// veri tipleri
		int sayi = 7;
		double ondalik = 1.5;
		String yazi = "yazýlarda kullanýlýr";
		char karakter = '1'; // tek týrnaklarla olmalý
		boolean dogruMu = false;

		System.out.println("int :" + sayi);
		System.out.println(dogruMu);

		
		// if else
		double ondalikSayi = 2.0;
		if (ondalikSayi > 2.1) {
			System.out.println("ondalik sayi küçüktür");
		} else if (ondalikSayi != 2.0)

		{
			System.out.println("sayi eþit deðildir");
		} else {
			System.out.println("eþittir");
		}

		
		// switch case
		String gunler = "Salý";

		switch (gunler) {

		case "Pazartesi":
			System.out.println("bugün pazartesi");
			break;
		case "Salý":
			System.out.println("bugün Salý");
			break;
		case "Çarþamba":
			System.out.println("bugün Çarþamba");
			break;
		case "Perþembe":
			System.out.println("bugün Perþembe");
			break;
		case "Cuma":
			System.out.println("bugün Cuma");
			break;
		case "Cumartesi":
			System.out.println("bugün Cumartesi");
			break;
		case "Pazar":
			System.out.println("bugün Pazar");
			break;
		default:
			System.out.println("geçersiz gün seçtiniz");
		}

		
		// for
		for (int i = 1; i < 5; i++) {
			System.out.println(i);
		}

		// while
		int i = 0;
		while (i < 10) {
			i += 2;
			System.out.println(i);
		}

		
		// do while
		int j = 0;
		do {
			System.out.println(j);
			j += 2;
		} while (j < 10);
		System.out.println("do while çalýþtý");

		
		// diziler
		String[] ogrenciler = new String[3];
		ogrenciler[0] = "hatice";
		ogrenciler[1] = "nur";
		ogrenciler[2] = "elif";

		for (int k = 0; k < ogrenciler.length; k++) {
			System.out.println(ogrenciler[i]);
		}

		for (String ogrenci : ogrenciler) {
			System.out.println(ogrenci);
		}
	}
}
