package com.ideal.jk.exception;

import com.ideal.jk.pojo.result.CodeMsg;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CommonException extends RuntimeException {
    private static final int CODE_DEFAULT = CodeMsg.BAD_REQUEST.getCode();
    private int code;

    public CommonException() {
        this(CODE_DEFAULT, null);
    }

    public CommonException(int code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
    }

    public CommonException(int code, String msg) {
        this(code, msg, null);
    }

    public CommonException(String msg, Throwable cause) {
        this(CODE_DEFAULT, msg, cause);
    }

    public CommonException(String msg) {
        this(msg, null);
    }

    public CommonException(CodeMsg codeMsg) {
        this(codeMsg, null);
    }

    public CommonException(CodeMsg codeMsg, Throwable cause) {
        this(codeMsg.getCode(), codeMsg.getMsg(), cause);
    }
}
