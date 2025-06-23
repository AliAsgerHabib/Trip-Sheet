package org.ashara.chennai.transport.tripsheet.service;

import org.ashara.chennai.transport.tripsheet.exceptions.ActCommonException;
import org.ashara.chennai.transport.tripsheet.service.constants.ColumnConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class EntryService {

    @Autowired
    DryStorageService dryStorageService;

    @Autowired
    ColdStorageService coldStorageService;

    @Autowired
    DryStorageTemperatureService dryStorageTemperatureService;

    @Autowired
    ColdStorageTemperatureService coldStorageTemperatureService;

    @Autowired
    PersonalHygieneService personalHygieneService;

    @Autowired
    HygieneAndCleaningService hygieneAndCleaningService;

    public Map<String, String> createMap(List<Object> dataRow, List<Object> heading) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < dataRow.size(); i++) {
            map.put((String)heading.get(i), (String)dataRow.get(i));
        }
        return map;
    }

    public void createEntry(List<Object> dataRow, List<Object> heading) {
        Map<String, String> dataMap = createMap(dataRow, heading);
        if (dataMap.get(ColumnConstants.CHECK_LIST) == null || dataMap.get(ColumnConstants.CHECK_LIST).isEmpty())
            throw new ActCommonException("No check list has been selected");

        switch (dataMap.get(ColumnConstants.CHECK_LIST)) {
            case "Dry Storage Check List" : dryStorageService.create(dataMap); break;
            case "Cold Storage Check List" : coldStorageService.create(dataMap); break;
            case "Dry Storage Room Temperature" : dryStorageTemperatureService.create(dataMap); break;
            case "Cold Storage Temperature" : ; coldStorageTemperatureService.create(dataMap); break;
            case "Personal Hygiene Checklist" : ; personalHygieneService.create(dataMap); break;
            case "Hygiene and Cleaning Monitoring" : hygieneAndCleaningService.create(dataMap); break;
            default:
                throw new ActCommonException("Invalid Check List Type");
        }
    }
}
