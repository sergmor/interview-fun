package com.clayons.interviewquestions;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.clayons.interviewquestions.Model.Person;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by walter on 3/27/17.
 */
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    private List<Person> mPeople;

//    private static Drawable isLikedImg;
//    private static Drawable isNotLikedImg;

    PersonAdapter(List<Person> myPeps) {
        mPeople = myPeps;
    }

    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // create a new view
        CardView v = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_person_summary, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Person person = mPeople.get(position);
        holder.name.setText(person.getName());

        final Context context = holder.photo.getContext();

        //NEED TO DOWNLOAD IMAGE, no time, just set to something later
        if (person.getIsLiked()) {
            //this is loading images multiple times, would like to store same image
            //ran out of time, but i would store the image properly
            Picasso.with(context).load(R.drawable.ic_heart_filled).into(holder.isLiked);
        } else {
            Picasso.with(context).load(R.drawable.ic_heart_outline).into(holder.isLiked);
        }
        holder.isLiked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //NOTE, yes i know this is not proper to load the image multiple times
                if (person.getIsLiked()) {
                    person.setIsLiked(false);
                    Picasso.with(context).load(R.drawable.ic_heart_outline).into((ImageView) v);
                } else {
                    person.setIsLiked(true);
                    Picasso.with(context).load(R.drawable.ic_heart_filled).into((ImageView) v);
                }
            }
        });

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return mPeople.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        TextView name;
        ImageView photo;
        ImageView isLiked;

        ViewHolder(CardView v) {
            super(v);
            mCardView = v;
            name = (TextView) v.findViewById(R.id.name);
            photo = (ImageView) v.findViewById(R.id.ivAvatarPerson);
            isLiked = (ImageView) v.findViewById(R.id.ivIsLiked);

        }
    }
}
