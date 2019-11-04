package com.moringaschool.betterreading.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.moringaschool.betterreading.R;
import com.moringaschool.betterreading.adapters.BooksListAdapter;

import com.moringaschool.betterreading.models.Work;
import com.moringaschool.betterreading.services.GoodReadsHttp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class BookSearchActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getCanonicalName();

    @BindView(R.id.recyclerview) RecyclerView mRecyclerview;

    private BooksListAdapter mAdapter;

    public List<Work> mBooks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_search);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String query = intent.getStringExtra("query");
        getBooks(query);
    }


    private void getBooks(String queryBook) {
        final GoodReadsHttp bookResponse = new GoodReadsHttp();
        bookResponse.findBooks(queryBook, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mBooks = bookResponse.searchResults(response);
                 BookSearchActivity.this.runOnUiThread(() -> {
                  mAdapter = new BooksListAdapter(getApplicationContext(),mBooks);
                  mRecyclerview.setAdapter(mAdapter);
                  RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(BookSearchActivity.this);
                  mRecyclerview.setLayoutManager(layoutManager);
                  mRecyclerview.setHasFixedSize(true);
                 });


            }


        });


    }


}
