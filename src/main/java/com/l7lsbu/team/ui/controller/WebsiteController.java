package com.l7lsbu.team.ui.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.l7lsbu.team.service.intrfc.WebsiteService;
import com.l7lsbu.team.shared.dto.WebsiteDto;
import com.l7lsbu.team.ui.model.request.WebsiteRequestModel;
import com.l7lsbu.team.ui.model.response.OperationStatusModel;
import com.l7lsbu.team.ui.model.response.RequestOperationStatus;
import com.l7lsbu.team.ui.model.response.SingleWebsiteRest;

import org.springframework.http.MediaType;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("websites") // http://localhost:8080/websites
public class WebsiteController {
    
    @Autowired
    WebsiteService websiteService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<SingleWebsiteRest> getWebsites(){
        List<SingleWebsiteRest> returnValue = new ArrayList<>();

        List<WebsiteDto> websites = websiteService.getWebsites();
        
        Type lisType = new TypeToken<List<SingleWebsiteRest>>() {}.getType();

        returnValue = new ModelMapper().map(websites, lisType);
        
        return returnValue;
    }

    @PostMapping
    public SingleWebsiteRest createWebsite(@RequestBody WebsiteRequestModel websiteRequest) {
        SingleWebsiteRest returnValue = new SingleWebsiteRest();

		WebsiteDto websiteDto = new WebsiteDto();
        BeanUtils.copyProperties(websiteRequest, websiteDto);

		WebsiteDto createdWebsite = websiteService.createWebsite(websiteDto);
		
        BeanUtils.copyProperties(createdWebsite, returnValue);
		return returnValue;
    }

    @DeleteMapping(path = "/{website}", produces = {MediaType.APPLICATION_JSON_VALUE })
    public OperationStatusModel deleteWebsite(@PathVariable String website) {

        OperationStatusModel returnValue = new OperationStatusModel();
        returnValue.setOperationName(RequestOperationName.DELETE.name());
        
        websiteService.deleteWebsite(website);
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
        return returnValue;
    }
}
