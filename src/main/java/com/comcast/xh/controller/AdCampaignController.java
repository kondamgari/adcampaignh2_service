package com.comcast.xh.controller;

import com.comcast.xh.domain.Campaign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by skonda004c on 8/5/2017.
 */

@RestController
public class AdCampaignController extends BaseAdCampaignController {

    private static final Logger log = LoggerFactory.getLogger(AdCampaignController.class);

    /***
     * Creates a Campaign for a partner
     * @param campaign
     * @throws Exception
     */
    @RequestMapping(value = "/campaign", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Campaign> addCampaign(@RequestBody Campaign campaign) throws Exception {
        return new ResponseEntity<Campaign>(campaignService.addCampaign(campaign),HttpStatus.CREATED);
    }

    /***
     * Retries a Campaign by campaignid - primary key
     * @param campaignid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/campaign/{campaignid}", method = RequestMethod.GET)
    public ResponseEntity<Campaign> getCampaignById(@PathVariable("campaignid") Long campaignid) throws Exception {
        return new ResponseEntity<Campaign>(campaignService.findOneCampaign(campaignid),HttpStatus.OK);
    }

    /***
     * Returns all the Campaigns for all the partners
     * @return
     */
    @RequestMapping(value = "/campaign", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Campaign>> getAllCampaigns() {
        return new ResponseEntity<Iterable<Campaign>>(campaignService.getAllCampaigns(),HttpStatus.OK);
    }

    /***
     * Updates a Campaign by campaignid
     * @param campaign
     * @throws Exception
     */
    @RequestMapping(value = "/campaign", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateCampaign(@RequestBody Campaign campaign) throws Exception {
        campaignService.updateCampaign(campaign);
    }

    /***
     * Deletes a Campaign by campaignid
     * @param campaignid
     * @throws Exception
     */
    @RequestMapping(value = "/campaign/{campaignid}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteCampaign(@PathVariable("campaignid") Long campaignid) throws Exception {
        campaignService.deleteCampaign(campaignid);
    }

    /***
     * Retrieves the active Campaigns for partnerid
     * Returns the campaign only if its active and created tim + duration < current time
     * @param partnerid
     * @return
     */
    @RequestMapping(value = "/campaign", params = "partnerid", method = RequestMethod.GET)
    public ResponseEntity<List<Campaign>> getCampaignsByPartnerId(@RequestParam("partnerid") String partnerid) throws Exception {
        return new ResponseEntity<List<Campaign>>(campaignService.findByPartnerid(partnerid),HttpStatus.OK);
    }

    /***
     * Retrieves the Campaigns by adContent
     * @param adcontent
     * @return
     */
    @RequestMapping(value = "/campaign", params = "adcontent", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Campaign>> getCampaignsByAdContent(@RequestParam("adcontent") String adcontent) throws Exception {
        return new ResponseEntity<Iterable<Campaign>>(campaignService.findByAdcontent(adcontent),HttpStatus.OK);
    }

    /***
     * Retrieves the Campaigns by adTitle
     * @param adtitle
     * @return
     */
    @RequestMapping(value = "/campaign", params = "adtitle", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Campaign>> getCampaignsByAdTitle(@RequestParam("adtitle") String adtitle)throws Exception {
        return new ResponseEntity<Iterable<Campaign>>(campaignService.findByAdtitle(adtitle),HttpStatus.OK);
    }

    /***
     * Retrieves Campaign by duration and adtitle
     * @param duration
     * @param adtitle
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/campaign", params = {"duration","adtitle"},method = RequestMethod.GET)
    public ResponseEntity<List<Campaign>> getCampaignsByAdTitle(@RequestParam("duration") int duration, @RequestParam("adtitle") String adtitle)throws Exception {
        return new ResponseEntity<List<Campaign>>(campaignService.findByAdtitleAndDuration(adtitle,duration),HttpStatus.OK);
    }

}
