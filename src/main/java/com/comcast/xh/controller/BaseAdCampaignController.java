package com.comcast.xh.controller;

import com.comcast.xh.service.AdCampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by skonda004c on 8/5/2017.
 */
@RequestMapping("/campaign")
public abstract class BaseAdCampaignController {
    @Autowired
    AdCampaignService campaignService;
}
