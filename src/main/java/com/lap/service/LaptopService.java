package com.lap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lap.dao.LaptopDao;
import com.lap.entity.Laptop;
import com.lap.exception.NotEnoughRaMException;
import com.lap.exception.oldModelException;

@Service
public class LaptopService {
	@Autowired
	LaptopDao ld;

	public ResponseEntity<String> addAll(List<Laptop> l) throws NotEnoughRaMException {
		for(Laptop p: l) {
			if(p.getRam()<4) {
				throw new NotEnoughRaMException();
			}
		}
		return ld.addAll(l);
	}

	public ResponseEntity<String> addById(Laptop l) throws oldModelException {
		try {
		if(l.getModel()<2024) {
				throw new oldModelException();
			}
		}
		catch(oldModelException e) {
			addById1(l);
			return new ResponseEntity<String>("saved but the model year is "+l.getModel()+" please update it",HttpStatus.BAD_REQUEST);
		}
		return ld.addById(l);
	}
	
	public ResponseEntity<String> addById1(Laptop l)  {		
		return ld.addById(l);
	}

	public List<Laptop> getByName(String name) {
		return ld.getById(name);
	}

	public String updatePrice(Laptop l, int id) {
		return ld.updatePrice(l,id);
	}

	
}
