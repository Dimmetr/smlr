package ru.dimmetr.smlr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class DefaultKeyMapperService implements KeyMapperService {

    @Autowired
    private KeyConverterService converter;

    private AtomicLong sequence = new AtomicLong(10000000L);

    private Map<Long, String> map = new ConcurrentHashMap<>();

    @Override
    public Get getLink(String key) {
        long id = converter.keyToId(key);
        String result = map.get(id);
        if (result == null) {
            return new NotFound(key);
        } else {
            return new Link(result);
        }
    }

    @Override
    public String add(String link) {
        long id = sequence.getAndIncrement();
        String key = converter.idToKey(id);
        map.put(id, link);
        return key;
    }
}
