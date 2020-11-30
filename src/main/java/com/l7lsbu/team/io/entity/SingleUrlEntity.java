package com.l7lsbu.team.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "urls")
public class SingleUrlEntity implements Serializable {
    
    private static final long serialVersionUID = 2186782296286417730L;

    @Id
	@GeneratedValue
    private long urlId;

    @Column(nullable = false)
    private long timeStamp = 23123;

    @Column(nullable = false)
    private String url = "";

    @Column(nullable = false)
    private String parentWebsite = "";


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
