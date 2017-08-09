package com.comcast.xh.repository;

import com.comcast.xh.domain.Campaign;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by skonda004c on 8/5/2017.
 */

@Repository
public interface CampaignRepository extends CrudRepository<Campaign, String> {
    public Iterable<Campaign> findByAdcontent(String adcontent);
    public Iterable<Campaign> findByAdtitle(String adtitle);
    public Campaign findByAdtitleAndDuration(String adtitle, int duration);

}
