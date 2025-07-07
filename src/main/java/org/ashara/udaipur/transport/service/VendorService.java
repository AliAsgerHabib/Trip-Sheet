package org.ashara.udaipur.transport.service;

import org.ashara.udaipur.transport.beans.vendor.VendorRequestDto;
import org.ashara.udaipur.transport.beans.vendor.VendorDto;
import org.ashara.udaipur.transport.entities.Vendor;
import org.ashara.udaipur.transport.exceptions.AUCommonException;
import org.ashara.udaipur.transport.exceptions.ResourceNotFoundException;
import org.ashara.udaipur.transport.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendorService {

    @Autowired
    VendorRepository vendorRepository;

    @Transactional
    public VendorDto create(VendorRequestDto vendorDto) {
        Vendor vendor = new Vendor();
        VendorDto response = new VendorDto();

        vendor.setName(vendorDto.getName());
        vendor.setRegisteredCity(vendorDto.getRegisteredCity());
        vendor.setRegisteredCountry(vendorDto.getRegisteredCountry());
        vendor.setContactPersonName(vendorDto.getContactPersonName());
        vendor.setContactPersonNo(vendorDto.getContactPersonNo());
        vendor.setContactPersonEmail(vendorDto.getContactPersonEmail());
        vendor.setCreatedAt(LocalDateTime.now());
        vendor.setUpdatedAt(LocalDateTime.now());
        vendorRepository.save(vendor);

        response.setVendorId(vendor.getId());
        response.setName(vendor.getName());
        return response;
    }

    public VendorDto details(Integer vendorId) {
        VendorDto response = new VendorDto();
        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(() -> new ResourceNotFoundException("No Vendor Found"));

        response.setVendorId(vendor.getId());
        response.setName(vendor.getName());
        response.setRegisteredCity(vendor.getRegisteredCity());
        response.setRegisteredCountry(vendor.getRegisteredCountry());
        response.setContactPersonName(vendor.getContactPersonName());
        response.setContactPersonNo(vendor.getContactPersonNo());
        response.setContactPersonEmail(vendor.getContactPersonEmail());
        return response;
    }

    public List<VendorDto> allDetails() {
        List<VendorDto> response = vendorRepository.findAll().stream().map(vendor -> {
            VendorDto dto = new VendorDto();
            dto.setVendorId(vendor.getId());
            dto.setName(vendor.getName());
            dto.setRegisteredCity(vendor.getRegisteredCity());
            dto.setRegisteredCountry(vendor.getRegisteredCountry());
            dto.setContactPersonName(vendor.getContactPersonName());
            dto.setContactPersonNo(vendor.getContactPersonNo());
            dto.setContactPersonEmail(vendor.getContactPersonEmail());
            return dto;
        }).collect(Collectors.toList());
        return response;
    }
}
