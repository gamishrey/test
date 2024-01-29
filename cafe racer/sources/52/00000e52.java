package com.soomla;

import com.soomla.data.JSONConsts;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Schedule {
    private static String TAG = "SOOMLA Schedule";
    public int mActivationLimit;
    public Recurrence mRequiredRecurrence;
    public List<DateTimeRange> mTimeRanges;

    /* loaded from: classes.dex */
    public enum Recurrence {
        EVERY_MONTH,
        EVERY_WEEK,
        EVERY_DAY,
        EVERY_HOUR,
        NONE
    }

    /* loaded from: classes.dex */
    public class DateTimeRange {
        public Date End;
        public Date Start;

        public DateTimeRange(Date date, Date date2) {
            this.Start = date;
            this.End = date2;
        }
    }

    public static Schedule AnyTimeOnce() {
        return new Schedule(1);
    }

    public static Schedule AnyTimeLimited(int i) {
        return new Schedule(i);
    }

    public static Schedule AnyTimeUnLimited() {
        return new Schedule(0);
    }

    public Schedule(int i) {
        this(null, Recurrence.NONE, i);
    }

    public Schedule(final Date date, final Date date2, Recurrence recurrence, int i) {
        this.mTimeRanges = new ArrayList<DateTimeRange>() { // from class: com.soomla.Schedule.1
            {
                add(new DateTimeRange(date, date2));
            }
        };
        this.mRequiredRecurrence = recurrence;
        this.mActivationLimit = i;
    }

    public Schedule(List<DateTimeRange> list, Recurrence recurrence, int i) {
        this.mTimeRanges = list;
        this.mRequiredRecurrence = recurrence;
        this.mActivationLimit = i;
    }

    public Schedule(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(JSONConsts.SOOM_SCHE_REC)) {
            this.mRequiredRecurrence = Recurrence.values()[jSONObject.getInt(JSONConsts.SOOM_SCHE_REC)];
        } else {
            this.mRequiredRecurrence = Recurrence.NONE;
        }
        this.mActivationLimit = jSONObject.getInt(JSONConsts.SOOM_SCHE_APPROVALS);
        this.mTimeRanges = null;
        if (jSONObject.has(JSONConsts.SOOM_SCHE_RANGES)) {
            this.mTimeRanges = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray(JSONConsts.SOOM_SCHE_RANGES);
            for (int i = 0; i < jSONArray.length(); i++) {
                this.mTimeRanges.add(new DateTimeRange(new Date(jSONArray.getJSONObject(i).getLong(JSONConsts.SOOM_SCHE_RANGE_START)), new Date(jSONArray.getJSONObject(i).getLong(JSONConsts.SOOM_SCHE_RANGE_END))));
            }
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mRequiredRecurrence != null) {
                jSONObject.put(JSONConsts.SOOM_SCHE_REC, this.mRequiredRecurrence.ordinal());
            }
            if (this.mTimeRanges != null) {
                JSONArray jSONArray = new JSONArray();
                for (DateTimeRange dateTimeRange : this.mTimeRanges) {
                    long time = dateTimeRange.Start.getTime();
                    long time2 = dateTimeRange.End.getTime();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(JSONConsts.SOOM_CLASSNAME, SoomlaUtils.getClassName(dateTimeRange));
                    jSONObject2.put(JSONConsts.SOOM_SCHE_RANGE_START, time);
                    jSONObject2.put(JSONConsts.SOOM_SCHE_RANGE_END, time2);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put(JSONConsts.SOOM_SCHE_RANGES, jSONArray);
            }
            jSONObject.put(JSONConsts.SOOM_SCHE_APPROVALS, this.mActivationLimit);
            jSONObject.put(JSONConsts.SOOM_CLASSNAME, SoomlaUtils.getClassName(this));
        } catch (JSONException unused) {
            SoomlaUtils.LogError(TAG, "An error occurred while generating JSON object.");
        }
        return jSONObject;
    }

    public boolean approve(int i) {
        List<DateTimeRange> list;
        Date date = new Date();
        if (this.mActivationLimit < 1 && ((list = this.mTimeRanges) == null || list.size() == 0)) {
            SoomlaUtils.LogDebug(TAG, "There's no activation limit and no TimeRanges. APPROVED!");
            return true;
        }
        int i2 = this.mActivationLimit;
        if (i2 > 0 && i >= i2) {
            SoomlaUtils.LogDebug(TAG, "Activation limit exceeded.");
            return false;
        }
        List<DateTimeRange> list2 = this.mTimeRanges;
        if (list2 == null || list2.size() == 0) {
            SoomlaUtils.LogDebug(TAG, "We have an activation limit that was not reached. Also, we don't have any time ranges. APPROVED!");
            return true;
        }
        for (DateTimeRange dateTimeRange : this.mTimeRanges) {
            if (date.after(dateTimeRange.Start) && date.before(dateTimeRange.End)) {
                SoomlaUtils.LogDebug(TAG, "We are just in one of the time spans, it can't get any better then that. APPROVED!");
                return true;
            }
        }
        if (this.mRequiredRecurrence == Recurrence.NONE) {
            return false;
        }
        for (DateTimeRange dateTimeRange2 : this.mTimeRanges) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(date);
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
            gregorianCalendar2.setTime(dateTimeRange2.Start);
            GregorianCalendar gregorianCalendar3 = new GregorianCalendar();
            gregorianCalendar3.setTime(dateTimeRange2.End);
            if (gregorianCalendar.get(12) >= gregorianCalendar2.get(12) && gregorianCalendar.get(12) <= gregorianCalendar3.get(12)) {
                SoomlaUtils.LogDebug(TAG, "Now is in one of the time ranges' minutes span.");
                if (this.mRequiredRecurrence == Recurrence.EVERY_HOUR) {
                    SoomlaUtils.LogDebug(TAG, "It's a EVERY_HOUR recurrence. APPROVED!");
                    return true;
                } else if (gregorianCalendar.get(10) >= gregorianCalendar2.get(10) && gregorianCalendar.get(10) <= gregorianCalendar3.get(10)) {
                    SoomlaUtils.LogDebug(TAG, "Now is in one of the time ranges' hours span.");
                    if (this.mRequiredRecurrence == Recurrence.EVERY_DAY) {
                        SoomlaUtils.LogDebug(TAG, "It's a EVERY_DAY recurrence. APPROVED!");
                        return true;
                    } else if (gregorianCalendar.get(7) >= gregorianCalendar2.get(7) && gregorianCalendar.get(7) <= gregorianCalendar3.get(7)) {
                        SoomlaUtils.LogDebug(TAG, "Now is in one of the time ranges' day-of-week span.");
                        if (this.mRequiredRecurrence == Recurrence.EVERY_WEEK) {
                            SoomlaUtils.LogDebug(TAG, "It's a EVERY_WEEK recurrence. APPROVED!");
                            return true;
                        } else if (gregorianCalendar.get(5) >= gregorianCalendar2.get(5) && gregorianCalendar.get(5) <= gregorianCalendar3.get(5)) {
                            SoomlaUtils.LogDebug(TAG, "Now is in one of the time ranges' days span.");
                            if (this.mRequiredRecurrence == Recurrence.EVERY_MONTH) {
                                SoomlaUtils.LogDebug(TAG, "It's a EVERY_MONTH recurrence. APPROVED!");
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public Recurrence getRequiredRecurrence() {
        return this.mRequiredRecurrence;
    }

    public List<DateTimeRange> getTimeRanges() {
        return this.mTimeRanges;
    }

    public int getActivationLimit() {
        return this.mActivationLimit;
    }
}