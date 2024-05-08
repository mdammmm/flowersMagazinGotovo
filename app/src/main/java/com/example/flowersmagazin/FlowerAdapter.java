package com.example.flowersmagazin;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.FlowerView>{
    private static final String PHOTO_URL = "https://services.hanselandpetal.com/photos/";

    private List<Flower> mFlovers;
    private Context mContext;

    public FlowerAdapter(Context context, List<Flower> flowersNames){
        //super(context, R.layout.item_flowers ,flowersNames);
        this.mContext = context;
        this.mFlovers = flowersNames;
    }
    @NonNull
    @Override
    public FlowerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flower,parent,false);
        FlowerView myViewClass=new FlowerView(view);
        return myViewClass;

    }

    public void onBindViewHolder(@NonNull FlowerView holder, int position) {
        Uri uri = Uri.parse(PHOTO_URL + mFlovers.get(position).getPhoto());
        holder.name.setText(mFlovers.get(position).getName());
        Glide.with(mContext).load(PHOTO_URL + mFlovers.get(position).getPhoto()).into(holder.photo);
    }
    @Override
    public int getItemCount() {
        return mFlovers.size();
    }





    public class FlowerView extends RecyclerView.ViewHolder{
        TextView name;
        ImageView photo;
        public FlowerView(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.itemTitle);
            photo = itemView.findViewById(R.id.imageView);

        }

    }
}

