package com.ra.ptit_cntt2_it210_btvn_ex5;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleMaxSizeException(Exception e) {
        ModelAndView mav = new ModelAndView("error-page");


        if (e.getMessage() != null && e.getMessage().contains("exceeds maximum size")) {
            mav.addObject("message", "Lỗi: File banner quá lớn! Vui lòng chọn file dưới 10MB.");
        } else {
            mav.addObject("message", "Có lỗi hệ thống xảy ra: " + e.getMessage());
        }
        return mav;
    }
}