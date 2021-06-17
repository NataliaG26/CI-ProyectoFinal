package co.edu.icesi.nigm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.nigm.model.Epidemevent;

@Repository
public interface EpidemeventRepository extends CrudRepository<Epidemevent,Long>{

}
