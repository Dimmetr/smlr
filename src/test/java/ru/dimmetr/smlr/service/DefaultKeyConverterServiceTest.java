package ru.dimmetr.smlr.service;

import org.junit.Test;

import java.util.Random;

public class DefaultKeyConverterServiceTest {

    private KeyConverterService service = new DefaultKeyConverterService();

    @Test
    public void givenIdMustBeConvertableBothWays() {
        Random rand = new Random();
        for (long i = 0; i < 1000L; i++) {
            long initialId = Math.abs(rand.nextLong());
            String key = service.idToKey(initialId);
            long id = service.keyToId(key);
            org.junit.Assert.assertEquals(initialId, id);
        }
    }
}
