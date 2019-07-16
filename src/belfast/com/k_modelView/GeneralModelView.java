package com.k_modelView;

import com.a_pojo.Menu;
import com.g_util.MyHttpStatus;

import java.util.List;

public class GeneralModelView extends BaseModelView {
    public String verifyCode;
    public List<Menu> menus;

    public GeneralModelView(MyHttpStatus status, String msg, String errMsg, String verifyCode) {
        super(status, msg, errMsg);
        this.verifyCode = verifyCode;
    }

    public GeneralModelView(MyHttpStatus status, String verifyCode) {
        super(status);
        this.verifyCode = verifyCode;
    }

    public GeneralModelView(MyHttpStatus status, List<Menu> menus) {
        super(status);
        this.menus = menus;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
