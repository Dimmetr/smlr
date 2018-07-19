package ru.dimmetr.smlr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dimmetr.smlr.service.AddRequest;
import ru.dimmetr.smlr.service.AddResponse;
import ru.dimmetr.smlr.service.KeyMapperService;

@Controller
public class AddController {

    public AddController() {
    }

    @Value("${smlr.prefix}")
    private String prefix;

    @Autowired
    private KeyMapperService service;

    @RequestMapping(path = "add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<AddResponse> addRest(@RequestBody AddRequest request) {
        return ResponseEntity.ok(new AddResponse(request.getLink(), service.add(request.getLink())));
    }

    @RequestMapping(path = "addhtml", method = RequestMethod.POST)
    public String addHtml(Model model,
                          @RequestParam(value = "link", required = true) String link) {
        AddResponse result = add(link);
        model.addAttribute("link", result.getLink());
        model.addAttribute("keyed", prefix + result.getKey());
        return "result";
    }

    private AddResponse add(String link) {
        return new AddResponse(link, service.add(link));
    }

}
