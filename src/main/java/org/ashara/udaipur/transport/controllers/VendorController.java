package org.ashara.udaipur.transport.controllers;

import jakarta.validation.Valid;
import org.ashara.udaipur.transport.beans.ResponseResource;
import org.ashara.udaipur.transport.beans.vendor.VendorRequestDto;
import org.ashara.udaipur.transport.beans.vendor.VendorDto;
import org.ashara.udaipur.transport.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    VendorService vendorService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseResource<VendorDto> create(@Valid @RequestBody VendorRequestDto vendorDTO) {
        VendorDto response = vendorService.create(vendorDTO);
        return new ResponseResource<>(HttpStatus.OK, "SUCCESS", response);
    }

    @RequestMapping(value = "/{vendorId}", method = RequestMethod.GET)
    public ResponseResource<VendorDto> details(@PathVariable Integer vendorId) {
        VendorDto response = vendorService.details(vendorId);
        return new ResponseResource<>(HttpStatus.OK, "SUCCESS", response);
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseResource<List<VendorDto>> details() {
        List<VendorDto> response = vendorService.allDetails();
        return new ResponseResource<>(HttpStatus.OK, "SUCCESS", response);
    }
}
