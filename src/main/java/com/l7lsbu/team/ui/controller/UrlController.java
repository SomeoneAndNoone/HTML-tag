package com.l7lsbu.team.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.l7lsbu.team.service.intrfc.UrlService;
import com.l7lsbu.team.shared.dto.UrlDto;
import com.l7lsbu.team.ui.model.request.UrlRequestModel;
import com.l7lsbu.team.ui.model.response.OperationStatusModel;
import com.l7lsbu.team.ui.model.response.RequestOperationStatus;
import com.l7lsbu.team.ui.model.response.SingleUrlRest;

import org.springframework.http.MediaType;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

@RestController
@RequestMapping("urls") // http://localhost:8080/tags
public class UrlController  {
    
    @Autowired
    UrlService urlService;

    @GetMapping(path = "/{parentWebsite}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<SingleUrlRest> getUrlsByWebsite(@PathVariable String parentWebsite){
        List<SingleUrlRest> returnValue = new ArrayList<>();

        List<UrlDto> urls = urlService.getUrls(parentWebsite);
        
        Type lisType = new TypeToken<List<SingleUrlRest>>() {}.getType();

        returnValue = new ModelMapper().map(urls, lisType);
        
        return returnValue;
    }


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE}) 
    public SingleUrlRest createUrl(@RequestBody UrlRequestModel urlRequest) throws Exception{
        SingleUrlRest returnValue = new SingleUrlRest();

        ModelMapper modelMapper = new ModelMapper();
		UrlDto urlDto = modelMapper.map(urlRequest, UrlDto.class);

		UrlDto createdUrl = urlService.createUrl(urlDto);
		returnValue = modelMapper.map(createdUrl, SingleUrlRest.class);

		return returnValue;
    }

    @DeleteMapping(path = "/{url}", produces = {MediaType.APPLICATION_JSON_VALUE })
    public OperationStatusModel deleteUrl(@PathVariable String url) {

        OperationStatusModel returnValue = new OperationStatusModel();
        returnValue.setOperationName(RequestOperationName.DELETE.name());
        
        urlService.deleteUrl(url);
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
        return returnValue;
    }
}
