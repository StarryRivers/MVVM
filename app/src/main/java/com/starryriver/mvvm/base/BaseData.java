package com.starryriver.mvvm.base;

/**
 * @author : StarryRivers
 * Project  : MVVM
 * Desc     : Unified request data format
 * @date : 2020/11/5 20:16
 */
public class BaseData<T> {
    private int errorCode;
    private String errorMsg;
    private T data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
