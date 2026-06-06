package com.cookandroid.share_platform;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.cookandroid.share_platform.databinding.ActivityAddPostBinding;

public class AddPostActivity extends AppCompatActivity {

    private ActivityAddPostBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddPostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvBack.setOnClickListener(v -> finish());

        //upload
        binding.btnUpload.setOnClickListener(v -> {
            String title = binding.etPostTitle.getText().toString();
            String content = binding.etPostContent.getText().toString();

            if (title.isEmpty() || content.isEmpty()) {
                Toast.makeText(this, "제목과 내용을 모두 입력해주세요.", Toast.LENGTH_SHORT).show();
                return;
            }

            Post newPost = new Post(title, content, "사용자1", "방금", 0, 0);

            Toast.makeText(this, "등록 완료(서버 연결 대기중)", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}