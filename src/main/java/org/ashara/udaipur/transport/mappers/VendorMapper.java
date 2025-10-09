package org.ashara.udaipur.transport.mappers;

import org.ashara.udaipur.transport.beans.vendor.VendorDto;
import org.ashara.udaipur.transport.beans.vendor.VendorRequestDto;
import org.ashara.udaipur.transport.entities.Vendor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface VendorMapper {

    Vendor toEntity(VendorRequestDto requestDto);

    @Mapping(source = "id", target = "vendorId")
    VendorDto toDto(Vendor vendor);

    List<VendorDto> toDtoList(List<Vendor> vendors);
}