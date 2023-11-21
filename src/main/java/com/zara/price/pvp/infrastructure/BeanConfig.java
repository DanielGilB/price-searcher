package com.zara.price.pvp.infrastructure;

import com.zara.price.pvp.application.find.PvpFinder;
import com.zara.price.pvp.domain.PvpFinderRepository;
import com.zara.price.pvp.infrastructure.persistence.JpaPvpFinderRepository;
import com.zara.price.pvp.infrastructure.persistence.SqlPvpFinderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public PvpFinderRepository pvpFinderRepository(JpaPvpFinderRepository jpaPvpFinderRepository) {
        return new SqlPvpFinderRepository(jpaPvpFinderRepository);
    }

    @Bean
    public PvpFinder pvpFinder(PvpFinderRepository pvpFinderRepository) {
        return new PvpFinder(pvpFinderRepository);
    }
}
