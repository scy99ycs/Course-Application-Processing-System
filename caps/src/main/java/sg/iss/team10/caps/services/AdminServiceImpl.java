package sg.iss.team10.caps.services;

import sg.iss.team10.caps.repo.AdminRepository;
import sg.iss.team10.caps.model.Admin;
import java.util.ArrayList;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminServiceImpl implements AdminService {
@Resource
private AdminRepository adminRepository;

@Override
@Transactional
public Admin findAdminById(Integer id)
{
	return adminRepository.findAdminById(id);
}

@Override
@Transactional
public Admin findAdminByName(String name)
{
	return adminRepository.findAdminByName(name);
}

@Override
@Transactional
public ArrayList<Admin> findAllAdmin()
{
	ArrayList<Admin> findall= (ArrayList<Admin>)adminRepository.findAllAdmin();
	return findall;
}

@Override
@Transactional
public Admin createAdmin(Admin admin)
{
	return adminRepository.saveAndFlush(admin);
}

@Override
@Transactional
public Admin changeAdmin(Admin admin)
{
	return adminRepository.saveAndFlush(admin);
}

@Override
@Transactional
public void removeAdmin(Admin admin)
{
	adminRepository.delete(admin);
}

@Override
@Transactional
public Admin authenticate(String username, String password) {
	return adminRepository.authenticate(username, password);
}



}
