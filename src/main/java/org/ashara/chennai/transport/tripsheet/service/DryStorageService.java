package org.ashara.chennai.transport.tripsheet.service;

import org.ashara.chennai.transport.tripsheet.beans.DryStorageDTO;
import org.ashara.chennai.transport.tripsheet.entities.DryStorage;
import org.ashara.chennai.transport.tripsheet.entities.DryStorageItems;
import org.ashara.chennai.transport.tripsheet.repository.DryStorageRepository;
import org.ashara.chennai.transport.tripsheet.service.constants.ColumnConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DryStorageService {

    @Autowired
    DryStorageRepository dryStorageRepository;

    public void create(Map<String, String> dataMap) {
        DryStorage dryStorage = new DryStorage();
        dryStorage.setEntryTime(dataMap.get(ColumnConstants.TIMESTAMP));
        dryStorage.setZone(dataMap.get(ColumnConstants.ZONE_NAME));
        dryStorage.setTeamMemberName(dataMap.get(ColumnConstants.FSH_TEAM_MEMBER_NAME));
        dryStorage.getDryStorageItemsList().add(createDryStorageItems(dryStorage, ColumnConstants.DRY_POWDERED_SPICES, dataMap));
        dryStorage.getDryStorageItemsList().add(createDryStorageItems(dryStorage, ColumnConstants.LIQUID_SPICES, dataMap));
        dryStorage.getDryStorageItemsList().add(createDryStorageItems(dryStorage, ColumnConstants.WHOLE_SPICES, dataMap));
        dryStorage.getDryStorageItemsList().add(createDryStorageItems(dryStorage, ColumnConstants.OILS_GHEE, dataMap));
        dryStorage.getDryStorageItemsList().add(createDryStorageItems(dryStorage, ColumnConstants.ATTA_FLOURS, dataMap));
        dryStorage.getDryStorageItemsList().add(createDryStorageItems(dryStorage, ColumnConstants.RICES, dataMap));
        dryStorage.getDryStorageItemsList().add(createDryStorageItems(dryStorage, ColumnConstants.PULSES_DALS, dataMap));
        dryStorage.getDryStorageItemsList().add(createDryStorageItems(dryStorage, ColumnConstants.SUGAR_TEA, dataMap));
        dryStorage.getDryStorageItemsList().add(createDryStorageItems(dryStorage, ColumnConstants.DRY_FRUITS_SEEDS, dataMap));
        dryStorage.getDryStorageItemsList().add(createDryStorageItems(dryStorage, ColumnConstants.SAUCES_SPREAD, dataMap));
        dryStorage.getDryStorageItemsList().add(createDryStorageItems(dryStorage, ColumnConstants.SOAP_LIQUID_SOAP, dataMap));
        dryStorage.getDryStorageItemsList().add(createDryStorageItems(dryStorage, ColumnConstants.OTHER_DAIRY_BREAD_EGG, dataMap));
        dryStorageRepository.save(dryStorage);
    }

    private DryStorageItems createDryStorageItems(DryStorage dryStorage, String itemName, Map<String, String> dataMap) {
        DryStorageItems dryStorageItems = new DryStorageItems();
        String[] stringOfInfo = dataMap.get(itemName).split(",");
        for (String s : stringOfInfo) {
            switch (s.trim()) {
                case "Food receiving vehicle was clean":
                    dryStorageItems.setVehicleClean(true);
                    break;
                case "No sign of Packaging Damage":
                    dryStorageItems.setPackagingWithoutDamage(true);
                    break;
                case "Expiry Date after 10 July 25":
                    dryStorageItems.setUnderExpiry(true);
                    break;
                case "Ingredients check":
                    dryStorageItems.setIngredientsChecked(true);
                    break;
                case "Items are store separately as required.":
                    dryStorageItems.setItemsSeparated(true);
                    break;
            }
        }
        itemName = itemName.replace("RECIEVING CHECKLIST (DRY) [", "").replace("]","");
        dryStorageItems.setItemName(itemName);
        dryStorageItems.setDryStorage(dryStorage);
        return  dryStorageItems;
    }

    public List<DryStorageDTO> getDryStorageDetails() {
        new ArrayList<>();
        List<DryStorage> dryStorageList = dryStorageRepository.findAll();

        return dryStorageList.stream().map(dryStorage -> {
            DryStorageDTO dryStorageDTO = new DryStorageDTO();
            dryStorageDTO.setId(dryStorage.getId());
            dryStorageDTO.setTeamMemberName(dryStorage.getTeamMemberName());
            dryStorageDTO.setZone(dryStorage.getZone());
            dryStorageDTO.setEntryTime(dryStorage.getEntryTime());
            return dryStorageDTO;
        }).collect(Collectors.toList());
    }

}