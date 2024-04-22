package com.intern.chatproject.services.impl;

import com.intern.chatproject.dto.WebsiteEntityDto;
import com.intern.chatproject.entities.WebsiteEntity;
import com.intern.chatproject.repositories.jpa.WebsiteRepositoryJpa;
import com.intern.chatproject.services.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WebsiteServiceImpl implements WebsiteService {

    @Autowired
    WebsiteRepositoryJpa websiteRepositoryJpa;
    @Override
    public Object create(WebsiteEntityDto dto) {
        long currentTime = System.currentTimeMillis();
        WebsiteEntity entity = WebsiteEntity.builder()
                .websiteId(UUID.randomUUID().toString())
                .websiteKey(dto.getWebsiteKey())
                .websiteName(dto.getWebsiteName())
                .groupId(dto.getGroupId())
                .showFrom(dto.getShowFrom() == null ? currentTime : dto.getShowFrom()).build();
        return websiteRepositoryJpa.save(entity);
    }

    @Override
    public Object edit(WebsiteEntityDto dto) {
        return null;
    }

    @Override
    public Object delete(WebsiteEntityDto dto) {
        return null;
    }

    @Override
    public Object getById(String id) {
        return websiteRepositoryJpa.getWebsiteEntityDtoByWebsiteId(id);
    }
}
