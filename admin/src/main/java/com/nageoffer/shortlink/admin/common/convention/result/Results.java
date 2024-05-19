package com.nageoffer.shortlink.admin.common.convention.result;

import com.nageoffer.shortlink.admin.common.convention.errorcode.BaseErrorCode;

import java.util.Optional;

/**
 * ClassName:Results
 * Description:
 * 全局返回对象构造器
 * @Author DubPAN
 * @Create2024/5/18 20:11
 * @Version 1.0
 */
public class Results {
    /**
     * 构造成功响应
     */
    public static Result<Void> success() {
        return new Result<Void>()
                .setCode(Result.SUCCESS_CODE);
    }

    /**
     * 构造带返回数据的成功响应
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>()
                .setCode(Result.SUCCESS_CODE)
                .setData(data);
    }

    /**
     * 构建服务端失败响应
     */
    public static Result<Void> failure() {
        return new Result<Void>()
                .setCode(BaseErrorCode.SERVICE_ERROR.code())
                .setMessage(BaseErrorCode.SERVICE_ERROR.message());
    }

//    /**
//     * 通过 {@link AbstractException} 构建失败响应
//     */
//    public static Result<Void> failure(AbstractException abstractException) {
//        String errorCode = Optional.ofNullable(abstractException.getErrorCode())
//                .orElse(BaseErrorCode.SERVICE_ERROR.code());
//        String errorMessage = Optional.ofNullable(abstractException.getErrorMessage())
//                .orElse(BaseErrorCode.SERVICE_ERROR.message());
//        return new Result<Void>()
//                .setCode(errorCode)
//                .setMessage(errorMessage);
//    }

    /**
     * 通过 errorCode、errorMessage 构建失败响应
     */
    public static Result<Void> failure(String errorCode, String errorMessage) {
        return new Result<Void>()
                .setCode(errorCode)
                .setMessage(errorMessage);
    }
}
