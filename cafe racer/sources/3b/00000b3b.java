package com.google.android.gms.internal.drive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class zzlc extends zzla {
    private static final Class<?> zzto = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzlc() {
        super();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.drive.zzla
    public final void zza(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) zznd.zzo(obj, j);
        if (list instanceof zzkz) {
            unmodifiableList = ((zzkz) list).zzds();
        } else if (zzto.isAssignableFrom(list.getClass())) {
            return;
        } else {
            if ((list instanceof zzmc) && (list instanceof zzkp)) {
                zzkp zzkpVar = (zzkp) list;
                if (zzkpVar.zzbo()) {
                    zzkpVar.zzbp();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        zznd.zza(obj, j, unmodifiableList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.drive.zzla
    public final <E> void zza(Object obj, Object obj2, long j) {
        ArrayList arrayList;
        List zzb = zzb(obj2, j);
        int size = zzb.size();
        List zzb2 = zzb(obj, j);
        if (zzb2.isEmpty()) {
            if (zzb2 instanceof zzkz) {
                zzb2 = new zzky(size);
            } else if ((zzb2 instanceof zzmc) && (zzb2 instanceof zzkp)) {
                zzb2 = ((zzkp) zzb2).zzr(size);
            } else {
                zzb2 = new ArrayList(size);
            }
            zznd.zza(obj, j, zzb2);
        } else {
            if (zzto.isAssignableFrom(zzb2.getClass())) {
                ArrayList arrayList2 = new ArrayList(zzb2.size() + size);
                arrayList2.addAll(zzb2);
                zznd.zza(obj, j, arrayList2);
                arrayList = arrayList2;
            } else if (zzb2 instanceof zzna) {
                List zzkyVar = new zzky(zzb2.size() + size);
                zzkyVar.addAll((zzna) zzb2);
                zznd.zza(obj, j, zzkyVar);
                arrayList = zzkyVar;
            } else if ((zzb2 instanceof zzmc) && (zzb2 instanceof zzkp)) {
                zzkp zzkpVar = (zzkp) zzb2;
                if (!zzkpVar.zzbo()) {
                    zzb2 = zzkpVar.zzr(zzb2.size() + size);
                    zznd.zza(obj, j, zzb2);
                }
            }
            zzb2 = arrayList;
        }
        int size2 = zzb2.size();
        int size3 = zzb.size();
        if (size2 > 0 && size3 > 0) {
            zzb2.addAll(zzb);
        }
        if (size2 > 0) {
            zzb = zzb2;
        }
        zznd.zza(obj, j, zzb);
    }

    private static <E> List<E> zzb(Object obj, long j) {
        return (List) zznd.zzo(obj, j);
    }
}