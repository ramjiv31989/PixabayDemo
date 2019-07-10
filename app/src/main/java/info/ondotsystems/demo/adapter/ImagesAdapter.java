package info.ondotsystems.demo.adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import info.ondotsystems.demo.DataModel.Hits;
import info.ondotsystems.demo.R;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.NewsViewHolder> {
    private Context context;
    private List<Hits> articles;

    public ImagesAdapter(Context context, List<Hits> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public ImagesAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.images_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImagesAdapter.NewsViewHolder holder, final int position) {
        String image = articles.get(position).getLargeImageURL();
        Log.e("imagestest",image);
        if (image != null) {
            Glide.with(context) //passing context
                    .load(image) //passing your url to load image.
                    .dontAnimate()
                    .placeholder(context.getDrawable(R.drawable.image_not_available)) //this would be your default image (like default profile or logo etc). it would be loaded at initial time and it will replace with your loaded image once glide successfully load image using url.
                    //.centerCrop()//this method help to fit image into center of your ImageView
                    .into(holder.ivNews); //pass imageView reference to appear the image.*/
        }
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {

        ImageView ivNews;
        private NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            ivNews = itemView.findViewById(R.id.ivNews);

        }
    }
}

