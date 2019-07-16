package com.b_controller;

import com.a_pojo.News;
import com.c_service.INewsService;
import com.g_util.MyHttpStatus;
import com.k_modelView.NewsModelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/news")
@ResponseBody
public class NewsController {

    @Autowired
    private INewsService newsService;

    /**
     * 分页查询中国青年网爬取新闻
     * @param map
     * @return
     */
    @RequestMapping(value = "/youthNews",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public NewsModelView getYouthNews(@RequestBody Map<String, String> map) throws Exception {
        int curPage = Integer.valueOf(map.get("page"));
        if(curPage < 1){
            throw new Exception("查询条件异常");
        }

        Map<String,Object> condition = new HashMap<>();
        condition.put("page",curPage);
        List<News> news = newsService.selectsByIdPage(condition);

        return new NewsModelView(MyHttpStatus.OK,news);
    }

}
