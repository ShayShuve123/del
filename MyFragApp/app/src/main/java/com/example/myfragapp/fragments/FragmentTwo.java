package com.example.myfragapp.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfragapp.R;
import com.example.myfragapp.classes.Clients;
import com.example.myfragapp.classes.ClientsData;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentTwo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTwo extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentTwo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTwo.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentTwo newInstance(String param1, String param2) {
        FragmentTwo fragment = new FragmentTwo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_two, container, false);

        Button btnLogIn2= view.findViewById(R.id.btnLogin2);
        TextView userName=view.findViewById(R.id.editTextUserNameL);//id of the username
        TextView pass=view.findViewById(R.id.editTextPasswordL);//id of the password
        btnLogIn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=userName.getText().toString().trim();//text of the username
                String password =pass.getText().toString().trim();
                Toast.makeText(getContext()," "+username+", "+password+" " , Toast.LENGTH_SHORT).show();
                //to check her if the name and the password in the arr/Db
                Clients user = ClientsData.getInstance().findUserByUsername(username);

                if (user == null || !user.getPassword().equals(password)) {
                    // User doesn't exist or password is incorrect
                    Toast.makeText(getContext(), "Invalid username or password.", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getContext(), " Sign up failed, try again...", Toast.LENGTH_SHORT).show();
                    Navigation.findNavController(view).navigate(R.id.action_fragmentTwo_to_mainFragment);
                } else {
                    //save the username in the cache and pass the username to the recycle view and then to the adapter
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", username);
                    editor.apply();
                    //end

                    // User exists and password is correct, navigate to FragmentThree
                     Navigation.findNavController(view).navigate(R.id.action_fragmentTwo_to_fragmentThree);

                }

            }
        });

        return view;



    }
}