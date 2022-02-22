package ders1;

public class HelloWorld {

	public static void main(String[] args) {

		System.out.println("hello");
		System.out.println("world");

		
		// de�i�kenler
		String calisanlar = "hatice";
		System.out.println(calisanlar);

		
		// veri tipleri
		int sayi = 7;
		double ondalik = 1.5;
		String yazi = "yaz�larda kullan�l�r";
		char karakter = '1'; // tek t�rnaklarla olmal�
		boolean dogruMu = false;

		System.out.println("int :" + sayi);
		System.out.println(dogruMu);

		
		// if else
		double ondalikSayi = 2.0;
		if (ondalikSayi > 2.1) {
			System.out.println("ondalik sayi k���kt�r");
		} else if (ondalikSayi != 2.0)

		{
			System.out.println("sayi e�it de�ildir");
		} else {
			System.out.println("e�ittir");
		}

		
		// switch case
		String gunler = "Sal�";

		switch (gunler) {

		case "Pazartesi":
			System.out.println("bug�n pazartesi");
			break;
		case "Sal�":
			System.out.println("bug�n Sal�");
			break;
		case "�ar�amba":
			System.out.println("bug�n �ar�amba");
			break;
		case "Per�embe":
			System.out.println("bug�n Per�embe");
			break;
		case "Cuma":
			System.out.println("bug�n Cuma");
			break;
		case "Cumartesi":
			System.out.println("bug�n Cumartesi");
			break;
		case "Pazar":
			System.out.println("bug�n Pazar");
			break;
		default:
			System.out.println("ge�ersiz g�n se�tiniz");
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
		System.out.println("do while �al��t�");

		
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
