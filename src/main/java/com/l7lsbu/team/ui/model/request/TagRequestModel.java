package com.l7lsbu.team.ui.model.request;

public class TagRequestModel {

    private long tagId;

    private long timeStamp;

    private String tag;

    private String parentUrl;

    private String parentWebsite;

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


    public String getParentWebsite() {
        return this.parentWebsite;
    }

    public void setParentWebsite(String parentWebsite) {
        this.parentWebsite = parentWebsite;
    }
  

    public String getParentUrl() {
        return this.parentUrl;
    }

    public void setParentUrl(String parentUrl) {
        this.parentUrl = parentUrl;
    }
}
