package com.clayons.interviewquestions.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.clayons.interviewquestions.Model.Person;
import com.clayons.interviewquestions.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Josh on 8/16/16.
 */
public class PersonsAdapter extends RecyclerView.Adapter<PersonsAdapter.PersonViewHolder>  {

    private final List<Person> mPersons;

    private PersonClickListener mPersonClickListener;

    public PersonsAdapter(List<Person> persons) {
        this.mPersons = persons;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_person_summary, parent, false);
        return new PersonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        final Context context = holder.parent.getContext();
        final Person person = getItem(position);
        holder.nameTV.setText(person.getName());
        Picasso.with(context)
                .load(getFavoriteIcon(person))
                .into(holder.favorite);
        Picasso.with(context).load(person.getPhotoUrl()).into(holder.avatar);
        holder.parent.setOnClickListener(performPersonClick(person, position));
    }

    private View.OnClickListener performPersonClick(final Person person, final int position) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mPersonClickListener != null) {
                    mPersonClickListener.onPersonClickListener(person, position);
                }
            }
        };
    }

    private int getFavoriteIcon(Person person) {
        return person.isLiked() ? R.drawable.ic_heart_filled : R.drawable.ic_heart_outline;
    }

    private Person getItem(int position) {
        return mPersons.get(position);
    }

    public void setOnPersonClickListener(PersonClickListener personClickListener) {
        mPersonClickListener = personClickListener;
    }

    public interface PersonClickListener {

        void onPersonClickListener(Person person, int position);

    }

    @Override
    public int getItemCount() {
        return mPersons.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {

        private final ImageView avatar;

        private final TextView nameTV;

        private final ImageView favorite;

        private final CardView parent;

        public PersonViewHolder(View itemView) {
            super(itemView);
            avatar = (ImageView) itemView.findViewById(R.id.ivAvatarPerson);
            nameTV = (TextView) itemView.findViewById(R.id.name);
            favorite = (ImageView) itemView.findViewById(R.id.ivIsLiked);
            parent = (CardView) itemView.findViewById(R.id.parent);
        }
    }
}
