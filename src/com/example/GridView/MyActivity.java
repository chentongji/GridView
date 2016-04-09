package com.example.GridView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.util.*;

public class MyActivity extends Activity {
    GridView grid;
    ImageView imageView;
    int[] imageIds = new int[]{
            R.drawable.bomb5 , R.drawable.bomb6 , R.drawable.bomb7
            , R.drawable.bomb8 , R.drawable.bomb9 , R.drawable.bomb10
            , R.drawable.bomb11 , R.drawable.bomb12	, R.drawable.bomb13
            , R.drawable.bomb14 , R.drawable.bomb15 , R.drawable.bomb16
    };

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        List<Map<String,Object>> listItems=new ArrayList<Map<String, Object>>();
        for (int i=0; i<imageIds.length;i++)
        {
            Map<String,Object>listItem = new HashMap<String, Object>();
            listItem.put("image",imageIds[i]);
            listItems.add(listItem);

    }
        imageView=(ImageView)findViewById(R.id.imageView);
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,R.layout.cell,new String[]{
        "image"},new int[]{R.id.image1
    });
        grid=(GridView)findViewById(R.id.grid01);
        grid.setAdapter(simpleAdapter);
        grid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?>parent, View view,int position,long id) {
                imageView.setImageResource(imageIds[position]);
            }
                @Override
                        public void onNothingSelected(AdapterView<?>parent)
                {
        }
        });
            grid.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
            @Override
            public  void onItemClick( AdapterView<?>parent,View view,int position,long id)
                {
                   imageView.setImageResource(imageIds[position]);
                }

            });
        }

}
