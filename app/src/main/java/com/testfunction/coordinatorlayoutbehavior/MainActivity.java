package com.testfunction.coordinatorlayoutbehavior;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.testfunction.coordinatorlayoutbehavior.adapters.StringListAdapter;
import com.testfunction.coordinatorlayoutbehavior.behaviors.SnackBarBehavior;
import com.testfunction.coordinatorlayoutbehavior.itemdecorations.DividerItemDecoration;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CoordinatorLayout mContainer;
    private View mView;
    private RecyclerView mRecyclerView;
    private boolean mHasBehavior = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
    }

    private void setup() {
        mContainer = (CoordinatorLayout) findViewById(R.id.container);
        mView = (View) findViewById(R.id.view_misc);

        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mRecyclerView.setAdapter(new StringListAdapter(this, mContainer, this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void addSnackBarBehavior(View view) {
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
        params.setBehavior(new SnackBarBehavior());
    }

    private void removeSnackBarBehavior(View view) {
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
        params.setBehavior(null);
    }

    @Override
    public void onClick(View v) {
        if (mHasBehavior) {
            removeSnackBarBehavior(mView);
        } else {
            addSnackBarBehavior(mView);
        }
        mHasBehavior = !mHasBehavior;
    }
}
