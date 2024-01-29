package com.soomla.events;

/* loaded from: classes.dex */
public class RewardTakenEvent extends SoomlaEvent {
    public final String RewardId;

    public RewardTakenEvent(String str) {
        this(str, null);
    }

    public RewardTakenEvent(String str, Object obj) {
        super(obj);
        this.RewardId = str;
    }
}