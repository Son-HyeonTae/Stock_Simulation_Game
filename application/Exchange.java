package application;


public class Exchange extends StockGame {
	
	static public String company[] = {"", "삼성전자", "SK하이닉스", "NAVER", "현대차", "카카오"};
	
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
