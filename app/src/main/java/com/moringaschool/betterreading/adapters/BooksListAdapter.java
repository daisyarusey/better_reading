package com.moringaschool.betterreading.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.betterreading.R;
import com.moringaschool.betterreading.models.Work;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BooksListAdapter extends RecyclerView.Adapter<BooksListAdapter.BookViewHolder> {
    private List<Work> mWork;
    private Context mContext;

    public BooksListAdapter(Context context,List<Work> mWork){
        this.mContext = context;
        this.mWork = mWork;
    }

    @NonNull
    @Override
    public BooksListAdapter.BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.books_list_item,parent,false);
        BookViewHolder viewHolder = new BookViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.bindBooks(mWork.get(position));

    }

    @Override
    public int getItemCount() {
        return mWork.size();
    }

    public  class BookViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.bookImage) ImageView mbookImage;
        @BindView(R.id.bookTitle) TextView mTitle;
        @BindView(R.id.authorName) TextView mAuthor;
        @BindView(R.id.rating) TextView mRating;

        private Context mContext;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            mContext = itemView.getContext();
        }

        public void bindBooks(Work work){
            mTitle.setText(work.getBestBook().getTitle());
            mAuthor.setText("Author" + work.getBestBook().getAuthor().getName());
            mRating.setText("Ratings" + work.getAverageRating());

            if (!(work.getBestBook().getSmallImageUrl().isEmpty())){
                Picasso.with(mContext).load(work.getBestBook().getSmallImageUrl())
                        .fit()
                        .centerCrop()
                        .placeholder(R.drawable.book)
                        .into(mbookImage);
            }
        }
    }

}
