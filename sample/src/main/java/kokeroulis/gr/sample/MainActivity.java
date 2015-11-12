package kokeroulis.gr.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import kokeroulis.gr.uiforms.forms.DoubleForm;
import kokeroulis.gr.uiforms.forms.IntegerForm;
import kokeroulis.gr.uiforms.validators.DoubleValidator;
import kokeroulis.gr.uiforms.validators.IntegerValidator;
import kokeroulis.gr.uiforms.validators.NumberValidator;

public class MainActivity extends AppCompatActivity {
    private Toast mToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntegerForm intForm = (IntegerForm) findViewById(R.id.int_form);
        DoubleForm doubleForm = (DoubleForm) findViewById(R.id.double_form);

        intForm.generateValidator(new IntegerValidator(0, 50));
        doubleForm.generateValidator(new DoubleValidator(0.0, 50.0));

        intForm.setInvalidInputListener(new NumberValidator.InvalidInputListener() {
            @Override
            public void onInvalidInput(String source, int reasonId) {
                showError(source, reasonId);
            }
        });

        doubleForm.setInvalidInputListener(new NumberValidator.InvalidInputListener() {
            @Override
            public void onInvalidInput(String source, int reasonId) {
                showError(source, reasonId);
            }
        });
    }

    private void showError(String msg, int reasonId) {
        stopToast();
        mToast = Toast.makeText(this, "Invalid input: " + msg + " Reason: " + reasonId, Toast.LENGTH_SHORT);
        mToast.show();
    }

    private void stopToast() {
        if (mToast == null) {
            return;
        }
        mToast.cancel();
        mToast = null;
    }
}
