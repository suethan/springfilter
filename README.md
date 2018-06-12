# springfilter
idea springboot 拦截器和过滤器使用
# 过滤器（Filter）
可操作HttpServletRequest和HttpServletResponse执行顺序在拦截器之前
可指定特定的url进行操作
```
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
```

# 拦截器（HandlerInterceptor）
preHandle,postHandle ,afterCompletion，preHandle是在Controller方法调用之前执行，
postHandle是在请求处理之后进行调用，但是在视图渲染之前，即Controller方法调用之后执行，
afterCompletion方法是在整个请求结束之后被调用，也是在DispatcherServlet渲染了对应识图之后执行，主要用于资源清理工作

# 区别
拦截器基于spring，过滤器基于web
