package com.sys.yms.util;

import java.io.Serializable;
//之所以要封装成responseData这样的数据，是因为要符合layui给出的规则。
public class ResponseData implements Serializable {
    private String code;
    private String msg;
    private Object data;
    private Integer count;

    public ResponseData(ResponseCode responseCode ,Object data) {
        this.code=responseCode.getCode();
        this.msg=responseCode.getMsg();
        this.data = data;
    }
    public ResponseData(ResponseCode responseCode ,Object data,Integer count) {
        this.code=responseCode.getCode();
        this.msg=responseCode.getMsg();
        this.data = data;
        this.count=count;
    }
    public ResponseData(ResponseCode responseCode) {
        this.code=responseCode.getCode();
        this.msg=responseCode.getMsg();
    }

    public ResponseData() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", count=" + count +
                '}';
    }
}
