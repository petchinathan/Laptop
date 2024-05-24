package com.lap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import com.lap.entity.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop, Integer>{
	@Query(value= " select * from laptops where name like  ? ",nativeQuery = true)
	List<Laptop> getByName(String name);

}
