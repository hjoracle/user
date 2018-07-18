package CollectionTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import jxl.write.WriteException;

public class Employee {

	public static void main(String[] args) throws WriteException, IOException {
		
		EmployeeMgmt mgmt = new EmployeeMgmt();
		Scanner sc = new Scanner(System.in);

		int menu;
		while(true) {
			System.out.println("menu 선택하세요. 1:전체조회(조건), 2:단건조회 , 3:입력 ,4:수정, 5:전체조회(map), 6:종료, 7:리스트(커서)");
			menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				//전체리스트
				mgmt.empListProc();
				break;
			case 2: 
				//단건조회 
				mgmt.empDTOProc();
				break;
			case 3:
				//insert
				mgmt.insertEmpProc();
				break;
			case 4:
				//update
				mgmt.updateEmpProc();
				break;
			case 5:
				mgmt.empListMap();
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			case 7:
				mgmt.empListCursor();
				break;
			case 8:
				EmployeeDAO dao = new EmployeeDAO();
				dao.excelExport();
				break;

			}//end of switch

			
			
			
			//		EmployeeDAO dao = new EmployeeDAO();
			//		
			//		EmployeeDTO dto = dao.getEmpDTO("113");
			//		System.out.println(dto);

			//		List<EmployeeDTO> list = dao.getEmpList();
			//		
			//		for(EmployeeDTO dto : list )
			//			System.out.println(dto);
		}
	}

}//end of main
