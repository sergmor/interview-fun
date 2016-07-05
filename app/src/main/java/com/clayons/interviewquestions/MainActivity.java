package com.clayons.interviewquestions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.clayons.interviewquestions.Model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * The goal of this exercise is to run a functional application that is architected well. It should show a list of items,
 * and based on user input, modifying the item. After completing, show the result on the emulator.
 * Feel free to consult web sites/ personal projects etc.
 *
 * Part I. Show a list of people and details.
 * - Show first name, last name, and an avatar image as a list on as part of the MainActivity.
 * - Background color of the items of the listshould alternate  -  first white, second black, third white, etc.
 * - When clicking on an item, all information is displayed on DetailActivity with the ability to edit the first name, last name, age, and phone number
 * - In addition, create a "Like" button on the detail page - this should change the drawable image from one to the other on the main list.
 * - "Prettify" the layouts so it is user friendly but leave the functionality untouched.
 *
 * Part II. show a list of items as a GET API Request to server using any kind of framework you know.
 * - Discuss how you would display and use the information retrieved from the below endpoint
 *      http://jsonplaceholder.typicode.com/users
 * - Discuss how to handle network errors
 * - Discuss how to model the object
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
