package com.allureinfosystems.recyclerview;

import android.graphics.drawable.Drawable;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;
        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;
        import java.util.ArrayList;
        import java.util.HashMap;

import static android.graphics.drawable.Drawable.*;


public class mDataAdapter extends RecyclerView.Adapter<mDataAdapter.MyViewHolder> {
    private ArrayList<HashMap<String, String>> dataSet;

    public mDataAdapter(ArrayList< HashMap<String, String>> dataSet) {
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_data, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        HashMap<String, String> Details = dataSet.get(position);
        holder.country.setText(Details.get("CName"));
        holder.flag.setImageResource(Integer.parseInt((Details.get("Cflag"))));


    }


    @Override

    public int getItemCount() {
        return (dataSet == null) ? 0 : dataSet.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView country;
        ImageView flag;



        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            country = (TextView) itemView.findViewById(R.id.countryname);
            flag = (ImageView) itemView.findViewById(R.id.flagname);

        }
    }
}

