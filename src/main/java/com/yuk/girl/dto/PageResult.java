package com.yuk.girl.dto;

/**
 * Created by Yuk on 2018/1/24.
 */
public class PageResult<T> {

    private boolean success;

    private Long total;

    //具体内容
    private T data;

    public PageResult() {
    }

    public PageResult(boolean success, Long total, T data) {
        this.success = success;
        this.total = total;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
