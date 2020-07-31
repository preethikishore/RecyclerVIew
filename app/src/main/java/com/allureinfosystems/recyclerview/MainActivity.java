package com.allureinfosystems.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    String[] countryName = {"INDIA","USA","UK","FRANCE","INDIA","USA","UK","FRANCE"};
    private RecyclerView.Adapter DataAdapter;
    int [] flag = { R.drawable.india,R.drawable.usa,R.drawable.uk,R.drawable.france,R.drawable.india,R.drawable.usa,R.drawable.uk,R.drawable.france};
    static ArrayList<HashMap<String, String>> dataItem;
    HashMap<String, String> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this,
                RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(mLayoutManager);


        //recyclerView.setAdapter(DataAdapter);
        dataItem = new ArrayList<>();

        for (int i = 0; i < countryName.length ; i++) {

            map = new HashMap<String, String>();
            map.put("CName",countryName[i]);
            map.put("Cflag", flag [i] +"");
            dataItem.add(map);


        }
        DataAdapter = new mDataAdapter(dataItem);
        recyclerView.setAdapter(DataAdapter);

        loadAnimation(recyclerView);
    }

    private void loadAnimation(RecyclerView recycler)
    {
        Context context = recycler.getContext();
        LayoutAnimationController layoutAnimationController =
                AnimationUtils.loadLayoutAnimation(context,R.anim.layout_fall_down);
        recycler.setLayoutAnimation(layoutAnimationController);
        recycler.getAdapter().notifyDataSetChanged();
        recycler.scheduleLayoutAnimation();

    }

}
