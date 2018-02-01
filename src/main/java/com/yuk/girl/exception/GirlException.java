package com.yuk.girl.exception;

import com.yuk.girl.enums.ResultEnum;

/**
 * Created by Yuk on 2018/1/17.
 */
public class GirlException extends RuntimeException{

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

}
