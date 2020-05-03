package pers.penglan.ioc.entity.dependencies;

/**
 * 用于测试p和c命名空间
 *
 * @Author PENGL
 * 2020-03-03
 */
public class PAndCNamespace {
    private String user = null;
    private String password = null;
    private boolean isVIP = false;

    public PAndCNamespace(String user, String password, boolean isVIP) {
        this.user = user;
        this.password = password;
        this.isVIP = isVIP;
    }

    public PAndCNamespace() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isVIP() {
        return isVIP;
    }

    public void setVIP(boolean VIP) {
        isVIP = VIP;
    }

    @Override
    public String toString() {
        return "PAndCNamespace{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", isVIP=" + isVIP +
                '}';
    }
}
