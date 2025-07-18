package com.hachau.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.hachau.models.Customer;

public class CustomerDetailActivity extends AppCompatActivity {
    EditText edt_customer_id;
    EditText edt_customer_name;
    EditText edt_customer_email;
    EditText edt_customer_phone;
    EditText edt_customer_username;
    EditText edt_customer_password;
    Button btn_new;
    Button btn_save;
    Button btn_remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_customer_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.lvOrdersViewer), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        addEvents();
    }

    private void addEvents() {
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process_save_customer();
            }
        });

        btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process_remove_customer();
            }
        });
    }

    private void process_remove_customer() {
        Intent intent=getIntent();
        String id=edt_customer_id.getText().toString();
        intent.putExtra("CUSTOMER_TO_REMOVE",id);
        setResult(600,intent);
        finish();
    }

    private void process_save_customer() {
//        lấy dữ liệu trên giao diện và mô hình hóa lại hướng đối tượng
        Customer c=new Customer();
        String id=edt_customer_id.getText().toString();
        if(id.trim().length()>0)
            c.setId(Integer.parseInt(id));
        c.setId(Integer.parseInt(edt_customer_id.getText().toString()));
        c.setName(edt_customer_name.getText().toString());
        c.setEmail(edt_customer_email.getText().toString());
        c.setPhone(edt_customer_phone.getText().toString());
        c.setUsername(edt_customer_username.getText().toString());
        c.setPassword(edt_customer_password.getText().toString());

//        lấy Intent từ màn hình gọi nó
        Intent intent=getIntent();
//        đóng gói dữ liệu vào intent
        intent.putExtra("NEW_CUSTOMER",c);
//        đóng dấu là sẽ gửi gói hàng này đi
        setResult(500,intent);
        finish();
    }

    private void addViews() {
        edt_customer_id=findViewById(R.id.edt_customer_id);
        edt_customer_name=findViewById(R.id.edt_customer_name);
        edt_customer_email=findViewById(R.id.edt_customer_email);
        edt_customer_phone=findViewById(R.id.edt_customer_phone);
        edt_customer_username=findViewById(R.id.edt_customer_username);
        edt_customer_password=findViewById(R.id.edt_customer_password);
        btn_new=findViewById(R.id.btn_new);
        btn_save=findViewById(R.id.btn_save);
        btn_remove=findViewById(R.id.btn_remove);
        display_infor();
    }

    private void display_infor() {
//        lấy intent từ CustomerManagementActivity gửi qua
        Intent intent=getIntent();
//        lấy dữ liệu Selected Customer từ intent
        Customer c= (Customer) intent.getSerializableExtra("SELECTED_CUSTOMER");
        if (c==null)
        {
            edt_customer_id.setVisibility(View.GONE);
            return;
        }
//        Hiển thị thông tin Customer lên giao diện
        edt_customer_id.setText(c.getId()+"");
        edt_customer_name.setText(c.getName());
        edt_customer_email.setText(c.getEmail());
        edt_customer_phone.setText(c.getPhone());
        edt_customer_username.setText(c.getUsername());
        edt_customer_password.setText(c.getPassword());
    }
}