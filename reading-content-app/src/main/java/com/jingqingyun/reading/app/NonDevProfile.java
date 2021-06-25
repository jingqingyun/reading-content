package com.jingqingyun.reading.app;

import org.springframework.context.annotation.Profile;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * NonDevProfile
 *
 * @author jingqingyun
 * @date 2021/1/25
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Profile({"test", "beta", "prod"})
public @interface NonDevProfile {

}
