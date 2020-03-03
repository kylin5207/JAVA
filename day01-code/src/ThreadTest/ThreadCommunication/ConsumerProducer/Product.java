package ThreadTest.ThreadCommunication.ConsumerProducer;
/*
    产品类
 */

public class Product {
    private String wrapper; //皮
    private String filling; //馅
    boolean flag = false; //初始值为false，表示没有产品

    public Product() {
    }

    public Product(String wrapper, String filling) {
        this.wrapper = wrapper;
        this.filling = filling;
    }

    public String getWrapper() {
        return wrapper;
    }

    public void setWrapper(String wrapper) {
        this.wrapper = wrapper;
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }
}
