package kokeroulis.gr.uiforms.forms;

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

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;

import kokeroulis.gr.uiforms.R;
import kokeroulis.gr.uiforms.validators.NumberValidator;

public abstract class BaseElementForm<Validator extends NumberValidator> extends LinearLayout {

    private EditText mEditValue;
    protected Validator mValidator;

    public BaseElementForm(Context context) {
        super(context);
        initUI(context);
    }

    public BaseElementForm(Context context, AttributeSet attrs) {
        super(context, attrs);
        initUI(context);
    }

    public BaseElementForm(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initUI(context);
    }

    private void initUI(Context context) {
        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);

        LayoutInflater inflater = (LayoutInflater) context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.number_form, this, true);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mEditValue = (EditText) findViewById(R.id.edit);
    }

    public void generateValidator(Validator validator) {
        mValidator = validator;
        setFilters();
    }

    protected void setFilters() {
        mEditValue.setFilters(new InputFilter[]{mValidator});
    }
}
