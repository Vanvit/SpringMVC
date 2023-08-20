package com.example.jdbcExample.service.supplier;

import java.util.List;
import java.util.Map;

import com.example.jdbcExample.dto.PageDTO;
import com.example.jdbcExample.dto.supplier.SupplierDTO;

public interface SupplierService {

    SupplierDTO createSupplier(SupplierDTO dto);

    List<SupplierDTO> getSuppliers();

    SupplierDTO updateSupplier(Long supplierId, SupplierDTO dto);

    void deleteSupplier(Long supplierId);

    SupplierDTO getSupplierBySupplierId(Long supplierId);
}
