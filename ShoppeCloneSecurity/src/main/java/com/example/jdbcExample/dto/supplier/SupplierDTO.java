package com.example.jdbcExample.dto.supplier;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SupplierDTO {
    private Long supplierId;
    private String name;
    private String phone;
    private String address;
    private String description;
    
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifierDate;
	
	private String createBy;
	private String modifierBy;
	
	

    public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifierDate() {
		return modifierDate;
	}

	public void setModifierDate(Date modifierDate) {
		this.modifierDate = modifierDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getModifierBy() {
		return modifierBy;
	}

	public void setModifierBy(String modifierBy) {
		this.modifierBy = modifierBy;
	}

	public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
