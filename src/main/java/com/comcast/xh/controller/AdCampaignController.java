package com.comcast.xh.controller;

import com.comcast.xh.domain.Campaign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 * Created by skonda004c on 8/5/2017.
 */

@RestController
public class AdCampaignController extends BaseAdCampaignController {
    final static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private static final Logger log = LoggerFactory.getLogger(AdCampaignController.class);

    /***
     * Creates a Campaign for a partner
     * @param campaign
     * @throws Exception
     */
    @RequestMapping(value = "/addCampaign", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void addCampaign(@RequestBody Campaign campaign) throws Exception {
        campaignService.addCampaign(campaign);
    }

    /***
     * Retries a Campaign by partnerId
     * @param partnerid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getCampaign/{partnerid}", method = RequestMethod.GET)
    public ResponseEntity<Campaign> getCampaign(@PathVariable("partnerid") String partnerid) throws Exception {
        return new ResponseEntity<Campaign>(campaignService.findOneCampaign(partnerid),HttpStatus.OK);
    }

    /***
     * Returns all the Campaigns for all the partners
     * @return
     */
    @RequestMapping(value = "/getAllCampaigns", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Campaign>> getAllCampaigns() {
        return new ResponseEntity<Iterable<Campaign>>(campaignService.getAllCampaigns(),HttpStatus.OK);
    }

    /***
     * Updates a Campaign by partnerId
     * @param campaign
     * @throws Exception
     */
    @RequestMapping(value = "/updateCampaign", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateCampaign(@RequestBody Campaign campaign) throws Exception {
        campaignService.updateCampaign(campaign);
    }

    /***
     * Deletes a Campaign by partnerID
     * @param partnerid
     * @throws Exception
     */
    @RequestMapping(value = "/deleteCampaign/{partnerid}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteCampaign(@PathVariable("partnerid") String partnerid) throws Exception {
        campaignService.deleteCampaign(partnerid);
    }

    /***
     * Retrieves the Campaigns by adContent
     * @param adcontent
     * @return
     */
    @RequestMapping(value = "/getCampaignsByAdContent/{adcontent}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Campaign>> getCampaignsByAdContent(@PathVariable("adcontent") String adcontent) throws Exception {
        return new ResponseEntity<Iterable<Campaign>>(campaignService.findByAdcontent(adcontent),HttpStatus.OK);
    }

    /***
     * Retrieves the Campaigns by adTitle
     * @param adtitle
     * @return
     */
    @RequestMapping(value = "/getCampaignsByAdTitle/{adtitle}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Campaign>> getCampaignsByAdTitle(@PathVariable("adtitle") String adtitle)throws Exception {
        return new ResponseEntity<Iterable<Campaign>>(campaignService.findByAdtitle(adtitle),HttpStatus.OK);
    }

}
