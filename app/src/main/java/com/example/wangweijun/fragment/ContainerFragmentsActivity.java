package com.example.wangweijun.fragment;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by wangweijun on 2017/9/26.
 */

public class ContainerFragmentsActivity extends Activity implements ListFragment.OnArticalListItemClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_container_fragments);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ListFragment listFragment = new ListFragment();
        Bundle data = new Bundle();
        data.putInt("age", 10);
        listFragment.setArguments(data);
        ft.add(R.id.container_fragment, listFragment);
        ft.commit();
    }

    @Override
    public void onItemSelected(int position) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        DetailFragment detailFragment = new DetailFragment();
        Bundle data = new Bundle();
        data.putInt("position", position);
        detailFragment.setArguments(data);
        ft.replace(R.id.container_fragment, detailFragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}
