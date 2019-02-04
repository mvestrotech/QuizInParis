package mvestro.android.quizinparis.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import mvestro.android.quizinparis.R;
import mvestro.android.quizinparis.model.HttpHandler;


public class FriendFragment extends Fragment {

    private String TAG = FriendFragment.class.getSimpleName();
    private ListView lv;
    private String url_img = "http://mvestrotech.tech/profiles/Nicolas-Gar.jpg";

    ArrayList<HashMap<String, String>> contactList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_friend, container, false);

        View view = inflater.inflate(R.layout.fragment_friend, container, false);

        contactList = new ArrayList<>();
        lv = (ListView) view.findViewById(R.id.list);
        ImageView imageView = view.findViewById(R.id.imageView);

        new GetContacts().execute();

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private class GetContacts extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();


        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = "https://api.myjson.com/bins/1dpcjw";
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray contacts = jsonObj.getJSONArray("contacts");

                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);
                        String id = c.getString("id");
                        String firstName = c.getString("first_name");
                        String lastName = c.getString("last_name");
                        String lastScore = c.getString("last_score");
                        String profileUrl = c.getString("profile_url");

                        // tmp hash map for single contact
                        HashMap<String, String> contact = new HashMap<>();

                        // adding each child node to HashMap key => value
                        contact.put("id", id);
                        contact.put("score", lastScore);
                        contact.put("name", lastName + " " + firstName);
//                        contact.put("mobile", gender);

                        // adding contact to contact list
                        contactList.add(contact);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());

                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            ListAdapter adapter = new SimpleAdapter(getActivity(), contactList,
                    R.layout.list_item, new String[]{ "name"},
                    new int[]{R.id.name});
            lv.setAdapter(adapter);
        }
    }
}
