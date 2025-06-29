package org.ashara.udaipur.transport.service;

import com.google.api.services.sheets.v4.Sheets;
import jakarta.annotation.PostConstruct;
import org.ashara.udaipur.transport.beans.BusEntryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class SheetsDataService {

    @Autowired
    private GSheetsReaderService gSheetsReaderService;

    Sheets sheets;

    public static List<Object> headingList = new ArrayList<>();


    @PostConstruct
    public void init() {
        try {
            sheets = gSheetsReaderService.getSheetsService();
            headingList = gSheetsReaderService.fetchSheetData(sheets).getFirst();
        }
        catch (Exception e) {
            System.out.println("Exception while reading Sheets: " + e);
        }
    }

    public List<BusEntryBean> readGSheets() {
        List<BusEntryBean> responseList = new ArrayList<>();
        try {
            List<List<Object>> newList = gSheetsReaderService.fetchSheetData(sheets);
            newList.removeFirst();
            for (List<Object> row : newList) {
                BusEntryBean busEntry = createEntry(row);
                if (busEntry.getBusId() != null && !busEntry.getBusId().isEmpty())
                    responseList.add(busEntry);
            }
        }
        catch (Exception e) {
            System.out.println("Exception while reading sheets" + e);
        }
        return responseList;
    }

    private BusEntryBean createEntry(List<Object> dataRow) {
        BusEntryBean busEntryBean = new BusEntryBean();
        String dateTimeString = (String) dataRow.get(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
        busEntryBean.setEntryTime(dateTime);
        busEntryBean.setBusId((String)dataRow.get(1));

        String entryType = (String) dataRow.get(2);
        if ("Pick-up".equalsIgnoreCase(entryType))
            busEntryBean.setEntryType(BusEntryBean.EntryType.PICKUP);
        else if("Drop-off".equalsIgnoreCase(entryType))
            busEntryBean.setEntryType(BusEntryBean.EntryType.DROPOFF);


        busEntryBean.setNoOfPassenegers(Integer.parseInt((String)dataRow.get(3)));
        busEntryBean.setRoute((String)dataRow.get(5));
        busEntryBean.setPickupPoint((String)dataRow.get(6));
        busEntryBean.setEntryBy((String) dataRow.get(7));

        return busEntryBean;
    }

}
