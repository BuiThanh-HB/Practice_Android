package com.BuiVanThanh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAdd ,btnSearch;
    EditText edUsername,edEmail, edPhone;
    RadioGroup rgGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edUsername = findViewById(R.id.edUsername);
        edEmail = findViewById(R.id.edEmail);
        edPhone = findViewById(R.id.edPhone);
        btnAdd = findViewById(R.id.btnAdd);
        rgGender = findViewById(R.id.rgGender);
        btnSearch = findViewById(R.id.btnSearch);
        btnAdd.setOnClickListener(this::onClick);
        btnSearch.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAdd:
                if (!validate()) {
                    return;
                }
                edPhone.setText("");
                break;
            case R.id.btnSearch:
                goSearch();
                break;
            default:
                break;
        }
    }
    private void goSearch(){
        Intent intent = new Intent(this,SearchActivity.class);
        startActivity(intent);
    }
    private void CheckValidate() {
        if (edUsername.getText().toString().isEmpty()) {
            Toast.makeText(this,"Please enter Customer Name", Toast.LENGTH_LONG).show();
            return;
        }

        if (edEmail.getText().toString().isEmpty()) {
            Toast.makeText(this,"Please enter Email Address", Toast.LENGTH_LONG).show();
            return;
        }

        if (edPhone.getText().toString().isEmpty()) {
            Toast.makeText(this,"Please enter Phone Number", Toast.LENGTH_LONG).show();
            return;
        }

        if (rgGender.getCheckedRadioButtonId() == -1){
            Toast.makeText(this,"Please select Gender", Toast.LENGTH_LONG).show();
            return;
        }
    }
    private boolean validate() {
        String mes = null;
        if (edUsername.getText().toString().trim().isEmpty()) {
            mes = "Ch??a nh???p username";
        }
        if (edEmail.getText().toString().isEmpty()) {
            mes = "Ch??a nh???p Email";
        }
        if (edPhone.getText().toString().trim().isEmpty()) {
            mes = "Ch??a nh???p s??? ??i???n tho???i";
        }
        if (rgGender.getCheckedRadioButtonId() == -1) {
            mes = "B???n ch??a ch???n gi???i t??nh";
        }
        if (mes != null) {
            Toast.makeText(this, mes, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


}