package com.clayons.interviewquestions.Ui;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.clayons.interviewquestions.DetailActivity;
import com.clayons.interviewquestions.MainActivity;
import com.clayons.interviewquestions.Model.Person;
import com.clayons.interviewquestions.Model.PersonProvider;
import com.clayons.interviewquestions.R;
import com.clayons.interviewquestions.Communication.RxBus;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscription;
import rx.subjects.PublishSubject;

/**
 * Created by Ugljesa Jovanovic (jovanovic.ugljesa@gmail.com) on 02-Mar-2017.
 */
public class MainPresenter {
    public static final String TAG = MainPresenter.class.getSimpleName();

    MainActivity activity;
    PersonProvider personProvider;
    PersonAdapter personAdapter;
    Subscription clickSubscription;
    Subscription personListSubscription;
    private List<Person> personList;

    public MainPresenter(MainActivity activity) {
        this.activity = activity;
        initializePresenter();
    }

    public void onDestroy(){
        this.activity = null;
        clickSubscription.unsubscribe();
        personListSubscription.unsubscribe();
    }



    public void initializePresenter(){
        personAdapter = new PersonAdapter();
        clickSubscription = personAdapter.getPositionClicksObservable().subscribe(
                (position) -> {
                    Log.d(TAG, "Showing person at position: " + position);
                    Intent showDetailsIntent = new Intent(activity, DetailActivity.class);
                    showDetailsIntent.putExtra(DetailActivity.PERSON_EXTRA, personList.get(position));
                    showDetailsIntent.putExtra(DetailActivity.POSITION_EXTRA, position);
                    activity.startActivity(showDetailsIntent);
                }
        );
        personProvider = PersonProvider.getInstance();
        personListSubscription = personProvider.getPersonObservable().subscribe(
                receivedPersonList -> {
                    Log.d(TAG, "Received person list from provider");
                    personList = receivedPersonList;
                    personAdapter.updatePeople();
                }
        );
        activity.adapterReady(personAdapter);
    }



    public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

        private final PublishSubject<Integer> onClickSubject = PublishSubject.create();

        public void updatePeople(){
            notifyDataSetChanged();
        }

        @Override
        public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Log.d(TAG, "Creating view holder");
            return new PersonViewHolder(
                    LayoutInflater.from(
                            parent.getContext()).inflate(R.layout.item_person_summary, parent, false)
            );

        }

        @Override
        public void onBindViewHolder(PersonViewHolder holder, final int position) {
            Person person = personList.get(position);
            holder.name.setText(person.getFirstName() + " " + person.getLastName());
            Picasso.with(activity).load(person.getPhotoUrl()).into(holder.profilePicture);
            if (person.isLiked()){
                holder.likedStatus.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_heart_filled));
            } else {
                holder.likedStatus.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_heart_outline));
            }
            holder.rootView.setOnClickListener(
                    v -> onClickSubject.onNext(position)
            );
        }

        @Override
        public int getItemCount() {
            return personList.size();
        }

        public class PersonViewHolder extends RecyclerView.ViewHolder {
            public View rootView;
            public ImageView profilePicture;
            public TextView name;
            public ImageView likedStatus;

            PersonViewHolder(View view){
                super(view);
                this.rootView = view.findViewById(R.id.parent);
                this.profilePicture = (ImageView) view.findViewById(R.id.ivAvatarPerson);
                this.name = (TextView) view.findViewById(R.id.name);
                this.likedStatus = (ImageView) view.findViewById(R.id.ivIsLiked);
            }

        }

        public Observable<Integer> getPositionClicksObservable(){
            return onClickSubject.asObservable();
        }

    }

}
