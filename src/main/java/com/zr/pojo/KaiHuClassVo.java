package com.zr.pojo;

import lombok.Data;

/**
 * Created by chenshuai on 2019/9/3.
 */
@Data
public class KaiHuClassVo {
    private Integer key;
    private String value;
    public KaiHuClassVo(Integer key,String value){
        this.key = key;
        this.value = value;
    }
}
