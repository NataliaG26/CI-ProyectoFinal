package co.edu.icesi.back.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.back.model.Epidemevent;

@Repository
public interface EpidemeventRepository extends CrudRepository<Epidemevent,Long>{

}
