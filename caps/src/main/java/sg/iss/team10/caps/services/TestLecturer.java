package sg.iss.team10.caps.services;

import sg.iss.team10.caps.model.Lecturer;

public class TestLecturer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LecturerService service = new LectureServiceImpl();
		Lecturer le = new Lecturer(14, "CY", "awesome", "4", "4");
		System.out.println("before");
		service.createLecturer(le);
		System.out.println("after");
	}
}
