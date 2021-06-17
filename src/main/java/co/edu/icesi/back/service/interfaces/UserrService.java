package co.edu.icesi.back.service.interfaces;

import co.edu.icesi.back.model.Userr;

public interface UserrService {
	
	public Userr createUserr(Userr userr);
	
	public Userr getUserrById(Long id);

}
