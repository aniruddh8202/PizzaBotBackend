package com.example.Temporary.controllers;

import com.example.Temporary.dto.MenuDTO;
import com.example.Temporary.models.Menu;
import com.example.Temporary.service_impl.MenuImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuRestController {


	@Autowired
	MenuImpl menuImpl;

	@Operation(summary = "Create Menu", description = "Creation Of Domino's Menu Card. ", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "404", description = "PageNotFound"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
	@PostMapping()
	public ResponseEntity<Menu> createMenu(@RequestBody MenuDTO menuDTO) {

		return new ResponseEntity<>(menuImpl.createMenu(menuDTO), HttpStatus.OK);

	}

	@Operation(summary = "Update Menu details by Id", description = "To update all the details in the Menu by Id.", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
	@PutMapping("/{id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable("id") Long id,  @RequestBody MenuDTO menuDTO){
        return new ResponseEntity<>(menuImpl.updateMenu(id, menuDTO), HttpStatus.OK);
    }

	@Operation(summary = "Delete Menu by Menu Id", description = "To delete an Menu by it's Menu id.", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMenu(@PathVariable("id") Long id) {
		return new ResponseEntity<>(menuImpl.deleteMenu(id), HttpStatus.OK);
	}

	@Operation(summary = "List of Menu by Id", description = "To fetch list of Menu by Id", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
	@GetMapping("/{id}")
	public ResponseEntity<Menu> getOne(@PathVariable("id") Long id) {
		return new ResponseEntity<>(menuImpl.getMenu(id), HttpStatus.OK);
	}

	@Operation(summary = "List of Menu details", description = "To fetch list of Menu", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
	@GetMapping
	public ResponseEntity<List<Menu>> getAll() {
		return new ResponseEntity<>(menuImpl.getAll(), HttpStatus.OK);
	}

}
