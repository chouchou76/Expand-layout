package com.hachau.myapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.hachau.connectors.CustomerConnector;
import com.hachau.connectors.SQLiteConnector;
import com.hachau.models.Customer;
import com.hachau.models.ListCustomer;

public class CustomerManagementActivity extends AppCompatActivity {

    GridView lvCustomer;
    ArrayAdapter<Customer> adapter;
    CustomerConnector connector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_customer_management);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.lvOrdersViewer), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        addEvents();
    }

    private void addEvents() {
        lvCustomer.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Customer selected=adapter.getItem(i);
//                adapter.remove(selected);
                Customer c=adapter.getItem(i);
                displayCustomerDetailActivity(c);
                return false;
            }
        });

//        lvCustomer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Customer c=adapter.getItem(position);
//                displayCustomerDetailActivity(c);
//            }
//        });
    }

    private void displayCustomerDetailActivity(Customer c) {
        Intent intent=new Intent(CustomerManagementActivity.this,CustomerDetailActivity.class);
        intent.putExtra("SELECTED_CUSTOMER", c);
//        startActivity(intent);
        startActivityForResult(intent,400);
    }

    @SuppressLint("WrongViewCast")
    private void addViews() {
        lvCustomer=findViewById(R.id.lvCustomer);
        adapter=new ArrayAdapter<>(
                CustomerManagementActivity.this,
                android.R.layout.simple_list_item_1
        );
        connector=new CustomerConnector();
        ListCustomer lc=connector.getAllCustomers(new SQLiteConnector(this).openDatabase());
        adapter.addAll(lc.getCustomers());
        lvCustomer.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu_customer,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menu_new_customer){
            Toast.makeText(CustomerManagementActivity.this,
                    "Mở màn hình thêm mới khách hàng",
                    Toast.LENGTH_LONG).show();
            Intent intent=new Intent(CustomerManagementActivity.this,CustomerDetailActivity.class);
//            đóng gói và đặt mã request code là 300
            startActivityForResult(intent,300);
        }
        else if(item.getItemId()==R.id.menu_broadcast_advertising)
        {
            Toast.makeText(CustomerManagementActivity.this,
                    "Gửi quảng cáo hàng loạt đến khách hàng",
                    Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId()==R.id.menu_help)
        {
            Toast.makeText(CustomerManagementActivity.this,
                    "Mở website hướng dẫn sử dụng",
                    Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        trường hợp xử lý cho NEW CUSTOMER ta chỉ quan rân 300 và 500 do ta định nghĩa
        if (requestCode==300 && resultCode==500)
        {
            Customer c=(Customer) data.getSerializableExtra("NEW_CUSTOMER");
            process_save_customer(c);
        }
        else if (requestCode==400 && resultCode==500) {
//            cập nhật dữ liệu cho customer
            Customer c=(Customer) data.getSerializableExtra("NEW_CUSTOMER");
            process_save_update_customer(c);
        }
        else if(requestCode==400 && resultCode==600)
        {
            String id=data.getStringExtra("CUSTOMER_TO_REMOVE");
            process_remove_customer(id);
        }
    }

    private void process_remove_customer(String id) {
        SQLiteConnector con=new SQLiteConnector(this);
        SQLiteDatabase database=con.openDatabase();
        CustomerConnector cc=new CustomerConnector();
        long flag=cc.removeCustomer(id,database);
        if (flag>0)
        {
            adapter.clear();
            adapter.addAll(cc.getAllCustomers(database).getCustomers());
        }
    }

    private void process_save_update_customer(Customer c) {
        SQLiteConnector con=new SQLiteConnector(this);
        SQLiteDatabase database=con.openDatabase();
        CustomerConnector cc=new CustomerConnector();
        long flag=cc.saveUpdateCustomer(c, database);
        if (flag>0)
        {
            adapter.clear();
            adapter.addAll(cc.getAllCustomers(database).getCustomers());
        }
    }


    private void process_save_customer(Customer c) {
        SQLiteConnector con=new SQLiteConnector(this);
        SQLiteDatabase database=con.openDatabase();
        CustomerConnector cc=new CustomerConnector();
        long flag=cc.saveNewCustomer(c,database);
        if (flag>0)
        {
            adapter.clear();
            adapter.addAll(cc.getAllCustomers(database).getCustomers());
        }
        }
    }
