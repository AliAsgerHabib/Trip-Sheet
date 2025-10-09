package org.ashara.udaipur.transport.service;

import org.ashara.udaipur.transport.beans.vendor.VendorRequestDto;
import org.ashara.udaipur.transport.beans.vendor.VendorDto;
import org.ashara.udaipur.transport.entities.Vendor;
import org.ashara.udaipur.transport.exceptions.ResourceNotFoundException;
import org.ashara.udaipur.transport.mappers.VendorMapper;
import org.ashara.udaipur.transport.repository.VendorRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VendorService {

    @Autowired
    VendorRepository vendorRepository;

    VendorMapper vendorMapper = Mappers.getMapper(VendorMapper.class);

    @Transactional
    public VendorDto create(VendorRequestDto vendorDto) {
        Vendor vendor = vendorMapper.toEntity(vendorDto);
        vendor.setCreatedAt(LocalDateTime.now());
        vendor.setUpdatedAt(LocalDateTime.now());
        vendorRepository.save(vendor);
        return vendorMapper.toDto(vendor);
    }

    public VendorDto details(Integer vendorId) {
        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(() -> new ResourceNotFoundException("No Vendor Found"));
        return vendorMapper.toDto(vendor);
    }

    public List<VendorDto> allDetails() {
        List<Vendor> vendorList = vendorRepository.findAll();
        return vendorMapper.toDtoList(vendorList);
    }
}
