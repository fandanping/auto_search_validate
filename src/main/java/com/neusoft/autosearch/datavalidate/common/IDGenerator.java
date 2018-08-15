package com.neusoft.autosearch.datavalidate.common;

import java.util.UUID;

/**
 * ID生成器
 */
public class IDGenerator {
    public static String generate(){
        return UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
    }
}
