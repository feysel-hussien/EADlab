package com.onlinebookstore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//feysel hussien//
@Getter
@Setter
@NoArgsConstructor
public class TestLombok {
    private String title;
    private String author;

    public static void main(String[] args) {
        TestLombok book = new TestLombok();
        book.setTitle("EAD");
        book.setAuthor("feya");
        
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
    }
}
