package com.testfunction.coordinatorlayoutbehavior.adapters;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.testfunction.coordinatorlayoutbehavior.R;

/**
 * Created by lodlock (iamhunted@gmail.com)
 * On 12/14/2015 1:21 PM
 * For the CoordinatorLayout Behavior (com.testfunction.coordinatorlayoutbehavior.adapters) project
 */
public class StringListAdapter extends RecyclerView.Adapter<StringListAdapter.Holder> implements View.OnClickListener {

    private final LayoutInflater       mInflater;
    private final String[]             mItems;
    private final View                 mContainer;
    private final View.OnClickListener mToggleListener;

    public StringListAdapter(Context context, View container, View.OnClickListener listener) {
        mInflater = LayoutInflater.from(context);
        mItems = context.getResources().getStringArray(R.array.items);
        mContainer = container;
        mToggleListener = listener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View                      itemView = mInflater.inflate(R.layout.list_item, parent, false);
        itemView.setOnClickListener(this);
        return new Holder(itemView);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.text.setText(mItems[position]);
    }

    @Override
    public int getItemCount() {
        return mItems.length;
    }

    @Override
    public void onClick(View v) {
        Snackbar.make(mContainer, ((TextView) v.findViewById(R.id.text1)).getText(), Snackbar.LENGTH_LONG).show();
    }

    public static class Holder extends RecyclerView.ViewHolder {
        public final TextView text;

        public Holder(View itemView) {
            super(itemView);
            this.text = (TextView) itemView.findViewById(R.id.text1);
            itemView.setClickable(true);
        }
    }
}