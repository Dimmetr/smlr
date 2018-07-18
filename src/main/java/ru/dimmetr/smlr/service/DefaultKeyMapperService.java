package ru.dimmetr.smlr.service;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DefaultKeyMapperService implements KeyMapperService {

    private Map<String, String> map= new ConcurrentHashMap<>();

    @Override
    public Add add(String key, String link) {
        if (map.containsKey(key)) {
            return new AlreadyExist(key);
        } else {
            map.put(key, link);
            return new Success(key, link);
        }
    }

    @Override
    public Get getLink(String key) {
        if (map.containsKey(key)) {
            return new Link(map.get(key));
        } else {
            return new NotFound(key);
        }
    }
}
