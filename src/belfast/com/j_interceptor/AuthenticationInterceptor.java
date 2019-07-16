package com.j_interceptor;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.g_util.MyHttpStatus;
import com.i_cache.EhcacheManager;
import com.k_modelView.BaseModelView;
import com.mysql.cj.util.StringUtils;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  SpringMvc拦截器，
 */
public class AuthenticationInterceptor implements HandlerInterceptor {


    // 拦截controller方法 preHandle会被SpringMvc执行两次，我们需要判断handler类型，防止其执行两次
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HttpRequestHandler){
            return true;
        }
        return authentication(request,response);
    }

    //执行Controller方法之后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    //SpringMvc处理完视图渲染，返回请求之前
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private boolean authentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String token = request.getHeader("Authorization");
        String[] arr = token.split("_");
        String cacheToken = "";
        if(arr.length > 1){
            cacheToken = EhcacheManager.getCacheValue(arr[1]);
        }

        // 手写Response，告诉前端没有登录凭证或者登录凭证不存在或者登录凭证不匹配
        if(StringUtils.isEmptyOrWhitespaceOnly(token) ||
                StringUtils.isEmptyOrWhitespaceOnly(cacheToken) ||
                !cacheToken.equals(token)){
            BaseModelView baseModelView = new BaseModelView(MyHttpStatus.NETWORK_AUTHENTICATION_REQUIRED,"","");
            ObjectMapper objectMapper = new ObjectMapper()
                    .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            response.setHeader("Access-Control-Allow-Origin","*");
            response.setHeader("Content-Typ","application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(baseModelView));
            return false;
        }



        return true;
    }
}
