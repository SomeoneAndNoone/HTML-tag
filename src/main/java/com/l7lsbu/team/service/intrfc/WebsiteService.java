package com.l7lsbu.team.service.intrfc;

import java.util.List;

import com.l7lsbu.team.shared.dto.WebsiteDto;


public interface WebsiteService {

    List<WebsiteDto> getWebsites();

    WebsiteDto createWebsite(WebsiteDto websiteDto);

    WebsiteDto deleteWebsite(String webisteUrl);
}
