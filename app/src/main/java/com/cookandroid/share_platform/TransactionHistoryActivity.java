package com.cookandroid.share_platform;

import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TransactionHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);

        findViewById(R.id.tv_back).setOnClickListener(v -> finish());

        ListView listView = findViewById(R.id.listViewTransactions);

        TextView emptyView = new TextView(this);
        emptyView.setText("거래 내역이 없습니다.");
        emptyView.setGravity(Gravity.CENTER);
        emptyView.setTextSize(18);

        emptyView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        ViewGroup parent = (ViewGroup) listView.getParent();
        parent.addView(emptyView);
        listView.setEmptyView(emptyView);
    }
}