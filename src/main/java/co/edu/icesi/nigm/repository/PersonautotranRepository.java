package co.edu.icesi.nigm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.nigm.model.Personautotran;

@Repository
public interface PersonautotranRepository extends CrudRepository<Personautotran,Integer>{

}
