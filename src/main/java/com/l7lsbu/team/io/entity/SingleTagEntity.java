package com.l7lsbu.team.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "tags")
public class SingleTagEntity implements Serializable {
    
    private static final long serialVersionUID = -7453233320333976206L;

    @Id
	@GeneratedValue
    private long tagId;

    @Column(nullable = false)
    private long timeStamp = 232;

	@Column(nullable = false)
    private String tag = "";


    @Column(nullable = false)
    private String parentUrl = "";

    @Column(nullable = false)
    private String parentWebsite = "";



    
    public String getParentWebsite() {
        return this.parentWebsite;
    }

    public void setParentWebsite(String parentWebsite) {
        this.parentWebsite = parentWebsite;
    }

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

    public String getParentUrl() {
        return this.parentUrl;
    }

    public void setParentUrl(String parentUrl) {
        this.parentUrl = parentUrl;
    }

}
