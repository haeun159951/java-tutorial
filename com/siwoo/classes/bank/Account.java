package com.siwoo.classes.bank;

public class Account {
    public static final int MAX_ADDR = 2;
    private String name;  // string 타입의 이름
    private String email;  // string 타입의 이메일
    private String password; // string 타입의 비번
    private Cash cash; // Cash 클래스 타입의 객체
    private Address[] addresses; // address 클래스 타입의 배열
    private AccountType accountType; // accountType의 객체
    private int numOfAddress;

    public Account(String name, String email, String password, Cash cash, AccountType type) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.addresses = new Address[2];  // 주소 최대 두개 - fir+++st, secondary
        this.cash = cash;
        this.accountType = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean verify(String password){
        return this.password.equals(password);   // 어카운트의 패스워드와 같은지 비교해서 증명하는 메서드
    }

    public Address[] getAddress() {
        return addresses;
    }


    //  addresses = [null, null], numOfAddress = 0
    //  addresses = [address1, null], numOfAddress = 1
    // addresses = [address1, address2], numOfAddress = 2
    public void addAddress(Address address){ // 주소가 꽉차지 않았을때만 addAddress로 주소 추가
        if (this.numOfAddress != MAX_ADDR){
            this.addresses[numOfAddress++] = address;
        }
    }
    // 0           1
    //[address1, address2]
    //[null, address2]

    //[]
    //Map, Stack, Queue
    public void removeAddress(Address address){ //address 가 존재하는 경우 주소 제
      boolean exists = false;

      for (int i=0; i<numOfAddress; i++) {
          if (addresses[i].equals(address)) {
              exists = true;
              addresses[i] = null;
          }
      }

      if(exists) {
          Address[] tmp = new Address[addresses.length];
          int size = 0;
          for (int i = 0; i < addresses.length; i++) {
              if (addresses[i] != null) {
                  tmp[size++] = addresses[i];
              }
          }
          numOfAddress = size;
          this.addresses = tmp;
      }
     }

     // 지금 현재 어카운트에서 돈을 성공적으로 친구 어카운트에게 보내느경우 1.  (실버이상인 경우) 오케
    //     돈이 충분항 경우 1.이 오케이
    //     돈이 충반하지 않은 경우. 2. 노
    //
    // 지금 현재 어카운트에서 친구 어카운트로 돈을 보내는데 실버 미만인 경우 2.
    //     노우
    //
    //  친구 객체가 널인경우
    //     예외를 던진다.
    public void sendMoney(Account friend, int amount){
        AccountType SILVER = new AccountType(2);

        if (friend.accountType.isBiggerOrEqual(SILVER)){
            cash.withdraw(amount);
            friend.cash.deposit(amount);
            System.out.println("money is sent");
        }
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public static void main(String[] args) {
        Account acct = new Account("haeun", "haeun159951@gmail.com",
                "123", new Cash(500), new AccountType(1));

        Account acct2 = new Account("kim", "siwoo@gmail.com",
                "456", new Cash(300), new AccountType(2));

        Account acct3 = new Account("john", "jj@gmail.com",
                "789", new Cash(700), new AccountType(3));

        Address add1 = new Address("M2H 1G6", "Toronto", "123 st", "805", "1");
        Address add2 = new Address("M2H 2G7", "Brampton", "456 st", "1000", "2");
        Address add3 = new Address("M2H 3G8", "North York", "789 st", "3", "3");

        acct.sendMoney(acct2, 160);
        System.out.println("send money to acct 2: " + acct2.cash.amount());
        System.out.println("acct money: " + acct.cash.amount());
        //acct2.sendMoney(acct3);
    }
}



