package com.google.android.gms.common.api.internal;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public final class zaa extends ActivityLifecycleObserver {
    private final WeakReference<C0002zaa> zaco;

    public zaa(Activity activity) {
        this(C0002zaa.zaa(activity));
    }

    private zaa(C0002zaa c0002zaa) {
        this.zaco = new WeakReference<>(c0002zaa);
    }

    @Override // com.google.android.gms.common.api.internal.ActivityLifecycleObserver
    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        C0002zaa c0002zaa = this.zaco.get();
        if (c0002zaa == null) {
            throw new IllegalStateException("The target activity has already been GC'd");
        }
        c0002zaa.zaa(runnable);
        return this;
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* renamed from: com.google.android.gms.common.api.internal.zaa$zaa  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0002zaa extends LifecycleCallback {
        private List<Runnable> zacn;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0002zaa zaa(Activity activity) {
            C0002zaa c0002zaa;
            synchronized (activity) {
                LifecycleFragment fragment = getFragment(activity);
                c0002zaa = (C0002zaa) fragment.getCallbackOrNull("LifecycleObserverOnStop", C0002zaa.class);
                if (c0002zaa == null) {
                    c0002zaa = new C0002zaa(fragment);
                }
            }
            return c0002zaa;
        }

        private C0002zaa(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.zacn = new ArrayList();
            this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final synchronized void zaa(Runnable runnable) {
            this.zacn.add(runnable);
        }

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        public void onStop() {
            List<Runnable> list;
            synchronized (this) {
                list = this.zacn;
                this.zacn = new ArrayList();
            }
            for (Runnable runnable : list) {
                runnable.run();
            }
        }
    }
}