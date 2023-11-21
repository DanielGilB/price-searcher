package com.zara.price.pvp.application.find;

import com.zara.price.pvp.domain.Criteria;
import com.zara.price.pvp.domain.Pvp;
import com.zara.price.pvp.domain.PvpFinderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PvpFinder {

    private PvpFinderRepository repository;

    public Optional<Pvp> find(Criteria criteria) {
        return repository.find(criteria);
    }
}
