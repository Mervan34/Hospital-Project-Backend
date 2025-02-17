package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.City;
import com.example.demo.model.District;

@Repository
public interface DistrictRepository extends JpaRepository<District,Long>{
	//List<District> findByCityId(Long cityId);
//	List<District> findByMervancityid(City mervancityid);
	List<District> findByMervancity(City mervancity);

}
