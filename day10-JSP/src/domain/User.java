package domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private String name;
    private int age;
    private Date birthday;

    public User() {
    }

    public User(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 逻辑视图
     * @return
     */
    public String getBirthdayStr() {
        // 格式化日期
        if(birthday != null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(this.birthday);
        }
        else {
            return "";
        }

    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
