package com.sample.swipelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.sample.swipelistview.view.OnSlideListener;
import com.sample.swipelistview.view.SwipeListView;
import com.sample.swipelistview.view.SwipeView;

import java.util.List;

/**
 * Created by honjane on 2015/12/25.
 */
public class SwipeAdapter extends BaseAdapter {
    private final LayoutInflater mInflater;
    private List<ItemModel> mItemModels;
    private Context mContext;
    private SwipeView mOldSwipeView;

    public SwipeAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    public void setListData(List<ItemModel> lists) {
        mItemModels = lists;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mItemModels.size();
    }

    @Override
    public ItemModel getItem(int position) {
        return mItemModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        SwipeView swipeView = (SwipeView) convertView;
        if (swipeView == null) {
            View view = mInflater.inflate(R.layout.layout_item, null);
            swipeView = new SwipeView(mContext);
            swipeView.setContentItemView(view);
            holder = new ViewHolder(swipeView);
            swipeView.setOnSlideListener(new OnSlideListener() {

                @Override
                public void onSlide(View view, int status) {

                    if (mOldSwipeView != null && mOldSwipeView != view) {
                        mOldSwipeView.shrink();
                    }

                    if (status == SLIDE_STATUS_ON) {
                        mOldSwipeView = (SwipeView) view;
                    }
                }
            });
            swipeView.setTag(holder);
        } else {
            holder = (ViewHolder) swipeView.getTag();
        }
        if (SwipeListView.mSwipeView != null) {
            SwipeListView.mSwipeView.shrink();
        }
        ItemModel itemModel = getItem(position);
        if (itemModel == null) {
            return swipeView;
        }

        holder.icon.setImageResource(itemModel.imgRes);
        holder.title.setText(itemModel.title);
        holder.desc.setText(itemModel.desc);
        holder.leftView.setText("删除");
        holder.rightView.setText("修改");
        holder.leftView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemModels == null) {
                    return;
                }
                mItemModels.remove(position);
                notifyDataSetChanged();
                Toast.makeText(mContext, "点击了删除", Toast.LENGTH_SHORT).show();
            }
        });
        holder.rightView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "点击了修改", Toast.LENGTH_SHORT).show();
            }
        });
        return swipeView;
    }

    static class ViewHolder {
        private ImageView icon;
        private TextView title;
        private TextView desc;
        private TextView leftView;
        private TextView rightView;

        ViewHolder(View view) {
            icon = (ImageView) view.findViewById(R.id.iv_icon);
            title = (TextView) view.findViewById(R.id.tv_title);
            desc = (TextView) view.findViewById(R.id.tv_desc);
            leftView = (TextView) view.findViewById(R.id.tv_left);
            rightView = (TextView) view.findViewById(R.id.tv_right);
        }
    }
}
