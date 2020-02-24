package ThreadTest.MainThreadTest;

public class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run(){
        //打印4次，我是xxx
        for (int i = 0; i < 4; i++) {
            System.out.println("第" + i + "次，我是" + this.name);
        }
    }
}
