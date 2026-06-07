package com.cookandroid.share_platform;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.cookandroid.share_platform.databinding.ActivityAddPostBinding;

public class AddPostActivity extends AppCompatActivity {
    private ActivityAddPostBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddPostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rgCategoryMain.setOnCheckedChangeListener((group, checkedId) -> {
            binding.rgDetailCategory.removeAllViews();
            binding.rgDetailCategory.setVisibility(View.VISIBLE);
            binding.rgDetailCategory.setAlpha(0f);
            binding.rgDetailCategory.setTranslationY(50f);

            String[] items = (checkedId == R.id.rb_group_buy) ?
                    getResources().getStringArray(R.array.group_buy_categories) :
                    getResources().getStringArray(R.array.delivery_categories);

            for (int i = 0; i < items.length; i++) {
                if (i >= 3) break;
                RadioButton rb = new RadioButton(this);
                rb.setText(items[i]);
                RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(
                        0, RadioGroup.LayoutParams.WRAP_CONTENT, 1.0f);
                rb.setLayoutParams(params);
                binding.rgDetailCategory.addView(rb);
            }

            ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(binding.rgDetailCategory, "alpha", 0f, 1f);
            ObjectAnimator transAnim = ObjectAnimator.ofFloat(binding.rgDetailCategory, "translationY", 50f, 0f);
            alphaAnim.setDuration(800);
            transAnim.setDuration(800);
            alphaAnim.start();
            transAnim.start();
        });

        binding.tvBack.setOnClickListener(v -> finish());
    }
}