package net.codestage.actk.androidnative;

import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FileFilter {
    private Boolean caseSensitive;
    private Boolean exactFileNameMatch;
    private Boolean exactFolderMatch;
    private String filterExtension;
    private String filterFileName;
    private String filterFolder;
    private Boolean folderRecursive;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileFilter(String str) {
        if (str == null || str.isEmpty()) {
            Log.e(NativeUtils.LogTag, "Can't parse FileFilter: string is null or empty!");
            return;
        }
        String[] split = str.split("\\|");
        if (split.length < 4) {
            String str2 = NativeUtils.LogTag;
            Log.e(str2, "Can't parse FileFilter: string split only to " + split.length + " parts instead of minimum 4 parts!");
            return;
        }
        this.caseSensitive = Boolean.valueOf(Boolean.parseBoolean(split[0]));
        this.folderRecursive = Boolean.valueOf(Boolean.parseBoolean(split[1]));
        this.exactFileNameMatch = Boolean.valueOf(Boolean.parseBoolean(split[2]));
        this.exactFolderMatch = Boolean.valueOf(Boolean.parseBoolean(split[3]));
        if (split.length >= 5) {
            this.filterFolder = split[4];
        }
        if (split.length >= 6) {
            this.filterExtension = split[5];
        }
        if (split.length >= 7) {
            this.filterFileName = split[6];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
        if (r5.filterExtension.equalsIgnoreCase(r6) == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean MatchPath(java.lang.String r6) {
        /*
            r5 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r6)
            java.lang.String r6 = r5.filterExtension
            r1 = 1
            java.lang.String r2 = "."
            r3 = 0
            if (r6 == 0) goto L4e
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L4e
            java.lang.String r6 = r0.getName()
            boolean r4 = r6.isEmpty()
            if (r4 == 0) goto L1e
            return r3
        L1e:
            int r4 = r6.indexOf(r2)
            if (r4 <= 0) goto L4d
            int r4 = r6.lastIndexOf(r2)
            int r4 = r4 + r1
            java.lang.String r6 = r6.substring(r4)
            boolean r4 = r6.isEmpty()
            if (r4 == 0) goto L34
            return r3
        L34:
            java.lang.Boolean r4 = r5.caseSensitive
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L45
            java.lang.String r4 = r5.filterExtension
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L4e
            return r3
        L45:
            java.lang.String r4 = r5.filterExtension
            boolean r6 = r4.equalsIgnoreCase(r6)
            if (r6 != 0) goto L4e
        L4d:
            return r3
        L4e:
            java.lang.String r6 = r5.filterFileName
            if (r6 == 0) goto Lad
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto Lad
            java.lang.String r6 = r0.getName()
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L63
            return r3
        L63:
            int r0 = r6.indexOf(r2)
            if (r0 <= 0) goto L71
            int r0 = r6.lastIndexOf(r2)
            java.lang.String r6 = r6.substring(r3, r0)
        L71:
            java.lang.Boolean r0 = r5.exactFileNameMatch
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L93
            java.lang.Boolean r0 = r5.caseSensitive
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L8a
            java.lang.String r0 = r5.filterFileName
            boolean r6 = r0.equals(r6)
            if (r6 != 0) goto Lad
            return r3
        L8a:
            java.lang.String r0 = r5.filterFileName
            boolean r6 = r0.equalsIgnoreCase(r6)
            if (r6 != 0) goto Lad
            return r3
        L93:
            java.lang.Boolean r0 = r5.caseSensitive
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto La4
            java.lang.String r0 = r5.filterFileName
            boolean r6 = r6.contains(r0)
            if (r6 != 0) goto Lad
            return r3
        La4:
            java.lang.String r0 = r5.filterFileName
            boolean r6 = net.codestage.actk.androidnative.NativeUtils.ContainsIgnoreCase(r6, r0)
            if (r6 != 0) goto Lad
            return r3
        Lad:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.codestage.actk.androidnative.FileFilter.MatchPath(java.lang.String):boolean");
    }
}