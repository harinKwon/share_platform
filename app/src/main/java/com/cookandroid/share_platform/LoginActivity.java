package com.cookandroid.share_platform;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.cookandroid.share_platform.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(v -> {
            String id = binding.etLoginId.getText().toString().trim();
            String pw = binding.etLoginPw.getText().toString().trim();

            SharedPreferences sharedPreferences = getSharedPreferences("RootUsers", MODE_PRIVATE);
            String savedPw = sharedPreferences.getString(id, "");

            if (savedPw.isEmpty()) {
                Toast.makeText(LoginActivity.this, "존재하지 않는 계정입니다.", Toast.LENGTH_SHORT).show();
            } else if (!savedPw.equals(pw)) {
                Toast.makeText(LoginActivity.this, "비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(LoginActivity.this, "환영합니다!", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("userId", id); // 로그인한 아이디를 담아서 메인으로 보냄
                startActivity(intent);
                finish();
            }
        });
        binding.tvGoSignup.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent);
        });
    }
}