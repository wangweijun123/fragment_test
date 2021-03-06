package com.example.wangweijun.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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

public class DetailFragment extends Fragment implements NoContentFragment.OnRefreshListener{
    OnArticalListItemClickListener callback;

    @Override
    public void onRefresh() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.remove(noContentFragment);
        ft.commit();

        position++;
        handler.sendEmptyMessageDelayed(0, 3000);
    }

    public interface OnArticalListItemClickListener {
        void onItemSelected(int position);
    }
    Context context;
    int position;



    @Override
    public void onAttach(Activity activity) {
        Log.i("wang", this + " onAttach");
        super.onAttach(activity);
        this.context = activity;
        try {
            this.callback = (OnArticalListItemClickListener)activity;
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
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        handler.sendEmptyMessageDelayed(0, 3000);
        return rootView;
    }
    NoContentFragment noContentFragment;
    private Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                if (position % 2 == 0) {
                    HasContentFragment fragment = new HasContentFragment();
                    Bundle data = new Bundle();
                    data.putInt("position", position);
                    fragment.setArguments(data);
                    ft.add(R.id.fragment_container, fragment);
                } else {
                    noContentFragment = new NoContentFragment();
                    noContentFragment.callback = DetailFragment.this;
                    ft.add(R.id.fragment_container, noContentFragment);
                }
                ft.commit();
            }
        }
    };

    @Override
    public void onResume() {
        Log.i("wang", this + " onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i("wang", this + " onPause");
        handler.removeCallbacksAndMessages(null);
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
