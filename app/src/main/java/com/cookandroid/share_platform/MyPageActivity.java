package com.cookandroid.share_platform;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.cookandroid.share_platform.databinding.ActivityMyPageBinding;

public class MyPageActivity extends AppCompatActivity {

    private ActivityMyPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String userId = getIntent().getStringExtra("userId");

        if (userId != null) {
            binding.tvMyId.setText(userId);
        }

        binding.btnLogout.setOnClickListener(v -> {
            Toast.makeText(MyPageActivity.this, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MyPageActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });

        binding.tvBack.setOnClickListener(v -> finish());
    }
}