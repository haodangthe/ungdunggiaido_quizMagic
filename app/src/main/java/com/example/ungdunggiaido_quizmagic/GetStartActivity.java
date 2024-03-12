package com.example.ungdunggiaido_quizmagic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class GetStartActivity extends AppCompatActivity {
    private Button btnGetStart;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_start);
        btnGetStart =findViewById(R.id.buttonStart);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Ẩn tiêu đề mặc định của ActionBar
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        btnGetStart = findViewById(R.id.buttonStart);
        btnGetStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý sự kiện khi nút Bắt đầu được nhấn

                startActivity(new Intent(GetStartActivity.this, XepHangDoiThuongActivity.class));
                // Kết thúc activity hiện tại
                finish();
                Toast.makeText(GetStartActivity.this, "Chuyển đến màn hình tiếp theo", Toast.LENGTH_SHORT).show();

            }
        });
    }
}