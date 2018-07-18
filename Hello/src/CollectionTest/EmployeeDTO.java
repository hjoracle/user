package CollectionTest;

import java.util.Formatter;

public class EmployeeDTO {
	
	private String employeeId;	//자바에서는 오라클에서 표현된 '_' 를 두번째 나오는 단어의 대문자로 표현 오라클: employee_id 
	private String firstName;
	private String lastName;
	private String email;
	private String jobId;
	private String hireDate;
	private String salary;
	
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	@Override
	public String toString() {
		Formatter fm = new Formatter();
		String result = fm.format("%6s\t %-10s\t %-10s\t %-10s\t %-10s\t %-10s",
						employeeId, firstName, lastName, email, jobId, hireDate).toString();
		return result;
				
//				 "EmployeeDTO [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
//					+ ", email=" + email + ", jobId=" + jobId + ", hireDate=" + hireDate + "]";
	}

	
}
