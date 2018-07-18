package ru.dimmetr.smlr.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class DefaultKeyMapperServiceTest {

    private KeyMapperService service = new DefaultKeyMapperService();

    private final static String KEY = "aAbBcCdD";
    private final static String LINK = "http://www.eveonline.com";
    private final static String LINK_NEW = "http://wow.ru";

    @Test
    public void clientCanAddNewKeyWithLink() {
        assertEquals(new Success(KEY, LINK), service.add(KEY, LINK));
        assertEquals(new Link(LINK), service.getLink(KEY));
    }

    @Test
    public void clientCanNotAddExistingKey() {
        service.add(KEY, LINK);
        assertEquals(new AlreadyExist(KEY), service.add(KEY, LINK_NEW));
        assertEquals(new Link(LINK), service.getLink(KEY));
    }

    @Test
    public void clientCanNotTakeLinkIfKeyIsNotFoundInService() {
        assertEquals(new NotFound(KEY), service.getLink(KEY));
    }

}
