package com.l7lsbu.team.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class SingleTagEntity implements Serializable {
    
    private static final long serialVersionUID = -7453233320333976206L;

    @Id
	@GeneratedValue
    private long tagId;

    @Column(nullable = false)
    private long timeStamp;

	@Column(nullable = false)
    private String tag;

    @Column(nullable = false)
    private String parentTag;

    @Column(nullable = false)
    private String parentUrl;


    public long getTagId() {
        return this.tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getParentTag() {
        return this.parentTag;
    }

    public void setParentTag(String parentTag) {
        this.parentTag = parentTag;
    }

    public String getParentUrl() {
        return this.parentUrl;
    }

    public void setParentUrl(String parentUrl) {
        this.parentUrl = parentUrl;
    }

}