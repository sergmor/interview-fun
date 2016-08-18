package com.clayons.interviewquestions.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

/**
 * Created by jaychung on 11/16/15.
 */
public class Person implements Parcelable {

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


    protected Person(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        age = in.readInt();
        phoneNum = in.readString();
        photoUrl = in.readString();
        isLiked = in.readByte() != 0;
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public String getName() {
        return firstName + " " + lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeInt(age);
        parcel.writeString(phoneNum);
        parcel.writeString(photoUrl);
        parcel.writeByte((byte) (isLiked ? 1 : 0));
    }

    public String toJson() {
        return new Gson().toJson(Person.class);
    }

}
