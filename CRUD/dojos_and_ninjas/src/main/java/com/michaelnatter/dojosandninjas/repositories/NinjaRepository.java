package com.michaelnatter.dojosandninjas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.michaelnatter.dojosandninjas.models.Dojo;
import com.michaelnatter.dojosandninjas.models.Ninja;

public interface NinjaRepository extends CrudRepository <Ninja, Long>{

		Optional<Ninja> findById(Long id);
		
		List<Ninja> findAll();
		
		List<Ninja> findAllById(Dojo dojo);
		
		Ninja save(Ninja ninja);
		
		void deleteById(Long id);
	
}
