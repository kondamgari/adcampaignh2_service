package com.comcast.xh.service;

import com.comcast.xh.domain.Campaign;


/**
 * Created by skonda004c on 8/6/2017.
 */
public interface AdCampaignService {

    public Campaign addCampaign(Campaign campaign)throws Exception;
    public boolean campaignExists(String partnerId);
    public Campaign findOneCampaign(String partnerId) throws Exception;
    public  Iterable<Campaign> getAllCampaigns();
    public Campaign updateCampaign(Campaign campaign) throws Exception;
    public void deleteCampaign(String partnerId) throws Exception;
    public  Iterable<Campaign> findByAdcontent(String adcontent) throws Exception;
    public  Iterable<Campaign> findByAdtitle(String adtitle) throws Exception;
}
