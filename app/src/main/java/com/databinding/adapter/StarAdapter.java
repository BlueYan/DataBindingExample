package com.databinding.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.databinding.activity.BR;
import com.databinding.activity.R;
import com.databinding.activity.databinding.ItemStarBinding;
import com.databinding.model.Star;
import com.google.common.hash.HashingOutputStream;

import java.io.PipedOutputStream;
import java.util.List;

/**
 * Author Yan.
 * Date 16/6/4.
 */
public class StarAdapter extends RecyclerView.Adapter<StarAdapter.StarViewHolder> {

    private Context mContext;

    private List<Star> mStars;

    private LayoutInflater mInflater;

    public StarAdapter(Context mContext, List<Star> mStars) {
        this.mContext = mContext;
        this.mStars = mStars;
        this.mInflater = LayoutInflater.from(mContext);
    }


    @Override
    public StarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        StarViewHolder mHolder = new StarViewHolder(mInflater.inflate(R.layout.item_star, parent, false));
        return mHolder;
    }

    @Override
    public void onBindViewHolder(StarViewHolder holder, int position) {
        Star mStar = mStars.get(position);
        holder.getStarBinding().setVariable(BR.mStar, mStar);
        holder.getStarBinding().executePendingBindings();
        holder.getStarBinding().idMImg.setImageURI(Uri.parse(mStar.getPicUrl()));
    }

    @Override
    public int getItemCount() {
        return mStars.size();
    }

    public static class StarViewHolder extends RecyclerView.ViewHolder {

        private ItemStarBinding mStarBinding;

        public StarViewHolder(View itemView) {
            super(itemView);
            mStarBinding = DataBindingUtil.bind(itemView);
        }

        public ItemStarBinding getStarBinding() {
            return mStarBinding;
        }
    }

}
