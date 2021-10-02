package in.spring.practice.bean;

public class TempBean {

    public TempBean() {
        System.out.println("Constructor.");
    }
    public void init() {
        System.out.println("init-method");
    }
    public void destroy() {
        System.out.println("destroy-method");
    }
}
