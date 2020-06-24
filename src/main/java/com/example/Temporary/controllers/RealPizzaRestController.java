package com.example.Temporary.controllers;

import com.example.Temporary.dto.RealPizzaDTO;
import com.example.Temporary.models.RealPizza;
import com.example.Temporary.service_impl.IRealPizza;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/realpizza")
public class RealPizzaRestController {

	@Autowired
	IRealPizza iRealPizza;

	@Operation(summary = "Create RealPizza", description = "Creation Of RealPizza. ", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "404", description = "PageNotFound"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
	@PostMapping
	public ResponseEntity<RealPizza> createPizza(@RequestBody RealPizzaDTO realPizzaDTO) {
		return new ResponseEntity<>(iRealPizza.createRealPizza(realPizzaDTO), HttpStatus.OK);
	}

	@Operation(summary = "Update RealPizza details by Id", description = "To update all the details in the RealPizza by Id.", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
	@PutMapping("/{id}")
	public ResponseEntity<RealPizza> updatePizza(@PathVariable("id") Long id, @RequestBody RealPizzaDTO realPizzaDTO) {
		return new ResponseEntity<>(iRealPizza.updateRealPizza(id, realPizzaDTO), HttpStatus.OK);
	}

	@Operation(summary = "Delete RealPizza by RealPizza Id", description = "To delete an RealPizza by it's RealPizza id.", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePizza(@PathVariable("id") Long id) {
		return new ResponseEntity<>(iRealPizza.deletePizza(id), HttpStatus.OK);
	}

	@Operation(summary = "List of RealPizza by Id", description = "To fetch list of RealPizza by Id", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
	@GetMapping("/{id}")
	public ResponseEntity<RealPizza> getOne(@PathVariable("id") Long id) {
		return new ResponseEntity<>(iRealPizza.getOne(id), HttpStatus.OK);
	}

	@Operation(summary = "List of RealPizza details", description = "To fetch list of RealPizza", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
	@GetMapping
	public ResponseEntity<List<RealPizza>> getAll() {
		return new ResponseEntity<>(iRealPizza.getAll(), HttpStatus.OK);
	}

	@Operation(summary = "List of RealPizza by Name", description = "To fetch list of RealPizza by Name", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
	@GetMapping("name/{name}")
	public ResponseEntity<RealPizza> getPizzaByName(@PathVariable("name") String name){
		return new ResponseEntity<>(iRealPizza.getByName(name), HttpStatus.OK);
	}

}
