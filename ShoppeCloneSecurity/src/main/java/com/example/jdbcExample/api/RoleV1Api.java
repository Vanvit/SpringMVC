package com.example.jdbcExample.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jdbcExample.dto.RoleDTO;
import com.example.jdbcExample.service.RoleService;

@RestController
@RequestMapping("api/v1/roles")
public class RoleV1Api {
	@Autowired
	private RoleService roleService;
	
	@PostMapping
	public RoleDTO createRole(@RequestBody RoleDTO dto) {
		RoleDTO newDto= roleService.createRole(dto);
		return newDto;
	}
	@GetMapping
	public List<RoleDTO> getAll(){
		return roleService.getAll();
	}
	@GetMapping("{roleId}")
	public RoleDTO getById(@PathVariable Long roleId){
		return roleService.getById(roleId);
	}
	@PutMapping("{roleId}")
	public RoleDTO updateRole(@PathVariable Long roleId, @RequestBody RoleDTO roleDTO){
		return roleService.updateRole(roleId,roleDTO);
	}
	@DeleteMapping("{roleId}")
	public void deleteId(@PathVariable Long roleId){
		 roleService.deletebyId(roleId);
	}
	

}
