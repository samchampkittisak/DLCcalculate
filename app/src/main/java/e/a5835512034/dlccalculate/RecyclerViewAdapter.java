package e.a5835512034.dlccalculate;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by 5835512034 on 4/17/2018.
 */

public class RecyclerViewAdapter
        extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    LayoutInflater mLayoutInflater;
    List<Actor> mData = Collections.emptyList();
    String[] list;
    ItemClickListener mItemClickListener;

    public RecyclerViewAdapter(Context context, List<Actor> data) {
        mLayoutInflater = LayoutInflater.from(context);
        this.mData =data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.type, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Actor setv = mData.get(position);
        holder.tvName.setText(setv.getName());
        holder.image.setBackgroundResource(setv.getResId());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public Actor getItem(int position) {
        return mData.get(position);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        protected TextView tvName;
        protected ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            image = (ImageView) itemView.findViewById(R.id.image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null)
                mItemClickListener.onItemClick(v, getAdapterPosition());
        }
    }

}
