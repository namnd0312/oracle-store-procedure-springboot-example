package com.namnd.store_procedure_example.filers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author nam.nd
 * @created 18/09/2021 - 6:55 PM
 */
public class FillterRequest extends HandlerInterceptorAdapter {

    private final Logger log = LoggerFactory.getLogger(FillterRequest.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("namnd");
        ObjectMapper mapper = new ObjectMapper();
        log.info("[{}][{}][REQUEST_BODY]: {}", request.getRequestURI(),
                mapper.writeValueAsString(handler));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
