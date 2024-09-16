package com.hrms.common.utils;


import lombok.Data;

import java.lang.reflect.Field;

@Data
public class BeanUtil {

    public static <T> T copyProperties(Object source, Class<? extends T> tClass){
        T t = cn.hutool.core.bean.BeanUtil.copyProperties(source, tClass);
        try {
            Field tIdField = tClass.getDeclaredField("id");
            Field tCreatedAtField = tClass.getDeclaredField("createdAt");
            tIdField.setAccessible(true);
            tCreatedAtField.setAccessible(true);

            Field sourceIdField = source.getClass().getDeclaredField("id");
            Field sourceCreatedAtField = source.getClass().getDeclaredField("createdAt");
            sourceIdField.setAccessible(true);
            sourceCreatedAtField.setAccessible(true);


            tIdField.set(t, sourceIdField.get(source));
            tCreatedAtField.set(t, sourceCreatedAtField.get(source));

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }
}
