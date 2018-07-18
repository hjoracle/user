package BookStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.swing.plaf.synth.SynthSplitPaneUI;

import CollectionTest.EmployeeDTO;
import CollectionTest.SearchVO;

public class IoMgmt {

	IoDAO dao = new IoDAO();
	IoDTO dto = new IoDTO();

	Scanner sc = new Scanner(System.in);

	public void getIoList() {
		
		List<IoDTO> list = dao.getIoList();
		
		System.out.println("< 전 체 리 스 트 >");
		System.out.println("==============================================================");
		System.out.println(" 입출고번호		상품번호	  	입출고량	  	창고");
		System.out.println("==============================================================");
		for(IoDTO dto1 : list)
		{	
			System.out.println(dto1);			
		}
		
		System.out.println();
	}
	
	public void insertIoProc() {

		System.out.println("상품코드를 입력하세요.");
		String pcode  = sc.nextLine();
		System.out.println("입·출고 수량을 입력하세요.(+: 입고, -: 출고)");
		String io_amount = sc.nextLine();
		System.out.println("창고 번호를 입력하세요.");
		String storagecode = sc.nextLine();

		dto.setPcode(pcode);
		dto.setIo_amount(io_amount);
		dto.setStoragecode(storagecode);

		dao.insertIoProc(dto);
	}
	
	
	
}