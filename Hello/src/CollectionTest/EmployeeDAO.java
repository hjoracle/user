package CollectionTest;

import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class EmployeeDAO {

	Connection conn = null;

	public Connection getConnection() {

		try {
			String user = "hr"; 
			String pw = "hr";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			Class.forName("oracle.jdbc.driver.OracleDriver");        
			conn = DriverManager.getConnection(url, user, pw);

			System.out.println("Database에 연결되었습니다.\n");

		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB 접속실패 : "+sqle.toString());
		} catch (Exception e) {
			System.out.println("Unkonwn error");
			e.printStackTrace();
		}//db접속환경
		return conn;
	}

	public void updateEmp(EmployeeDTO dto) {

		getConnection();

		int c =0;

		String sql = "update employees " + 
				"set first_name=?, last_name=?, email=?, job_id =? " + 
				"where employee_id = ?";

		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(++c, dto.getFirstName());
			pstmt.setString(++c, dto.getLastName());
			pstmt.setString(++c, dto.getEmail());
			pstmt.setString(++c, dto.getJobId());
			pstmt.setString(++c, dto.getEmployeeId());

			int cnt = pstmt.executeUpdate();

			System.out.println(cnt + " 건이 갱신되었습니다.");

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}
	public void updateEmpProc(EmployeeDTO dto) {
		getConnection();

		try {
			CallableStatement cstmt = conn.prepareCall("{call update_emp_proc(?,?,?,?)}");
			cstmt.setString(1, dto.getEmployeeId());
			cstmt.setString(2, dto.getFirstName());
			cstmt.setString(3, dto.getLastName());
			cstmt.setString(4, dto.getEmail());

			int r = cstmt.executeUpdate();

			System.out.println(r+ " 건 수정되었습니다.(Proc)");

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void insertEmp(EmployeeDTO dto) {

		getConnection();

		String sql = "insert into employees (employee_id, first_name, last_name, email, hire_date, job_id) " + 
				"values (?,?,?,?, sysdate,?)";

		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEmployeeId());
			pstmt.setString(2, dto.getFirstName());
			pstmt.setString(3, dto.getLastName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getJobId());

			int cnt = pstmt.executeUpdate();

			System.out.println(cnt + " 건이 입력되었습니다.");

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void insertEmpPorc(EmployeeDTO dto) {
		getConnection();

		try {
			CallableStatement cstmt = conn.prepareCall("{call insert_emp_proc(?,?,?,?)}");
			cstmt.setString(1, dto.getFirstName());
			cstmt.setString(2, dto.getLastName());
			cstmt.setString(3, dto.getEmail());
			cstmt.setString(4, dto.getJobId());

			int r = cstmt.executeUpdate();

			System.out.println(r+ " 건 입력되었습니다.(Proc)");

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}
	public EmployeeDTO getEmpDTO(String emp_id) {
		getConnection();

		EmployeeDTO dto = null;
		List<EmployeeDTO> list = new ArrayList<>();

		String sql = "select employee_id, first_name, last_name, email from employees" + " where employee_id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp_id);
			ResultSet rs = pstmt.executeQuery();			//반환 타입이 Resultset

			if(rs.next()) {
				dto = new EmployeeDTO();
				dto.setEmployeeId(rs.getString("employee_id"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

		return dto;

	}

	public List<EmployeeDTO> getEmpList(SearchVO vo) {
		getConnection();

		EmployeeDTO dto = null;
		List<EmployeeDTO> list = new ArrayList<>();

		String whereClause = "where 1=1 ";
		if(vo.getSearchCondition().equals("first_name"))
			whereClause += " and first_name like '%'||'" + vo.getSearchKeyword() + "'||'%'";
		if(vo.getSearchCondition().equals("hire_date"))
			//			whereClause += " and hire_date > to_date('" + vo.getSearchKeyword() + "', 'rrrrmmdd')";
			whereClause += " and hire_date > '"+ vo.getSearchKeyword() + "'";

		String sql = "select employee_id, first_name, last_name, email, to_char(hire_date,'rrrr-mm-dd') as hire_date, job_id from employees " + whereClause + " order by 1 desc";
		//		String sql = "select employee_id, first_name, last_name, email, to_char(hire_date,'rrrr-mm-dd') as hire_date, job_id from employees " + "order by 1 desc";

		System.out.println(sql);

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();			//반환 타입이 Resultset

			while(rs.next()){

				dto = new EmployeeDTO();
				dto.setEmployeeId(rs.getString("employee_id"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setHireDate(rs.getString("hire_date"));
				dto.setJobId(rs.getString("job_id"));
				list.add(dto);

			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<Map<String, Object>> getEmpListMap() {

		getConnection();

		String sql = "select employee_id, first_name from employees";
		Map<String, Object> map = null;
		List<Map<String, Object>> list = new ArrayList<>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {

				map = new HashMap<>();
				map.put("employee_id", rs.getString("employee_id"));
				map.put("first_name", rs.getString("first_name"));
				list.add(map);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;


	}

	public List<EmployeeDTO> getEmpListCursor() {
		getConnection();

		List<EmployeeDTO> list = new ArrayList<>();
		EmployeeDTO dto = null;

		//프로시저를 호출할 때 쓰는 함수 
		try {
			CallableStatement cstmt = conn.prepareCall("{call get_emplist_proc(?,?,?)}");
			cstmt.setInt(1,  500);
			cstmt.setDate(2, new Date(100,0,1));
			cstmt.registerOutParameter(3,oracle.jdbc.OracleTypes.CURSOR);
			cstmt.executeQuery();
			ResultSet rs = (ResultSet) cstmt.getObject(3);

			while(rs.next()){

				dto = new EmployeeDTO();
				dto.setEmployeeId(rs.getString("employee_id"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setHireDate(rs.getString("hire_date"));
				dto.setJobId(rs.getString("job_id"));
				list.add(dto);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}
	public List<EmployeeDTO> getEmployeeList() {
		
		getConnection();
		
		EmployeeDTO employees = null;
		List<EmployeeDTO> list = new ArrayList<>();

		String sql = "select first_name, last_name, salary from employees";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				employees = new EmployeeDTO();
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setSalary(rs.getString("salary"));
				list.add(employees);
			}
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}return list;
		}
		public void excelExport() throws IOException, WriteException {
			EmployeeDAO dao = new EmployeeDAO();

			WritableWorkbook workbook = Workbook.createWorkbook(new File("new.xls"));
			WritableSheet sheet = workbook.createSheet("emp", 0);
			WritableCellFormat wcf = new WritableCellFormat();
			wcf.setAlignment(Alignment.CENTRE);
			wcf.setBackground(Colour.GOLD);
			WritableFont arial10Bold = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
			wcf.setFont(arial10Bold);
			sheet.setColumnView(0, 20);
			sheet.setColumnView(1, 20);
			sheet.setColumnView(2, 20);

			sheet.addCell(new Label(0, 0, "firstName", wcf));
			sheet.addCell(new Label(1, 0, "lastName", wcf));
			sheet.addCell(new Label(2, 0, "salary", wcf));

			List<EmployeeDTO> list = dao.getEmployeeList();
			int j = 0;
			for (EmployeeDTO emp : list) {
				Label lblFirstName = new Label(0, j, emp.getFirstName());
				Label lblLastName = new Label(1, j, emp.getLastName());
				Label lblSalary = new Label(2, j, emp.getSalary());

				sheet.addCell(lblFirstName);
				sheet.addCell(lblLastName);
				sheet.addCell(lblSalary);
				j++;
			}
			workbook.write();
			workbook.close();
			System.out.println("excel completed.");
		}

	}
