package com.siwoo.types;

public class ScopeTest {
    
    private static class Scope {
        private int e = 2;  // class
        
        public void showElement(int param) {
            assert param >= 0;  //function
            if (param == 0) return;
            System.out.printf("Guess what is the scope of param [%d]%n", param);  //10
            int e = 1;
            System.out.println("Method Level scope: " + e); //1
            System.out.println("Class Level scope: " + this.e); //2
            
            Scope outerScope = new Scope();  //function
            {
                Scope blockScope = new Scope();  //block
                blockScope.showElement(param-1);//9
            }
            outerScope.showElement(param-1); //8
            //blockScope.showElement();
            
            for (int i=0; i<10; i++) {
                System.out.println(i);
            }
            //System.out.println(i << 1);
        }
    }

    public static void main(String[] args) {
        new Scope().showElement(10);
    }
}
