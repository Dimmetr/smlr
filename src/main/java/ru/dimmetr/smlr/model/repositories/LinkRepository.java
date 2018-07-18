package ru.dimmetr.smlr.model.repositories;

import org.springframework.data.repository.Repository;
import ru.dimmetr.smlr.model.Link;

import java.util.List;
import java.util.Optional;

public interface LinkRepository extends Repository<Link, Long> {

    Optional<Link> findOne(Long id);
    Link save(Link link);
    List<Link> findAll();
}
