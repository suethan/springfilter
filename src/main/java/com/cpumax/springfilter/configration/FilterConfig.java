package com.cpumax.springfilter.configration;

import org.apache.catalina.filters.RemoteIpFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

//类似xml beans
@Configuration//过滤器
public class FilterConfig {
    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        logger.info("执行顺讯-》过滤器FilterRegistrationBean");
        MyFilter filter= new MyFilter();
        List<String> urlPatterns = new ArrayList<String>();
        registration.setFilter(filter);
        urlPatterns.add("/login");//doFilter 只会对login在 doFilter中进行处理，其他的不做处理
        registration.setUrlPatterns(urlPatterns);
        //registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("MyFilter");
        registration.setOrder(1);

        return registration;
    }
    Logger logger = LoggerFactory.getLogger(this.getClass());
    public class MyFilter implements Filter {
        @Override
        public void destroy() {
            // TODO Auto-generated method stub
        }


        @Override
        public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
                throws IOException, ServletException {
            // TODO Auto-generated method stub
            logger.info("执行顺讯-》过滤器doFilter");
            HttpServletRequest request = (HttpServletRequest) srequest;
           // PrintWriter out = null ;
           // out=sresponse.getWriter();
            //out.append("dadajdijasdji");
            System.out.println("this is MyFilter,url :"+request.getRequestURI());
            filterChain.doFilter(srequest, sresponse);



        }


    }
}
