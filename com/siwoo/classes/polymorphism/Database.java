package com.siwoo.classes.polymorphism;

public class Database {

    private static class MongoDB implements DB{
        public String getUser(int d){
            return "mongo db";
        }
    }

    private static class MysqlDB implements DB{
        public String getUser(int id){
            return "my sql db";
        }
    }

    private interface DB{
        String getUser(int id);
    }

    public static void main(String[] args) {
        DB db = new MongoDB();
        System.out.println(db.getUser(10));
        db = new MysqlDB();
        System.out.println(db.getUser(10));
        Object o = db;


        MysqlDB mysqlDB =  new MysqlDB();
        DB parent = mysqlDB;
        System.out.println(parent.getUser(50));
    }

    private class OtherCode{
        DB db = new MongoDB();

        void doSomething(){
            String user = db.getUser(10);
            System.out.println(user);
        }
    }

    private class OtherCode1{
        DB db = new MysqlDB();

        void doSomething(){
            String user = db.getUser(20);
            System.out.println(user);
        }
    }

    private class OtherCode2{
        DB db = new MysqlDB();

        void doSomething(){
            String user = db.getUser(5);
            System.out.println(user);
        }
    }
}
// 인터페이스를 통해 변수를 사용하면, 변경되는 부분이 있을때
// 변수를 생성하는 부분만 바꾸면 된다.
// 다형성: 부모 타입은 변수에 자식 인스턴스 저장 가능 / 오직부모에 정의된 메서드만 사용가능
// 여러가지 형태 (자식클래스) 를 가질 수 있는 능력을 의미 => 부모타입 변수
//=> 특정 부모 타입의 참조변수로 그 부모의 자식 타임의 객체를 참조할 수 있는 능력  DB db = new MysqlDB();
// polymorphism: many forms and it occurs when we have classes that are
// related to each other by inheritance

// 같은 자료형의 변수에 여러가지 객체를 대입하여 다양한 결과를 만들어내는 성질
// 상속 혹은 인터페이스와 연관되어 사용된다.
// 해당 변수에 저장된 객체가 실제 어떤 클래스인지 몰라도, 부모의
// 메서드를 사용 할 수 있다.
// 형 변환을 통해 실제 자손 타입의 참조변수로 형변화이 가능합니다. 다운캐스