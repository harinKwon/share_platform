package com.cookandroid.share_platform;

import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.cookandroid.share_platform.databinding.ActivityMyPostsBinding;

public class MyPostsActivity extends AppCompatActivity {
    private ActivityMyPostsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyPostsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String userId = getIntent().getStringExtra("userId");

        binding.back.setOnClickListener(v -> finish());

        TextView emptyView = new TextView(this);
        emptyView.setText("아직 업로드한 글이 없습니다.");
        emptyView.setGravity(Gravity.CENTER);
        emptyView.setTextSize(18);

        emptyView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        ViewGroup parent = (ViewGroup) binding.getRoot();
        parent.addView(emptyView);
        binding.listViewPosts.setEmptyView(emptyView);
    }
}