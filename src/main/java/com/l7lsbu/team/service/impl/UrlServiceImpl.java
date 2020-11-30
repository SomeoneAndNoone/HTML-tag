package com.l7lsbu.team.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.l7lsbu.team.exceptions.CustomException;
import com.l7lsbu.team.io.entity.SingleUrlEntity;
import com.l7lsbu.team.repository.SingleUrlRepository;
import com.l7lsbu.team.service.intrfc.UrlService;
import com.l7lsbu.team.shared.dto.UrlDto;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class UrlServiceImpl implements UrlService {


    @Autowired
    SingleUrlRepository singleUrlRepository;


    @Override
    public List<UrlDto> getUrls(String parentWebsite) {
        List<UrlDto> returnValue = new ArrayList<>();
        List<SingleUrlEntity> urls = singleUrlRepository.findAllByParentWebsite(parentWebsite);
        for (SingleUrlEntity urlEntity : urls) {
            UrlDto urlDto = new UrlDto();
            BeanUtils.copyProperties(urlEntity, urlDto);
            returnValue.add(urlDto);
        }

        return returnValue;
    }

    @Override
    public UrlDto createUrl(UrlDto urlDto) {
        if(singleUrlRepository.findByUrl(urlDto.getUrl()) != null){
            throw new CustomException("Url already exists");
        }

        SingleUrlEntity singleUrlEntity =  new SingleUrlEntity();
        BeanUtils.copyProperties(urlDto, singleUrlEntity);

        SingleUrlEntity storedEntity = singleUrlRepository.save(singleUrlEntity);
        UrlDto returnValue = new UrlDto();
        BeanUtils.copyProperties(storedEntity, returnValue);

        return returnValue;
    }

    @Override
    public void deleteUrl(String url) {
        SingleUrlEntity urlEntity = singleUrlRepository.findByUrl(url);
        singleUrlRepository.delete(urlEntity);
    }

    @Override
    public void deleteUrls(String parentWebsite) {
        List<SingleUrlEntity> dUrls = singleUrlRepository.findAllByParentWebsite(parentWebsite);
        for(SingleUrlEntity dUrl : dUrls) {
            singleUrlRepository.delete(dUrl);
        }
    }

}
