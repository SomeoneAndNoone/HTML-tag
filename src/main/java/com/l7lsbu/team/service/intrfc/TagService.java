package com.l7lsbu.team.service.intrfc;

import java.util.List;

import com.l7lsbu.team.shared.dto.TagDto;

public interface TagService {
    
    List<TagDto> getTags(String parentUrl);

    TagDto createTag(TagDto tagDto);

    void deleteTag(String tag);

    void deleteTagsByUrl(String parentUrl);

    void deleteTagsByWebiste(String parentWebsite);

    void updateTag(TagDto tagDto);
}

