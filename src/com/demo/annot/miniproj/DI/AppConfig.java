package com.demo.annot.miniproj.DI;

import com.demo.annot.miniproj.DI.annotation.ComponentScan;
import com.demo.annot.miniproj.DI.annotation.Configuration;

@Configuration
@ComponentScan(packageName = "com.demo.annot.miniproj.DI")
public class AppConfig {

}