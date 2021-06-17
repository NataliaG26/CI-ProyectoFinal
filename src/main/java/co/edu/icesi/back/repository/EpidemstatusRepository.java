package co.edu.icesi.back.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.back.model.Epidemstatus;

@Repository
public interface EpidemstatusRepository extends CrudRepository<Epidemstatus, Long> {

}
