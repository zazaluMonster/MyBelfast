package com.b_controller;

import com.a_pojo.Crew;
import com.a_pojo.Menu;
import com.g_util.MyHttpStatus;
import com.g_util.MyStringUtil;
import com.k_modelView.GeneralModelView;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/general")
@ResponseBody
public class GeneralController {

    @RequestMapping(value = "/verificationCode",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public GeneralModelView getVerificationCode() {
        String verifyCode = MyStringUtil.getVerifyCode();
        return new GeneralModelView(MyHttpStatus.OK,verifyCode);
    }

    // 简单的菜单管理,直接写死进行权限比较,大型系统不会这么写,因为不好维护.可以使用用户-权限表来实现可维护性
    @RequestMapping(value = "/getMenu",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public GeneralModelView getMenu(@RequestBody Crew crew) {
        List<Menu> menuList = new ArrayList<>();
        menuList.add(new Menu("news","看看新闻"));
        if(crew.getCrewName().equals("admin")){
            menuList.add(new Menu("crewManage","用户管理"));
        }
        menuList.add(new Menu("about","关于我"));

        return new GeneralModelView(MyHttpStatus.OK,menuList);
    }




}
