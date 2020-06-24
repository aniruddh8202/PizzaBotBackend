package com.example.Temporary.controllers;

import com.example.Temporary.dto.ToppingsDTO;
import com.example.Temporary.models.Toppings;
import com.example.Temporary.service_impl.IToppings;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toppings")
public class ToppingsController {

    @Autowired
    IToppings itoppings;

    @Operation(summary = "Create Toppings", description = "Creation Of Toppings. ", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "404", description = "PageNotFound"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
    @PostMapping
    public ResponseEntity<Toppings> createTopping(@RequestBody ToppingsDTO toppingsDTO){
        return new ResponseEntity<>(itoppings.createTopping(toppingsDTO), HttpStatus.OK);
    }

    @Operation(summary = "Update Toppings details by Id", description = "To update all the details in the Toppings by Id.", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
    @PutMapping("/{id}")
    public ResponseEntity<Toppings> updateTopping(@PathVariable("id") Long id, @RequestBody ToppingsDTO toppingsDTO){
        return new ResponseEntity<>(itoppings.updateTopping(id, toppingsDTO), HttpStatus.OK);
    }

    @Operation(summary = "Delete Toppings by Toppings Id", description = "To delete an Toppings by it's Toppings id.", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTopping(@PathVariable("id") Long id){
        return new ResponseEntity<>(itoppings.deleteTopping(id), HttpStatus.OK);
    }

    @Operation(summary = "List of Toppings by Id", description = "To fetch list of Toppings by Id", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
    @GetMapping("/{id}")
    public ResponseEntity<Toppings> getOne(@PathVariable("id") Long id){
        return new ResponseEntity<>(itoppings.getOne(id), HttpStatus.OK);
    }

    @Operation(summary = "List of Toppings details", description = "To fetch list of Toppings", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
    @GetMapping
    public ResponseEntity<List<Toppings>> getAll(){
        return new ResponseEntity<>(itoppings.getAll(), HttpStatus.OK);
    }

}
