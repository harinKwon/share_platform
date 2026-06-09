package com.cookandroid.share_platform;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.cookandroid.share_platform.databinding.ActivityAddPostBinding;

public class AddPostActivity extends AppCompatActivity {
    private ActivityAddPostBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddPostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 뒤로 가기 버튼 작동
        binding.tvBack.setOnClickListener(v -> finish());

    }
}