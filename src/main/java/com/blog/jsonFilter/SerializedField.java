package com.blog.jsonFilter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据过滤
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SerializedField {

    /**
     * 需要返回的数据
     * @return
     */
    String[] includes() default {};

    /**
     * 需要去除的数据
     * @return
     */
    String[] excludes() default {};
}
