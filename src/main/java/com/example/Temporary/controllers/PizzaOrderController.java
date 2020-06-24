package com.example.Temporary.controllers;
import com.example.Temporary.dto.PizzaOrderDTO;
import com.example.Temporary.models.PizzaOrder;
import com.example.Temporary.service_impl.IPizzaOrder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizza-order")
public class PizzaOrderController {

    @Autowired
    IPizzaOrder iPizzaOrder;

    @Operation(summary = "Create PizzaOrder", description = "Creation Of PizzaOrder. ", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "404", description = "PageNotFound"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
    @PostMapping
    public ResponseEntity<PizzaOrder> createPizzaOrder(@RequestBody PizzaOrderDTO pizzaOrderDTO){
        return new ResponseEntity<>(iPizzaOrder.createPizzaorder(pizzaOrderDTO), HttpStatus.OK);
    }

    @Operation(summary = "Update PizzaOrder details by Id", description = "To update all the details in the PizzaOrder by Id.", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
    @PutMapping("/{id}")
    public ResponseEntity<PizzaOrder> updatePizzaOrder(@PathVariable("id") Long id, @RequestBody PizzaOrderDTO pizzaOrderDTO){
        return new ResponseEntity<>(iPizzaOrder.updatePizza(id, pizzaOrderDTO), HttpStatus.OK);
    }

    @Operation(summary = "Delete PizzaOrder by PizzaOrder Id", description = "To delete an PizzaOrder by it's PizzaOrder id.", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePizzaOrder(@PathVariable("id") Long id){
        return new ResponseEntity<>(iPizzaOrder.deletePizza(id), HttpStatus.OK);
    }

    @Operation(summary = "List of PizzaOrder by Id", description = "To fetch list of PizzaOrder by Id", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
    @GetMapping("/{id}")
    public ResponseEntity<PizzaOrder> getOne(@PathVariable("id") Long id){
        return new ResponseEntity<>(iPizzaOrder.getOne(id), HttpStatus.OK);
    }

    @Operation(summary = "List of PizzaOrder details", description = "To fetch list of PizzaOrder", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
    @GetMapping
    public ResponseEntity<List<PizzaOrder>> getAll(){
        return new ResponseEntity<>(iPizzaOrder.getAll(), HttpStatus.OK);
    }

}
