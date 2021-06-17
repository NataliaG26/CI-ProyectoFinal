package co.edu.icesi.back.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.back.model.Personautotran;

@Repository
public interface PersonautotranRepository extends CrudRepository<Personautotran,Integer>{

}
