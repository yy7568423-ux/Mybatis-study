package com.dddj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author DDDJ
 **/
//有参构造
@AllArgsConstructor
//无参构造
@NoArgsConstructor
@Data
public class User implements Serializable {
    private int id;
    private String name;
    private String pwd;
}
