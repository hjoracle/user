package CollectionTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class EmployeeMgmt {
	
	EmployeeDAO dao = new EmployeeDAO();
	EmployeeDTO dto = new EmployeeDTO();
	
	Scanner sc = new Scanner(System.in);
	
	public void empListProc() {
				
		SearchVO vo = new SearchVO();
		vo.setSearchCondition("hire_date");
		vo.setSearchKeyword("19870101");
		List<EmployeeDTO> list = dao.getEmpList(vo);
		
		System.out.println("                     		       < 전 체 리 스 트 >                                                ");
		System.out.println("◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇");
		System.out.println(" empNo	FirstName	LastName	Email		Job		Date");
		System.out.println("◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇");
		for(EmployeeDTO dto1 : list)
		{	
			System.out.println(dto1);
			System.out.println("---------------------------------------------------------------------------------------------");
		}
		
		System.out.println("◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇");
		System.out.println();
	}
	
	public void empDTOProc() {
		
		System.out.println("조회할 사원번호를 입력하세요.");
		String empNo = sc.nextLine();
		EmployeeDTO dto2 = dao.getEmpDTO(empNo);
		System.out.println("                     		        < 단 건 조 회 >                                                 ");
		System.out.println("ㅁ");
		System.out.println(" empNo	FirstName	LastName	Email		Job		Date");
		System.out.println("◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇");
		System.out.println(dto2);
		
		System.out.println();
	}
	
	public void insertEmpProc() {
		
		System.out.println("사원번호를 입력하세요.");
		String empNo = sc.nextLine();
		System.out.println("이름을 입력하세요.");
		String firstName = sc.nextLine();
		System.out.println("성을 입력하세요.");
		String lastName = sc.nextLine();
		System.out.println("이메일을 입력하세요.");
		String email = sc.nextLine();
		System.out.println("직무를 입력하세요.");
		String job = sc.nextLine();
		
		dto.setEmployeeId(empNo);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setEmail(email);
		dto.setJobId(job);
		
//		dao.insertEmp(dto);
		dao.insertEmpPorc(dto);
	}
	
	public void updateEmpProc() {
		
		System.out.println("수정할 사원번호를 입력하세요.");
		String empNo = sc.nextLine();
		System.out.println("수정할 이름을 입력하세요.");
		String firstName = sc.nextLine();
		System.out.println("수정할 성을 입력하세요.");
		String lastName = sc.nextLine();
		System.out.println("수정할 이메일을 입력하세요.");
		String email = sc.nextLine();
		
		dto.setEmployeeId(empNo);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setEmail(email);
		
		
//		dao.updateEmp(dto);
		dao.updateEmpProc(dto);
	}
	public void empListMap() {
		
		List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
		list1 = dao.getEmpListMap();
		for(Map<String, Object> map : list1)
			System.out.println(map);
	}
	
	public void empListCursor() {
		List<EmployeeDTO> list = dao.getEmpListCursor();
		for(EmployeeDTO d: list)
			System.out.println(d);
	}
}
