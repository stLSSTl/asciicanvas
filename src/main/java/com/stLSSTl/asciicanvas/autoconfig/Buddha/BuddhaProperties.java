package com.stLSSTl.asciicanvas.autoconfig.Buddha;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "buddha")
public class BuddhaProperties {
}
