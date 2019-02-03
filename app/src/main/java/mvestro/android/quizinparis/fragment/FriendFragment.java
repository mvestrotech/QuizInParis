package mvestro.android.quizinparis.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mvestro.android.quizinparis.R;
import mvestro.android.quizinparis.controller.Friend;
import mvestro.android.quizinparis.controller.MainActivity;


public class FriendFragment extends Fragment {

    private String TAG = MainActivity.class.getSimpleName();
    private ListView lv;
    private ListView mListView;
    private Friend mfriend;
    private List<Friend> friendList;
    ArrayList<HashMap<String, String>> contactList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_friend, container, false);

        View view = inflater.inflate(R.layout.fragment_friend, container, false);

        String[] mListFriend = {"Arthur",
                                "Nicolas",
                                "Elodie",
                                "Lauryn"};

        ListView listView = (ListView) view.findViewById(R.id.listView);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mListFriend);

        listView.setAdapter(listViewAdapter);

        return view;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
