package com.cookandroid.share_platform;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.cookandroid.share_platform.databinding.ActivityPostListBinding;
import java.util.ArrayList;
import java.util.List;

public class PostListActivity extends AppCompatActivity {

    private ActivityPostListBinding binding;
    private PostAdapter adapter;
    private List<Post> postList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPostListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String title = getIntent().getStringExtra("title");
        if (title != null) {
            binding.tvTitle.setText(title);
        } else {
            binding.tvTitle.setText("게시판");
        }

        binding.tvBack.setOnClickListener(v -> finish());

        postList = new ArrayList<>();

        adapter = new PostAdapter(postList);
        binding.rvPosts.setLayoutManager(new LinearLayoutManager(this));
        binding.rvPosts.setAdapter(adapter);
        checkEmptyState();
    }
    private void checkEmptyState() {
        if (postList == null || postList.isEmpty()) {
            binding.rvPosts.setVisibility(View.GONE);
            binding.tvEmptyState.setVisibility(View.VISIBLE);
        } else {
            binding.tvEmptyState.setVisibility(View.GONE);
            binding.rvPosts.setVisibility(View.VISIBLE);
        }
    }
}