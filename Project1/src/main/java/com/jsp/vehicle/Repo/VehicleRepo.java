package com.jsp.vehicle.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.vehicle.Module.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle,Integer>{

	@Query(value = "select * from vehicle where colour=?1",nativeQuery =true)
	List<Vehicle> getByColour(String colour);
	
}
