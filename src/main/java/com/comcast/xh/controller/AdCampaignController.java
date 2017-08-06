package com.comcast.xh.controller;

import com.comcast.xh.domain.Campaign;
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
class AdCampaignController extends BaseAdCampaignController {
    final static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");


    @RequestMapping(value = "/addCampaign", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void addCampaign(@RequestBody Campaign campaign) throws Exception {
        campaignService.addCampaign(campaign);
    }

    @RequestMapping(value = "/getCampaign/{partner_id}", method = RequestMethod.GET)
    public ResponseEntity<Campaign> getCampaign(@PathVariable("partner_id") String partner_id) throws Exception {
        return new ResponseEntity<Campaign>(campaignService.findOneCampaign(partner_id),HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllCampaigns", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Campaign>> getAllCampaigns() {
        return new ResponseEntity<Iterable<Campaign>>(campaignService.getAllCampaigns(),HttpStatus.OK);
    }

    @RequestMapping(value = "/updateCampaign", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateCampaign(@RequestBody Campaign campaign) throws Exception {
        campaignService.updateCampaign(campaign);
    }

    @RequestMapping(value = "/deleteCampaign/{partner_id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteCampaign(@PathVariable("partner_id") String partner_id) throws Exception {
        campaignService.deleteCampaign(partner_id);
    }

}
