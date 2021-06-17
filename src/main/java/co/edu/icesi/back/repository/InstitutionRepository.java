package co.edu.icesi.back.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.back.model.Institution;

@Repository
public interface InstitutionRepository extends CrudRepository<Institution, Long>{

}
