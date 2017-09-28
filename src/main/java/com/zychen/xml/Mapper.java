package com.zychen.xml;

import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author 章源辰
 * @time: 2017/9/28 23:16
 * @describion:
 */
@Inherited
@Documented
@Target({ ElementType.FIELD})
@Retention(RUNTIME)
public @interface Mapper {

    String value() default "";
}
