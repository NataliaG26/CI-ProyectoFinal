package co.edu.icesi.nigm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.nigm.model.Epidemstatus;

@Repository
public interface EpidemstatusRepository extends CrudRepository<Epidemstatus, Long> {

}
