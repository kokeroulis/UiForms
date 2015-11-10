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
import android.widget.EditText;

import kokeroulis.gr.uiforms.validators.DoubleValidator;

public class DoubleForm extends BaseElementForm {
    public DoubleForm(Context context) {
        super(context);
    }

    public DoubleForm(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DoubleForm(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void setFilters(EditText editView) {
        DoubleValidator validator = new DoubleValidator(0.0, 50.0);
        editView.setFilters(new InputFilter[]{validator});
    }
}
