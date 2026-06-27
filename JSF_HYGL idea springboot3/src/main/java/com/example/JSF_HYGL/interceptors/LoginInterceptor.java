package com.example.JSF_HYGL.interceptors;

import com.example.JSF_HYGL.utils.JwtUtil;
import com.example.JSF_HYGL.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component//注入到ioc容器中
//拦截器（jwt认证）
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //令牌验证
        String token= request.getHeader("Authorization");
        //验证token 用户登录成功后，系统会自动下发JWT令牌，然后在后续的每次请求中，浏览器都需要在请求头header中携
        //带到服务端，请求头的名称为 Authorization，值为 登录时下发的JWT令牌。
        //如果检测到用户未登录，则http响应状态码为401
        try {
            Map<String, Object> claims= JwtUtil.parseToken(token);

            //把业务数据存储到Threadlocal中
            ThreadLocalUtil.set(claims);

            //放行
            return true;
        } catch (Exception e) {
            //http响应状态码为401
            response.setStatus(401);
            //不放行
            return false;
        }

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //清空Threadlocal中的数据
        ThreadLocalUtil.remove();

    }
}
