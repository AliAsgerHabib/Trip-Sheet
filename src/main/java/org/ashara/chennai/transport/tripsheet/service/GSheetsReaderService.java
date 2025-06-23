package org.ashara.chennai.transport.tripsheet.service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.http.HttpCredentialsAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class GSheetsReaderService {

    @Autowired
    ResourceLoader resourceLoader;

    private static final String APPLICATION_NAME = "Google Sheets Monitor";

    @Value("${gsheets.spreadsheet.id}")
    private String SPREADSHEET_ID;

    @Value("${gsheets.spreadsheet.range}")
    private String RANGE;

    public void readSheets() {
        try {
            Sheets sheetsService = getSheetsService();
            List<List<Object>> prevData = fetchSheetData(sheetsService);

            System.out.println("Monitoring for updates...");

            while (true) {
                Thread.sleep(5000);
                List<List<Object>> newData = fetchSheetData(sheetsService);

                if (newData.size() > prevData.size()) {
                    List<List<Object>> newRows = newData.subList(prevData.size(), newData.size());
                    for (List<Object> row : newRows) {
                        System.out.println("New row added: " + row);
                    }
                    prevData = newData;
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error while reading the file: " + e);
        }
    }

    public Sheets getSheetsService() throws Exception {

        Resource resource = resourceLoader.getResource("classpath:credentials-transport.json");
        GoogleCredentials credentials = GoogleCredentials.fromStream(resource.getInputStream())
                .createScoped(List.of(SheetsScopes.SPREADSHEETS));
        return new Sheets.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                GsonFactory.getDefaultInstance(),
                new HttpCredentialsAdapter(credentials))
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public List<List<Object>> fetchSheetData(Sheets service) throws Exception {
        ValueRange response = service.spreadsheets().values()
                .get(SPREADSHEET_ID, RANGE)
                .execute();
        return response.getValues() == null ? new ArrayList<>() : response.getValues();
    }
}
