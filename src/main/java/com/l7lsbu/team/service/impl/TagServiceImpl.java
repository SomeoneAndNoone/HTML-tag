package com.l7lsbu.team.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.l7lsbu.team.exceptions.CustomException;
import com.l7lsbu.team.io.entity.SingleTagEntity;
import com.l7lsbu.team.io.repository.SingleTagRepository;
import com.l7lsbu.team.service.intrfc.TagService;
import com.l7lsbu.team.shared.dto.TagDto;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    SingleTagRepository singleTagRepository;

    @Override
    public List<TagDto> getTags() {
        List<TagDto> returnValue = new ArrayList<>();
        Iterable<SingleTagEntity> tags = singleTagRepository.findAll();
        for (SingleTagEntity singleTagEntity : tags) {
            TagDto tagDto = new TagDto();
            BeanUtils.copyProperties(singleTagEntity, tagDto);
            returnValue.add(tagDto);
        }

        return returnValue;
    }

    @Override
    public TagDto createTag(TagDto tagDto) {
        if (singleTagRepository.findByTag(tagDto.getTag()) != null) {
            throw new CustomException("Tag already exists");
        }

        SingleTagEntity singleTagEntity = new SingleTagEntity();
        BeanUtils.copyProperties(tagDto, singleTagEntity);

        SingleTagEntity storedEntity = singleTagRepository.save(singleTagEntity);
        TagDto returnValue = new TagDto();
        BeanUtils.copyProperties(storedEntity, returnValue);

        return returnValue;
    }

    @Override
    public void deleteTag(String tag) {
        SingleTagEntity tagEntity = singleTagRepository.findByTag(tag);
        singleTagRepository.delete(tagEntity);
    }

    @Override
    public void deleteTagsByUrl(String parentUrl) {
        singleTagRepository.deleteTagsByUrl(parentUrl);
    }

    @Override
    public void deleteTagsByWebiste(String parentWebsite) {
        singleTagRepository.deleteTagsByWebsite(parentWebsite);
    }

    @Override
    public void updateTag(TagDto tagDto) {
        singleTagRepository.updateTag(tagDto.getTag(), tagDto.getTagId());
    }
}
