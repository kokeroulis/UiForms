package kokeroulis.gr.uiforms.validators;

/*  Copyright (C) 2015 Antonis Tsiapaliokas
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
    */

import android.text.InputFilter;
import android.text.Spanned;

public abstract class NumberValidator<T extends Comparable<T>> implements InputFilter {
    private final T mMaxVal;
    private final T mMinVal;

    private static int BIGGER = 1;
    private static int LOWER = -1;

    public NumberValidator(T minVal, T maxVal) {
        mMaxVal = maxVal;
        mMinVal = minVal;
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        String number = dest.toString() + source;
        final T val = charToVal(number);

        if (val.compareTo(charToVal("0")) != LOWER
            && val.compareTo(mMaxVal) != BIGGER
            && val.compareTo(mMinVal) != LOWER) {
            return source;
        } else {
            return "";
        }
    }

    protected abstract T charToVal(String source);
}
