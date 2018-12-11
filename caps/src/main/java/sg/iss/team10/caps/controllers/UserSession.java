package sg.iss.team10.caps.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import sg.iss.team10.caps.model.Admin;
import sg.iss.team10.caps.model.Lecturer;
import sg.iss.team10.caps.model.Student;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UserSession {
	
	private String sessionId = null;
	private Admin admin = null;
	private Lecturer lecturer = null;
	private Student student = null;
	
	public UserSession() {
		super();
	}

	public UserSession(String sessionId, Admin admin, Lecturer lecturer, Student student) {
		super();
		this.sessionId = sessionId;
		this.admin = admin;
		this.lecturer = lecturer;
		this.student = student;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
}
