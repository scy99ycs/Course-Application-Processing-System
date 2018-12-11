package sg.iss.team10.caps.services;

import sg.iss.team10.caps.repo.AdminRepository;
import sg.iss.team10.caps.model.Admin;
import java.util.ArrayList;

public interface AdminService {
	
	Admin removeAdmin(Admin admin);
	Admin changeAdmin(Admin admin);
	Admin createAdmin(Admin admin);
	ArrayList<Admin> findAllAdmin();
	Admin findAdminByName(String name);
	Admin findAdminById(Integer id);
}
