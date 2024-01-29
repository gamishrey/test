package com.soomla.events;

import java.util.HashMap;

/* loaded from: classes.dex */
public class CustomEvent extends SoomlaEvent {
    private HashMap<String, String> mExtra;
    private String mName;

    public CustomEvent(String str, HashMap<String, String> hashMap) {
        this(str, hashMap, null);
    }

    public CustomEvent(String str, HashMap<String, String> hashMap, Object obj) {
        super(obj);
        this.mName = str;
        this.mExtra = hashMap;
    }

    public String getName() {
        return this.mName;
    }

    public HashMap<String, String> getExtra() {
        return this.mExtra;
    }
}