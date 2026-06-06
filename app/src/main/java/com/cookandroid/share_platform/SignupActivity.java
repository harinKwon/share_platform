package com.cookandroid.share_platform;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.cookandroid.share_platform.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {

    private ActivitySignupBinding binding;

    private boolean isVerified = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSendVerification.setOnClickListener(v -> {
            String id = binding.etSignupId.getText().toString().trim();
            if (id.isEmpty()) {
                Toast.makeText(SignupActivity.this, "이메일 또는 전화번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(SignupActivity.this, "인증번호가 발송되었습니다!", Toast.LENGTH_SHORT).show();
        });

        binding.btnVerifyCode.setOnClickListener(v -> {
            isVerified = true;
            Toast.makeText(SignupActivity.this, "인증이 완료되었습니다.", Toast.LENGTH_SHORT).show();

            binding.etSignupId.setEnabled(false);
            binding.btnSendVerification.setEnabled(false);
            binding.etVerificationCode.setEnabled(false);
            binding.btnVerifyCode.setEnabled(false);
        });

        binding.btnSignupSubmit.setOnClickListener(v -> {
            String id = binding.etSignupId.getText().toString().trim();
            String pw = binding.etSignupPw.getText().toString().trim();

            if (id.isEmpty() || pw.isEmpty()) {
                Toast.makeText(SignupActivity.this, "정보를 모두 입력해주세요.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!isVerified) {
                Toast.makeText(SignupActivity.this, "이메일/전화번호 인증을 먼저 완료해주세요.", Toast.LENGTH_SHORT).show();
                return;
            }

            SharedPreferences sharedPreferences = getSharedPreferences("RootUsers", MODE_PRIVATE);

            if (sharedPreferences.contains(id)) {
                Toast.makeText(SignupActivity.this, "이미 가입된 이메일/전화번호입니다.", Toast.LENGTH_SHORT).show();
            } else {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(id, pw);
                editor.apply();

                Toast.makeText(SignupActivity.this, "가입 성공! 로그인해주세요.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        binding.tvBack.setOnClickListener( v-> finish());
    }
}