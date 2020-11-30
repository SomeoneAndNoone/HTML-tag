package com.l7lsbu.team.service.intrfc;

import java.util.List;

import com.l7lsbu.team.shared.dto.UrlDto;

public interface UrlService {
    
    List<UrlDto> getUrls(String parentWebsite);

    UrlDto createUrl(UrlDto urlDto);

    void deleteUrl(String url);

    void deleteUrls(String parentWebsite);
}
