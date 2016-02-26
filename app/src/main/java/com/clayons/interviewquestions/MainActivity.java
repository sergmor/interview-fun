package com.clayons.interviewquestions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.clayons.interviewquestions.Model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * A list of person objects is given.
 * Show first name, last name, and avatar as a list on MainActivity.
 * Show all information on DetailActivity.
 * First name and last name should be editable. add a save button for storing this information.
 * Create an interface class to store the data in a persistent storage.
 * Create an interface to sync database with a server.
 *
 * Condition:
 * Alternate the background color for the list on MainActivity - first white, second black, third white, etc.
 * "Like" button on the detail page should override the background color on the main page with a blue color background.
 * bonus points for using MVP structure.
 * bonus points for suggesting/using up-to-date animation and transition effects.
 * bonus points for using well known libraries.
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
