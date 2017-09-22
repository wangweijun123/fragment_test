package com.example.wangweijun.fragment;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int mStackLevel = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentTransaction ft = getFragmentManager().beginTransaction();
        CountingFragment newfragment = new CountingFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("num", mStackLevel);
        newfragment.setArguments(bundle);
        ft.replace(R.id.container_fragment, newfragment).commit();

        // Watch for button clicks.
        Button button = (Button)findViewById(R.id.new_fragment);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addFragmentToStack();
            }
        });
        button = (Button)findViewById(R.id.delete_fragment);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

    }

    void addFragmentToStack() {
        mStackLevel++;
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        CountingFragment newfragment = new CountingFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("num", mStackLevel);
        newfragment.setArguments(bundle);
        ft.replace(R.id.container_fragment, newfragment);
//        ft.setCustomAnimations(R.anim.alpha_from_0_to_1,R.anim.alpha_from_1_to_0);
        ft.addToBackStack(null);
        ft.commit();
    }
}
