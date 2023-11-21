package com.zara.price.pvp.application.find;

import com.zara.price.pvp.domain.Criteria;
import com.zara.price.pvp.domain.Pvp;
import com.zara.price.pvp.domain.PvpFinderRepository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class PvpFinder {

    private PvpFinderRepository repository;

    public Optional<Pvp> find(Criteria criteria) {
        return repository.find(criteria);
    }
}
