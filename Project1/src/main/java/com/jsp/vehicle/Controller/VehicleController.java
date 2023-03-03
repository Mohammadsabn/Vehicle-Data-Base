package com.jsp.vehicle.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.vehicle.Module.Vehicle;
import com.jsp.vehicle.Service.VehicleService;

@RestController
public class VehicleController {
	@Autowired
	VehicleService s;
	
	@PostMapping("/addDetails")
	ResponseEntity<Vehicle> addDetails( @RequestBody Vehicle v){
		return new ResponseEntity<Vehicle>(s.add(v),HttpStatus.CREATED);
	}
	
	@PostMapping("/updateVehicle/{vid}")
	ResponseEntity<Vehicle> updateById(@RequestBody Vehicle v,@PathVariable int vid){
		return new ResponseEntity<Vehicle>(s.updateById(v, vid),HttpStatus.OK);
		
	}
	
	@GetMapping("/getAll")
	List<Vehicle> getAll(){
		return s.getAll();
	}
	
	@DeleteMapping("/deleteById/{vid}")
	ResponseEntity<Vehicle> deleteById(@PathVariable int vid) {
	return new ResponseEntity<Vehicle>(s.deleteById(vid),HttpStatus.OK);
	}
	
	@GetMapping("/getByColour/{colour}")
	List<Vehicle> getByClour(@PathVariable String colour){
		return s.getByColour(colour);
	}
	
	


}
