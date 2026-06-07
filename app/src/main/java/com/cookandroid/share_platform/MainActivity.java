package com.cookandroid.share_platform;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import com.cookandroid.share_platform.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //menu
        binding.btnMenu.setOnClickListener(v -> binding.drawerLayout.openDrawer(GravityCompat.END));

        //mypage
        binding.menuMypage.setOnClickListener(v -> {
            Intent intent = new Intent(this, MyPageActivity.class);
            intent.putExtra("userId", getIntent().getStringExtra("userId"));
            startActivity(intent);
            binding.drawerLayout.closeDrawers();
        });

        //myposts
        binding.menuMyPosts.setOnClickListener(v -> {
            Intent intent = new Intent(this, MyPostsActivity.class);
            intent.putExtra("userId", getIntent().getStringExtra("userId"));
            startActivity(intent);
            binding.drawerLayout.closeDrawers();
        });

        //tradehistory
        binding.menuTradeHistory.setOnClickListener(v -> {
            Intent intent = new Intent(this, TransactionHistoryActivity.class);
            startActivity(intent);
            binding.drawerLayout.closeDrawers();
        });

        //addpost
        binding.fabAddPost.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddPostActivity.class);
            intent.putExtra("userId", getIntent().getStringExtra("userId"));
            startActivity(intent);
        });

        //groupbuy
        binding.layoutGroupBuy.setOnClickListener(v -> {
            Intent intent = new Intent(this, PostListActivity.class);
            intent.putExtra("title", "공동 구매");
            startActivity(intent);
        });

        //delivery
        binding.layoutDelivery.setOnClickListener(v -> {
            Intent intent = new Intent(this, PostListActivity.class);
            intent.putExtra("title", "배달비 1/n");
            startActivity(intent);
        });

        //community
        binding.layoutCommunity.setOnClickListener(v -> {
            Intent intent = new Intent(this, PostListActivity.class);
            intent.putExtra("title", "자유 커뮤니티");
            startActivity(intent);
        });
    }
}