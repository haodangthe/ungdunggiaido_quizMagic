package com.example.ungdunggiaido_quizmagic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextUsernameLogin;
    private EditText editTextPasswordLogin;
    private TextView textViewRegisterLogin;
    private TextView textViewForgorpasswordLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsernameLogin = findViewById(R.id.editTextUsernameLogin);
        editTextPasswordLogin = findViewById(R.id.editTextPasswordLogin);
        textViewRegisterLogin = findViewById(R.id.textViewRegister);


    }

    public void login(View view) {
        String username = editTextUsernameLogin.getText().toString().trim();
        String password = editTextPasswordLogin.getText().toString().trim();

        // Kiểm tra tên người dùng và mật khẩu
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập tên người dùng và mật khẩu", Toast.LENGTH_SHORT).show();
        } else {
            // Thực hiện logic kiểm tra đăng nhập
            // Ví dụ: kiểm tra từ cơ sở dữ liệu, xác minh thông tin, vv...
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish(); // Đóng màn hình đăng nhập sau khi chuyển sang màn hình chính
        }
    }

    public void goToRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
