package org.ashara.chennai.transport.tripsheet.controllers;


import org.ashara.chennai.transport.tripsheet.beans.DryStorageDTO;
import org.ashara.chennai.transport.tripsheet.repository.DryStorageRepository;
import org.ashara.chennai.transport.tripsheet.service.DryStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:80")
@RestController
@RequestMapping("/details")
public class DetailsController {

    @Autowired
    DryStorageService dryStorageService;

    @GetMapping("/dryStorage")
    public List<DryStorageDTO> getData() {
        return dryStorageService.getDryStorageDetails();
    }
}
