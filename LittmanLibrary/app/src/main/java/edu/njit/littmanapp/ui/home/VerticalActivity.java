package edu.njit.littmanapp.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import edu.njit.littmanapp.R;
import edu.njit.littmanapp.ui.DetailsActivity;

public class VerticalActivity extends Activity implements OnItemClickListener {
    private static final String TAG = "VerticalActivity";

    protected RecyclerView mRecyclerView;
    protected VerticalAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        Entry[] data = (Entry[]) getIntent().getSerializableExtra("intentList");
        mAdapter = new VerticalAdapter(this, data);
        mAdapter.setListener(this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    private static Entry[] publications = new Entry[]{
            new Entry("one", "Text #1"),
            new Entry("two", "Text #2"),
            new Entry("three", "Text #3"),
            new Entry("four", "Text #4")};

    @Override
    public void onItemClick(Entry entry) {
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    }
}

