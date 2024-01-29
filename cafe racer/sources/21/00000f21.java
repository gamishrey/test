package com.unity3d.player;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unity3d.services.core.request.metrics.MetricCommonTags;

/* loaded from: classes.dex */
public final class i extends Dialog implements TextWatcher, View.OnClickListener {
    private static int d = 1627389952;
    private static int e = -1;
    public boolean a;
    private Context b;
    private UnityPlayer c;
    private int f;
    private boolean g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {
        private static final int a = View.generateViewId();
        private static final int b = View.generateViewId();
        private static final int c = View.generateViewId();
    }

    public i(Context context, UnityPlayer unityPlayer, String str, int i, boolean z, boolean z2, boolean z3, String str2, int i2, boolean z4, boolean z5) {
        super(context);
        this.b = null;
        this.c = null;
        this.b = context;
        this.c = unityPlayer;
        Window window = getWindow();
        this.a = z5;
        window.requestFeature(1);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.x = 0;
        attributes.y = 0;
        window.setAttributes(attributes);
        window.setBackgroundDrawable(new ColorDrawable(0));
        final View createSoftInputView = createSoftInputView();
        setContentView(createSoftInputView);
        window.setLayout(-1, -2);
        window.clearFlags(2);
        window.clearFlags(134217728);
        window.clearFlags(67108864);
        if (!this.a) {
            window.addFlags(32);
            window.addFlags(262144);
        }
        EditText editText = (EditText) findViewById(a.b);
        a(editText, str, i, z, z2, z3, str2, i2);
        ((Button) findViewById(a.a)).setOnClickListener(this);
        this.f = editText.getCurrentTextColor();
        a(z4);
        this.c.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.unity3d.player.i.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                if (createSoftInputView.isShown()) {
                    Rect rect = new Rect();
                    i.this.c.getWindowVisibleDisplayFrame(rect);
                    int[] iArr = new int[2];
                    i.this.c.getLocationOnScreen(iArr);
                    Point point = new Point(rect.left - iArr[0], rect.height() - createSoftInputView.getHeight());
                    Point point2 = new Point();
                    i.this.getWindow().getWindowManager().getDefaultDisplay().getSize(point2);
                    int height = i.this.c.getHeight() - point2.y;
                    int height2 = i.this.c.getHeight() - point.y;
                    if (height2 != height + createSoftInputView.getHeight()) {
                        i.this.c.reportSoftInputIsVisible(true);
                    } else {
                        i.this.c.reportSoftInputIsVisible(false);
                    }
                    i.this.c.reportSoftInputArea(new Rect(point.x, point.y, createSoftInputView.getWidth(), height2));
                }
            }
        });
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.unity3d.player.i.2
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z6) {
                if (z6) {
                    i.this.getWindow().setSoftInputMode(5);
                }
            }
        });
        editText.requestFocus();
    }

    private static int a(int i, boolean z, boolean z2, boolean z3) {
        int i2 = (z ? 32768 : 524288) | (z2 ? 131072 : 0) | (z3 ? 128 : 0);
        if (i < 0 || i > 11) {
            return i2;
        }
        int[] iArr = {1, 16385, 12290, 17, 2, 3, 8289, 33, 1, 16417, 17, 8194};
        return (iArr[i] & 2) != 0 ? iArr[i] : iArr[i] | i2;
    }

    private void a(EditText editText, String str, int i, boolean z, boolean z2, boolean z3, String str2, int i2) {
        editText.setImeOptions(6);
        editText.setText(str);
        editText.setHint(str2);
        editText.setHintTextColor(d);
        editText.setInputType(a(i, z, z2, z3));
        editText.setImeOptions(33554432);
        if (i2 > 0) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
        }
        editText.addTextChangedListener(this);
        editText.setSelection(editText.getText().length());
        editText.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        ((EditText) findViewById(a.b)).setSelection(0, 0);
        this.c.reportSoftInputStr(str, 1, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b() {
        EditText editText = (EditText) findViewById(a.b);
        if (editText == null) {
            return null;
        }
        return editText.getText().toString();
    }

    public final String a() {
        InputMethodSubtype currentInputMethodSubtype = ((InputMethodManager) this.b.getSystemService("input_method")).getCurrentInputMethodSubtype();
        if (currentInputMethodSubtype == null) {
            return null;
        }
        String locale = currentInputMethodSubtype.getLocale();
        if (locale == null || locale.equals("")) {
            String mode = currentInputMethodSubtype.getMode();
            String extraValue = currentInputMethodSubtype.getExtraValue();
            return mode + " " + extraValue;
        }
        return locale;
    }

    public final void a(int i) {
        EditText editText = (EditText) findViewById(a.b);
        if (editText != null) {
            if (i > 0) {
                editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
            } else {
                editText.setFilters(new InputFilter[0]);
            }
        }
    }

    public final void a(int i, int i2) {
        int i3;
        EditText editText = (EditText) findViewById(a.b);
        if (editText == null || editText.getText().length() < (i3 = i2 + i)) {
            return;
        }
        editText.setSelection(i, i3);
    }

    public final void a(String str) {
        EditText editText = (EditText) findViewById(a.b);
        if (editText != null) {
            editText.setText(str);
            editText.setSelection(str.length());
        }
    }

    public final void a(boolean z) {
        this.g = z;
        EditText editText = (EditText) findViewById(a.b);
        Button button = (Button) findViewById(a.a);
        View findViewById = findViewById(a.c);
        if (z) {
            editText.setBackgroundColor(0);
            editText.setTextColor(0);
            editText.setCursorVisible(false);
            editText.setHighlightColor(0);
            editText.setOnClickListener(this);
            editText.setLongClickable(false);
            button.setTextColor(0);
            findViewById.setBackgroundColor(0);
            findViewById.setOnClickListener(this);
            return;
        }
        editText.setBackgroundColor(e);
        editText.setTextColor(this.f);
        editText.setCursorVisible(true);
        editText.setOnClickListener(null);
        editText.setLongClickable(true);
        button.setClickable(true);
        button.setTextColor(this.f);
        findViewById.setBackgroundColor(e);
        findViewById.setOnClickListener(null);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.c.reportSoftInputStr(editable.toString(), 0, false);
        EditText editText = (EditText) findViewById(a.b);
        int selectionStart = editText.getSelectionStart();
        this.c.reportSoftInputSelection(selectionStart, editText.getSelectionEnd() - selectionStart);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    protected final View createSoftInputView() {
        RelativeLayout relativeLayout = new RelativeLayout(this.b);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(e);
        relativeLayout.setId(a.c);
        EditText editText = new EditText(this.b) { // from class: com.unity3d.player.i.3
            @Override // android.widget.TextView, android.view.View
            public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
                if (i == 4) {
                    i iVar = i.this;
                    iVar.a(iVar.b(), true);
                    return true;
                } else if (i == 84) {
                    return true;
                } else {
                    return super.onKeyPreIme(i, keyEvent);
                }
            }

            @Override // android.widget.TextView
            protected final void onSelectionChanged(int i, int i2) {
                i.this.c.reportSoftInputSelection(i, i2 - i);
            }

            @Override // android.widget.TextView, android.view.View
            public final void onWindowFocusChanged(boolean z) {
                super.onWindowFocusChanged(z);
                if (z) {
                    ((InputMethodManager) i.this.b.getSystemService("input_method")).showSoftInput(this, 0);
                }
            }
        };
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(0, a.a);
        editText.setLayoutParams(layoutParams);
        editText.setId(a.b);
        relativeLayout.addView(editText);
        Button button = new Button(this.b);
        button.setText(this.b.getResources().getIdentifier("ok", "string", MetricCommonTags.METRIC_COMMON_TAG_PLATFORM_ANDROID));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(11);
        button.setLayoutParams(layoutParams2);
        button.setId(a.a);
        button.setBackgroundColor(0);
        relativeLayout.addView(button);
        ((EditText) relativeLayout.findViewById(a.b)).setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.unity3d.player.i.4
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    i iVar = i.this;
                    iVar.a(iVar.b(), false);
                }
                return false;
            }
        });
        relativeLayout.setPadding(16, 16, 16, 16);
        return relativeLayout;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.a || !(motionEvent.getAction() == 4 || this.g)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        a(b(), true);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        a(b(), false);
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}