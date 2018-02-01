package com.yuk.girl.utils;

import com.yuk.girl.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Yuk on 2018/1/17.
 */
@Component
public class ResultUtil {

    @Autowired
    private Result result;

    /**
     * 请求成功
     * @param code
     * @param msg
     * @param object
     * @return
     */
    public Result success(Integer code,String msg,Object object){
        result.setCode(code);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }

    /**
     * 请求错误
     * @param code
     * @param msg
     * @return
     */
    public Result error(Integer code,String msg){
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
}
