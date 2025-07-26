package org.ashara.udaipur.transport.controllers;

import jakarta.validation.Valid;
import org.ashara.udaipur.transport.beans.ResponseResource;
import org.ashara.udaipur.transport.beans.point.PointDto;
import org.ashara.udaipur.transport.beans.point.PointRequestDto;
import org.ashara.udaipur.transport.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/point")
public class PointsController {

    @Autowired
    PointService pointService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseResource<PointDto> create(@Valid @RequestBody PointRequestDto request) {
        PointDto response = pointService.create(request);
        return new ResponseResource<>(HttpStatus.OK, "SUCCESS", response);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseResource<List<PointDto>> details() {
        List<PointDto> response = pointService.allDetails();
        return new ResponseResource<>(HttpStatus.OK, "SUCCESS", response);
    }
}
