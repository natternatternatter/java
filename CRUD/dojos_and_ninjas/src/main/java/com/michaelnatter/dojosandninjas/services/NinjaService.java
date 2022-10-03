package com.michaelnatter.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaelnatter.dojosandninjas.models.Dojo;
import com.michaelnatter.dojosandninjas.models.Ninja;
import com.michaelnatter.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	NinjaRepository ninjaRepository;
	
	public List<Ninja> allNinjas() {
		return ninjaRepository.findAll();
	}
	
	public Ninja oneNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		}
		else {
			return null;
		}
	}
	
//	public List<Ninja> ninjasByDojo(Dojo dojo) {
//		return ninjaRepository.findAllById(ninja.dojo);
//	}
	
	public void removeNinja(Long id) {
		ninjaRepository.deleteById(id);
	}
	
    public Ninja createNinja(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }
}
