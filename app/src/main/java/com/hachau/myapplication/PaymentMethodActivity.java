package com.hachau.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.hachau.adapters.PaymentMethodAdapter;
import com.hachau.connectors.SQLiteConnector;
import com.hachau.models.PaymentMethod;

import java.util.ArrayList;
import java.util.List;

public class PaymentMethodActivity extends AppCompatActivity {

    ListView lvPaymentMethod;
    PaymentMethodAdapter adapter;
    SQLiteConnector sqLiteConnector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_payment_method);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        loadPaymentMethods();
    }

    private void addViews() {
        lvPaymentMethod = findViewById(R.id.lvPaymentMethod);
        adapter = new PaymentMethodAdapter(this, R.layout.item_payment_method);
        lvPaymentMethod.setAdapter(adapter);
        sqLiteConnector = new SQLiteConnector(this);
    }

    private void loadPaymentMethods() {
        SQLiteDatabase db = sqLiteConnector.openDatabase();
        if (db == null) {
            Toast.makeText(this, "Cannot access database!", Toast.LENGTH_LONG).show();
            return;
        }

        List<PaymentMethod> paymentMethods = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM \"Payment Method\"", null); // Sử dụng đúng tên bảng "Payment Method"
        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex("id");
            int nameIndex = cursor.getColumnIndex("Name");
            int descriptionIndex = cursor.getColumnIndex("Description");

            if (idIndex == -1 || nameIndex == -1 || descriptionIndex == -1) {
                Toast.makeText(this, "Database columns (id, Name, or Description) not found! Check table structure.", Toast.LENGTH_LONG).show();
                cursor.close();
                sqLiteConnector.closeDatabase();
                return;
            }

            do {
                int id = cursor.getInt(idIndex);
                String name = cursor.getString(nameIndex);
                String description = cursor.getString(descriptionIndex);
                paymentMethods.add(new PaymentMethod(id, name, description));
            } while (cursor.moveToNext());
        } else {
            Toast.makeText(this, "No payment methods found in 'Payment Method' table!", Toast.LENGTH_LONG).show();
        }
        cursor.close();
        sqLiteConnector.closeDatabase();

        adapter.clear();
        adapter.addAll(paymentMethods);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sqLiteConnector.closeDatabase(); // Đóng cơ sở dữ liệu khi Activity bị hủy
    }
}

