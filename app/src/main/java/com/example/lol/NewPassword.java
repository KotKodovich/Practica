package com.example.lol;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class NewPassword extends AppCompatActivity {

    // Объявление переменных для EditText и Button
    EditText passwordEditText;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);

        // Получение ссылок на EditText и Button из XML-макета
        passwordEditText = findViewById(R.id.editText1);
        submitButton = findViewById(R.id.editText2);

        // Изначально отключаем кнопку отправки
        submitButton.setEnabled(false);

        // Добавляем слушатель изменений текста к полю ввода пароля
        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                // Включаем кнопку отправки, если поле пароля не пустое
                submitButton.setEnabled(!s.toString().trim().isEmpty());
            }
        });
    }
}
