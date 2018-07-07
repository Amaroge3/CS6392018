package com.example.andimaroge.stateslistproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private String[] mDataset;

    private LayoutInflater inflater;



    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        public ViewHolder(View itemView){
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.listText);
        }

    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public Adapter(Context context, String[] myDataset) {

        inflater = LayoutInflater.from(context);
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
      View view = inflater.inflate(R.layout.text_view, parent, false);
      ViewHolder holder = new ViewHolder(view);
      return holder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        String data = mDataset[position];
        holder.textView.setText(data);
        holder.textView.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
               if (position == 4) {
                   String geoUri = String.format("geo:33.448380,-112.074040");
                   Uri geo = Uri.parse(geoUri);
                   Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                   view.getContext().startActivity(geoMap);
               }
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}