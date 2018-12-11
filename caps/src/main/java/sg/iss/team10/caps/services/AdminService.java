package sg.iss.team10.caps.services;

import java.util.ArrayList;

import sg.iss.team10.caps.model.Admin;

public interface AdminService {

	void removeAdmin(Admin admin);

	Admin changeAdmin(Admin admin);

	Admin createAdmin(Admin admin);

	ArrayList<Admin> findAllAdmin();

	Admin findAdminByName(String name);

	Admin findAdminById(Integer id);
	
	Admin authenticate(String username, String password);
}
