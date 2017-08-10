package com.comcast.xh.service;

import com.comcast.xh.domain.Campaign;
import com.comcast.xh.repository.CampaignRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;

import static org.mockito.Mockito.when;

/**
 * Created by skonda004c on 8/5/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class AdCampaignServiceImplTest {

    @InjectMocks
    private AdCampaignServiceImpl adCampaignService;

    @Mock
    private CampaignRepository campaignRepository;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCampaign(){

        String partnerId = "partnerid";

        Campaign campaignResponse = new Campaign();
        campaignResponse.setPartnerid("partnerid");
        campaignResponse.setAdtitle("Test");

        when(campaignRepository.findOne(partnerId)).thenReturn(campaignResponse);
        try {
            Campaign response = adCampaignService.findOneCampaign(partnerId);
            assertEquals(campaignResponse.getPartnerid(),response.getPartnerid());
            assertEquals(campaignResponse.getAdtitle(),response.getAdtitle());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
