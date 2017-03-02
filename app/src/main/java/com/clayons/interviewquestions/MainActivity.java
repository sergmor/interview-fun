package com.clayons.interviewquestions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.clayons.interviewquestions.Model.Person;
import com.clayons.interviewquestions.Ui.MainPresenter;

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

    RecyclerView peopleReclyclerView;
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        peopleReclyclerView = (RecyclerView) findViewById(R.id.people_list);
        peopleReclyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainPresenter = new MainPresenter(this);


    }

    public void adapterReady(MainPresenter.PersonAdapter personAdapter){
        peopleReclyclerView.setAdapter(personAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.onDestroy();
    }
}
