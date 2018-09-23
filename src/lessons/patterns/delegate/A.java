package lessons.patterns.delegate;

public class A {

    public void f(){
        System.out.println("string");
    }
}
  class B {

    A a = new A();
    void f(){
        a.f();
    }

}
