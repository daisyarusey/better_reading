package com.moringaschool.betterreading.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.moringaschool.betterreading.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.searchText) EditText mTitle;
    @BindView(R.id.search_btn) Button mSearchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mSearchBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String query = mTitle.getText().toString();
        Intent intent = new Intent(MainActivity.this,BookSearchActivity.class);
        intent.putExtra("query", query);
        startActivity(intent);

    }
}
