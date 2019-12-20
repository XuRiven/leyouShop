package xuriven.springboot.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration//声明该类是一个配置类
@EnableConfigurationProperties(JdbcProperties.class)//声明使用JdbcProperties这个类对象
//@PropertySource("classpath:jdbc.properties")//指定属性文件的路径
public class JdbcConfiguration {
/*
    @Value("${jdbc.url}")
    String url;
    @Value("${jdbc.driverClassName}")
    String driverClassName;
    @Value("${jdbc.username}")
    String username;
    @Value("${jdbc.password}")
    String password;*/

    /**
     * 1、Autowired注入
     */
//    @Autowired
//    private JdbcProperties jdbcProperties;


    /**
     * 2、构造函数注入
     */
    private JdbcProperties jdbcProperties;

    public JdbcConfiguration(JdbcProperties jdbcProperties) {
        this.jdbcProperties = jdbcProperties;
    }


  /*  @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(jdbcProperties.getUrl());
        dataSource.setDriverClassName(jdbcProperties.getDriverClassName());
        dataSource.setUsername(jdbcProperties.getUsername());
        dataSource.setPassword(jdbcProperties.getPassword());
        return dataSource;
    }*/


    /**
      * 3、@Bean方法注入参数
      * @return
     */
    /*@Bean
    public DataSource dataSource(JdbcProperties jdbcProperties) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(jdbcProperties.getUrl());
        dataSource.setDriverClassName(jdbcProperties.getDriverClassName());
        dataSource.setUsername(jdbcProperties.getUsername());
        dataSource.setPassword(jdbcProperties.getPassword());
        return dataSource;
    }*/


    /**
     * 4、如果一段属性只有一个Bean需要使用，我们无需将其注入到一个类（JdbcProperties）中，而是直接在需要的声明即可
     * 声明需要注入的属性前缀，springboot会自动把相关属性通过set方法注入到DataSource中
     * 使用前提：该类必须要有对应属性的set方法。
     *
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "jdbc")
    public DataSource dataSource(){
         DruidDataSource dataSource = new DruidDataSource();
         return dataSource;
    }


}
