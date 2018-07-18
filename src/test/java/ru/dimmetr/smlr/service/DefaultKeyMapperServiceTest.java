package ru.dimmetr.smlr.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class DefaultKeyMapperServiceTest {

    @InjectMocks
    private KeyMapperService service = new DefaultKeyMapperService();

    private final static String KEY = "aAbBcCdD";
    private final static String LINK_A = "http://www.google.com";
    private final static String LINK_B = "http://www.yahoo.com";
    private final static String KEY_A = "abc";
    private final static String KEY_B = "cde";
    private final static long ID_A = 10000000L;
    private final static long ID_B = 10000001L;


    @Mock
    private KeyConverterService converter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        Mockito.when(converter.keyToId(KEY_A)).thenReturn(ID_A);
        Mockito.when(converter.idToKey(ID_A)).thenReturn(KEY_A);
        Mockito.when(converter.keyToId(KEY_B)).thenReturn(ID_B);
        Mockito.when(converter.idToKey(ID_B)).thenReturn(KEY_B);
    }

    @Test
    public void clientCanAddLinks() {
        String keyA = service.add(LINK_A);
        assertEquals(new Link(LINK_A), service.getLink(keyA));
        String keyB = service.add(LINK_B);
        assertEquals(new Link(LINK_B), service.getLink(keyB));
        assertNotEquals(keyA, keyB);
    }

    @Test
    public void clientCanNotTakeLinkIfKeyIsNotFoundInService() {
        assertEquals(new NotFound(KEY), service.getLink(KEY));
    }

}
