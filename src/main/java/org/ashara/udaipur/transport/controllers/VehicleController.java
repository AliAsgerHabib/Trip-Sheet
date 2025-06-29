package org.ashara.udaipur.transport.controllers;

import org.ashara.udaipur.transport.beans.ResponseResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/vehicle")
@RestController
public class VehicleController {

    private static final Logger LOG = LoggerFactory.getLogger(VehicleController.class);

    @GetMapping("/hello")
    public ResponseResource<String> hello() {
        return new ResponseResource<>(HttpStatus.OK, "SUCCESS", "Method executed");
    }
}
