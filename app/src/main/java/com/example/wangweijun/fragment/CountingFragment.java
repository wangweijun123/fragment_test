package com.example.wangweijun.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by wangweijun1 on 2017/9/22.
 *
 * 替换布局文件的的view，一般是FramLayout布局
 */

public class CountingFragment extends Fragment {

    int mNum;
    /**
     * When creating, retrieve this instance's number from its arguments.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments() != null ? getArguments().getInt("num") : 1;
        Log.i("wang", this + ", onCreate mNum:"+mNum);
    }

    /**
     * The Fragment's UI is just a simple text view showing its
     * instance number.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("wang", this + ", onCreateView  mNum:"+mNum);
        View v = inflater.inflate(R.layout.hello_world, container, false);
        View tv = v.findViewById(R.id.text);
        ((TextView)tv).setText("Fragment #" + mNum);
        if (mNum % 2 == 0) {
            tv.setBackgroundColor(Color.RED);
        } else {
            tv.setBackgroundColor(Color.BLUE);
        }

        return v;
    }

    @Override
    public void onResume() {
        Log.i("wang", this + ", onResume  mNum:"+mNum);
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i("wang", this + ", onPause  mNum:"+mNum);
        super.onPause();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        Log.i("wang", this + ",setUserVisibleHint  mNum:"+mNum+", isVisibleToUser:"+isVisibleToUser);
        super.setUserVisibleHint(isVisibleToUser);
    }


    /**
     * Create a new instance of CountingFragment, providing "num"
     * as an argument.
     */
    static CountingFragment newInstance(int num) {
        CountingFragment f = new CountingFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        return f;
    }
}
