package com.comcast.xh.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by skonda004c on 8/5/2017.
 */

@Entity
@Table(name="campaign", schema = "public")
public class Campaign {

    String partnerid;
    String adcontent;
    String adtitle;
    String adstatus;
    int duration;
    Date dateOfCreation;

    @Id
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
