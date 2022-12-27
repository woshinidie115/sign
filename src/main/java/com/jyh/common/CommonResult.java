package com.jyh.common;

public class CommonResult {

    /**
     * 操作状态
     */
    private int code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 返回前端需要绑定的数据
     */
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static CommonResult success() {
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(CommonConstants.SUCCESS);
        return commonResult;
    }

    public static CommonResult success(Object data) {
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(CommonConstants.SUCCESS);
        commonResult.setData(data);
        return commonResult;
    }

    public static CommonResult error(String msg) {
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(CommonConstants.ERROR);
        commonResult.setMsg(msg);
        return commonResult;
    }
}
