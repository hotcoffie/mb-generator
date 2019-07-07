package com.xieyu.mbgenerator;

import lombok.Data;

/**
 * Description: 统一返回对象
 *
 * @author 谢宇
 * Date: 2019/7/6 006 下午 12:19
 */
@Data
public class Result {
    private Integer code;
    private String message;
    private Object data;

    public static Result success(Object data) {
        return success(ResultCode.SUCCESS, data);
    }

    public static Result success(int code, Object data) {
        ResultCode rc = ResultCode.get(code);
        rc = rc != null ? rc : ResultCode.SUCCESS;
        return success(rc, data);
    }

    public static Result success(ResultCode rc, Object data) {
        Result rs = new Result();
        rs.setCode(rc.getCode());
        rs.setData(data);
        return rs;
    }

    public static Result error(String message) {
        return error(ResultCode.ERROR, message);
    }

    public static Result error(int code, String message) {
        ResultCode rc = ResultCode.get(code);
        rc = rc != null ? rc : ResultCode.ERROR;
        return error(ResultCode.ERROR, message);
    }

    public static Result error(ResultCode rc, String message) {
        Result rs = new Result();
        rs.setCode(rc.getCode());
        rs.setMessage(message);
        return rs;
    }

    public enum ResultCode {
        /**
         * 成功
         */
        SUCCESS(100),
        /**
         * 失败
         */
        ERROR(200);

        private int code;

        ResultCode(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public static ResultCode get(int code) {
            for (ResultCode value : ResultCode.values()) {
                if (value.code == code) {
                    return value;
                }
            }
            return null;
        }
    }
}
