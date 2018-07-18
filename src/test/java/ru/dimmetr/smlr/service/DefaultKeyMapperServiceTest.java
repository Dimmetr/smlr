package ru.dimmetr.smlr.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ru.dimmetr.smlr.model.repositories.LinkRepository;

import java.util.Optional;

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
    private ru.dimmetr.smlr.model.Link LINK_OBJ_A = new ru.dimmetr.smlr.model.Link(LINK_A, ID_A);
    private ru.dimmetr.smlr.model.Link LINK_OBJ_B = new ru.dimmetr.smlr.model.Link(LINK_B, ID_B);


    @Mock
    private KeyConverterService converter;

    @Mock
    private LinkRepository repo;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        Mockito.when(converter.keyToId(KEY_A)).thenReturn(ID_A);
        Mockito.when(converter.idToKey(ID_A)).thenReturn(KEY_A);
        Mockito.when(converter.keyToId(KEY_B)).thenReturn(ID_B);
        Mockito.when(converter.idToKey(ID_B)).thenReturn(KEY_B);

        Mockito.when(repo.findOne(Mockito.anyObject())).thenReturn(Optional.empty());
        Mockito.when(repo.save(new ru.dimmetr.smlr.model.Link(LINK_A))).thenReturn(LINK_OBJ_A);
        Mockito.when(repo.save(new ru.dimmetr.smlr.model.Link(LINK_B))).thenReturn(LINK_OBJ_B);
        Mockito.when(repo.findOne(ID_A)).thenReturn(Optional.of(LINK_OBJ_A));
        Mockito.when(repo.findOne(ID_B)).thenReturn(Optional.of(LINK_OBJ_B));
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
