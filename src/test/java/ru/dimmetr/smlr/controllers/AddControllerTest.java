package ru.dimmetr.smlr.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.dimmetr.smlr.SmlrApplication;
import ru.dimmetr.smlr.service.AddRequest;
import ru.dimmetr.smlr.service.KeyMapperService;

@TestPropertySource(locations = "classpath:repositories-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SmlrApplication.class)
@WebAppConfiguration
public class AddControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Mock
    private KeyMapperService service;

    @Autowired
    @InjectMocks
    public AddController controller;

    private final static String KEY = "key";
    private final static String LINK = "link";

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        Mockito.when(service.add(LINK)).thenReturn(KEY);
    }

    @Test
    public void whenUserAddLinkHeTakesAKey() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(new AddRequest(LINK))))
                .andExpect(MockMvcResultMatchers.jsonPath("$.key", Matchers.equalTo(KEY)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.link", Matchers.equalTo(LINK)));
    }

    @Test
    public void whenUserAddLinkByFormHeTakesWebPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/addhmtl")
                .param("link", LINK)
        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(KEY)))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(LINK)));
    }
}
