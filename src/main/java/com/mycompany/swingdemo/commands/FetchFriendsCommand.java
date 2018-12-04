package com.mycompany.swingdemo.commands;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.mycompany.swingdemo.model.Friend;

public class FetchFriendsCommand extends Command<List<Friend>> {

    @Override
    protected List<Friend> runCommand() throws Exception {
        // In reality, would probably be an HTTP GET or whatever
        Thread.sleep(3000);
        return Arrays.asList("Frank", "Sally", "kittens").stream().map(name -> {
            var friend = new Friend();
            friend.name = name;
            return friend;
        }).collect(Collectors.toList());
    }

}