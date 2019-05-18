package cn.gorillahug.back.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ModelUtils {
    /**
     * 获取实体类对象值
     *
     * @param item
     * @return
     * @throws IllegalAccessException
     */
    public static List<Object> getModelValue(Object item) throws IllegalAccessException {
        List<Object> result = new ArrayList<>();
        Class<?> clazz = item.getClass();
        // 返回Class中所有的字段，包括私有字段
        Field[] fields = clazz.getDeclaredFields();
        if (fields == null || fields.length == 0) {
            return result;
        }
        for (Field field : fields) {
            field.setAccessible(true);
            Object val = field.get(item);
            result.add(val);
        }
        return result;
    }
}
