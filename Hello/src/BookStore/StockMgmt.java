package BookStore;

import java.util.Scanner;

public class StockMgmt {

	StockDAO dao = new StockDAO();
	StockDTO dto = new StockDTO();

	Scanner sc = new Scanner(System.in);

	public void insertStockProc() {

		System.out.println("��ǰ�ڵ带 �Է��ϼ���.");
		String pcode  = sc.nextLine();
		System.out.println("â�� ��ȣ�� �Է��ϼ���.");
		String storagecode = sc.nextLine();

		dto.setPcode(pcode);
		dto.setStoragecode(storagecode);

		dao.insertStockProc(dto);

}
