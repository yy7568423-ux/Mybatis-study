package com.dddj.utils;

import org.junit.Test;

import java.util.UUID;

/**
 * @author DDDJ
 **/
@SuppressWarnings("all")//忽略警告
public class IDUtils {
    public static String getID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }


    @Test
    //获取随机ID
    public void test(){
        System.out.println(getID());
    }
}
