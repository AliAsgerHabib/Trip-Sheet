package org.ashara.chennai.transport.tripsheet.service;

import org.ashara.chennai.transport.tripsheet.entities.ColdStorage;
import org.ashara.chennai.transport.tripsheet.entities.ColdStorageItems;
import org.ashara.chennai.transport.tripsheet.repository.ColdStorageRepository;
import org.ashara.chennai.transport.tripsheet.service.constants.ColumnConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ColdStorageService {

    @Autowired
    ColdStorageRepository coldStorageRepository;

    public void create(Map<String, String> dataMap) {
        ColdStorage coldStorage = new ColdStorage();
        coldStorage.setEntryTime(dataMap.get(ColumnConstants.TIMESTAMP));
        coldStorage.setZone(dataMap.get(ColumnConstants.ZONE_NAME));
        coldStorage.setTeamMemberName(dataMap.get(ColumnConstants.FSH_TEAM_MEMBER_NAME));
        coldStorage.getColdStorageItemsList().add(createColdStorageItems(coldStorage, ColumnConstants.COLD_VEGETABLES, dataMap));
        coldStorage.getColdStorageItemsList().add(createColdStorageItems(coldStorage, ColumnConstants.COLD_FRUITS, dataMap));
        coldStorage.getColdStorageItemsList().add(createColdStorageItems(coldStorage, ColumnConstants.COLD_DAIRY, dataMap));
        coldStorage.getColdStorageItemsList().add(createColdStorageItems(coldStorage, ColumnConstants.COLD_DRINKS, dataMap));
        coldStorage.getColdStorageItemsList().add(createColdStorageItems(coldStorage, ColumnConstants.COLD_MEAT, dataMap));
        coldStorage.getColdStorageItemsList().add(createColdStorageItems(coldStorage, ColumnConstants.COLD_ICE_CREAM, dataMap));
        coldStorage.getColdStorageItemsList().add(createColdStorageItems(coldStorage, ColumnConstants.COLD_ICE_CREAM, dataMap));
        coldStorageRepository.save(coldStorage);
    }

    private ColdStorageItems createColdStorageItems(ColdStorage coldStorage, String itemName, Map<String, String> dataMap) {
        ColdStorageItems coldStorageItems = new ColdStorageItems();
        String[] stringOfInfo = dataMap.get(itemName).split(",");
        for (String s : stringOfInfo) {
            switch (s.trim()) {
                case "Food receiving vehicle was clean":
                    coldStorageItems.setVehicleClean(true);
                    break;
                case "No sign of Packaging Damage":
                    coldStorageItems.setPackagingWithoutDamage(true);
                    break;
                case "Expiry Date after 10 July 25":
                    coldStorageItems.setUnderExpiry(true);
                    break;
                case "Ingredients check":
                    coldStorageItems.setIngredientsChecked(true);
                    break;
                case "Items are store separately as required.":
                    coldStorageItems.setItemsSeparated(true);
                    break;
            }
        }
        itemName = itemName.replace("RECIEVING CHECKLIST (COLD STORAGE ) [", "").replace("]","");
        coldStorageItems.setItemName(itemName);
        coldStorageItems.setColdStorage(coldStorage);
        return  coldStorageItems;
    }
}
