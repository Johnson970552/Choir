package com.ac.choir.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ac.choir.Entity.ChoirEntity;
import com.ac.choir.ServiceImp.ChoirServiceImp;
@RestController
public class ChoirController {
	
	@Autowired
	public ChoirServiceImp choirService;
	
	@PostMapping("/save")
//	public ResponseEntity<ChoirEntity> Save(@RequestBody ChoirEntity Entity){
//		return new ResponseEntity<>(choirService.SaveData(Entity),HttpStatus.CREATED);
//	}
	public ResponseEntity<ChoirEntity>cEntity(
			@RequestParam("name")String name,
			@RequestParam("role")String role,
			@RequestParam("mobile")long mobile,
			@RequestParam("emailId")String emailId,
			@RequestParam("address")String address,
			@RequestParam("image")MultipartFile imaFile){
		ChoirEntity choirEntity=new ChoirEntity();
		choirEntity.setName(name);
		choirEntity.setRole(role);
		choirEntity.setMobile(mobile);
		choirEntity.setEmailId(emailId);
		choirEntity.setAdress(address);
		try {
			choirEntity=choirService.saveChoir(choirEntity, imaFile);
		}catch(IOException s) {
			s.printStackTrace();
			}
		return ResponseEntity.ok(choirEntity);
	}
	@GetMapping("getall")
	public ResponseEntity<List<ChoirEntity>> getEntity(){
		 List<ChoirEntity>entities=choirService.getAll();
	return ResponseEntity.status(HttpStatus.OK).body(entities);	 
	}
	@DeleteMapping("/deleteby/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id){
	 String deleteById =choirService.DeleteData(id)
;
		return ResponseEntity.status(HttpStatus.OK).body(deleteById);
	}
	@GetMapping("/getById/{id}")
	public ResponseEntity< ChoirEntity> getById(@PathVariable long id){
		
			return new  ResponseEntity<>(choirService.getDataById( id),HttpStatus.OK);

		}

	@PutMapping("/update/{id}")
	public ResponseEntity< ChoirEntity> update(@RequestBody ChoirEntity update,@PathVariable int id){
		 ChoirEntity update1=choirService.UpdateData(id,update);
		return ResponseEntity.status(HttpStatus.CREATED).body(update1);
	}
	
	

}
