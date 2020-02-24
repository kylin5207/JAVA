package ThreadTest.MultiThreadTest1;

/*
    继承Thread类，并重写run()方法
 */

public class PersonThread extends Thread{
    private String name;

    public PersonThread() {
    }

    public PersonThread(String name) {
        this.name = name;
    }

    public void run(){

        for (int i = 0; i < 4; i++) {
            System.out.println("第" + i + "次，我是" + this.name);
        }
    }


}
