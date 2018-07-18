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
		
		System.out.println("< �� ü �� �� Ʈ >");
		System.out.println("==============================================================");
		System.out.println(" ������ȣ		��ǰ��ȣ	  	�����	  	â��");
		System.out.println("==============================================================");
		for(IoDTO dto1 : list)
		{	
			System.out.println(dto1);			
		}
		
		System.out.println();
	}
	
	public void insertIoProc() {

		System.out.println("��ǰ�ڵ带 �Է��ϼ���.");
		String pcode  = sc.nextLine();
		System.out.println("�ԡ���� ������ �Է��ϼ���.(+: �԰�, -: ���)");
		String io_amount = sc.nextLine();
		System.out.println("â�� ��ȣ�� �Է��ϼ���.");
		String storagecode = sc.nextLine();

		dto.setPcode(pcode);
		dto.setIo_amount(io_amount);
		dto.setStoragecode(storagecode);

		dao.insertIoProc(dto);
	}
	
	
	
}