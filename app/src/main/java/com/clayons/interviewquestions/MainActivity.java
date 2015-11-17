package com.clayons.interviewquestions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.clayons.interviewquestions.Model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * A list of person objects is given. Show the data to the user and render that on fragment A. Every other item contains a completely different background color. Ex) first white, second black, third white, etc.
 * Clicking on the "Like" button from the detail page should reflect in the main page with a transparent blue color background
 - must support older devices
 - must be able to present the list in a linear recycler view.
 - clicking on one item should show a fragment with detail page and same info presented on a large layout
 - layout file structure
 - bonus points for using MVP structure.
 - bonus points for fancy animation and page transitions.
 - bonus points for using libraries + dependency injection frameworks
 */
public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        initPerson();
    }

    private void initPerson() {
        List<Person> persons = new ArrayList<>(5);
        persons.add(new Person("John", "Doe", 20, "111-222-3333", "http://i58.tinypic.com/2z6fa6t.jpg"));
        persons.add(new Person("Jane", "Kish", 30, "111-222-3334", "http://i58.tinypic.com/2z6fdsl.jpg"));
        persons.add(new Person("Sam", "Jackson", 24, "111-222-3335", "http://i60.tinypic.com/2z6fdbr.jpg"));
        persons.add(new Person("Pete", "Dorey", 15, "111-222-3336", "http://i57.tinypic.com/2z6fb0p.jpg"));
        persons.add(new Person("George", "Mime", 5, "111-222-3337", "http://i59.tinypic.com/2z6fakl.jpg"));
    }
}
