package com.siwoo.classes;

public class Page {
    private int pageNum;
    private int itemSize;
    private Page nextPage;

    public Page(){
        //제일 첫 페이지로 생성
        this(1, 1, null);
    }

    public Page(int pageNum){
        this(pageNum, 1, null);
    }

    //this
    //this() -
    public Page(int pageNum, int itemSize, Page nextPage){
        // pageNum 번째, itemSize 만큼 데이터를 가지는 페이지를 생성.
        this.pageNum = pageNum;
        this.itemSize = itemSize;
        this.nextPage = nextPage;
    }

    public boolean isNext(Page page) {
        // page Num 번째 itemSize 만큼 데이터를 가지고 이전 페이지 (nextPage 은 다음 페이지) 를 가리키는 페이지 생성.
        return false;
    }

    public boolean isLast(){
        return false;
    }

    public void showPageInfo(){
        System.out.println("page");
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNum=" + pageNum +
                ", itemSize=" + itemSize +
                ", nextPage=" + nextPage +
                '}';
    }

    public static void main(String[] args) {
        Page third = new Page(3, 10, null);
        Page second = new Page(3, 10, null);
        Page first = new Page(3, 10, null);

        Page p1 = new Page();
        Page p2 = new Page(2);
        Page p3 = new Page(7,8,first);
        System.out.println(p3);
        first.showPageInfo();
    }
}
