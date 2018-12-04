package com.mycompany.swingdemo.services;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import com.mycompany.swingdemo.commands.FetchProfileImageCommand;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

public class ProfilePhotosService {

    private Map<String, BufferedImage> imageCache = new HashMap<String, BufferedImage>();
    private Map<String, Observable<BufferedImage>> fetchesInProgress = new HashMap<String, Observable<BufferedImage>>();
    private BehaviorSubject<BufferedImage> profilePhoto = BehaviorSubject.create();

    public Observable<BufferedImage> getCurrentUsersProfilePhoto() {
        return this.profilePhoto;
    }

    public Observable<BufferedImage> getProfilePhotoFor(String name) {
        if (this.imageCache.containsKey(name)) {
            return Observable.just(this.imageCache.get(name));
        }
        if (this.fetchesInProgress.containsKey(name)) {
            return this.fetchesInProgress.get(name);
        }
        var fetch = new FetchProfileImageCommand(name, 64, 64).execute();
        this.fetchesInProgress.put(name, fetch);
        fetch.doOnNext(bufferedImage -> {
            this.imageCache.put(name, bufferedImage);
            this.fetchesInProgress.remove(name);
        });
        return fetch;
    }

    public void setCurrentUsersProfilePhoto(BufferedImage image) {
        this.profilePhoto.onNext(image);
    }

}