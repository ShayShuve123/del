package com.example.myfragapp.classes;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfragapp.R;

import java.util.ArrayList;

public  class CustomerAdapter  extends RecyclerView.Adapter<CustomerAdapter.MyViewHolder> {

    ArrayList<Ingredient> dataset;//arr for the recycler view

    ArrayList<Ingredient> filteredList; //filtered list for the recycler view

    ArrayList<Ingredient> clientList; //list for the recycler view that introduce just what the client chose


    //pass the arr from the main
    public CustomerAdapter(ArrayList<Ingredient> dataset) {
        this.dataset = dataset;
        this.filteredList = new ArrayList<>(dataset);
    }

    //
    @SuppressLint("NotifyDataSetChanged")
    public void filterList(ArrayList<Ingredient> filteredList) {
        this.filteredList = filteredList;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {//2.THE CONNECTION TO THE CARD,take out the data

        //In the array
        TextView textIngredientName;
        TextView textIngredientPrice;
        ImageView IngredientImage;
        TextView textIngredientAmount;//quantityText

        //Buttons
        Button btnPlus;
        Button btnMinus;
        Button btnAdd;





        //Content of the card,for using
        public MyViewHolder(View itemView) {
            super(itemView);
            textIngredientName = itemView.findViewById(R.id.textViewIngredientName); //textViewIngredientName
            textIngredientPrice = itemView.findViewById(R.id.textViewIngredientPrice);
            IngredientImage = itemView.findViewById(R.id.imageView);
            textIngredientAmount = itemView.findViewById(R.id.quantityTextView);

            btnPlus = itemView.findViewById(R.id.btnPlus);
            btnMinus=itemView.findViewById(R.id.btnMinus);
            btnAdd=itemView.findViewById(R.id.btnAdd);

        }

    }


    @NonNull
    @Override
    public CustomerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout,parent,false);//1.return the card was opened
        MyViewHolder myVHolder=new MyViewHolder(view); //MyViewHolder--all the data on the card
        return myVHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {//in the back have a loop for the object[i]==position,paas all the arr

        // Ensure position is within the bounds of the filteredList
        Ingredient currentItem = filteredList.get(position);//for the searching
        //print all what in arr
        holder.textIngredientName.setText(currentItem.getIngredientName());
        holder.textIngredientPrice.setText(String.valueOf(currentItem.getIngredientPrice()));
        holder.IngredientImage.setImageResource(currentItem.getIngredientImage());
        holder.textIngredientAmount.setText(String.valueOf(currentItem.getIngredientAmount()));
        //holder.textIngredientAmount.setText(currentItem.getIngredientAmount());

        // Adding click listener to the itemView for a specific Ingredient
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the click event
                String IngredientName = dataset.get(position).getIngredientName();
                String message = "Clicked on " + IngredientName;
                Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show(); // Show the Toast message
            }
        });



        //+ btn
        holder.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newAmount = currentItem.getIngredientAmount() + 1;
                currentItem.setIngredientAmount(newAmount);
                holder.textIngredientAmount.setText(String.valueOf(newAmount));
            }
        });
        //- btn
        holder.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newAmount = currentItem.getIngredientAmount() -1;
                currentItem.setIngredientAmount(newAmount);
                holder.textIngredientAmount.setText(String.valueOf(newAmount));
            }
        });
        //add to
        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //her i need to add the ingrisiant to the bag of the clint to this arr  private ArrayList<Ingredient> ingredients; //To add the ingredients per each client ,
               //i need to know which clint get in and then Clients.cuurnt client.ingredients.add(currentItem)
               //COMLICATED but the idai is to pass her just the name of the user and then to sherch whit the funcshin find users
            }
        });






    }

    @Override
    public int getItemCount() { return filteredList.size();}
}
