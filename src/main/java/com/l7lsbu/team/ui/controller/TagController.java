package com.l7lsbu.team.ui.controller;

import java.util.ArrayList;
import java.util.List;

import com.l7lsbu.team.service.intrfc.TagService;
import com.l7lsbu.team.shared.dto.TagDto;
import com.l7lsbu.team.ui.model.request.DeleteTagRequest;
import com.l7lsbu.team.ui.model.request.TagRequestModel;
import com.l7lsbu.team.ui.model.response.OperationStatusModel;
import com.l7lsbu.team.ui.model.response.RequestOperationStatus;
import com.l7lsbu.team.ui.model.response.SingleTagRest;

import java.lang.reflect.Type;
import org.springframework.http.MediaType;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tags") // http://localhost:8080/tags/
public class TagController {
    
    @Autowired
    TagService tagService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<SingleTagRest> getTagsByUrl(){
        List<SingleTagRest> returnValue = new ArrayList<>();

        List<TagDto> tags = tagService.getTags();
        
        Type lisType = new TypeToken<List<SingleTagRest>>() {}.getType();

        returnValue = new ModelMapper().map(tags, lisType);
        
        return returnValue;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE}) 
    public SingleTagRest createTag(@RequestBody TagRequestModel tagRequest) throws Exception{
        SingleTagRest returnValue = new SingleTagRest();

        ModelMapper modelMapper = new ModelMapper();
		TagDto tagDto = modelMapper.map(tagRequest, TagDto.class);

		TagDto createdTag = tagService.createTag(tagDto);
		returnValue = modelMapper.map(createdTag, SingleTagRest.class);

		return returnValue;
    }

    @DeleteMapping(path = "/byTag", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE })
    public OperationStatusModel deleteTag(@RequestBody DeleteTagRequest request) {

        OperationStatusModel returnValue = new OperationStatusModel();
        returnValue.setOperationName(RequestOperationName.DELETE.name());
        
        tagService.deleteTag(request.getRequestStr());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
        return returnValue;
    }

    @DeleteMapping(path = "/byParentUrl", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE })
    public OperationStatusModel deleteTagByParentUrl(@RequestBody DeleteTagRequest request) {

        OperationStatusModel returnValue = new OperationStatusModel();
        returnValue.setOperationName(RequestOperationName.DELETE.name());
        
        tagService.deleteTagsByUrl(request.getRequestStr());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
        return returnValue;
    }

    @DeleteMapping(path = "/byParentWebsite", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE })
    public OperationStatusModel deleteTagByParentWebsite(@RequestBody DeleteTagRequest request) {

        OperationStatusModel returnValue = new OperationStatusModel();
        returnValue.setOperationName(RequestOperationName.DELETE.name());
        
        tagService.deleteTagsByWebiste(request.getRequestStr());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
        return returnValue;
    }
}





















