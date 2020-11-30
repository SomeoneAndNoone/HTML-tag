package com.l7lsbu.team.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.l7lsbu.team.exceptions.CustomException;
import com.l7lsbu.team.io.entity.SingleWebsiteEntity;
import com.l7lsbu.team.io.repository.SingleWebsiteRepository;
import com.l7lsbu.team.service.intrfc.WebsiteService;
import com.l7lsbu.team.shared.dto.WebsiteDto;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class WebsiteServiceImpl implements WebsiteService {

    @Autowired
    SingleWebsiteRepository singleWebsiteRepository;

    @Override
    public List<WebsiteDto> getWebsites() {
        
        List<WebsiteDto> returnValue = new ArrayList<>();
        Iterable<SingleWebsiteEntity> websites = singleWebsiteRepository.findAll();
        for(SingleWebsiteEntity websiteEntity : websites) {
            WebsiteDto websiteDto = new WebsiteDto();
            BeanUtils.copyProperties(websiteEntity, websiteDto);
            returnValue.add(websiteDto);
        }

        return returnValue;
    }

    @Override
    public WebsiteDto createWebsite(WebsiteDto websiteDto) {
        if(singleWebsiteRepository.findByWebsite(websiteDto.getWebsite()) != null){
            throw new CustomException("Url already exists");
        }

        SingleWebsiteEntity singleWebsiteEntity =  new SingleWebsiteEntity();
        BeanUtils.copyProperties(websiteDto, singleWebsiteEntity);

        SingleWebsiteEntity storedEntity = singleWebsiteRepository.save(singleWebsiteEntity);
        WebsiteDto returnValue = new WebsiteDto();
        BeanUtils.copyProperties(storedEntity, returnValue);

        return returnValue;
    }

    @Override
    public void deleteWebsite(String webiste) {
        SingleWebsiteEntity websiteEntity = singleWebsiteRepository.findByWebsite(webiste);
        singleWebsiteRepository.delete(websiteEntity);
    }
    
}
