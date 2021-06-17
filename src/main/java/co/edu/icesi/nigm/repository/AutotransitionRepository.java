package co.edu.icesi.nigm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.nigm.model.Autotransition;

@Repository
public interface AutotransitionRepository extends CrudRepository<Autotransition,Long> {

}
