package com.codepath.apps.restclienttemplate.models;

import androidx.room.Embedded;

import java.util.ArrayList;
import java.util.List;

public class TweetWithUser {
    //@Embedded notation flattens the properties of the User object into the object, preserving encapsulation.
    @Embedded
    User user;

    @Embedded(prefix = "tweet_")
    Tweet tweet;

    public static List<Tweet> getTweetList(List<TweetWithUser> tweetWithUsers) {
        List<Tweet> tweets = new ArrayList<>();

        for (TweetWithUser t: tweetWithUsers) {
            Tweet tweet = new Tweet();
            tweet.user = t.user;
            tweets.add(tweet);
        }
        return tweets;
    }
}
