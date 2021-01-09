package umn.ac.id.utsmobilemusique_22713;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Username, Password;
    private Button btnLogin;
    private TextView Warning;
    private AppCompatCheckBox Checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Username = findViewById(R.id.etName);
        Password = findViewById(R.id.etPass);
        Password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                   btnLogin.performClick();
                   return true;
                }
                return false;
            }
        });

        btnLogin = findViewById(R.id.btnLogin);
        Warning = findViewById(R.id.warning);
        Checkbox = findViewById(R.id.checkbox);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Username.getText().toString(), Password.getText().toString());
            }
        });

        // hide password
        Password.setTransformationMethod(PasswordTransformationMethod.getInstance());

        Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    // show password
                    Password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    // hide password
                    Password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });


    }

    @SuppressLint("SetTextI18n")
    private void validate(String userName, String userPass){
        if((userName.equals("musique")) && (userPass.equals("musique123"))){
            Intent intent = new Intent(MainActivity.this, MusicPlayer.class);
            startActivity(intent);
        }else if((!userName.equals("musique")) && (userPass.equals("musique123"))){
            Warning.setVisibility(View.VISIBLE);
            Warning.setText("Username salah");
        }else if((userName.equals("musique")) && (!userPass.equals("musique123"))) {
            Warning.setVisibility(View.VISIBLE);
            Warning.setText("Password salah");
        }else if((userName.equals("")) && (userPass.equals(""))) {
            Warning.setVisibility(View.VISIBLE);
            Warning.setText("Username dan Password tidak boleh kosong");
        }else if((!userName.equals("musique")) && (!userPass.equals("musique123"))) {
            Warning.setVisibility(View.VISIBLE);
            Warning.setText("Username dan Password salah");
        }else{
            Warning.setVisibility(View.VISIBLE);
        }
    }
}
