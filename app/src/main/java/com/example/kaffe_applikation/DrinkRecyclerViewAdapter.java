package com.example.kaffe_applikation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.ObjectInputStream;
import java.text.BreakIterator;
import java.util.ArrayList;

public class DrinkRecyclerViewAdapter extends RecyclerView.Adapter<DrinkRecyclerViewAdapter.ViewHolder> {

    private ArrayList<Drink> drinks;
    private LayoutInflater inflater;

    public DrinkRecyclerViewAdapter(Context context, ArrayList<Drink> drinks) {
        this.inflater = LayoutInflater.from(context);
        this.drinks = drinks;
    }

    @NonNull
    @Override
    public DrinkRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkRecyclerViewAdapter.ViewHolder holder, int position) {
        Drink drink = drinks.get(position);
        holder.name.setText(drink.getName());
        holder.cost.setText(drink.getCost().toString()+"kr");
        holder.category.setText(drink.getCategory());
        Picasso.get().load(drink.getAuxdata()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return drinks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name, cost, category;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            cost = itemView.findViewById(R.id.cost);
            category = itemView.findViewById(R.id.category);
            image = itemView.findViewById(R.id.image);
        }
    }
}
