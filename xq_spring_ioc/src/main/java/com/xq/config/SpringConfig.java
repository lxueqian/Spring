package com.xq.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@Configurable //标志改类是Spring核心配置类
@ComponentScan("com.xq")// 扫描注解 <context:component-scan base-package="com.xq">
@Import({DataSourceConfig.class}) //<import resource="applicationContext-product.xml"></import>
public class SpringConfig {
}
