package ru.dimmetr.smlr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.dimmetr.smlr.service.AddRequest;
import ru.dimmetr.smlr.service.AddResponse;
import ru.dimmetr.smlr.service.KeyMapperService;

@Controller
@RequestMapping("add")
public class AddController {

    public AddController() {
    }

    @Autowired
    private KeyMapperService service;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<AddResponse> add(@RequestBody AddRequest request) {
        return ResponseEntity.ok(new AddResponse(request.getLink(), service.add(request.getLink())));
    }

}
