package com.cookandroid.share_platform;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import com.cookandroid.share_platform.databinding.ActivityMainBinding;
import android.view.View;
import android.widget.LinearLayout;

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
        LinearLayout layoutGroupBuy = findViewById(R.id.layout_group_buy);
        layoutGroupBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GroupBuyActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout layoutDelivery = findViewById(R.id.layout_delivery);
        layoutDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DeliveryActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout layoutCommunity = findViewById(R.id.layout_community);
        layoutCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CommunityListActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout layoutReview = findViewById(R.id.layout_review);
        layoutReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReviewListActivity.class);
                startActivity(intent);
            }
        });
    }
}