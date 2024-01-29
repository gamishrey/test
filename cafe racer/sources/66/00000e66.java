package com.soomla.events;

/* loaded from: classes.dex */
public class RewardGivenEvent extends SoomlaEvent {
    public final String RewardId;

    public RewardGivenEvent(String str) {
        this(str, null);
    }

    public RewardGivenEvent(String str, Object obj) {
        super(obj);
        this.RewardId = str;
    }
}