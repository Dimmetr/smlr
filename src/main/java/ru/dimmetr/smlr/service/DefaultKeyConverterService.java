package ru.dimmetr.smlr.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@Component
public class DefaultKeyConverterService implements KeyConverterService {

    private char[] chars = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890-_".toCharArray();
    private Supplier<Map> sup = () -> {
        Map<Character, Long> map = new HashMap<>();
        for(int i = 0; i < chars.length; i++) {
            map.put(chars[i], Long.valueOf(i));
        }
        return map;
    };
    private Map<Character, Long> charToLong = sup.get();

    @Override
    public String idToKey(long id) {
        long n = id;
        StringBuilder builder = new StringBuilder();
        while (n != 0L) {
            builder.append(chars[Math.toIntExact(n % chars.length)]);
            n /= chars.length;
        }
        return builder.reverse().toString();
    }

    @Override
    public long keyToId(String key) {
        long a = 0L;
        for(Character c : key.toCharArray()) {
            a = a * chars.length + charToLong.get(c);
        }
        return a;
    }
}
