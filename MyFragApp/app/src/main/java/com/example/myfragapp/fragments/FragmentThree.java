package com.example.myfragapp.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myfragapp.R;
import com.example.myfragapp.classes.Clients;
import com.example.myfragapp.classes.ClientsData;
import com.example.myfragapp.classes.CustomerAdapter;
import com.example.myfragapp.classes.Ingredient;

import java.util.ArrayList;
import com.example.myfragapp.classes.IngredientsData;

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
    private LinearLayoutManager linearLayoutManager ;
    private CustomerAdapter adapter;
    private ClientsData clientsData;


    //add the option of searching
    private void filter(String text) {
        ArrayList<Ingredient> filteredList = new ArrayList<>();
        for (Ingredient item : dataset) {
            if (item.getIngredientName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapter.filterList(filteredList); // Update adapter with filtered list
    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_three, container, false);

        //the connection to the recycle view
        recyclerView = view.findViewById(R.id.resView1); //find the recyclerView for using  //view.
        searchEditText = view.findViewById(R.id.editTextSearch);//find the searchText(id:editTextText) for using

        dataset=new ArrayList<>();
        linearLayoutManager= new LinearLayoutManager(getContext()); //will give the ability of the recyclerView to move from up to down

        recyclerView.setLayoutManager(linearLayoutManager);//set recyclerView to move from up to down
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        for(int i=0; i <IngredientsData.ingredientAmountArray.length; i++){
            dataset.add(new Ingredient(
                    IngredientsData.ingredientNameArray[i],
                    IngredientsData.ingredientPriceArray[i],
                    IngredientsData.ingredientImageArray[i]
            ) );
        }
        clientsData = new ClientsData();
        adapter = new CustomerAdapter(dataset, clientsData,getContext());

        //adapter=new CustomerAdapter(dataset);

        recyclerView.setAdapter(adapter);

        recyclerView.setAdapter(adapter);

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
                filter(s.toString()); 
            }
        });

        //log out btn,Pass from main to SignUp fragment
        Button btnLogOut= view.findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentThree_to_mainFragment);

            }
        });

        return view;

    }

}