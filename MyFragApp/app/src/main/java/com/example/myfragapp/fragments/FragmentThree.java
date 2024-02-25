package com.example.myfragapp.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myfragapp.R;
import com.example.myfragapp.classes.CustomerAdapter;
import com.example.myfragapp.classes.Ingredient;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentThree#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentThree extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentThree() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentThree.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentThree newInstance(String param1, String param2) {
        FragmentThree fragment = new FragmentThree();
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

    //the connection to the recycle view
    private ArrayList<Ingredient> dataset;
    private RecyclerView recyclerView;
    private EditText searchEditText;

    //will give the ability of the recyclerView to move from up to down
    private LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    private CustomerAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_three, container, false);

        //i will paas like that the username and then will take him from the adapter//not sure
        String username = getArguments().getString("username");
        TextView textViewClientUsername=view.findViewById(R.id.textViewClientUsername);
        if(username!=null)
        {
            textViewClientUsername.setText(username);
        }

        //the connection to the recycle view
        recyclerView = view.findViewById(R.id.resView1); //find the recyclerView for using  //view.
        searchEditText = view.findViewById(R.id.editTextSearch);//find the searchText(id:editTextText) for using

        dataset=new ArrayList<>();

        recyclerView.setLayoutManager(linearLayoutManager);//set recyclerView to move from up to down
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        for(int i=0; i <IngredientsData.drawableArray.length; i++){
            dataset.add(new Ingredient(
                    IngredientsData.nameArray[i],
                    IngredientsData.descriptionArray[i],
                    IngredientsData.drawableArray[i]
            ) );
        }


        adapter=new CustomeAdapter(dataset);
        recyclerView.setAdapter(adapter);
        //add the option of searching

        // Set up TextWatcher for EditText
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString()); // Call filter method when text changes
            }
        });

        private void filter(String text) {
            ArrayList<DataModel> filteredList = new ArrayList<>();
            for (DataModel item : dataset) {
                if (item.getCharacterName().toLowerCase().contains(text.toLowerCase())) {
                    filteredList.add(item);
                }
            }
            adapter.filterList(filteredList); // Update adapter with filtered list
        }




        return view;

    }
}