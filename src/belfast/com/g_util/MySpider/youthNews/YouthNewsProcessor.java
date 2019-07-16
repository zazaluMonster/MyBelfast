package com.g_util.MySpider.youthNews;

import Processor.AbstractProcessor;
import Util.MyLogger;
import Util.StringUtil;
import com.a_pojo.News;
import com.e_constants.NewsTag;
import com.g_util.DateUtil;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class YouthNewsProcessor extends AbstractProcessor<News> {

    @Override
    public List<News> parseToList(File downloadFile) throws Exception {

        if(downloadFile == null){
            throw new Exception("parse file is null");
        }

        List<News> result = new ArrayList<>();

        try(RandomAccessFile randomAccessFile_read = new RandomAccessFile(downloadFile,"rw")){
            String curLine = "";
            while ( (curLine = randomAccessFile_read.readLine()) != null){
                if (StringUtil.isNull(curLine)){
                    continue;
                }
                if(curLine.contains("<li>")){
                    String time = curLine.substring(curLine.indexOf("<font>"),curLine.indexOf("</font>")).substring(6);
                    String content = curLine.split("</a></li>")[0].substring(curLine.lastIndexOf(".htm\">")).substring(6);

                    time = new String(time.getBytes(StandardCharsets.ISO_8859_1),"GBK");
                    content = new String(content.getBytes(StandardCharsets.ISO_8859_1),"GBK");

                    MyLogger.log(time + content);

                    Date date = DateUtil.getSqlDateByStringAndPattern(time,"yyyy-MM-dd HH:mm:ss");
                    String simpleDataStr = DateUtil.getTimeString(date,"yyyyMMdd");

                    News news = new News();
                    news.setTitle(content);
                    news.setHits(new Random().nextInt(3000));//由于中国青年网没有点击数显示，随便捏造下
                    news.setOutTime(simpleDataStr);
                    news.setTag(NewsTag.YOUTH_NEWS);
                    news.setUrl("/blank");//我之前写的爬取程序没有爬取url,暂时用/blank代替

                    result.add(news);
                }
                if(curLine.contains("</ul>")){
                    break;
                }
            }
        }
        return result;

    }
}
