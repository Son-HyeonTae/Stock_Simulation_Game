package application;


public class Exchange extends StockGame {
	
	static public String company[] = {"", "�Ｚ����", "SK���̴н�", "NAVER", "������", "īī��"};
	
	void companyPrint() {
		for (int i=1; i<=5; i++) {
			System.out.println(i +"," + company[i]);
		}
		System.out.print("Choose company : ");
	}
	
	void howMuch() {
		System.out.print("How many stock you want? : ");
	}
}
