package com.cookandroid.share_platform;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.cookandroid.share_platform.databinding.ActivityPostDetailBinding;

public class PostDetailActivity extends AppCompatActivity {

    private ActivityPostDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPostDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvBack.setOnClickListener(v -> finish());


        binding.btnOpenChat.setOnClickListener(v -> {
            Toast.makeText(this, "카카오톡 오픈채팅으로 연결합니다.", Toast.LENGTH_SHORT).show();
        });
    }
}