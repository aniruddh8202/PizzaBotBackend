package com.example.Temporary.controllers;

import com.example.Temporary.dto.SizesDTO;
import com.example.Temporary.models.Sizes;
import com.example.Temporary.service_impl.ISize;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sizes")
public class SizesController {

	@Autowired
	ISize size;

	@Operation(summary = "Create Sizes", description = "Creation Of Sizes. ", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "404", description = "PageNotFound"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
	@PostMapping
	public ResponseEntity<Sizes> createOne(@RequestBody SizesDTO sizesDTO) {
		return new ResponseEntity<>(size.createSize(sizesDTO), HttpStatus.OK);
	}

	@Operation(summary = "Update Size details by Id", description = "To update all the details in the SIze by Id.", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
	@PutMapping("/{id}")
	public ResponseEntity<Sizes> update(@PathVariable("id") Long id, @RequestBody SizesDTO sizesDTO) {
		return new ResponseEntity<>(size.updateSize(id, sizesDTO), HttpStatus.OK);
	}

	@Operation(summary = "Delete Sizes by Size Id", description = "To delete an Sizes by it's Size id.", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		return new ResponseEntity<>(size.deleteSize(id), HttpStatus.OK);
	}

	@Operation(summary = "List of Sizes by Id", description = "To fetch list of Sizes by Id", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
	@GetMapping("/{id}")
	public ResponseEntity<Sizes> getOne(@PathVariable("id") Long id) {
		return new ResponseEntity<>(size.getOne(id), HttpStatus.OK);
	}

	@Operation(summary = "List of Sizes details", description = "To fetch list of Sizes", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
	@GetMapping
	public ResponseEntity<List<Sizes>> getAll() {
		return new ResponseEntity<>(size.getAll(), HttpStatus.OK);
	}

}
