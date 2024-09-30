package com.emazon.transaction.adapters.driven.feigns.adapter;

import com.emazon.transaction.adapters.driven.feigns.client.UserFeign;
import com.emazon.transaction.domain.spi.UserPersistencePort;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFeignAdapter implements UserPersistencePort {
    private final UserFeign userFeign;

    @Override
    public String getIdFromCurrentUser() {
        try {
            return userFeign.getUserByToken().getId();
        } catch (FeignException e) {
            return null;
        }
    }
}