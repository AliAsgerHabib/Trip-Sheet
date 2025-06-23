package org.ashara.chennai.transport.tripsheet.tasks;


import com.google.api.services.sheets.v4.Sheets;
import jakarta.annotation.PostConstruct;
import org.ashara.chennai.transport.tripsheet.service.EntryService;
import org.ashara.chennai.transport.tripsheet.service.GSheetsReaderService;
import org.ashara.chennai.transport.tripsheet.service.constants.ColumnConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ScheduledTask {

    @Autowired
    private GSheetsReaderService gSheetsReaderService;

    public static List<List<Object>> mainList = new ArrayList<>();

    public static List<Object> headingList = new ArrayList<>();

    @Autowired
    private EntryService entryService;

    Sheets sheets;

    @PostConstruct
    public void init() {
        try {
            sheets = gSheetsReaderService.getSheetsService();
            mainList = gSheetsReaderService.fetchSheetData(sheets);
            headingList = mainList.getFirst();
        }
        catch (Exception e) {
            System.out.println("Exception while reading Sheets: " + e);
        }
    }

//    @Scheduled(fixedRate = 5000)
    public void readGSheetsOnSchedule() {
        try {
            List<List<Object>> newList = gSheetsReaderService.fetchSheetData(sheets);
            if (newList.size() > mainList.size()) {
                List<List<Object>> newRows = newList.subList(mainList.size(), newList.size());
                for (List<Object> row : newRows) {
                    entryService.createEntry(row, headingList);
                }
                mainList = newList;
            }
        }
        catch (Exception e) {
            System.out.println("Exception while reading sheets" + e);
        }
    }
}
