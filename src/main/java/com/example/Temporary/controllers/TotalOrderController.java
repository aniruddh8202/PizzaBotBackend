package com.example.Temporary.controllers;

import com.example.Temporary.dto.TotalOrderDTO;
import com.example.Temporary.models.TotalOrder;
import com.example.Temporary.service_impl.ITotalOrder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/totalorder")
public class TotalOrderController {

    @Autowired
    ITotalOrder iTotalOrder;

    @Operation(summary = "Create TotalOrder", description = "Creation Of TotalOrder. ", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "404", description = "PageNotFound"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
    @PostMapping
    public ResponseEntity<TotalOrder> createTotalOrder(@RequestBody TotalOrderDTO totalOrderDTO){
        return new ResponseEntity<>(iTotalOrder.createTotalOrder(totalOrderDTO), HttpStatus.OK);
    }

    @Operation(summary = "Update TotalOrder details by Id", description = "To update all the details in the TotalOrder by Id.", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
    @PutMapping("/{id}")
    public ResponseEntity<TotalOrder> updateTotalOrder(@PathVariable("id") Long id, @RequestBody TotalOrderDTO totalOrderDTO){
        return new ResponseEntity<>(iTotalOrder.updateTotalOrder(id, totalOrderDTO), HttpStatus.OK);
    }

    @Operation(summary = "Delete TotalOrder by TotalOrder Id", description = "To delete an TotalOrder by it's TotalOrder id.", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMapping(@PathVariable("id") Long id){
        return new ResponseEntity<>(iTotalOrder.deleteTotalOrder(id), HttpStatus.OK);
    }

    @Operation(summary = "List of TotalOrder by Id", description = "To fetch list of TotalOrder by Id", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
    @GetMapping("/{id}")
    public ResponseEntity<TotalOrder> getOne(@PathVariable("id") Long id){
        return new ResponseEntity<>(iTotalOrder.getOne(id), HttpStatus.OK);
    }

    @Operation(summary = "List of TotalOrder details", description = "To fetch list of TotalOrder", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
    @GetMapping
    public ResponseEntity<List<TotalOrder>> getAll(){
        return new ResponseEntity<>(iTotalOrder.getAll(), HttpStatus.OK);
    }

}
