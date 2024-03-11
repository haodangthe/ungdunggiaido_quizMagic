package com.example.ungdunggiaido_quizmagic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextUsernameRegister;
    private EditText editTextPasswordRegister;
    private EditText editTextEmailRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextUsernameRegister = findViewById(R.id.editTextUsernameRegister);
        editTextPasswordRegister = findViewById(R.id.editTextPasswordRegister);
        editTextEmailRegister =findViewById(R.id.editTextEmailRegister);

    }

    public void register(View view) {
        String username = editTextUsernameRegister.getText().toString().trim();
        String password = editTextPasswordRegister.getText().toString().trim();
        String email = editTextEmailRegister.getText().toString().trim();

        // Kiểm tra tên người dùng và mật khẩu ,email
        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập tên người dùng và mật khẩu", Toast.LENGTH_SHORT).show();
        } else {
            // Thực hiện logic đăng ký
            // Ví dụ: thêm thông tin đăng ký vào cơ sở dữ liệu, lưu trữ tài khoản mới, vv...

            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish(); // Đóng màn hình đăng ký sau khi chuyển về màn hình đăng nhập
        }
    }

    public void goToLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}