package com.clayons.interviewquestions.Model;

import android.util.Log;

import com.clayons.interviewquestions.Communication.RxBus;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.subjects.BehaviorSubject;

/**
 * Created by Ugljesa Jovanovic (jovanovic.ugljesa@gmail.com) on 02-Mar-2017.
 */
public class PersonProvider {
    public static final String TAG = PersonProvider.class.getSimpleName();

    private static PersonProvider instance = new PersonProvider();

    private List<Person> personList;
    private RxBus rxBus;

    public static PersonProvider getInstance() {
        return instance;
    }

    public PersonProvider() {
        rxBus = RxBus.getInstance();
        rxBus.getLikeChangeObservable().subscribe(
                likePositionPair -> {
                    Log.d(TAG, "Person: " + likePositionPair.first +
                            " liked: " + likePositionPair.second
                    );
                    personList.get(likePositionPair.first).setLiked(likePositionPair.second);
                    peersonListSubject.onNext(personList);
                }
        );
        personList = initPerson();
        peersonListSubject.onNext(personList);
    }

    private BehaviorSubject<List<Person>> peersonListSubject = BehaviorSubject.create();

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

    public Observable<List<Person>> getPersonObservable() {
        return peersonListSubject.asObservable();
    }


}
