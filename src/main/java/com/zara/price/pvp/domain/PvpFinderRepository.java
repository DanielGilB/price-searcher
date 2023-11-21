package com.zara.price.pvp.domain;

import java.util.Optional;

public interface PvpFinderRepository {
    Optional<Pvp> find(Criteria criteria);
}
