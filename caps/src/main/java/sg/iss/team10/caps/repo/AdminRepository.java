package sg.iss.team10.caps.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sg.iss.team10.caps.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> 
{
	@Query("SELECT a from Admin a where a.adminId =:id")
	Admin findAdminById(@Param("id") int id);
	
	@Query("SELECT a FROM a.Admin WHERE a.adminName=:name")
	Admin findAdminByName(@Param("name") String name);


@Query("SELECT a FROM Admin a")
ArrayList<Admin> findAllAdmin();
}
