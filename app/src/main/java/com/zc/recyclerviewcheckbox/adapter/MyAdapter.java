package com.zc.recyclerviewcheckbox.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.zc.recyclerviewcheckbox.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zc on 2018/4/11.
 */

public class MyAdapter extends RecyclerView.Adapter {
    private List<Integer> mData;
    private Context context;

    private Map<Integer, Boolean> map = new HashMap<>();
    private boolean onBind;
    private int checkedPosition = -1;

    public MyAdapter(List<Integer> mData) {
        this.mData = mData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_rv, parent, false);
        return new ItemViewHolder(view);
    }

    //得到当前选中的位置
    public int getCheckedPosition() {
        return checkedPosition;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ItemViewHolder itemHolder = (ItemViewHolder) holder;
        itemHolder.cb.setText("checkbox" + "-" + position);
        itemHolder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    map.clear();
                    map.put(position, true);
                    checkedPosition = position;
                } else {
                    map.remove(position);
                    if (map.size() == 0) {
                        checkedPosition = -1; //-1 代表一个都未选择
                    }
                }
                if (!onBind) {
                    notifyDataSetChanged();
                }
            }
        });
        onBind = true;
        if (map != null && map.containsKey(position)) {
            itemHolder.cb.setChecked(true);
        } else {
            itemHolder.cb.setChecked(false);
        }
        onBind = false;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.cb)
        CheckBox cb;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
