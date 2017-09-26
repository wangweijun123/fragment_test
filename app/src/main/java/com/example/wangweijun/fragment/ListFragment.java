package com.example.wangweijun.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by wangweijun on 2017/9/26.
 */

public class ListFragment extends Fragment implements AdapterView.OnItemClickListener{
    OnArticalListItemClickListener callback;

    public interface OnArticalListItemClickListener {
        void onItemSelected(int position);
    }
    Context context;
    int age;
    @Override
    public void onAttach(Activity activity) {
        Log.i("wang", this + " onAttach");
        super.onAttach(activity);
        this.context = activity;
        try {
            this.callback = (OnArticalListItemClickListener)activity;
        }catch (ClassCastException ex) {

        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i("wang", this + " onCreate");
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            age = bundle.getInt("age", 0);
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.i("wang", this + " onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_listview, container, false);
        ListView listView = (ListView)rootView.findViewById(R.id.listview);
        listView.setAdapter(new MyAdapter());
        listView.setOnItemClickListener(this);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (callback != null) {
            callback.onItemSelected(position);
        }
    }


    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv = new TextView(context);
            tv.setTextSize(25);
            tv.setTextColor(Color.RED);
            tv.setText("postion:"+position + ", age:"+age);
            return tv;
        }
    }

}