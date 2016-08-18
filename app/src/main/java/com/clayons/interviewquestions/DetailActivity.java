package com.clayons.interviewquestions;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.clayons.interviewquestions.Model.Person;
import com.squareup.picasso.Picasso;


public class DetailActivity extends AppCompatActivity {

    public final static String PERSON = "person_extra";
    public static final String PERSON_POSITION = "person_position_extra";

    private Person person;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        person = getIntent().getParcelableExtra(PERSON);
        position = getIntent().getIntExtra(PERSON_POSITION, -1);

        setUpToolbar();
        loadAvatar();
        loadName();
        loadAge();
        loadPhoneNumber();
        setUpLikeButton();
    }

    @SuppressWarnings("ConstantConditions")
    private void setUpToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(person.getName());
    }

    private void setUpLikeButton() {
        final Button likeButton = (Button) findViewById(R.id.btnLike);
        if(person.isLiked()) {
            showLiked(likeButton);
        } else {
            showNotLiked(likeButton);
        }
        likeButton.setOnClickListener(likePerson());
    }

    private void showNotLiked(Button likeButton) {
        ViewCompat.setBackgroundTintList(likeButton, ContextCompat.getColorStateList(this, R.color.light_grey));
        likeButton.setText(R.string.like);
        likeButton.setTextColor(ContextCompat.getColor(this, android.R.color.black));
    }

    private void showLiked(Button likeButton) {
        ViewCompat.setBackgroundTintList(likeButton, ContextCompat.getColorStateList(this, R.color.red));
        likeButton.setText(R.string.liked);
        likeButton.setTextColor(ContextCompat.getColor(this, android.R.color.white));
    }

    private View.OnClickListener likePerson() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                person.setLiked(!person.isLiked());
                setUpLikeButton();
            }
        };
    }

    private void loadAvatar() {
        final ImageView avatar = (ImageView) findViewById(R.id.ivAvatar);
        Picasso.with(this).load(person.getPhotoUrl()).into(avatar);
    }

    private void loadName() {
        final TextView name = (TextView) findViewById(R.id.tvName);
        name.setText(person.getName());
    }

    @SuppressLint("SetTextI18n")
    private void loadAge() {
        TextView age = (TextView) findViewById(R.id.tvAge);
        age.setText(Integer.toString(person.getAge()));
    }

    private void loadPhoneNumber() {
        TextView phoneNumber = (TextView) findViewById(R.id.tvPhoneNum);
        phoneNumber.setText(person.getPhoneNum());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra(PERSON, person);
        intent.putExtra(PERSON_POSITION, position);
        setResult(Activity.RESULT_OK, intent);
        super.finish();
    }
}
