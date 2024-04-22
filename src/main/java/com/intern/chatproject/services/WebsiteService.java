package com.intern.chatproject.services;

import com.intern.chatproject.dto.WebsiteEntityDto;

public interface WebsiteService {
    Object create(WebsiteEntityDto dto);
    Object edit(WebsiteEntityDto dto);
    Object delete(WebsiteEntityDto dto);
    Object getById(String id);
}
