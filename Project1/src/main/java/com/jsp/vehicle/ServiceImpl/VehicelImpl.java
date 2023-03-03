package com.jsp.vehicle.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.vehicle.Exception.SourceNotFoundException;
import com.jsp.vehicle.Module.Vehicle;
import com.jsp.vehicle.Repo.VehicleRepo;
import com.jsp.vehicle.Service.VehicleService;
@Service
public class VehicelImpl implements  VehicleService{
	
	@Autowired
	VehicleRepo repo;
	
	@Override
	public Vehicle add(Vehicle v) {
		return  repo.save(v);
	}

	@Override
	public Vehicle updateById(Vehicle v, int vid) {
		Vehicle e= repo.findById(vid).orElseThrow(()->new SourceNotFoundException("Vehicle", "vid", vid));
		e.setBrand(v.getBrand());
		e.setColour(v.getBrand());
		e.setCost(v.getCost());
		return repo.save(e);
	}

	@Override
	public List<Vehicle> getAll() {
		return repo.findAll();
	}

	@Override
	public Vehicle deleteById(int vid) {
			if(repo.existsById(vid)) {
				Vehicle exist=repo.findById(vid).orElseThrow(()-> new SourceNotFoundException("Vehhicle", "vid", vid));
				repo.delete(exist);
				return exist;
			}
			else {
				
				return null;
			}
	}

	@Override
	public List<Vehicle> getByColour(String colour) {
		return repo.getByColour(colour);
	}

	

}
