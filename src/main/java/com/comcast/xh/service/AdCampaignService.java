package com.comcast.xh.service;

import com.comcast.xh.domain.Campaign;

import java.util.List;


/**
 * Created by skonda004c on 8/6/2017.
 */
public interface AdCampaignService {

    public Campaign addCampaign(Campaign campaign)throws Exception;
    public boolean campaignExists(Long campaignid);
    public Campaign findOneCampaign(Long campaignid) throws Exception;
    public  Iterable<Campaign> getAllCampaigns();
    public Campaign updateCampaign(Campaign campaign) throws Exception;
    public void deleteCampaign(Long campaignid) throws Exception;
    public  Iterable<Campaign> findByAdcontent(String adcontent) throws Exception;
    public  Iterable<Campaign> findByAdtitle(String adtitle) throws Exception;
    public List<Campaign> findByAdtitleAndDuration(String adtitle, int duration) throws Exception;
    public  List<Campaign> findByPartnerid(String partnerid) throws Exception;
}
