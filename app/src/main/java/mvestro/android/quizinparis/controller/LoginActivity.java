package mvestro.android.quizinparis.controller;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import mvestro.android.quizinparis.R;

public class LoginActivity extends AppCompatActivity {

    private TextView mIdLogin;
    private TextView mPasswordLogin;
    private Button mValidateBtn;
    private String password;
    private String ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mIdLogin = (TextView) findViewById(R.id.activity_login_id_input);
        mPasswordLogin = (TextView) findViewById(R.id.activity_login_password_input);
        mValidateBtn = (Button) findViewById(R.id.activity_login_validate_btn);
        password = "root";
        ID = "root";

        mValidateBtn.setEnabled(false);

        mPasswordLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mValidateBtn.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mValidateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username = (EditText)findViewById(R.id.activity_login_id_input);
                EditText password = (EditText)findViewById(R.id.activity_login_password_input);
                remoteLogin(username.getText().toString(), password.getText().toString());
                    // User clicked the button
                    //Intent gridActivityIntent = new Intent(LoginActivity.this, GridActivity.class);
                    //startActivity(gridActivityIntent);
            }
        });

    }

    public void remoteLogin(String username, String password){
        ProgressDialog pDialog = new ProgressDialog(this);
        String urlString = "http://mvestrotech.tech/api/login.php?key=iot1235&username="+username+"&password="+password;
        Ion.with(this).load(urlString).asJsonObject().setCallback(new FutureCallback<JsonObject>() {
            @Override
            public void onCompleted(Exception e, JsonObject result) {
                Log.d("test", result.toString());
                if(result.get("id") != null){
                    Friend me = (Friend) Friend.getFriendFromJson(result);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),
                            "pas bon id", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
