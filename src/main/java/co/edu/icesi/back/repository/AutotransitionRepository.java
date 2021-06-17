package co.edu.icesi.back.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.back.model.Autotransition;

@Repository
public interface AutotransitionRepository extends CrudRepository<Autotransition,Long> {

}
