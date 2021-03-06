package com.solitude.Ecommerce.fiflter;

import com.alibaba.fastjson.JSON;
import com.solitude.Ecommerce.common.BaseContext;
import com.solitude.Ecommerce.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;

        String requestURI = request1.getRequestURI();
        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/user/sendMsg",
                "/user/login",
                "/doc.html",
                "/webjars/**",
                "/swagger-resources",
                "/v2/api-docs",
                "/index.html"
        };

        boolean check = check(urls, requestURI);
        if (check) {
            chain.doFilter(request1, response1);
            return;
        }

        if (request1.getSession().getAttribute("employee") != null) {
            log.info("User ready, id = {}",(request1.getSession().getAttribute("employee")));
            Long empId = (Long) request1.getSession().getAttribute("employee");
            BaseContext.setThreadLocal(empId);
            chain.doFilter(request1, response1);
            return;
        }

        if (request1.getSession().getAttribute("user") != null) {
            log.info("User ready, id = {}",(request1.getSession().getAttribute("user")));
            Long userId = (Long) request1.getSession().getAttribute("user");
            BaseContext.setThreadLocal(userId);
            chain.doFilter(request1, response1);
            return;
        }

        log.info("Do Filter: {}", request1.getRequestURI());
        response1.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
    }

    public boolean check(String[] urls, String requestURI) {
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if (match) {
                return true;
            }
        }
        return false;
    }
}
