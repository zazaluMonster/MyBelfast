package com.l_schedule;

import Boot.custom.DemoBoot;
import DownLoader.custom.StreamDownloader;
import MySpiderStart.MySpider;
import ScheduleQueue.custom.DemoScheduleQueue;
import com.c_service.INewsService;
import com.g_util.MySpider.youthNews.YouthNewsProcessor;
import com.g_util.MySpider.youthNews.YouthnewsService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;

public class MySchedule {

    @Autowired
    private INewsService newsService;

    private static final Logger logger = LogManager.getLogger(MySchedule.class);

    /**
     * 定时爬取中国青年网的新闻数据
     * @throws Exception
     */
    public void spiderNews() throws Exception {
        logger.info("开始启动爬虫对新闻网站新闻进行爬取");

        logger.info("准备爬取http://news.youth.cn/gn/index.htm的内容");

        //URL数据demo
        URL[] urls = new URL[]{
                new URL("http://news.youth.cn/gn/index.htm"),
        };

        MySpider mySpider = new MySpider(urls)
                .addBoot(new DemoBoot())
                .addDownloader(new StreamDownloader())
                .addProcessor(new YouthNewsProcessor())
                .addScheduleQueue(new DemoScheduleQueue())
                .addDataService(new YouthnewsService());

        logger.info("开始爬取");

        try{
            mySpider.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 每天清理一次新闻表
     */
    public void newsClean(){
        logger.info("开始清理新闻表");

        newsService.deleteAll();
    }
}
