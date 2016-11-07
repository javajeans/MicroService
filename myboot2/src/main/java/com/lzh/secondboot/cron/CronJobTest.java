package com.lzh.secondboot.cron;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 作者： Jonathan
 * 创建时间： 2016/11/7 ${Time}.
 * CronJobTest的描述：定时任务测试类
 */
@Component
public class CronJobTest {
    int i = 0;
    @Scheduled(cron = "${job.everysecond.cron}")
    public void everySecond(){
           System.out.println("第"+(++i)+"次调用，每秒任务，当前时间："+nowTime());
    }


    private String nowTime() {
        return DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
    }
}
