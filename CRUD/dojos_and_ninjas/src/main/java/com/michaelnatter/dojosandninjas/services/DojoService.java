package com.michaelnatter.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaelnatter.dojosandninjas.models.Dojo;
import com.michaelnatter.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {

	@Autowired
	DojoRepository dojoRepository;
	
	public List<Dojo> allDojos() {
		return dojoRepository.findAll();
	}
	
	public Dojo oneDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		else {
			return null;
		}
	}
	
	public void removeDojo(Long id) {
		dojoRepository.deleteById(id);
	}
	
    public Dojo createDojo(Dojo dojo) {
        return dojoRepository.save(dojo);
    }
}
