package com.hachau.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class EmployeeManagementActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_management);
    }

    public void open_employee_healthcare_activity(View view) {
        Intent intent=new Intent(EmployeeManagementActivity.this, EmployeeHealthCareActivity.class);
        startActivity(intent);
    }
}
