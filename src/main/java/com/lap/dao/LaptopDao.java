package com.lap.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.lap.entity.Laptop;
import com.lap.repository.LaptopRepository;

@Repository
public class LaptopDao {
	@Autowired
	LaptopRepository lr;
	
	public ResponseEntity<String> addAll(List<Laptop> l) {
		lr.saveAll(l);
		return new ResponseEntity<>("All values saved",HttpStatus.CREATED);
	}

	public ResponseEntity<String> addById(Laptop l) {
		lr.save(l);
		return ResponseEntity.ok("saved successfully");
	}

	public List<Laptop> getById(String name) {
		return lr.getByName(name);
	}

	public String updatePrice(Laptop l,int id) {
		Laptop l1 = lr.findById(id).get();
		System.out.println(l1);
		l1.setPrice(l.getPrice());
		lr.save(l1);
		return "updated successfully";
	}

}
