package ders2;

public class Urunler {

//attributes or field
	private int id;
	private String name;

	//constructor
	public Urunler(int id, String name) {
		System.out.println("yapýcý blok çalýþtý");
		this.id = id;
		this.name = name;

	}

	//boþ constructor
	public Urunler() {

	}

//getter
	public int getId() {
		return id;
	}

//setter
	public void setId(int id) {
		// this._id = id; //this içinde bulunulan demek
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name; 
	}

}
