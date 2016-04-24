package com.innominds.exception.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * This is used to handle web page exception.
 *
 * @author ThirupathiReddy V
 *
 */
@ControllerAdvice
public class WebExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleError404(HttpServletRequest request, Exception e) {
        final ModelAndView mav = new ModelAndView("exception");
        mav.addObject("name", e.getClass().getSimpleName());
        mav.addObject("message", e.getMessage());

        return mav;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView exception(Exception e) {

        final ModelAndView mav = new ModelAndView("exception");
        mav.addObject("name", e.getClass().getSimpleName());
        mav.addObject("message", e.getMessage());

        return mav;
    }
}
