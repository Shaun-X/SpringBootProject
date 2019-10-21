package shaun.sb.springbootDemo;

import java.util.Date;

public class DevOpsStudent {
	private int studentId;
	private String studentName;
	private String joinDate;
	public DevOpsStudent(int studentId, String studentName, String joinDate) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.joinDate = joinDate;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	@Override
	public String toString() {
		return "DevOpsStudent [studentId=" + studentId + ", studentName=" + studentName + ", joinDate=" + joinDate
				+ "]";
	}
}
