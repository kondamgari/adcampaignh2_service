package com.comcast.xh.service;

import com.comcast.xh.domain.Campaign;
import com.comcast.xh.repository.CampaignRepository;
import com.comcast.xh.util.ErrorConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by skonda004c on 8/5/2017.
 */
@Component
public class AdCampaignServiceImpl implements AdCampaignService {

    private static final Logger log = LoggerFactory.getLogger(AdCampaignServiceImpl.class);
    @Autowired
    CampaignRepository campaignRepository;

    public Campaign addCampaign(Campaign campaign) throws Exception {

        //Check if any campaign exists with the partner_id, if yes throw the exception
        if(campaignRepository.exists((campaign.getPartner_id()))){
            throw new Exception(ErrorConstants.ONE_CAMPAIGN_PER_PARTNER);
        }else{ //Save the new Campaign details for the partner
            return campaignRepository.save(campaign);
        }

    }

    public boolean campaignExists(String partnerId){
        return campaignRepository.exists(partnerId);
    }

    /***
     * Find a Campaign for the given the partnerId.
     * Returns the active campaign
     * @param partnerId
     * @return
     * @throws Exception
     */
    public Campaign findOneCampaign(String partnerId) throws Exception{
        log.info("Start:AdCampaignServiceImpl.findOneCampaign>>>");
        Campaign campaign = null;

        if(!StringUtils.isEmpty(partnerId)){
            campaign =  campaignRepository.findOne(partnerId);
        }
        //Check whether its active or not.
        if(null!=campaign && !StringUtils.isEmpty(campaign.getAd_status()) && "Active".equalsIgnoreCase(campaign.getAd_status())) {
            log.info("Found an active campaign for {}",partnerId);
            return campaign;
        }else {
            throw new Exception(ErrorConstants.NO_CAMPAIGN_FOR_PARTNER);
        }
    }

    public  Iterable<Campaign> getAllCampaigns(){
        return campaignRepository.findAll();
    }

    @Override
    public Campaign updateCampaign(Campaign campaign) throws Exception {

        //Check if campaign exists for the partner to be updated
        if(null!=campaign && !StringUtils.isEmpty(campaign.getPartner_id()) && campaignRepository.exists(campaign.getPartner_id()))
            return campaignRepository.save(campaign);
         else{ //No campaign found to update
            throw new Exception(ErrorConstants.NO_CAMPAIGN_FOUND);
        }
    }

    @Override
    public void deleteCampaign(String partnerId) throws Exception {
        //Check if campaign exists with partnerId
        if(!StringUtils.isEmpty(partnerId) && campaignRepository.exists(partnerId))
            campaignRepository.delete(partnerId);
        else{ //No campaign found to update
            throw new Exception(ErrorConstants.NO_CAMPAIGN_FOUND);
        }
    }

}
