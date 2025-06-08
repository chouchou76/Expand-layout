package com.hachau.connectors;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SQLiteConnector {
    private static final String DATABASE_NAME = "Sales_Database.db";
    private static final String DB_PATH_SUFFIX = "/databases/";
    private SQLiteDatabase database = null;
    private final Activity context;

    public SQLiteConnector(Activity context) {
        this.context = context;
    }

    public SQLiteDatabase openDatabase() {
        File dbFile = context.getDatabasePath(DATABASE_NAME);

        if (!dbFile.exists()) {
            copyDatabaseFromAssets();
        }

        database = SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.OPEN_READWRITE);
        return database;
    }

    private void copyDatabaseFromAssets() {
        try {
            InputStream inputStream = context.getAssets().open(DATABASE_NAME);
            String outFileName = getDatabasePath();

            File dbFolder = new File(context.getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if (!dbFolder.exists()) {
                dbFolder.mkdir();
            }

            OutputStream outputStream = new FileOutputStream(outFileName);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }

            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getDatabasePath() {
        return context.getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME;
    }

    public SQLiteDatabase getDatabase() {
        return database;
    }

    public void closeDatabase() {
        if (database != null && database.isOpen()) {
            database.close();
        }
    }
}
