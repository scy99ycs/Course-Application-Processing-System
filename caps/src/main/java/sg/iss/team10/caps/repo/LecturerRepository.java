package sg.iss.team10.caps.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.iss.team10.caps.model.Lecturer;

public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {

}
