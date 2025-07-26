package org.ashara.udaipur.transport.controllers;

import jakarta.validation.Valid;
import org.ashara.udaipur.transport.beans.ResponseResource;
import org.ashara.udaipur.transport.beans.bus.BusDto;
import org.ashara.udaipur.transport.beans.bus.BusRequestDto;
import org.ashara.udaipur.transport.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bus")
public class BusController {

    @Autowired
    BusService busService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseResource<BusDto> create(@Valid @RequestBody BusRequestDto requestDto) {
        BusDto response = busService.create(requestDto);
        return new ResponseResource<>(HttpStatus.OK, "SUCCESS", response);
    }
}
