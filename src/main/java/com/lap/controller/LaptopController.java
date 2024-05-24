package com.lap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lap.entity.Laptop;
import com.lap.exception.NotEnoughRaMException;
import com.lap.exception.oldModelException;
import com.lap.service.LaptopService;

@RestController
public class LaptopController {
	@Autowired
	LaptopService ls;
	
	@PostMapping("/addAll")
	public ResponseEntity<String> addAll(@RequestBody List<Laptop> l) throws NotEnoughRaMException {
		return ls.addAll(l);
	}
	@PostMapping("/addById")
	public ResponseEntity<String> addById(@RequestBody Laptop l) throws oldModelException  {
		return ls.addById(l);
	}
	@GetMapping("getByName/{name}")
	public List<Laptop> getByName(@PathVariable String name) {
		return ls.getByName(name);
	}
	@PatchMapping("/updatePrice/{id}")
	public String updatePrice(@RequestBody Laptop l,@PathVariable int id) {
		return ls.updatePrice(l,id);
	}
}
