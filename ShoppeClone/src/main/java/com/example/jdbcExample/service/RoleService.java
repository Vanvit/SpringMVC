package com.example.jdbcExample.service;

import java.util.List;

import com.example.jdbcExample.dto.RoleDTO;

public interface RoleService {
	public RoleDTO createRole(RoleDTO roleDTO);

	public List<RoleDTO> getAll();
	
	public RoleDTO getById(Long roleId);

	public RoleDTO updateRole(Long roleId, RoleDTO roleDTO);

	public void deletebyId(Long roleId);

}
