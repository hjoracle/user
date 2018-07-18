package Test;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jxl.Workbook;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

class Employee1 {
	String firstName;
	String lastName;
	double salary;

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return String.format("%6s %10s %8.0f", firstName, lastName, salary);
	}

}

public class Stream {

	public static void main(String[] args) {
		int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

		int stm = Arrays.stream(a)
				.filter(n -> n%2 == 1)
				.sum();
		System.out.println(stm);
		System.out.println();
		//-----------------------------------------------------------------------------------------------------//	
		Connection conn = null;

		try {
			String user = "hr"; 
			String pw = "hr";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			Class.forName("oracle.jdbc.driver.OracleDriver");        
			conn = DriverManager.getConnection(url, user, pw);

			System.out.println("Database�� ����Ǿ����ϴ�.\n");

		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB ����̹� �ε� ���� :"+cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB ���ӽ��� : "+sqle.toString());
		} catch (Exception e) {
			System.out.println("Unkonwn error");
			e.printStackTrace();
		}//db����ȯ��


		//2. employee table���� first name�� �����ͼ� �̸��� ���̰� 7���� ū ����Ʈ�� ���, �̸��� Alexander�� ã�Ƽ� ���.
		Employee1 employees = null;
		List<Employee1> list = new ArrayList<>();

		String sql = "select first_name, last_name, salary from employees";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				employees = new Employee1();
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setSalary(rs.getDouble("salary"));
				list.add(employees);
			}
			list.stream()
			.filter(s -> s.getFirstName().length() > 7)
			.forEach(System.out::println);

			System.out.println();

			list.stream()
			.filter(s -> s.getFirstName().length() > 7)
			.filter(s -> s.getFirstName().equals("Alexander"))
			.forEach(System.out::println);

			System.out.println();
			//3.salary�� 700�̻��� ��� ���
			list.stream()
			.filter(s -> s.getSalary() >= 700)
			.forEach(System.out::println);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
