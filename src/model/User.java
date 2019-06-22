package model;

/**
 * @ClassName: User
 * @Description: TODO
 * @Author: 梁壮
 * @Date: 2019/6/4 16:38
 * @Version: 1.0
 */
public class User {
    /**
     * 以下分别是管理员用户的信息，分别为：
     *  用户名，密码，姓名，性别，部门，职务。
     */
    private String user;
    private String password;
    private String name;
    private String sex;
    private String department;
    private String post;
    private String time;

    public String setUser(String user) {
        return this.user = user;
    }
    public String getUser() {
        return user;
    }
    public String setPassword(String password) {
        return this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public String setName(String name) {
        return this.name = name;
    }
    public String getName() {
        return name;
    }
    public String setSex(String sex) {
        return this.sex = sex;
    }
    public String getSex() {
        return sex;
    }
    public String setDepartment(String department) {
        return this.department = department;
    }
    public String getDepartment() {
        return department;
    }
    public String setPost(String post) { return this.post = post; }
    public String getPost() { return post; }
    public String setTime(String time) {
        return this.time = time;
    }
    public String getTime() { return time; }
}
