package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the STUDENT database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STUDENT_GRADEID_GENERATOR", sequenceName="S_GRADE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="STUDENT_GRADEID_GENERATOR")
	private long gradeid;

	private String assignmentname;

	private double grade;

	@Temporal(TemporalType.DATE)
	private Date gradedate;

	private String studentid;

	@Column(name="\"TYPE\"")
	private String type;

	public Student() {
	}

	public long getGradeid() {
		return this.gradeid;
	}

	public void setGradeid(long gradeid) {
		this.gradeid = gradeid;
	}

	public String getAssignmentname() {
		return this.assignmentname;
	}

	public void setAssignmentname(String assignmentname) {
		this.assignmentname = assignmentname;
	}

	public double getGrade() {
		return this.grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public Date getGradedate() {
		return this.gradedate;
	}

	public void setGradedate(Date gradedate) {
		this.gradedate = gradedate;
	}

	public String getStudentid() {
		return this.studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}