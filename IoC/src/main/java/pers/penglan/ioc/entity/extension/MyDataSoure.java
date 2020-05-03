package pers.penglan.ioc.entity.extension;

/**
 * @Author PENGL
 * 2020-03-05
 */
public class MyDataSoure {
    private String driverClassName = null;
    private String url = null;
    private String username = null;
    private String password = null;

    public MyDataSoure() {
    }

    public MyDataSoure(String driverClassName, String url, String username, String password) {
        this.driverClassName = driverClassName;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDriverClassName() {

        return driverClassName;
    }

    @Override
    public String toString() {
        return "MyDataSoure{" +
                "driverClassName='" + driverClassName + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
