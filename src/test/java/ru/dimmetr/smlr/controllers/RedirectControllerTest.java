package ru.dimmetr.smlr.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.dimmetr.smlr.service.KeyMapperService;
import ru.dimmetr.smlr.service.Link;
import ru.dimmetr.smlr.service.NotFound;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedirectControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Mock
    private KeyMapperService service;

    @Autowired
    @InjectMocks
    public RedirectController controller;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        Mockito.when(service.getLink(PATH)).thenReturn(new Link(HEADER_VALUE));
        Mockito.when(service.getLink(BAD_PATH)).thenReturn(new NotFound(BAD_PATH));
    }

    private final static String PATH = "aAbBcCdD";
    private final static int REDIRECT_STATUS = 302;
    private final static String HEADER_NAME = "Location";
    private final static String HEADER_VALUE = "http://www.eveonline.com";

    @Test
    public void controllerMustRedirectUsWhenRequestIsSuccessful() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/" + PATH))
                .andExpect(MockMvcResultMatchers.status().is(REDIRECT_STATUS))
                .andExpect(MockMvcResultMatchers.header().string(HEADER_NAME, HEADER_VALUE));
    }

    private final static String BAD_PATH = "/olololo";
    private final static int NOT_FOUND = 404;

    @Test
    public void controllerMustReturn404ifBadKey() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/" + BAD_PATH))
                .andExpect(MockMvcResultMatchers.status().is(NOT_FOUND));
    }
}
