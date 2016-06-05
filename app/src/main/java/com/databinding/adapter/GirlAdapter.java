package com.databinding.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.databinding.activity.BR;
import com.databinding.activity.R;
import com.databinding.activity.databinding.ItemGirlBinding;
import com.databinding.model.Girl;

import java.util.List;

/**
 * Author Yan.
 * Date 16/6/3.
 */
public class GirlAdapter extends RecyclerView.Adapter<GirlAdapter.GirlViewHolder>{

    private Context mContext;

    private List<Girl> mGirls;

    private LayoutInflater mInflater;

    private OnItemClickListener mItemClickListener;

    private OnItemLongClickListener mItemLongClickListener;

    public GirlAdapter(Context mContext, List<Girl> mGirls) {
        this.mContext = mContext;
        this.mGirls = mGirls;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public GirlViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final GirlViewHolder mHolder = new GirlViewHolder(mInflater.inflate(R.layout.item_girl, parent, false));
        if ( mItemClickListener != null ) {
            mHolder.getItemBinding().getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClickListener.onItemClick(v, mHolder.getLayoutPosition());
                }
            });
        }

        if ( mItemLongClickListener != null ) {
            mHolder.getItemBinding().getRoot().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mItemLongClickListener.onItemLongClick(v, mHolder.getLayoutPosition());
                    return true;
                }
            });
        }

        return mHolder;
    }

    @Override
    public void onBindViewHolder(GirlViewHolder holder, int position) {
        Girl mGirl = mGirls.get(position);
        holder.getItemBinding().setVariable(BR.mGirl, mGirl);  //设置绑定的数据源
        holder.getItemBinding().executePendingBindings();
        holder.getItemBinding().idMImg.setImageURI(Uri.parse(mGirl.getPicUrl()));
    }

    @Override
    public int getItemCount() {
        return mGirls.size();
    }

    public static class GirlViewHolder extends RecyclerView.ViewHolder {

        private ItemGirlBinding mItemBinding;

        public GirlViewHolder(View itemView) {
            super(itemView);
            mItemBinding = DataBindingUtil.bind(itemView);
        }

        public ItemGirlBinding getItemBinding() {
            return mItemBinding;
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mItemClickListener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        mItemLongClickListener = listener;
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public interface OnItemLongClickListener {
        public void onItemLongClick(View view, int position);
    }
}
