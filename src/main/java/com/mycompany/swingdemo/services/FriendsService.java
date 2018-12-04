package com.mycompany.swingdemo.services;

import java.util.List;

import com.mycompany.swingdemo.commands.FetchFriendsCommand;
import com.mycompany.swingdemo.model.Friend;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

public class FriendsService {

    private BehaviorSubject<List<Friend>> friends = null;

    public FriendsService() {

    }

    public Observable<List<Friend>> getFriends() {
        if (this.friends == null) {
            this.initializeFriends();
        }
        return this.friends;
    }

    private void initializeFriends() {
        new FetchFriendsCommand().execute().subscribe(friends -> {
            this.friends = BehaviorSubject.createDefault(friends);
        });
    }

}