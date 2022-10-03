package com.michaelnatter.dojosandninjas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.michaelnatter.dojosandninjas.models.Dojo;

public interface DojoRepository extends CrudRepository <Dojo, Long>{

	Optional<Dojo> findById(Long id);
	
	List<Dojo> findAll();
	
	Dojo save(Dojo dojo);
	
	void deleteById(Long id);
	
}
