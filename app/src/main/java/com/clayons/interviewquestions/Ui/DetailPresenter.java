package com.clayons.interviewquestions.Ui;

import android.content.Intent;

import com.clayons.interviewquestions.Communication.RxBus;
import com.clayons.interviewquestions.DetailActivity;
import com.clayons.interviewquestions.Model.Person;

/**
 * Created by Ugljesa Jovanovic (jovanovic.ugljesa@gmail.com) on 02-Mar-2017.
 */
public class DetailPresenter {
    public static final String TAG = DetailPresenter.class.getSimpleName();

    private RxBus rxBus;
    private DetailActivity activity;
    private Person person;
    private int position;
    private boolean failedShowingDetails = false;

    public DetailPresenter(DetailActivity activity){
        this.activity = activity;
        rxBus = RxBus.getInstance();
        Intent startIntent = activity.getIntent();
        if (startIntent != null){
            Person person = (Person) startIntent.getSerializableExtra(DetailActivity.PERSON_EXTRA);
            position = startIntent.getIntExtra(DetailActivity.POSITION_EXTRA, -1);
            if (person != null){
                this.person = person;
                activity.displayPerson(person);
            } else {
                failedShowingDetails = true;
                activity.displayError();
            }
        }
    }

    public void likeButtonClicked(){
        if (!failedShowingDetails) {
            person.setLiked(!person.isLiked());
            rxBus.publishLikeChange(position, person.isLiked());
            activity.displayPerson(person);
        }
    }



}
