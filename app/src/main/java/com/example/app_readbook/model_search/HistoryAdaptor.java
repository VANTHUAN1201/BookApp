package com.example.app_readbook.model_search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_readbook.R;

import java.util.List;

public class HistoryAdaptor extends RecyclerView.Adapter<HistoryAdaptor.HistoryViewHolder>{
   private List<history> mList;
   private IClickHistory iClickHistory;
    public HistoryAdaptor(List<history> mList, IClickHistory iClickHistory) {
        this.mList = mList;
        this.iClickHistory = iClickHistory;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_history , parent , false);
        return new HistoryViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        history history = mList.get(position);
        if(history == null)
        {
            return;
        }
        holder.img_time.setImageResource(history.getImg_time());
        holder.txt_nameBook.setText(history.getBook());
        holder.img_clear.setText(history.getImg_clear());
        holder.img_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iClickHistory.clickItem(history);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(mList != null)
        {
            return mList.size();
        }
        return 0;
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder {
        private final ImageView img_time;
        private final TextView img_clear;
        private final TextView txt_nameBook;
        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            img_time  = itemView.findViewById(R.id.image_time);
            img_clear = itemView.findViewById(R.id.img_clear);
            txt_nameBook = itemView.findViewById(R.id.tv_namebook);
        }
    }
}
