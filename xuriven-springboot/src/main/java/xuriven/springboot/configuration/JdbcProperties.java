package xuriven.springboot.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 声明当前类为属性读取类，读取属性文件中前缀为"jdbc"的值
 * 在类上定义的属性，名称必须与属性文件中jdbc.后面部分一致，而且必须有get/set方法
 */
@ConfigurationProperties(prefix = "jdbc")
public class JdbcProperties {
    private String url;
    private String driverClassName;
    private String username;
    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
