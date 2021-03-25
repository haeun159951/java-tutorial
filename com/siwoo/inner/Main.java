package com.siwoo.inner;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        //내부 클래스 접근하려면 항상 외부클래스의 객체를 생성후 내부 클래스의 인스턴스 생성 가능
        Outer outer = new Outer("outer");
        Outer.InnerInstance innerInstance = outer.new InnerInstance("inner");
        System.out.println(innerInstance); //outer, inner=inner

        //스테틱은 외부클래스를 만들지 않고 도 인스턴스 생성 가능하다.
        Outer.InnerStatic staticInstance = new Outer.InnerStatic("inner static");
        System.out.println(staticInstance);

        //로컬 클래스 만들기
        outer.localClass("local class");
//
//        for (int i=0; i<10; i++)
//            System.out.println(
//                    new Outer("outer")
//                            .new InnerInstance(i + ""))

        // 익명 클래스 - 상속 할때 사용한다
        Outer anonymous = new Outer("anonymous"){
            private String secondName = "no name";

            @Override
            public String toString() {
                return String.format("%s, additional fields=%s", super.toString(), secondName);
            }
        };
        System.out.println(anonymous);

        //lamda == 익명
        F lambda = () ->{
            System.out.println("hello lambda");
        };
        lambda.function();
        F anonymousF = new F(){
            @Override
            public void function() {
                System.out.println("hello anonymous");
            }
        };
        anonymousF.function();

        // functional programming
        IntStream.range(0,10).forEach(new IntConsumer(){
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        });
        IntStream.range(0,10).forEach((value) -> System.out.println(value));
    }
}

interface F{
    void function();
}
class Outer {
    protected static final String NAME ="Static member";
    protected String name ="Instance member";

    public Outer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("static-outer=%s, outer=%s", NAME, name);
    }

     class InnerInstance{
        private String name;

        public InnerInstance(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("%s, inner=%s", Outer.this.toString(), name);
        }
    }

    //내부 스테틱 클래스

     static class InnerStatic{
        private String name;

        public InnerStatic(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("static-outer=%s, inner=%s", NAME, name);
        }
    }


    //로컬 클래스 로컬변수는 - 메서드 안에 잇는 변수이다.  내부 인스턴스 클래스와 비슷하게 사용한다
    // 메서드 안에서만 접근 가능한다.
    //인스턴스 메서드 
    public void localClass(String name){
        class LocalClass {
            public String name;

            public LocalClass(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return String.format("static-outer=%s, outer=%s, inner=%s", NAME, Outer.this.name, name);
            }
        }

        LocalClass localClass = new LocalClass(name);
        System.out.println(localClass);
    }
}
