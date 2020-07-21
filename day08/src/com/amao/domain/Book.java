package com.amao.domain;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/20 19:46
 */
public class Book {
    private String bookId;
    private String bookName;
    private String bookAuthor;
    private Double price;

    @Override
    public String toString() {
        return "图书信息{" +
                "图书ID='" + bookId + '\'' +
                ", 图书名称='" + bookName + '\'' +
                ", 图书作者='" + bookAuthor + '\'' +
                ", 图书价格=" + price +
                '}';
    }

    public Book(String bookId, String bookName, String bookAuthor, Double price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.price = price;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public Double getPrice() {
        return price;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
