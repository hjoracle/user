package CollectionTest;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class DepartmentDAO {

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

	public List<DepartmentDTO> getDepartmentList() {

		getConnection();

		DepartmentDTO department = null;
		List<DepartmentDTO> list = new ArrayList<>();

		String sql = "select department_id, department_name, manager_id, location_id from departments";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				department = new DepartmentDTO();
				department.setDepartmentId(rs.getString("department_id"));
				department.setDepartmentName(rs.getString("department_name"));
				department.setManagerId(rs.getString("manager_id"));
				department.setLocationId(rs.getString("location_id"));
				list.add(department);
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
		DepartmentDAO dao = new DepartmentDAO();

		WritableWorkbook workbook = Workbook.createWorkbook(new File("new.xls"));
		WritableSheet sheet = workbook.createSheet("dept", 0);
		WritableCellFormat wcf = new WritableCellFormat();
		wcf.setAlignment(Alignment.CENTRE);
		wcf.setBackground(Colour.GOLD);
		WritableFont arial10Bold = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
		wcf.setFont(arial10Bold);
		sheet.setColumnView(0, 20);
		sheet.setColumnView(1, 20);
		sheet.setColumnView(2, 20);
		sheet.setColumnView(3, 20);

		sheet.addCell(new Label(0, 0, "department_id", wcf));
		sheet.addCell(new Label(1, 0, "department_name", wcf));
		sheet.addCell(new Label(2, 0, "magager_id", wcf));
		sheet.addCell(new Label(3, 0, "location_id", wcf));

		List<DepartmentDTO> list = dao.getDepartmentList();
		int j = 0;
		for (DepartmentDTO dept : list) {
			Label lblDepartmentId = new Label(0, j, dept.getDepartmentId());
			Label lblDepartmentName = new Label(1, j, dept.getDepartmentName());
			Label lblManagerId = new Label(2, j, dept.getManagerId());
			Label lblLocationId = new Label(3, j, dept.getLocationId());

			sheet.addCell(lblDepartmentId);
			sheet.addCell(lblDepartmentName);
			sheet.addCell(lblManagerId);
			sheet.addCell(lblLocationId);
			j++;
		}
		workbook.write();
		workbook.close();
		System.out.println("excel completed.");
	}
	public static void main(String[] args) throws WriteException, IOException {
		DepartmentDAO dao = new DepartmentDAO();
		dao.excelExport();
	}

}
