package com.example.jdbcExample.api.supplier;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.jdbcExample.dto.PageDTO;
import com.example.jdbcExample.dto.supplier.SupplierDTO;
import com.example.jdbcExample.service.supplier.SupplierService;

@RestController
@RequestMapping("admin/api/v1/suppliers")
public class SupplierV1Api {
    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public SupplierDTO createSupplier(@RequestBody SupplierDTO dto) {
        return supplierService.createSupplier(dto);
    }

    @PutMapping("{supplierId}")
    public SupplierDTO updateSupplier(@PathVariable(name = "supplierId") Long supplierId,
                                      @RequestBody SupplierDTO dto) {
        return supplierService.updateSupplier(supplierId, dto);
    }

    @GetMapping
    public List<SupplierDTO> getSupplierDTOs() {
        return supplierService.getSuppliers();
    }

    @DeleteMapping("{supplierId}")
    public void deleteSupplierById(@PathVariable(name = "supplierId") Long supplierId) {
        supplierService.deleteSupplier(supplierId);
    }
}
