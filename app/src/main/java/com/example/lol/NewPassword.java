package com.example.lol;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class NewPassword extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private Button buttonLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);

        // Инициализация полей ввода и кнопки
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        buttonLogIn = findViewById(R.id.buttonLogIn);

        // Добавление слушателей текста
        editText1.addTextChangedListener(textWatcher);
        editText2.addTextChangedListener(textWatcher);

        // Добавление слушателя нажатия на кнопку
        buttonLogIn.setOnClickListener(v -> {
            Intent intent = new Intent(NewPassword.this, LogIn.class);
            startActivity(intent);
        });
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            validate(); // Вызов метода проверки
        }

        @Override
        public void afterTextChanged(Editable s) {}
    };

    private void validate() {
        String editText1Input = editText1.getText().toString().trim();
        String editText2Input = editText2.getText().toString().trim();

        // Проверка, что оба поля не пусты
        if (!editText1Input.isEmpty() && !editText2Input.isEmpty()) {
            buttonLogIn.setEnabled(true); // Активация кнопки
        } else {
            buttonLogIn.setEnabled(false); // Деактивация кнопки
        }
    }
}

