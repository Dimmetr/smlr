package ru.dimmetr.smlr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dimmetr.smlr.service.KeyMapperService;
import ru.dimmetr.smlr.service.Link;
import ru.dimmetr.smlr.service.NotFound;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/{key}")
public class RedirectController {

    private static final String HEADER_NAME = "Location";

    @Autowired
    private KeyMapperService service;

    @RequestMapping()
    public void redirect(@PathVariable(value = "key") String key, HttpServletResponse response) {
        KeyMapperService.Get result = service.getLink(key);

        if (result instanceof Link) {
            response.setHeader(HEADER_NAME, ((Link) result).getLink());
            response.setStatus(302);
        } else if (result instanceof NotFound) {
            response.setStatus(404);
        }
    }


}
