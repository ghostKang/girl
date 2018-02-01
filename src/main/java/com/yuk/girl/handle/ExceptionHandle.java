package com.yuk.girl.handle;

import com.yuk.girl.domain.Result;
import com.yuk.girl.enums.ResultEnum;
import com.yuk.girl.exception.GirlException;
import com.yuk.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Yuk on 2018/1/17.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @Autowired
    private ResultUtil resultUtil;

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            // 自定义的异常
            GirlException girlException = (GirlException)e;
            return resultUtil.error(girlException.getCode(),girlException.getMessage());
        }else{
            logger.error("【系统异常】={}",e);
            // 未知异常
            return resultUtil.error(ResultEnum.unknown.getCode(),ResultEnum.unknown.getMsg());
        }


    }
}
