package com.example.wangweijun.fragment;

import android.app.FragmentTransaction;
import android.content.Intent;
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
        ft.add(R.id.container_fragment, newfragment).commit();

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


        Button skip = (Button)findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ContainerFragmentsActivity.class));
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
//        ft.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_right_exit);
//        ft.setCustomAnimations(R.anim.alpha_from_0_to_1,R.anim.alpha_from_1_to_0);
        ft.replace(R.id.container_fragment, newfragment);

        ft.addToBackStack(null);// 控制是否加入堆栈，如果不调用，就是不加入，用户按返回直接退出activity
        ft.commit();
    }
}
