package com.clayons.interviewquestions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.clayons.interviewquestions.Model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * The goal of this exercise is to run a functional application that is architected well. It should show a list of {@link Person} items,
 * and based on user input, modifying the item. After completing, show the result on the emulator.
 * Feel free to consult web sites/ personal projects etc.
 *
 * Part I. Show a list of people and details.
 * - Show name, a heart icon, and an avatar image as a list on as part of the MainActivity.
 * - When clicking on an item, all information is displayed on DetailActivity with the ability favorite an item
 * - In addition, create a "Favorite" button on the detail page - this should change the drawable image from one to the other on the main list.
 *
 * - There are screen shots for how the layouts are supposed to look in the root directory.
 *
 *
 * Part II. show a list of items as a GET API Request to server using any kind of framework you know.
 * - Discuss how you would display and use the information retrieved from the below endpoint
 *      http://jsonplaceholder.typicode.com/users
 * - Discuss how to handle network errors
 * - Discuss how to model the object
 *
 *
 * WE PREFER FUNCTIONALITY FIRST, LAYOUT LAST
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
    }

    public void initPerson() {
        final List<Person> persons = new ArrayList<>();
        persons.add(new Person("Shubhanshu", "Yadav", 5, "111-222-3337", "http://www.max2.com/img/SHUBHANSHU.png", false));
        persons.add(new Person("Atesh", "Yurdakul", 5, "111-222-3337", "http://www.max2.com/img/ATESH.png", false));
        persons.add(new Person("Daniel", "Yurdakul", 5, "111-222-3337", "http://www.max2.com/img/DANIEL.png", false));
        persons.add(new Person("Pranav", "Bhalla", 5, "111-222-3337", "http://www.max2.com/img/PRANAV.png", false));
        persons.add(new Person("Rohan", "Nagrani", 20, "111-222-3333", "http://www.max2.com/img/ROHAN.png", false));
        persons.add(new Person("Michael", "Salmasi", 30, "111-222-3334", "http://www.max2.com/img/MICHAEL.png", false));
        persons.add(new Person("Josh", "Williams", 24, "111-222-3335", "http://www.max2.com/img/josh.png", false));
        persons.add(new Person("Jing", "Guo", 15, "111-222-3336", "http://www.max2.com/img/jing.png", false));
        persons.add(new Person("Zhenyu", "Wen", 5, "111-222-3337", "http://www.max2.com/img/zhenyu.png", false));
    }

}
