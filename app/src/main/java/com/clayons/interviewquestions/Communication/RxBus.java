package com.clayons.interviewquestions.Communication;

import android.util.Pair;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by Ugljesa Jovanovic (jovanovic.ugljesa@gmail.com) on 02-Mar-2017.
 */
public class RxBus {
    public static final String TAG = RxBus.class.getSimpleName();

    public static RxBus instance = new RxBus();


    private PublishSubject<Pair<Integer, Boolean>> likeChangeSubject = PublishSubject.create();

    private RxBus(){

    }

    public static RxBus getInstance() {
        return instance;
    }

    public Observable<Pair<Integer, Boolean>> getLikeChangeObservable(){
        return likeChangeSubject.asObservable();
    }

    public void publishLikeChange(Integer position, Boolean isLiked){
        likeChangeSubject.onNext(new Pair<>(position, isLiked));
    }
}
