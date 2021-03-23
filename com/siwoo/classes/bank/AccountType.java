package com.siwoo.classes.bank;

// encapsulation - 캡슐화
//  : 내부 구현을 외부로부터 숨기는 방법.

public class AccountType {
    private int type;

    public static final int BRONZE = 1;
    public static final int SILVER = 2;
    public static final int GOLD = 3;

    public AccountType(int type) {
        this.type = type;
    }

    public boolean isBronze() {
        return type == BRONZE;
    }

    public boolean isSilver(){
        return type == SILVER;
    }

    public boolean isGold(){
        return type == GOLD;
    }

    public boolean isBiggerOrEqual(AccountType type) {
        return this.type <= type.type;
    }
}


