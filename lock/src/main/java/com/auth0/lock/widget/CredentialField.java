/*
 * CredentialField.java
 *
 * Copyright (c) 2014 Auth0 (http://auth0.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.auth0.lock.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.EditText;

import com.auth0.lock.R;

/**
 * Created by hernan on 12/15/14.
 */
public class CredentialField extends EditText {

    private final int iconResource;
    private final int errorIconResource;
    private final int colorResource;
    private final int errorColorResource;

    public CredentialField(Context context) {
        this(context, null);
    }

    public CredentialField(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.editTextStyle);
    }

    public CredentialField(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CredentialField, defStyleAttr, 0);
        try {
            iconResource = a.getResourceId(R.styleable.CredentialField_normalIconDrawable, -1);
            errorIconResource = a.getResourceId(R.styleable.CredentialField_errorIconDrawable, -1);
            errorColorResource = a.getResourceId(R.styleable.CredentialField_errorColor, R.color.credential_field_error);
            colorResource = getTextColors().getDefaultColor();
            setCompoundDrawablesWithIntrinsicBounds(iconResource, 0, 0, 0);
        } finally {
            a.recycle();
        }
    }

    public void markAsInvalid(boolean invalid) {
        if (invalid) {
            setCompoundDrawablesWithIntrinsicBounds(errorIconResource, 0, 0, 0);
            setTextColor(getResources().getColor(errorColorResource));
        } else {
            setCompoundDrawablesWithIntrinsicBounds(iconResource, 0, 0, 0);
            setTextColor(colorResource);
        }
    }
}
