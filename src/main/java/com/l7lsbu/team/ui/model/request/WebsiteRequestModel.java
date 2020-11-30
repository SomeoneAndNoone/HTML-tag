package com.l7lsbu.team.ui.model.request;

public class WebsiteRequestModel {
    
    private long websiteId;

    private long timeStamp;

    private String website;


    public long getWebsiteId() {
        return this.websiteId;
    }

    public void setWebsiteId(long websiteId) {
        this.websiteId = websiteId;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
