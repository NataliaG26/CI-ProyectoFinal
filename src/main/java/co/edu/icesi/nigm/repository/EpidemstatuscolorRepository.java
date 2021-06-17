package co.edu.icesi.nigm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.nigm.model.Epidemstatuscolor;

@Repository
public interface EpidemstatuscolorRepository extends CrudRepository<Epidemstatuscolor, Long> {

}
