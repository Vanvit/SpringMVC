package com.example.jdbcExample.converter.supplier;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.jdbcExample.dto.supplier.SupplierDTO;
import com.example.jdbcExample.entity.SupplierEntity;

@Component
public class SupplierConverter {

    public SupplierDTO toDTO(SupplierEntity supplierEntity) {
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setSupplierId(supplierEntity.getSupplierId());
        supplierDTO.setName(supplierEntity.getName());
        supplierDTO.setPhone(supplierEntity.getPhone());
        supplierDTO.setAddress(supplierEntity.getAddress());
        supplierDTO.setDescription(supplierEntity.getDescription());

        supplierDTO.setCreateDate(supplierEntity.getCreateDate());
        supplierDTO.setCreateBy(supplierEntity.getCreateBy());
        supplierDTO.setModifierDate(supplierEntity.getModifierDate());
        supplierDTO.setModifierBy(supplierEntity.getModifierBy());
        
        return supplierDTO;
    }

    public SupplierEntity toEntity(SupplierDTO supplierDTO) {
        SupplierEntity supplierEntity = new SupplierEntity();
        supplierEntity.setName(supplierDTO.getName());
        supplierEntity.setPhone(supplierDTO.getPhone());
        supplierEntity.setAddress(supplierDTO.getAddress());
        supplierEntity.setDescription(supplierDTO.getDescription());
        return supplierEntity;
    }

    /* List */

    public List<SupplierDTO> toDTOList(List<SupplierEntity> supplierEntities) {
        List<SupplierDTO> supplierDTOList = new ArrayList<>();
        for (SupplierEntity supplierEntity : supplierEntities) {
            supplierDTOList.add(toDTO(supplierEntity));
        }
        return supplierDTOList;
    }

    public List<SupplierEntity> toEntityList(List<SupplierDTO> supplierDTOList) {
        List<SupplierEntity> supplierEntities = new ArrayList<>();
        for (SupplierDTO supplierDTO : supplierDTOList) {
            supplierEntities.add(toEntity(supplierDTO));
        }
        return supplierEntities;
    }

    // update
    public SupplierEntity toEntity(SupplierEntity supplierEntity, SupplierDTO supplierDTO) {
        supplierEntity.setName(supplierDTO.getName());
        supplierEntity.setPhone(supplierDTO.getPhone());
        supplierEntity.setAddress(supplierDTO.getAddress());
        supplierEntity.setDescription(supplierDTO.getDescription());
        return supplierEntity;
    }
}
