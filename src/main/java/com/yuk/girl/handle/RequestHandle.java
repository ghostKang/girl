package com.yuk.girl.handle;

import com.yuk.girl.domain.Result;
import com.yuk.girl.enums.ResultEnum;
import com.yuk.girl.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Yuk on 2018/1/18.
 */
@Controller
public class RequestHandle {

    @Autowired
    private ResultUtil resultUtil;

    /**
     * 请求为空
     * @return
     */
    public Result isNull(){
        return resultUtil.error(ResultEnum.isNull.getCode(),ResultEnum.isNull.getMsg());
    }

    /**
     * 请求成功
     * @param object
     * @return
     */
    public Result success(Object object){
        return resultUtil.success(ResultEnum.success.getCode(),ResultEnum.success.getMsg(),object);
    }
}
