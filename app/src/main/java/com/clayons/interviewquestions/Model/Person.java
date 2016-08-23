package com.clayons.interviewquestions.Model;

/**
 * Created by jaychung on 11/16/15.
 */
public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private String phoneNum;
    private String photoUrl;
    private boolean isLiked;

    public Person(String firstName, String lastName, Integer age, String phoneNum, String photoUrl, boolean isLiked) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.age = age;
        this.photoUrl = photoUrl;
        this.isLiked = isLiked;
    }

}
