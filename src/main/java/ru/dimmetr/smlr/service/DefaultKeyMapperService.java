package ru.dimmetr.smlr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.dimmetr.smlr.model.Link;
import ru.dimmetr.smlr.model.repositories.LinkRepository;

import java.util.Optional;

@Component
public class DefaultKeyMapperService implements KeyMapperService {

    @Autowired
    private KeyConverterService converter;

    @Autowired
    private LinkRepository repo;

    @Override
    public Get getLink(String key) {
        Optional<Link> result = repo.findOne(converter.keyToId(key));
        if (result.isPresent()) {
            return new ru.dimmetr.smlr.service.Link(result.get().getText());
        } else {
            return new NotFound(key);
        }
    }

    @Override
    @Transactional
    public String add(String link) {
        return converter.idToKey(repo.save(new Link(link)).getId());
    }
}
