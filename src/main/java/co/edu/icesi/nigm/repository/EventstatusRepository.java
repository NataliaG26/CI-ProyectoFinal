package co.edu.icesi.nigm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.nigm.model.Eventstatus;

@Repository
public interface EventstatusRepository extends CrudRepository<Eventstatus,Long>{

}
