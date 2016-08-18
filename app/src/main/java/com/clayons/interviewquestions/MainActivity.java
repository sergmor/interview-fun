package com.clayons.interviewquestions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.clayons.interviewquestions.Adapters.PersonsAdapter;
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
 * - Show first name, last name, a star icon, and an avatar image as a list on as part of the MainActivity.
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

    private static final int PERSON_DETAIL_RESULT_CODE = 100;

    private List<Person> persons;
    private PersonsAdapter personsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        setUpToolbar();
        persons = initPerson();
        setUpRecyclerView(persons);
    }

    @SuppressWarnings("ConstantConditions")
    private void setUpToolbar() {
        getSupportActionBar().setTitle(R.string.persons_label);
    }

    private void setUpRecyclerView(List<Person> persons) {
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.messages_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(getAdapter(persons));
    }

    private RecyclerView.Adapter getAdapter(List<Person> persons) {
        personsAdapter = new PersonsAdapter(persons);
        personsAdapter.setOnPersonClickListener(goToDetailActivity());
        return personsAdapter;
    }

    private PersonsAdapter.PersonClickListener goToDetailActivity() {
        return new PersonsAdapter.PersonClickListener() {
            @Override
            public void onPersonClickListener(Person person, int position) {
                final Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.PERSON, person);
                intent.putExtra(DetailActivity.PERSON_POSITION, position);
                startActivityForResult(intent, PERSON_DETAIL_RESULT_CODE);
            }
        };
    }

    public List<Person> initPerson() {
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
        return persons;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK && requestCode == PERSON_DETAIL_RESULT_CODE) {
            final Person person = data.getParcelableExtra(DetailActivity.PERSON);
            final int position = data.getIntExtra(DetailActivity.PERSON_POSITION, -1);
            persons.set(position, person);
            personsAdapter.notifyItemChanged(position);
        }
    }
}
