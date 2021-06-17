package co.edu.icesi.nigm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.nigm.model.Institution;

@Repository
public interface InstitutionRepository extends CrudRepository<Institution, Long>{

}
