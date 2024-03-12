package com.example.ungdunggiaido_quizmagic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextUsernameLogin;
    private EditText editTextPasswordLogin;
    private TextView textViewRegisterLogin;
    private TextView textViewForgorpasswordLogin;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsernameLogin = findViewById(R.id.editTextUsernameLogin);
        editTextPasswordLogin = findViewById(R.id.editTextPasswordLogin);
        textViewRegisterLogin = findViewById(R.id.textViewRegister);
        btnLogin =findViewById(R.id.buttonLogin);

        textViewRegisterLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open registration activity here
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform login functionality here
                String username = editTextUsernameLogin.getText().toString().trim();
                String password = editTextPasswordLogin.getText().toString().trim();

                // Xác thực tên người dùng và mật khẩu (ví dụ: đối với cơ sở dữ liệu)

                if (isValidCredentials(username, password)) {
                    // Nếu thông tin xác thực hợp lệ, hãy tiến hành đăng nhập

                    Intent intent = new Intent(LoginActivity.this, XepHangDoiThuongActivity.class);
                    startActivity(intent);
                    finish(); // Đóng hoạt động đăng nhập để tránh quay lại
                } else {
                    // Nếu thông tin đăng nhập không hợp lệ, hiển thị thông báo lỗi
                    Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean isValidCredentials(String username, String password) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            return username.matches("[a-zA-Z0-9]{3,20}");
        }

        // Kiểm tra xem mật khẩu có ít nhất 6 ký tự không
        if (password.length() < 6) {
            return false;
        }

        // Nếu tất cả các điều kiện được đáp ứng, trả về true
        return true;
}
}







