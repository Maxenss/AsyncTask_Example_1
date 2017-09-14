package com.easylabs.asynctask_example_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity
        implements View.OnClickListener {
    ArrayList<Button> buttons = new ArrayList<>();
    ArrayList<Counter> counters = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button b1 = new Button(this);
        Button b2 = new Button(this);
        Button b3 = new Button(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);

        Counter ct1 = new Counter(30, "Name1");
        Counter ct2 = new Counter(20, "Name2");
        Counter ct3 = new Counter(10, "Name3");
        counters.add(ct1);
        counters.add(ct2);
        counters.add(ct3);
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        int index = buttons.indexOf(button);
        Counter counter = counters.get(index);
        counter.setCount(counter.getCount() + 1);
    }

    private void newCounter() {
        Button newButton = new Button(this);
        newButton.setOnClickListener(this);
        Counter counter = new Counter(10, "Counter");

        buttons.add(newButton);
        counters.add(counter);
    }
}
