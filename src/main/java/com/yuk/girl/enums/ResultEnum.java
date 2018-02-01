package com.yuk.girl.enums;

/**
 * Created by Yuk on 2018/1/18.
 */
public enum ResultEnum {
    unknown(-2,"未知错误"),
    isNull(-1,"没有查到信息"),
    success(0,"成功"),
    primary(1,"还在上小学"),
    high(2,"还在上初中")
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
