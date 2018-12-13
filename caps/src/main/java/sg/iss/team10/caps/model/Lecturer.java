package sg.iss.team10.caps.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import org.hibernate.loader.collection.PaddedBatchingCollectionInitializerBuilder;


/**
 * The persistent class for the lecturer database table.
 * 
 */
@Entity
@NamedQuery(name="Lecturer.findAll", query="SELECT l FROM Lecturer l")
public class Lecturer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
	//@SequenceGenerator(name="id_generator", sequenceName = "staffid_seq", allocationSize=1)
	private int staffId;
	
	private String staffName;

	private String designation;

	private String username;
	
	private String password;
	
	@OneToMany(mappedBy="lecturer")
	private Collection<Course> course;

	public Collection<Course> getCourse() {
		return course;
	}

	public void setCourse(Collection<Course> course) {
		this.course = course;
	}
	
	public Course addCourse(Course newCourse) {
		course.add(newCourse);
		return newCourse;
	}

	public Lecturer() {
		course = new ArrayList<Course>();
	}
	
	public Lecturer(int staffId, String staffName, String designation, String username, String password) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.designation = designation;
		this.username = username;
		this.password = password;
		course = new ArrayList<Course>();
	}

	public int getStaffId() {
		return this.staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStaffName() {
		return this.staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
