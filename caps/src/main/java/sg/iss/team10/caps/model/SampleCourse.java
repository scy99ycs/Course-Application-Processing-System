//package sg.iss.team10.caps.model;
//
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "course")
//public class SampleCourse {
//	@Id
//	private int cid;
//	@Column(name = "course_code")
//	private String courseCode;
//	@Column(name = "course_name")
//	private String courseName;
//	@Column(name = "start_date")
//	private Date startDate;
//	@Column(name = "end_date")
//	private Date endDate;
//	private int credit;
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "lnric")
//	private SampleLecturer lecturer;
//	@ManyToMany(targetEntity = SampleStudent.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinTable(name = "student_course", joinColumns = {
//			@JoinColumn(name = "ccid", referencedColumnName = "cid") }, inverseJoinColumns = {
//					@JoinColumn(name = "snric", referencedColumnName = "nric") }
//
//	)
//	private Set<SampleStudent> students = new HashSet<SampleStudent>();
//
//	// Constructor
//	public SampleCourse() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public SampleCourse(int cid, String courseCode, String courseName, Date startDate, Date endDate, int credit,
//			SampleLecturer lecturer, HashSet<SampleStudent> students) {
//		super();
//		this.cid = cid;
//		this.courseCode = courseCode;
//		this.courseName = courseName;
//		this.startDate = startDate;
//		this.endDate = endDate;
//		this.credit = credit;
//		this.lecturer = lecturer;
//		this.students = students;
//	}
//
//	public SampleCourse(String courseCode, String courseName, Date startDate, Date endDate, int credit) {
//		super();
//		this.courseCode = courseCode;
//		this.courseName = courseName;
//		this.startDate = startDate;
//		this.endDate = endDate;
//		this.credit = credit;
//	}
//
//	// Getters & Setters
//	public int getCid() {
//		return cid;
//	}
//
//	public void setCid(int cid) {
//		this.cid = cid;
//	}
//
//	public String getCourseCode() {
//		return courseCode;
//	}
//
//	public void setCourseCode(String courseCode) {
//		this.courseCode = courseCode;
//	}
//
//	public String getCourseName() {
//		return courseName;
//	}
//
//	public void setCourseName(String courseName) {
//		this.courseName = courseName;
//	}
//
//	public Date getStartDate() {
//		return startDate;
//	}
//
//	public void setStartDate(Date startDate) {
//		this.startDate = startDate;
//	}
//
//	public Date getEndDate() {
//		return endDate;
//	}
//
//	public void setEndDate(Date endDate) {
//		this.endDate = endDate;
//	}
//
//	public int getCredit() {
//		return credit;
//	}
//
//	public void setCredit(int credit) {
//		this.credit = credit;
//	}
//
//	public SampleLecturer getLecturer() {
//		return lecturer;
//	}
//
//	public void setLecturer(SampleLecturer lecturer) {
//		this.lecturer = lecturer;
//	}
//
//	public HashSet<SampleStudent> getStudents() {
//		return (HashSet<SampleStudent>) students;
//	}
//
//	public void setStudents(HashSet<SampleStudent> students) {
//		this.students = students;
//	}
//
//	// Object Basics
//	@Override
//	public String toString() {
//		return "Course [cid=" + cid + ", courseCode=" + courseCode + ", courseName=" + courseName + ", startDate="
//				+ startDate + ", endDate=" + endDate + ", credit=" + credit + ", lecturer=" + lecturer + ", students="
//				+ students + "]";
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + cid;
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		SampleCourse other = (SampleCourse) obj;
//		if (cid != other.cid)
//			return false;
//		return true;
//	}
//
//}
