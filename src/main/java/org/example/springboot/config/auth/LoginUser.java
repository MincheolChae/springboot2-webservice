package org.example.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)  //이 어노테이션이 생성될 수 있는 위치는 메소드의 parameter 부분이다.
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}
