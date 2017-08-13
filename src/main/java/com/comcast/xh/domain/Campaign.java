package com.comcast.xh.domain;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by skonda004c on 8/5/2017.
 */

@Entity
@Table(name="campaign", schema = "public")
public class Campaign {

    private Long campaignid;
    private String partnerid;
    private String adcontent;
    private String adtitle;
    private String adstatus;
    private int duration;
    private Date dateOfCreation;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long getCampaignid() {
        return campaignid;
    }

    public void setCampaignid(Long campaignid) {
        this.campaignid = campaignid;
    }

    //@Id
    public String getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(String partnerid) {
        this.partnerid = partnerid;
    }

    public String getAdcontent() {
        return adcontent;
    }

    public void setAdcontent(String adcontent) {
        this.adcontent = adcontent;
    }

    public String getAdtitle() {
        return adtitle;
    }

    public void setAdtitle(String adtitle) {
        this.adtitle = adtitle;
    }

    public String getAdstatus() {
        return adstatus;
    }

    public void setAdstatus(String adstatus) {
        this.adstatus = adstatus;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
}
