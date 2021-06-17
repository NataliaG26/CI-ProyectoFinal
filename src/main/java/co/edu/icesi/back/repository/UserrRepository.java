package co.edu.icesi.back.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.back.model.Userr;

@Repository
public interface UserrRepository extends CrudRepository<Userr, Long>{
	
	Userr findByUserName(String userName);

}
