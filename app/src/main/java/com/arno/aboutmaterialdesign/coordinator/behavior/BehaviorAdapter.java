package com.arno.aboutmaterialdesign.coordinator.behavior;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arno.aboutmaterialdesign.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arno on 2017/10/23.
 */

public class BehaviorAdapter extends Adapter<BehaviorAdapter.ViewHolder>{

    private Context mContext;
    private List<String> mData;

    public BehaviorAdapter(Context context){
        this.mContext = context;
        mData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mData.add(String.format("这是第%d条数据。",i));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_rv_behavior, parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txt_item.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData == null? 0:mData.size();
//        return 50;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView txt_item;

        public ViewHolder(View itemView) {
            super(itemView);
            txt_item = ((TextView) itemView.findViewById(R.id.item_rv_behavior_text));
        }
    }

}
