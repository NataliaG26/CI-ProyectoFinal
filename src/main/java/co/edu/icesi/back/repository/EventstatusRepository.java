package co.edu.icesi.back.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.back.model.Eventstatus;

@Repository
public interface EventstatusRepository extends CrudRepository<Eventstatus,Long>{

}
