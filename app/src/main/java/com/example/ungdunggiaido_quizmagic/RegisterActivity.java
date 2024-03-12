package com.example.ungdunggiaido_quizmagic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextUsernameRegister;
    private EditText editTextPasswordRegister;
    private EditText editTextEmailRegister;
    private Button btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextUsernameRegister = findViewById(R.id.editTextUsernameRegister);
        editTextPasswordRegister = findViewById(R.id.editTextPasswordRegister);
        editTextEmailRegister = findViewById(R.id.editTextEmailRegister);
        btnRegister = findViewById(R.id.buttonRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsernameRegister.getText().toString().trim();
                String password = editTextPasswordRegister.getText().toString().trim();
                String email = editTextEmailRegister.getText().toString().trim();

                // Kiểm tra thông tin đăng ký hợp lệ
                if (!username.isEmpty() && !password.isEmpty() && !email.isEmpty()) {
                    // Kiểm tra thông tin đăng ký hợp lệ
                    if (isValidUsername(username) && isValidPassword(password) && isValidEmail(email)) {
                        // Kiểm tra xem tên người dùng hoặc email đã tồn tại trong cơ sở dữ liệu
                        if (isUserExists(username) || isEmailExists(email)) {
                            Toast.makeText(RegisterActivity.this, "Username or email already exists.", Toast.LENGTH_SHORT).show();
                        } else {
                            // Thêm người dùng mới vào cơ sở dữ liệu
                            boolean success = addUserToDatabase(username, password, email);
                            if (success) {
                                // Đăng ký thành công, chuyển người dùng đến màn hình đăng nhập hoặc màn hình chính
                                 Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                 startActivity(intent);
                                finish(); // Đóng màn hình đăng ký
                            } else {
                                Toast.makeText(RegisterActivity.this, "Registration failed. Please try again.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else {
                        Toast.makeText(RegisterActivity.this, "Invalid input. Please check your input and try again.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "All fields are required.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidUsername(String username) {
        // Kiểm tra xem tên người dùng không chứa ký tự đặc biệt và có độ dài từ 3 đến 20 ký tự
        return username.matches("[a-zA-Z0-9]{3,20}");
    }

    private boolean isValidPassword(String password) {
        // Kiểm tra mật khẩu có ít nhất 6 ký tự và chứa ít nhất một chữ cái thường và một chữ số
       return password.length() >= 6 ;
//              &&  password.matches("^(?=.*[a-z])(?=.*\\d)[a-zA-Z\\d]*$");
    }

    private boolean isValidEmail(String email) {
        // Kiểm tra địa chỉ email có hợp lệ không bằng cách sử dụng biểu thức chính quy
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isUserExists(String username) {
        // Kiểm tra xem tên người dùng đã tồn tại trong cơ sở dữ liệu
        // return databaseHelper.checkUserExists(username);
        return false; // Giả sử chưa có hàm kiểm tra trong cơ sở dữ liệu
    }

    private boolean isEmailExists(String email) {
        // Kiểm tra xem địa chỉ email đã tồn tại trong cơ sở dữ liệu
        // return databaseHelper.checkEmailExists(email);
        return false; // Giả sử chưa có hàm kiểm tra trong cơ sở dữ liệu
    }

    private boolean addUserToDatabase(String username, String password, String email) {
        // Thêm người dùng mới vào cơ sở dữ liệu
        // return databaseHelper.addUser(username, password, email);
        return true;
    }
}

