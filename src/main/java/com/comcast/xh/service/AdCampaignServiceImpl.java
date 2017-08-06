package com.comcast.xh.service;

import com.comcast.xh.domain.Campaign;
import com.comcast.xh.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * Created by skonda004c on 8/5/2017.
 */
@Component
public class AdCampaignServiceImpl implements AdCampaignService {

    @Autowired
    CampaignRepository campaignRepository;

    public Campaign addCampaign(Campaign campaign) {
        campaignRepository.save(campaign);
        return campaign;
    }

    public boolean campaignExists(String partnerId){
        return campaignRepository.exists(partnerId);
    }

    public Campaign findOneCampaign(String partnerId){
        return campaignRepository.findOne(partnerId);
    }

    public  Iterable<Campaign> getAllCampaigns(){
        return campaignRepository.findAll();
    }

}
