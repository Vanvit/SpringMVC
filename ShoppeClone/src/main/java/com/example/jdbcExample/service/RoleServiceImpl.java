package com.example.jdbcExample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jdbcExample.converter.RoleConverter;
import com.example.jdbcExample.dto.RoleDTO;
import com.example.jdbcExample.entity.RoleEntity;
import com.example.jdbcExample.exception.ValidateException;
import com.example.jdbcExample.repository.RoleRepository;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private RoleConverter roleConverter;

	@Override
	public RoleDTO createRole(RoleDTO roleDTO) {
		// Validate
		String code = roleDTO.getCode();
		validateCode(code);
		// Logic
		// dto -> entity
		RoleEntity newRole = roleConverter.toEntity(roleDTO);
		roleRepository.save(newRole);
		// entity -> dto
		RoleDTO newRoleDto = roleConverter.toDto(newRole);
		return newRoleDto;

	}

	/*----------------------------------*/
	// method is used Validate field (code)
	private void validateCode(String code) {
		if (code == null || code.isEmpty()) {
			throw new ValidateException("code field cannot be empty!!!!");
		}
		Optional<RoleEntity> roleEntity = roleRepository.findByCode(code);
		if (roleEntity.isPresent()) {
			throw new ValidateException("Role ID is exited!!!");
		}
	}

	/*----------------------------------*/
	@Override
	public List<RoleDTO> getAll() {
		// Logic
		// get entity
		List<RoleEntity> roleEntities = roleRepository.findAll();
		// entity -> dto
		List<RoleDTO> roleDtos = roleConverter.toDto(roleEntities);

		return roleDtos;
	}
	@Override
	public RoleDTO getById(Long roleId) {
		// logic
		// lay entity ma muon update
		RoleEntity roleEntity = getRoleEntityById(roleId);
		// entity -> dto
//		RoleDTO newRoleDto = roleConverter.toDto(roleEntity);
		return roleConverter.toDto(roleEntity);
	}

	@Override
	public RoleDTO updateRole(Long roleId, RoleDTO roleDTO) {
		// Validate
		String code = roleDTO.getCode();
		validateCode(code);
		// logic
		// lay entity ma muon update
		RoleEntity roleEntity = getRoleEntityById(roleId);

		// set DL moi cho entity
		roleEntity.setName(roleDTO.getName());
		roleEntity.setCode(roleDTO.getCode());

		roleRepository.save(roleEntity);
		return roleConverter.toDto(roleEntity);
	}
	
	/*----------------------------------*/
	// method is used Validate (roleId)
	private RoleEntity getRoleEntityById(Long roleId) {
		RoleEntity roleEntity = 
				roleRepository.findById(roleId).orElseThrow(() -> new ValidateException("not found Role Id!!"));
		return roleEntity;
	}
	/*----------------------------------*/
	
	@Override
	public void deletebyId(Long roleId) {
		// TODO Auto-generated method stub
		RoleEntity roleEntityById = getRoleEntityById(roleId);
		roleRepository.deleteById(roleId);

	}
 }
