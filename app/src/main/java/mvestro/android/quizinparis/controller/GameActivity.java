package mvestro.android.quizinparis.controller;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import mvestro.android.quizinparis.R;
import mvestro.android.quizinparis.fragment.FriendFragment;
import mvestro.android.quizinparis.model.Friend;
import mvestro.android.quizinparis.model.HttpHandler;
import mvestro.android.quizinparis.model.Question;
import mvestro.android.quizinparis.model.QuestionBank;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private String TAG = FriendFragment.class.getSimpleName();
    private TextView mQuestionTextView;
    private ProgressBar mProgressBar;
    private Button mAnswerButton1;
    private Button mAnswerButton2;
    private Button mAnswerButton3;
    private Button mAnswerButton4;

    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;

    private int mScore;
    private int mNumberOfQuestions;
    private int counter;

    public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";
    public static final String BUNDLE_STATE_SCORE = "currentScore";
    public static final String BUNDLE_STATE_QUESTION = "currentQuestion";

    private boolean mEnableTouchEvents;

    ArrayList<HashMap<String, String>> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        System.out.println("GameActivity::onCreate()");

        Bundle arr = getIntent().getExtras();
        String val_arr = arr.getString("ARR");
        new GetQuestion().execute();
        new GetResponse().execute();

    }
    public void getQuestion(){
        ProgressDialog pDialog = new ProgressDialog(this);
        String urlString = "http://mvestrotech.tech/api/getQuestion.php?key=iot1235";
        Ion.with(this).load(urlString).asJsonObject().setCallback(new FutureCallback<JsonObject>() {
            @Override
            public void onCompleted(Exception e, JsonObject result) {
                result.get("id");
            }
        });
    }

    private class GetQuestion extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = "http://mvestrotech.tech/api/getQuestion.php";
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    // Getting JSON Array node
                    JSONArray jsonObj = new JSONArray(jsonStr);


                    // looping through All Contacts
                    for (int i = 0; i < jsonObj.length(); i++) {


                        JSONObject c = jsonObj.getJSONObject(i);
                        String zone = c.getString("zone");
                        Bundle arr = getIntent().getExtras();
                        String val_arr = arr.getString("ARR");

                        if(zone.equals(val_arr)){
                            String laquestion = c.getString("question");

                            TextView textViewQuestion = (TextView)findViewById(R.id.activity_game_question_text);
                            textViewQuestion.setText(laquestion);
                            break;
                        }else{
                            TextView textViewQuestion = (TextView)findViewById(R.id.activity_game_question_text);
                            textViewQuestion.setText("pas bon");
                        }
                    }

                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    TextView textViewQuestion = (TextView)findViewById(R.id.activity_game_question_text);
                    textViewQuestion.setText("erreur");

                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");
            }

            return null;
        }


    }

    private class GetResponse extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = "http://mvestrotech.tech/api/getResponse.php";
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    // Getting JSON Array node
                    JSONArray jsonObj = new JSONArray(jsonStr);
                    int j = 0;
                    for (int i = 0; i < jsonObj.length(); i++) {
                        // looping through All Contacts
                        Bundle arr = getIntent().getExtras();
                        String val_arr = arr.getString("ARR");
                        JSONObject c = jsonObj.getJSONObject(i);
                        String id = c.getString("id");
                        String zone = c.getString("zone");
                        String rep = c.getString("response");
                        TextView textViewreponse;
                        if(zone.equals(val_arr)){
                            switch(j){
                                case 0: textViewreponse = (TextView)findViewById(R.id.activity_game_answer1_btn);
                                    textViewreponse.setText(rep);
                                    break;
                                case 1: textViewreponse = (TextView)findViewById(R.id.activity_game_answer2_btn);
                                    textViewreponse.setText(rep);
                                    break;
                                case 2: textViewreponse = (TextView)findViewById(R.id.activity_game_answer3_btn);
                                    textViewreponse.setText(rep);
                                    break;
                            }
                            j++;
                        }


                    }

                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    TextView textViewQuestion = (TextView)findViewById(R.id.activity_game_answer1_btn);
                    textViewQuestion.setText("erreur");

                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");
            }

            return null;
        }


    }

    @Override
    public void onClick(View v) {

    }
}
