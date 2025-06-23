package org.ashara.chennai.transport.tripsheet.controllers;

import org.ashara.chennai.transport.tripsheet.beans.BusEntryBean;
import org.ashara.chennai.transport.tripsheet.service.SheetsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
