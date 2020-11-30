package com.l7lsbu.team.ui.model.response;

public class SingleUrlRest {

    private long urlId;

    private long timeStamp;

    private String url;

    private String parentWebsite;

    public long getUrlId() {
        return this.urlId;
    }

    public void setUrlId(long urlId) {
        this.urlId = urlId;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParentWebsite() {
        return this.parentWebsite;
    }

    public void setParentWebsite(String parentWebsite) {
        this.parentWebsite = parentWebsite;
    }

}
