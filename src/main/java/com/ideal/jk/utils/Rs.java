package com.ideal.jk.utils;

import com.ideal.jk.exception.CommonException;
import com.ideal.jk.pojo.query.PageQuery;
import com.ideal.jk.pojo.result.R;

public class Rs {
    public static R error(String msg) {
        return new R().setSuccess(false).setMsg(msg);
    }

    public static R ok(PageQuery query) {
        R r = new R();
        r.put("total", query.getTotal());
        r.put("pages", query.getPages());
        r.setSuccess(true).setData(query.getData());
        return r;
    }

    public static R ok(String msg) {
        return new R().setSuccess(true).setMsg(msg);
    }

    public static R ok(Object data) {
        return new R().setSuccess(true).setData(data);
    }

    public static R error(Throwable t) {

        if (t instanceof CommonException) {
            R r = new R();
            CommonException e = (CommonException) t;
            return r.setCode(e.getCode()).setMsg(e.getMessage());
        } else {
            return error(t.getMessage());
        }

    }
}
