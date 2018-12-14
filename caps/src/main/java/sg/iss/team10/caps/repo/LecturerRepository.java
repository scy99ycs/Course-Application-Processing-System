package sg.iss.team10.caps.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.team10.caps.model.Lecturer;

public interface LecturerRepository extends JpaRepository<Lecturer, Integer>	 {
	
	@Query("SELECT l FROM Lecturer l where l.staffId= :id")
	Lecturer findLecturerById(@Param("id") int staffId);
	
	@Query("SELECT l FROM Lecturer l where l.staffName LIKE :staffName")
	Lecturer findLecturerByName(@Param("staffName") String staffName);

	@Query("SELECT l FROM Lecturer l WHERE l.username=:un AND l.password=:pwd")
	Lecturer authenticate(@Param("un") String username, @Param("pwd") String password);
	
	@Query("SELECT staffId FROM Lecturer")
	ArrayList<Integer> findAllIds();
	
	@Query("SELECT MAX(staffId) FROM Lecturer")
	Integer findMaxStaffId();
}
