package com.clayons.interviewquestions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.clayons.interviewquestions.Model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Please complete the code below and run on the emulator to show working results. Feel free to consult web sites/ personal projects etc.
 *
 * 1. A list of person objects is given as below
 * - Show first name, last name, and an avatar image as a list on MainActivity.
 * -  Background color for the list on MainActivity should alternate  -  first white, second black, third white, etc.
 * - Show all information on DetailActivity with the ability to edit the first name, last name, age, and phone number
 * - "Like" button on the detail page should change the drawable image from one to the other.
 * - "Prettify" the layouts so it is user friendly but leave the functionality untouched.
 *
 * <p/>
 * bonus points for:
 *  adding any test cases, frameworks, and code relevant
 *  using MVP structure.
 *  suggesting/using up-to-date animation and transition effects.
 *  using third party libraries.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        initPerson();
    }

    public void initPerson() {
        List<Person> persons = new ArrayList<>(5);
        persons.add(new Person("John", "Doe", 20, "111-222-3333", "http://i58.tinypic.com/2z6fa6t.jpg", false));
        persons.add(new Person("Jane", "Kish", 30, "111-222-3334", "http://i58.tinypic.com/2z6fdsl.jpg", false));
        persons.add(new Person("Sam", "Jackson", 24, "111-222-3335", "http://i60.tinypic.com/2z6fdbr.jpg", false));
        persons.add(new Person("Pete", "Dorey", 15, "111-222-3336", "http://i57.tinypic.com/2z6fb0p.jpg", false));
        persons.add(new Person("George", "Mime", 5, "111-222-3337", "http://i59.tinypic.com/2z6fakl.jpg", false));
    }
}
