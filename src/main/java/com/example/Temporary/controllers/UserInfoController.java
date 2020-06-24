package com.example.Temporary.controllers;

import com.example.Temporary.dto.UserInfoDTO;
import com.example.Temporary.models.UserInfo;
import com.example.Temporary.service_impl.IUserInfo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {

	@Autowired
	IUserInfo iUserInfo;

	@Operation(summary = "Create UserInfo", description = "Creation Of UserInfo. ", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "404", description = "PageNotFound"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
	@PostMapping
	public ResponseEntity<UserInfo> createUserInfo(@RequestBody UserInfoDTO userInfoDTO) {
		return new ResponseEntity<>(iUserInfo.createUserInfo(userInfoDTO), HttpStatus.OK);
	}

	@Operation(summary="Update UserInfo details by Id",description="To update all the details in the UserInfo by Id.",responses={
	@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
	@PutMapping("/{id}")
    public ResponseEntity<UserInfo> updateUserInfo(@PathVariable("id") Long id, @RequestBody UserInfoDTO userInfoDTO){
        return new ResponseEntity<>(iUserInfo.updateUserInfo(id, userInfoDTO), HttpStatus.OK);
    }

	@Operation(summary = "Delete UserInfo by UserInfo Id", description = "To delete an UserInfo by it's UserInfo id.", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUserInfo(@PathVariable("id") Long id) {
		return new ResponseEntity<>(iUserInfo.deleteUserInfo(id), HttpStatus.OK);
	}

	@Operation(summary = "List of UserInfo by Id", description = "To fetch list of UserInfo by Id", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
	@GetMapping("/{id}")
	public ResponseEntity<UserInfo> getOne(@PathVariable("id") Long id) {
		return new ResponseEntity<>(iUserInfo.getOne(id), HttpStatus.OK);
	}

	@Operation(summary = "List of UserInfo details", description = "To fetch list of UserInfo", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "204", description = "No Content"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
	@GetMapping
	public ResponseEntity<List<UserInfo>> getAll() {
		return new ResponseEntity<>(iUserInfo.getAll(), HttpStatus.OK);
	}

}
