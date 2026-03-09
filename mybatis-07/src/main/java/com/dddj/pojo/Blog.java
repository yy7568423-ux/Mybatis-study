package com.dddj.pojo;

import lombok.Data;
import java.util.Date;

/**
 * @author DDDJ
 **/

@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime;//属性名与字段名不一致，通过xml配置驼峰命名转换
    private int views;
}
