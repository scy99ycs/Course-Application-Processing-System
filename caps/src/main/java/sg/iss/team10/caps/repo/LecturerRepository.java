package sg.iss.team10.caps.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.team10.caps.model.Lecturer;

public interface LecturerRepository extends JpaRepository<Lecturer, Integer>	 {
	
	@Query("SELECT l FROM Lecture l where l.staffId= :staffId")
	Lecturer findLecturerById(@Param("staffId") int staffId);
	
	@Query("SELECT l FROM Lecture l where l.staffName LIKE :staffName")
	Lecturer findLecturerByName(@Param("staffName") String staffName);

}
