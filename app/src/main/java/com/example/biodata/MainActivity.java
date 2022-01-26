package com.example.biodata;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtName;
    private EditText edtTtl;
    private EditText edtKlass;
    private EditText edtAddress;
    private EditText edtHobby;
    private Button btnSave;
    private TextView tvResult;

    private static final String STATE_RESULT = "state_result";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtName = findViewById(R.id.edt_name);
        edtTtl = findViewById(R.id.edt_ttl);
        edtKlass = findViewById(R.id.edt_klass);
        edtAddress = findViewById(R.id.edt_address);
        edtHobby = findViewById(R.id.edt_hobby);
        btnSave = findViewById(R.id.btn_save);
        tvResult = findViewById(R.id.tv_result);


        btnSave.setOnClickListener(this);

        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(result);
        }


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_save) {
            String inputName = edtName.getText().toString().trim();
            String inputTTL = edtTtl.getText().toString().trim();
            String inputKlass = edtKlass.getText().toString().trim();
            String inputAddress = edtAddress.getText().toString().trim();
            String inputHobby = edtHobby.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputName)) {
                isEmptyFields = true;
                edtName.setError("Field ini tidak boleh kosong!");
            }
            if (TextUtils.isEmpty(inputTTL)) {
                isEmptyFields = true;
                edtTtl.setError("Field ini tidak boleh kosong!");
            }
            if (TextUtils.isEmpty(inputKlass)) {
                isEmptyFields = true;
                edtKlass.setError("Field ini tidak boleh kosong!");
            }
            if (TextUtils.isEmpty(inputAddress)) {
                isEmptyFields = true;
                edtAddress.setError("Field ini tidak boleh kosong!");
            }
            if (TextUtils.isEmpty(inputHobby)) {
                isEmptyFields = true;
                edtHobby.setError("Field ini tidak boleh kosong!");
            }

            if (!isEmptyFields && !isInvalidDouble) {
                String name = inputName;
                String ttl = inputTTL;
                String klass = inputKlass;
                String address = inputAddress;
                String hobby = inputHobby;


                tvResult.setText(String.valueOf("\n" + "Nama : " + name + "\n" + "TTL : " + ttl + "\n" + "Kelas : " + klass + "\n" + "Alamat : " + address + "\n" + "Hobi : " + hobby));

            }
        }
    }
}


