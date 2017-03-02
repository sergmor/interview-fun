package com.clayons.interviewquestions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.clayons.interviewquestions.Model.Person;
import com.clayons.interviewquestions.Ui.DetailPresenter;
import com.squareup.picasso.Picasso;


public class DetailActivity extends AppCompatActivity {
    public static final String TAG = DetailActivity.class.getSimpleName();

    public static final String PERSON_EXTRA = "personExtra";
    public static final String POSITION_EXTRA = "positionExtra";

    TextView nameTextView;
    TextView ageTextView;
    TextView phoneTextView;
    ImageView avatarImageView;
    Button likeButton;

    DetailPresenter detailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        nameTextView = (TextView) findViewById(R.id.tvName);
        ageTextView = (TextView) findViewById(R.id.tvAge);
        phoneTextView = (TextView) findViewById(R.id.tvPhone);
        avatarImageView = (ImageView) findViewById(R.id.ivAvatar);
        likeButton = (Button) findViewById(R.id.btnLike);

        detailPresenter = new DetailPresenter(this);



    }

    public void displayPerson(Person person){
        nameTextView.setText(person.getFirstName() + " " + person.getLastName());
        ageTextView.setText(Integer.toString(person.getAge()));
        phoneTextView.setText(person.getPhoneNum());
        Picasso.with(this).load(person.getPhotoUrl()).into(avatarImageView);
        if (person.isLiked()){
            likeButton.setText(getResources().getString(R.string.liked));
        } else {
            likeButton.setText(getResources().getString(R.string.like));
        }
        likeButton.setOnClickListener(
                view -> detailPresenter.likeButtonClicked()
        );
    }

    public void displayError(){
        nameTextView.setText(getResources().getString(R.string.error_showing_details));
    }

}
