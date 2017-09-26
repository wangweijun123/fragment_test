package com.example.wangweijun.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by wangweijun on 2017/9/26.
 */

public class NoContentFragment extends Fragment{
    public OnRefreshListener callback;

    public interface OnRefreshListener {
        void onRefresh();
    }
    int position;
    @Override
    public void onAttach(Activity activity) {
        Log.i("wang", this + " onAttach");
        super.onAttach(activity);
        try {
            this.callback = (OnRefreshListener)activity;
        }catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i("wang", this + " onCreate");
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            position = bundle.getInt("position", 0);
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.i("wang", this + " onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_no_content, container, false);
        TextView tv = (TextView)rootView.findViewById(R.id.tv);
        tv.setText("no content");
        tv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (callback != null) {
                    callback.onRefresh();
                }
            }
        });
        return rootView;
    }


    @Override
    public void onResume() {
        Log.i("wang", this + " onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i("wang", this + " onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i("wang", this + " onStop");
        super.onStop();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("wang", this + " onDetach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("wang", this + " onDestroy");
    }
}
