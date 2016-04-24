package com.innominds.exception.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        System.err.println("---------------- ERROR HANDLER ------------------");
        final ModelAndView mv = new ModelAndView("exception");
        mv.addObject("name", ex.getClass().getSimpleName());
        mv.addObject("message", ex.getMessage());
        mv.addObject("errorCode", response.getStatus());
        return mv;
    }

}
