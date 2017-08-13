package com.comcast.xh.service;

import com.comcast.xh.domain.Campaign;
import com.comcast.xh.repository.CampaignRepository;
import com.comcast.xh.util.CampaignUtil;
import com.comcast.xh.util.ErrorConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by skonda004c on 8/5/2017.
 */
@Component
public class AdCampaignServiceImpl implements AdCampaignService {

    private static final Logger log = LoggerFactory.getLogger(AdCampaignServiceImpl.class);
    @Autowired
    private CampaignRepository campaignRepository;
    @Autowired
    private CampaignUtil campaignUtil;


    public Campaign addCampaign(Campaign campaign) throws Exception {

            Calendar cal = Calendar.getInstance();
            campaign.setDateOfCreation(cal.getTime());
            return campaignRepository.save(campaign);
    }

    public boolean campaignExists(Long campaignid){
        return campaignRepository.exists(campaignid);
    }

    /***
     * Find a Campaign for the given the partnerId.
     * Returns the active campaign
     * @param campaignid
     * @return
     * @throws Exception
     */
    public Campaign findOneCampaign(Long campaignid) throws Exception{
        log.info("Start:AdCampaignServiceImpl.findOneCampaign>>>");
        Campaign campaign = null;
        boolean active=false;

        campaign =  campaignRepository.findOne(campaignid);

        //Check whether its active or not.
        if(null!=campaign && !StringUtils.isEmpty(campaign.getAdstatus()) && "Active".equalsIgnoreCase(campaign.getAdstatus())) {
            log.info("Found an active campaign for {}",campaignid);
            //Now check whether current time is greater than duration + created time
            long duration = campaignUtil.duration(campaign.getDateOfCreation());
            if(duration > campaign.getDuration()){
                log.info("Campaign is expired....");
            }else{
                log.info("Campaign is Active....");
                active = true;
            }

        }
        if(active) {
            return campaign;
        }else
        {
            throw new Exception(ErrorConstants.NO_CAMPAIGN_FOR_PARTNER);
        }
    }

    public  Iterable<Campaign> getAllCampaigns(){
        return campaignRepository.findAll();
    }

    @Override
    public Campaign updateCampaign(Campaign campaign) throws Exception {

        //Check if campaign exists for the campaignid to be updated
        if(null!=campaign && campaign.getCampaignid()!=null && campaignRepository.exists(campaign.getCampaignid()))
            return campaignRepository.save(campaign);
         else{ //No campaign found to update
            throw new Exception(ErrorConstants.NO_CAMPAIGN_FOUND);
        }

    }

    @Override
    public void deleteCampaign(Long campaignid) throws Exception {
        //Check if campaign exists with partnerId
        if(campaignid!=null && campaignRepository.exists(campaignid))
            campaignRepository.delete(campaignid);
        else{ //No campaign found to delete
            throw new Exception(ErrorConstants.NO_CAMPAIGN_FOUND_TO_DELETE);
        }

    }

    @Override
    public Iterable<Campaign> findByAdcontent(String adcontent) throws Exception {
        Iterable<Campaign> campaigns = campaignRepository.findByAdcontent(adcontent);
        if(null!=campaigns){
            return campaigns;
        }else{
            log.info("No Campaigns found for adconent: {}",adcontent);
            throw new Exception(ErrorConstants.NO_CAMPAIGN_FOUND_FOR_ADCONTENT);
        }
    }

    @Override
    public Iterable<Campaign> findByAdtitle(String adtitle)throws Exception {
        Iterable<Campaign> campaigns = campaignRepository.findByAdtitle(adtitle);
        if(null!=campaigns){
            return campaigns;
        }else{
            log.info("No Campaigns found for adtitle: {}",adtitle);
            throw new Exception(ErrorConstants.NO_CAMPAIGN_FOUND_FOR_ADTITLE);
        }
    }

    @Override
    public List<Campaign> findByAdtitleAndDuration(String adtitle, int duration) throws Exception {
        List<Campaign> list = new ArrayList<Campaign>();
        Iterable<Campaign> campaigns = campaignRepository.findByAdtitleAndDuration(adtitle,duration);
        for(Campaign c:campaigns){
            list.add(c);
        }
        if(null!=list && !list.isEmpty())
            return list;
        else{
            log.info("No Campaigns found for adtitle: {} and duration: {}",adtitle,duration);
            throw new Exception(ErrorConstants.NO_CAMPAIGN_FOUND_FOR_ADTITLE_DURATION);
        }
    }

    /***
     * Returns the active campaigns for the partner
     * @param partnerid
     * @return
     * @throws Exception
     */
    @Override
    public List<Campaign> findByPartnerid(String partnerid) throws Exception {
        List<Campaign> responseList = null;
        Iterable<Campaign> campaigns = campaignRepository.findByPartnerid(partnerid);
        if(null!=campaigns){
            responseList = new ArrayList<Campaign>();
            for(Campaign campaign:campaigns){
                if(null!=campaign && !StringUtils.isEmpty(campaign.getAdstatus()) && "Active".equalsIgnoreCase(campaign.getAdstatus())) {
                    log.info("Found an active campaign for {}",partnerid);
                    //Now check whether current time is greater than duration + created time
                    long duration = campaignUtil.duration(campaign.getDateOfCreation());
                    if(duration > campaign.getDuration()){
                        log.info("Campaign is expired....");
                    }else{
                        log.info("Campaign is Active....");
                        responseList.add(campaign);     //Return only the active campaigns
                    }
                }
            }
        }

        if(responseList!=null && !responseList.isEmpty()) {
            return responseList;
        }else {
            log.info("No Campaigns found for partnerid: {}",partnerid);
            throw new Exception(ErrorConstants.NO_CAMPAIGN_FOR_PARTNER);
        }
    }
}
