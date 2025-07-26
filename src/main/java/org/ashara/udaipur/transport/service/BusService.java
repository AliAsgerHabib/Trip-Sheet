package org.ashara.udaipur.transport.service;

import org.ashara.udaipur.transport.beans.bus.BusDto;
import org.ashara.udaipur.transport.beans.bus.BusRequestDto;
import org.ashara.udaipur.transport.entities.Bus;
import org.ashara.udaipur.transport.entities.Point;
import org.ashara.udaipur.transport.entities.Vendor;
import org.ashara.udaipur.transport.exceptions.AUCommonException;
import org.ashara.udaipur.transport.repository.BusRepository;
import org.ashara.udaipur.transport.repository.PointRepository;
import org.ashara.udaipur.transport.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BusService {

    @Autowired
    PointRepository pointRepository;

    @Autowired
    VendorRepository vendorRepository;

    @Autowired
    BusRepository busRepository;

    @Transactional
    public BusDto create(BusRequestDto requestDto) {

        Point pickup = pointRepository.findById(requestDto.getPickUpPointId())
                .orElseThrow(() -> new AUCommonException("No pickup point found for the given id"));
        Point dropOff = pointRepository.findById(requestDto.getDropOffPointId())
                .orElseThrow(() -> new AUCommonException("No drop off point found for the given id"));
        Vendor vendor = vendorRepository.findById(requestDto.getVendorId())
                .orElseThrow(() -> new AUCommonException("No Vendor Found."));

        // Create Bus entity and map the fields from requestDto
        Bus bus = new Bus();
        bus.setRegistrationNumber(requestDto.getRegistrationNo());
        bus.setDriverName(requestDto.getDriverName());
        bus.setDriverContactNo(requestDto.getDriverContactNo());
        bus.setMaxCapacity(requestDto.getMaxCapacity());
        bus.setPickup(pickup);
        bus.setDropOff(dropOff);
        bus.setVendor(vendor);

        // Save bus to the repository
        busRepository.save(bus);

        // Map Bus to BusDto
        BusDto response = new BusDto();
        response.setBusId(bus.getId());
        response.setRegistrationNo(bus.getRegistrationNumber());
        response.setDriverName(bus.getDriverName());
        response.setDriverContactNo(bus.getDriverContactNo());
        response.setMaxCapacity(bus.getMaxCapacity());
        response.setPickUpPointId(pickup.getId());
        response.setPickUpPointName(pickup.getName());
        response.setDropOffPointId(dropOff.getId());
        response.setDropOffPointName(dropOff.getName());
        response.setVendorId(vendor.getId());
        response.setVendorName(vendor.getName());

        return response;
    }

}
