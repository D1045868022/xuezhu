package com.zr.pojo;

import lombok.Data;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by chenshuai on 2019/9/3.
 */
@Data
public class XiaLaClass {
    private Integer id;
    private String name;
    public XiaLaClass(Integer id,String name){
        this.id = id;
        this.name = name;
    }
}
