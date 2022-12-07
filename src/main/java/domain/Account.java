package domain;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable {
    /**性别男*/
    public final static String SEX_FEMALE="男";
    /**性别女*/
    public final static String SEX_MALE="女";
    /**状态正常*/
    public final static int STATUS_NORMAL=1;
    /**状态异常*/
    public final static int STATUS_ERRO=0;
    //角色类型
    private  int type;
    /**游客*/
    public final static int TYPE_TOURIST=1;
    /**普通用户*/
    public final static int TYPE_USER=2;
    /**管理员*/
    public final static int TYPE_ADMINISTRATOR=3;
    //唯一属性id，由数据库自动生成
    private int id;
    //用户名
    private String name;
    //性别
    private String sex;
    //密码
    private String password;
    //创建日期
    private Date createTime;
    //状态
    private int status;
    //电话
    private String phone;
    //邮箱
    private String email;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Account() {
    }

    public Account(int id, String name, String sex, String password, Date createTime, int status, int type, String phone, String email) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.password = password;
        this.createTime = createTime;
        this.status = status;
        this.type = type;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        System.out.println("获取创建时间"+createTime);
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Account{" +
                "type=" + type +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
