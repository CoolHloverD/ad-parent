package com.qfx.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Qingfengxu
 * @version V1.0
 * @date 2019/3/26 15:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> implements Serializable {
    private int code;
    private String message;
    private T date;

    public CommonResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
