package sg.iss.team10.caps.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int studentId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date enrollmentDate;

	private String firstMidName;

	private String lastName;

	private String password;

	private String username;
	@OneToMany(mappedBy="student")
	private Collection<Enrollment> enrollment;

	public Collection<Enrollment> getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Collection<Enrollment> enrollment) {
		this.enrollment = enrollment;
	}

	public Student() {
		enrollment= new ArrayList<Enrollment>();
	}

	public int getStudentId() {
		return this.studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public Date getEnrollmentDate() {
		return this.enrollmentDate;
	}

	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public String getFirstMidName() {
		return this.firstMidName;
	}

	public void setFirstMidName(String firstMidName) {
		this.firstMidName = firstMidName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
