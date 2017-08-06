package com.comcast.xh.service;

import com.comcast.xh.domain.Campaign;


/**
 * Created by skonda004c on 8/6/2017.
 */
public interface AdCampaignService {

    public Campaign addCampaign(Campaign campaign);
    public boolean campaignExists(String partnerId);
    public Campaign findOneCampaign(String partnerId);
    public  Iterable<Campaign> getAllCampaigns();

}
