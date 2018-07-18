package BookStore;

import java.util.Scanner;

public class StockMgmt {

	StockDAO dao = new StockDAO();
	StockDTO dto = new StockDTO();

	Scanner sc = new Scanner(System.in);

	public void insertStockProc() {

		System.out.println("상품코드를 입력하세요.");
		String pcode  = sc.nextLine();
		System.out.println("창고 번호를 입력하세요.");
		String storagecode = sc.nextLine();

		dto.setPcode(pcode);
		dto.setStoragecode(storagecode);

		dao.insertStockProc(dto);

}
