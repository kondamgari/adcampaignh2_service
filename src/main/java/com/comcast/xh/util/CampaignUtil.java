package com.comcast.xh.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by skonda004c on 8/7/2017.
 */

@Component
public class CampaignUtil {
    private static final Logger log = LoggerFactory.getLogger(CampaignUtil.class);

    public long duration(Date oldDate){
        //Get the old/created time
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(oldDate);
        log.info(" Created>>> Year: {} >> Month: {} >> Date: {} >> HH: {} >> MM : {} >> SS: {} ",
                calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE),
                calendar.get(Calendar.HOUR),calendar.get(Calendar.MINUTE),calendar.get(Calendar.SECOND));

        LocalDateTime createdTime = LocalDateTime.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE),
                calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
        Calendar calendar1 = Calendar.getInstance();

        LocalDateTime newDate = LocalDateTime.of(calendar1.get(Calendar.YEAR), calendar1.get(Calendar.MONTH), calendar1.get(Calendar.DATE),
                calendar1.get(Calendar.HOUR), calendar1.get(Calendar.MINUTE), calendar1.get(Calendar.SECOND));
        log.info("New>>>Year: {} >> Month: {} >> Date: {} >> HH: {} >> MM : {} >> SS: {} ",calendar1.get(Calendar.YEAR), calendar1.get(Calendar.MONTH), calendar1.get(Calendar.DATE),
                calendar1.get(Calendar.HOUR), calendar1.get(Calendar.MINUTE), calendar1.get(Calendar.SECOND));

        //count seconds between dates
        Duration duration = Duration.between(createdTime, newDate);

        log.info("Duration seconds : {}",duration.getSeconds());
        return duration.getSeconds();
    }
}
