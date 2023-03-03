package com.jsp.vehicle.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jsp.vehicle.Module.Vehicle;

@Service
public interface VehicleService {

	Vehicle add(Vehicle v);

	Vehicle updateById(Vehicle v, int vid);

	List<Vehicle> getAll();
	
	Vehicle deleteById(int vid);

	List<Vehicle> getByColour(String colour);
	
}
