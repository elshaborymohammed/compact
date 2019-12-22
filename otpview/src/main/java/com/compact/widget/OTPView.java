package com.compact.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class OTPView extends AppCompatEditText {
    //    public static final String DEFAULT_MASK = "\u25CF";
    private static final String XML_NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android";

    private Drawable background;
    private ColorStateList colorStateListLine;
    private int maxLength;
    private Paint linePaint;
    private boolean isLine = true;
    private boolean isError = false;
    private List<Rect> rect = new ArrayList<>();
    private List<OnOTPCompleteListener> listeners = new ArrayList<>();

    public OTPView(Context context) {
        super(context);
        init(context, null);
    }

    public OTPView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public OTPView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setMaxLines(1);
        if (null != attrs) {
            maxLength = attrs.getAttributeIntValue(XML_NAMESPACE_ANDROID, "maxLength", 6);
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});
            setBackgroundDrawable(null);
            setCursorVisible(false);

            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.OTPView);
            isLine = a.getBoolean(R.styleable.OTPView_line, true);
            if (isLine) {
                linePaint = new Paint(getPaint());
                ColorStateList colors = a.getColorStateList(R.styleable.OTPView_lineColors);
                if (null != colors) {
                    colorStateListLine = colors;
                } else {
                    colorStateListLine = ContextCompat.getColorStateList(context, R.color.se_otp);
                }
            } else {
                background = a.getDrawable(R.styleable.OTPView_backgroundDrawable);
                if (null == background) {
                    background = ContextCompat.getDrawable(context, R.drawable.bg_otp);
                }
            }
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        int availableWidth = getWidth(); //- ViewCompat.getPaddingEnd(this) - ViewCompat.getPaddingStart(this);
        int top = 0;
        int bottom = (int) (getHeight() - (getHeight() * 0.20));
        int rectWidth = bottom;
        int allSpace = availableWidth - (rectWidth * maxLength);
        int space = allSpace / (maxLength + 1);
        int left;

        rect = new ArrayList<>();
        for (int i = 0; i < maxLength; i++) {
            left = (rectWidth * i) + (space * (i + 1));
            rect.add(new Rect(
                    left,
                    top,
                    left + rectWidth,
                    bottom
            ));
        }
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        setError(false);

        if (hasOnOTPCompleteListener() && text.length() == maxLength) {
            for (OnOTPCompleteListener listener : listeners) {
                listener.onOTPCompleteListener(this, text);
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float[] textWidths = new float[maxLength];
        getPaint().getTextWidths(getText().toString(), 0, getText().length(), textWidths);

        TextPaint paint = getPaint();
        paint.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 20, getResources().getDisplayMetrics()));

        for (int i = 0; i < maxLength; i++) {
            if (isLine) {
                updateColorForLines(i < getText().length(), i == getText().length());
                canvas.drawLine(rect.get(i).left, rect.get(i).bottom, rect.get(i).right, rect.get(i).bottom, linePaint);
            } else {
                updateDrawableState(i < getText().length(), i == getText().length());
                background.setBounds(rect.get(i));
                background.draw(canvas);
            }
        }

        Rect bounds;
        for (int i = 0; i < getText().length(); i++) {
            bounds = new Rect();
            getPaint().getTextBounds(getText().toString(), i, i + 1, bounds);
            canvas.drawText(getText().toString(),
                    i,
                    i + 1,
                    rect.get(i).left + Math.abs(Math.abs(rect.get(i).right - rect.get(i).left) - textWidths[i]) / 2,
                    rect.get(i).bottom - Math.abs(Math.abs(rect.get(i).top - rect.get(i).bottom) - bounds.height()) / 2,
                    paint
            );
        }
    }

    private void updateColorForLines(boolean hasText, boolean isNext) {
        if (isError) {
            linePaint.setColor(getColorForState(android.R.attr.state_active));
        } else if (isFocused()) {
            linePaint.setColor(getColorForState(android.R.attr.state_focused));
            if (isNext) {
                linePaint.setColor(getColorForState(android.R.attr.state_focused, android.R.attr.state_selected));
            } else if (hasText) {
                linePaint.setColor(getColorForState(android.R.attr.state_focused, android.R.attr.state_checked));
            }
        } else {
            if (hasText) {
                linePaint.setColor(getColorForState(-android.R.attr.state_focused, android.R.attr.state_checked));
            } else {
                linePaint.setColor(getColorForState(-android.R.attr.state_focused));
            }
        }
        linePaint.setStrokeWidth(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources().getDisplayMetrics()));
    }

    protected void updateDrawableState(boolean hasText, boolean isNext) {
        if (isError) {
            background.setState(new int[]{android.R.attr.state_active});
        } else if (isFocused()) {
            background.setState(new int[]{android.R.attr.state_focused});
            if (isNext) {
                background.setState(new int[]{android.R.attr.state_focused, android.R.attr.state_selected});
            } else if (hasText) {
                background.setState(new int[]{android.R.attr.state_focused, android.R.attr.state_checked});
            }
        } else {
            if (hasText) {
                background.setState(new int[]{-android.R.attr.state_focused, android.R.attr.state_checked});
            } else {
                background.setState(new int[]{-android.R.attr.state_focused});
            }
        }
    }

    private int getColorForState(int... states) {
        return colorStateListLine.getColorForState(states, Color.RED);
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
        invalidate();
    }

    public void addOnOTPCompleteListener(OnOTPCompleteListener listener) {
        this.listeners.add(listener);
    }

    public void removeOnOTPCompleteListener(OnOTPCompleteListener listener) {
        this.listeners.remove(listener);
    }

    public void clearOnOTPCompleteListener() {
        this.listeners.clear();
    }

    public boolean hasOnOTPCompleteListener() {
        return null != this.listeners && this.listeners.size() > 0;
    }

    public interface OnOTPCompleteListener {
        void onOTPCompleteListener(OTPView view, CharSequence otp);
    }
}
