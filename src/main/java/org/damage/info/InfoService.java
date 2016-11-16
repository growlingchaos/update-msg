package org.damage.info;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InfoService {

    private final Map<String, Info> infoMap;


    public InfoService() {
        infoMap = createStrtingData();
    }

    private Map<String, Info> createStrtingData() {
        HashMap<String, Info> map = new HashMap<>();
        map.put("one", new Info("one", 101));
        map.put("two", new Info("two", 22));
        return map;
    }

    public Info findInfoById(String id) {
        if (!infoMap.containsKey(id)) {
            throw new NotFoundException(Info.class, id);
        }
        return infoMap.get(id);
    }

    public String addNewInfo(Info newInfo) {
        String newInfoId = newInfo.getName();
        if (infoMap.containsKey(newInfoId)) {
            throw new IllegalArgumentException("Info already present");
        }
        infoMap.put(newInfoId, newInfo);
        return newInfoId;
    }
}
