package ders2;

public class Urunler {

//attributes or field
	private int id;
	private String name;

	//constructor
	public Urunler(int id, String name) {
		System.out.println("yap�c� blok �al��t�");
		this.id = id;
		this.name = name;

	}

	//bo� constructor
	public Urunler() {

	}

//getter
	public int getId() {
		return id;
	}

//setter
	public void setId(int id) {
		// this._id = id; //this i�inde bulunulan demek
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name; 
	}

}
