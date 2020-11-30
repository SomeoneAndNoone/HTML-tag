package com.l7lsbu.team.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="websites")
public class SingleWebsiteEntity implements Serializable {
    
    private static final long serialVersionUID = -1361132597679777573L;

    @Id
	@GeneratedValue
    private long websiteId;
    
    @Column(nullable = false)
    private long timeStamp = 12123;

    @Column(nullable = false)
    private String website = "";


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
