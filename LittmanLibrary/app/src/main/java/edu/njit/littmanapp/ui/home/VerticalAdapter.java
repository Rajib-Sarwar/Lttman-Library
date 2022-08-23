package edu.njit.littmanapp.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import edu.njit.littmanapp.R;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.ViewHolder>  {
    private static final String TAG = "CollectionAdapter";

    private Context mContext;
    private Entry[] mDataSet;

    private OnItemClickListener itemClickListener;

    public void setListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView tvName;
        private final TextView tvDetail;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
            imageView = v.findViewById(R.id.image_view);
            tvName = (TextView) v.findViewById(R.id.tv_title);
            tvDetail = (TextView) v.findViewById(R.id.tv_detail);
        }

        public ImageView getImageView() {
            return imageView;
        }

        public TextView getTvName() {
            return tvName;
        }

        public TextView getTvDetail() {
            return tvDetail;
        }
    }

    public VerticalAdapter(Context context, Entry[] dataSet) {
        mContext = context;
        mDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.vertical_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        int resourceId = mContext.getResources().getIdentifier(mDataSet[position].image, "drawable", mContext.getPackageName());
        viewHolder.getImageView().setImageResource(resourceId);
        viewHolder.getTvName().setText(mDataSet[position].title);
        viewHolder.getTvDetail().setText(mDataSet[position].detail);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p = position;
                Entry entry = mDataSet[position];
                itemClickListener.onItemClick(entry);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}
