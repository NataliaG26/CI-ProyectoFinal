package co.edu.icesi.back.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.back.model.Userr;
import co.edu.icesi.back.repository.UserrRepository;
import co.edu.icesi.back.service.interfaces.UserrService;

@Service
public class UserrServiceImpl implements UserrService{
	
	private UserrRepository userrRepository;
	
	@Autowired
	public UserrServiceImpl(UserrRepository userrRepository) {
		this.userrRepository = userrRepository;
	}

	@Override
	public Userr createUserr(Userr userr) {
		userrRepository.save(userr);
		return userr;
	}
	
	@Override
	public Userr getUserrById(Long id) {
		return userrRepository.findById(id).get();
	}
	

}
