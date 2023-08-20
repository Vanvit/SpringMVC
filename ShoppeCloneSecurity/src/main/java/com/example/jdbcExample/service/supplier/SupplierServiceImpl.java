package com.example.jdbcExample.service.supplier;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jdbcExample.converter.supplier.SupplierConverter;
import com.example.jdbcExample.dto.PageDTO;
import com.example.jdbcExample.dto.RoleDTO;
import com.example.jdbcExample.dto.supplier.SupplierDTO;
import com.example.jdbcExample.entity.RoleEntity;
import com.example.jdbcExample.entity.SupplierEntity;
import com.example.jdbcExample.exception.ValidateException;
import com.example.jdbcExample.repository.supplier.SupplierRepository;
import com.example.jdbcExample.utils.AppStringUtils;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierConverter supplierConverter;

    @Autowired
    private EntityManager entityManager;

    @Override
    public SupplierDTO createSupplier(SupplierDTO dto) {
        // validate
        String name = dto.getName();
        if (!AppStringUtils.hasText(name)) {
            throw new ValidateException("Supplier name cannot be empty!");
        }
        // converter dto -> entity
        SupplierEntity newSupplierEntity = supplierConverter.toEntity(dto);
        supplierRepository.save(newSupplierEntity);
        // converter entity -> dto
        SupplierDTO resultDto = supplierConverter.toDTO(newSupplierEntity);

        return resultDto;
    }

    @Override
    public SupplierDTO updateSupplier(Long supplierId, SupplierDTO dto) {
        SupplierEntity supplierEntity = supplierRepository.findById(supplierId).orElseThrow(
                () -> new ValidateException("Supplier Not Found!"));

        // dto -> entity
        supplierConverter.toEntity(supplierEntity, dto);
        supplierRepository.save(supplierEntity);

        return supplierConverter.toDTO(supplierEntity);
    }

    @Override
    public void deleteSupplier(Long supplierId) {
        // validate
        supplierRepository.findById(supplierId).orElseThrow(
                () -> new ValidateException("Supplier Not Found!"));

        supplierRepository.deleteById(supplierId);
    }

    @Override
    public List<SupplierDTO> getSuppliers() {
		// Logic
		// get entity
		List<SupplierEntity> supplierEntities = supplierRepository.findAll();
		// entity -> dto
		List<SupplierDTO> supplierDtos = supplierConverter.toDTOList(supplierEntities);

		return supplierDtos;
    }

    @Override
    public SupplierDTO getSupplierBySupplierId(Long supplierId) {
        SupplierEntity supplierEntity = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new ValidateException("Supplier not found"));

        return supplierConverter.toDTO(supplierEntity);
    }
}