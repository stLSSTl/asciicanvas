package com.stLSSTl.asciicanvas.annotation;


import com.stLSSTl.asciicanvas.autoconfig.Buddha.BuddhaAutoConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(BuddhaAutoConfig.class)
public @interface Buddha {

}
