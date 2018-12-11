package sg.iss.team10.caps.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;

	private int capacity;

	private String courseName;

	private int credit;

	public Collection<Enrollment> getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Collection<Enrollment> enrollment) {
		this.enrollment = enrollment;
	}

	private String duration;

	private int staffId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@OneToMany(mappedBy = "course")
	private Collection<Enrollment> enrollment;

	@ManyToOne
	@JoinColumn(name = "staffId", insertable = false, updatable = false)
	private Lecturer lecturer;

	public Course() {
		enrollment = new ArrayList<Enrollment>();
	}

	public int getCourseId() {
		return this.courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCredit() {
		return this.credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getDuration() {
		return this.duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getStaffId() {
		return this.staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}
