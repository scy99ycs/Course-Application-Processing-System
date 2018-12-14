package sg.iss.team10.caps.util;

public class CapsLogic {

	public static Character calculateGrade(Float score) {
		if (score != null) {
			switch ((int) (score / 20)) {
			case 0:
				return 'F';
			case 1:
				return 'D';
			case 2:
				return 'C';
			case 3:
				return 'B';
			default:
				return 'A';
			}
		} 
		else
			return '-';
	}
	
	public static Float calculateGPA(Float averageScore) {
		return averageScore/25;
	}
}
