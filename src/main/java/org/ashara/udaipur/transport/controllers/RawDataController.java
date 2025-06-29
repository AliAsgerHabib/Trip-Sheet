package org.ashara.udaipur.transport.controllers;

import org.ashara.udaipur.transport.beans.BusEntryBean;
import org.ashara.udaipur.transport.service.SheetsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/raw")
public class RawDataController {

    @Autowired
    SheetsDataService sheetsDataService;

    @GetMapping("/getSheets")
    public List<BusEntryBean> getSheetsData() {
        return sheetsDataService.readGSheets();
    }
}
