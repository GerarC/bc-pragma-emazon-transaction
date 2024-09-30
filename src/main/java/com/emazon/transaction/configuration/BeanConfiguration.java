package com.emazon.transaction.configuration;

import com.emazon.transaction.adapters.driven.feigns.adapter.ProductFeignAdapter;
import com.emazon.transaction.adapters.driven.feigns.client.ProductFeign;
import com.emazon.transaction.adapters.driven.jpa.adapter.SupplyJpaAdapter;
import com.emazon.transaction.adapters.driven.jpa.mapper.SupplyEntityMapper;
import com.emazon.transaction.adapters.driven.jpa.persistence.SupplyRepository;
import com.emazon.transaction.domain.api.SaleServicePort;
import com.emazon.transaction.domain.api.SupplyServicePort;
import com.emazon.transaction.domain.api.usecase.SaleUseCase;
import com.emazon.transaction.domain.api.usecase.SupplyUseCase;
import com.emazon.transaction.domain.spi.ProductPersistencePort;
import com.emazon.transaction.domain.spi.SalePersistencePort;
import com.emazon.transaction.domain.spi.SupplyPersistencePort;
import com.emazon.transaction.domain.spi.UserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final UserDetailsService userDetailsService;
    private final SupplyPersistencePort supplyPersistencePort;
    private final ProductPersistencePort productPersistencePort;
    private final UserPersistencePort userPersistencePort;
    private final SalePersistencePort salePersistencePort;

    @Bean
    SupplyServicePort supplyServicePort() {
        return new SupplyUseCase(supplyPersistencePort, productPersistencePort, userPersistencePort);
    }

    @Bean
    SaleServicePort saleServicePort() {
        return new SaleUseCase(salePersistencePort, userPersistencePort, productPersistencePort);
    }


    // security
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }

}
