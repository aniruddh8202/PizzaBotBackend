package com.example.Temporary.controllers;

import com.example.Temporary.dto.DiscountDTO;
import com.example.Temporary.models.Discount;
import com.example.Temporary.service_impl.IDiscount;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discount")
public class DiscountRestController {

    @Autowired
    IDiscount iDiscount;

    @Operation(summary = "Create Discount", description = "Creation Of Discount. ", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "404", description = "PageNotFound"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
    @PostMapping
    public ResponseEntity<Discount> createDiscount(@RequestBody DiscountDTO discountDTO){
        return new ResponseEntity<>(iDiscount.craeteDiscount(discountDTO), HttpStatus.OK);
    }

    @Operation(summary = "Update Discount details by Id", description = "To update all the details in the Discount by Id.", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
   
    @PutMapping("/{id}")
    public ResponseEntity<Discount> updateDiscount(@PathVariable("id") Long id, @RequestBody DiscountDTO discountDTO){
        return new ResponseEntity<>(iDiscount.updateDiscount(id, discountDTO), HttpStatus.OK);
    }
    

    @Operation(summary = "Delete Discount by Discount Id", description = "To delete an Discount by it's Discount id.", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDiscount(@PathVariable("id") Long id){
        return new ResponseEntity<>(iDiscount.deleteDiscount(id), HttpStatus.OK);
    }

    @Operation(summary = "List of Discount by Id", description = "To fetch list of Discount by Id", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
    @GetMapping("/{id}")
    public ResponseEntity<Discount> getOne(@PathVariable("id") Long id){
        return new ResponseEntity<>(iDiscount.getOne(id), HttpStatus.OK);
    }

    @Operation(summary = "List of Discount details", description = "To fetch list of Discount", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
    @GetMapping
    public ResponseEntity<List<Discount>> getAll(){
        return new ResponseEntity<>(iDiscount.getAll(), HttpStatus.OK);
    }

}
