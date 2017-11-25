package com.example.data_struct;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;

public class DataBase {
    private static final String taskTable = "TaskTable";
    private static final String photoTable = "PhotoTable";

    class TaskRows {
        public static final String ID = "id";
        public static final String operator = "operatorCol";
        public static final String name = "nameCol";
        public static final String description = "descriptionCol";
        public static final String createTime = "createTimeCol";
        public static final String receiveDate = "receiveDateCol";
        public static final String startDate = "startDateCol";
        public static final String prepareStartTime = "prepareStartDateCol";
        public static final String prepareEndTime = "prepareEndTimeCol";
        public static final String endManeuresTime = "endManeuresTimeCol";
        public static final String readyWatchTime = "readyWatchTimeCol";
        public static final String endWatchTime = "endWatchTimeCol";
        public static final String acceptTime = "acceptTimeCol";
        public static final String endConnectionTime = "endConnectionTimeCol";
        public static final String readyFillTime = "readyFillTimeCol";
        public static final String startFillTime = "startFillDateCol";
        public static final String endDisconnectionTime = "endDisconnectedTimeCol";
        public static final String endProbeTime = "endProbeTImeCol";
        public static final String readyWatchTime2 = "readyWatchTime2Col";
        public static final String acceptTime2 = "acceptTime2Col";
        public static final String prepareEndTime2 = "prepareEndTime2Col";
        public static final String endManeuresTime2 = "endManeuresTime2Col";
        public static final String finishTime = "finishTimeCol";
        public static final String isDeleted = "isDeletedCol";
    }

    class PhotoRows{
        public static final String ID = "id";
        public static final String url = "urlCol";
        public static final String taskId = "taskCol";
        public static final String field = "fieldCol";
    }

    private static DataBase instance;
    final String LOG_TAG = "dbLog";
    private DBHelper dbHelper;

    private DataBase(Context context) {
        dbHelper = new DBHelper(context);
    }

    static public DataBase getInstance(Context context) {
        if (instance == null) {
            instance = new DataBase(context);
        }
        return instance;
    }

    public void addTask(Task task) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(sourceWord, word.getSrcWord());
        contentValues.put(translatedWord, word.getDstWord());
        contentValues.put(sourceLang, word.getSrcLang());
        contentValues.put(destLang, word.getDstLang());
        db.insert(tableName, null, contentValues);
    }

    public ArrayList<Word> getWords() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String[] select = {sourceWord};
        Cursor cursor = db.query(tableName, null, null, null, null, null, null);
        ArrayList<Word> ret = new ArrayList<>();
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                ret.add(new Word(cursor.getString(cursor.getColumnIndex(sourceWord)),
                        cursor.getString(cursor.getColumnIndex(translatedWord)),
                        cursor.getInt(cursor.getColumnIndex(sourceLang)), cursor.getInt(cursor.getColumnIndex(destLang))));
                cursor.moveToNext();
            }
        }
        cursor.close();
        return ret;
    }

    public Boolean isIn(Word word) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String[] columns = {sourceWord, translatedWord, sourceLang, destLang};
        String selection = sourceWord + " = ? and " + translatedWord + " = ? and " + sourceLang +
                " = ? and " + destLang + " = ?";
        String[] args = {word.getSrcWord(), word.getDstWord() == null ? "NULL" : word.getDstWord(),
                word.getSrcLang().toString(),
                word.getDstLang().toString()};
        Cursor cursor = db.query(tableName, columns, selection, args, null, null, null);
        if (cursor.getCount() == 1) {
            cursor.close();
            return Boolean.TRUE;
        } else {
            cursor.close();
            return Boolean.FALSE;
        }
    }

    public void delete(Word word) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String selection = sourceWord + " = ?";
        String[] args = {word.getSrcWord()};
        db.delete(tableName, selection, args);
    }

    @Override
    protected void finalize() throws Throwable {
        dbHelper.close();
    }

    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            // конструктор суперкласса
            super(context, "wordDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d(LOG_TAG, "--- onCreate database ---");
            // создаем таблицу с полями
            db.execSQL("create table " + taskTable + " ("
                    + TaskRows.ID + " integer primary key autoincrement,"+
                    TaskRows.operator + " text, " +
            TaskRows.name + " text, " +
            TaskRows.description + " text, " +
            TaskRows.createTime + " integer, " +
            TaskRows.receiveDate + " integer, " +
            TaskRows.startDate + " integer, " +
            TaskRows.prepareStartTime + " integer, " +
            TaskRows.prepareEndTime + " integer, " +
            TaskRows.endManeuresTime + " integer, " +
            TaskRows.readyWatchTime + " integer, " +
            TaskRows.endWatchTime + " integer, " +
            TaskRows.acceptTime + " integer, " +
            TaskRows.endConnectionTime + " integer, " +
            TaskRows.readyFillTime + " integer, " +
            TaskRows.startFillTime + " integer, " +
            TaskRows.endDisconnectionTime + " integer, " +
            TaskRows.endProbeTime + " integer, " +
            TaskRows.readyWatchTime2 + " integer, " +
            TaskRows.acceptTime2 + " integer, " +
            TaskRows.prepareEndTime2 + " integer, " +
            TaskRows.endManeuresTime2 + " integer, " +
            TaskRows.finishTime + " integer, " +
            TaskRows.isDeleted + " integer" +
                    ");");
            db.execSQL("create table " + taskTable + " ("
                    + PhotoRows.ID + " integer primary key autoincrement,"+
                    PhotoRows.url + " text, " +
            PhotoRows.taskId + " integer, " +
            PhotoRows.field + " text," +
            "FOREIGN KEY(" +PhotoRows.taskId + ") REFERENCES " + taskTable + "(" + TaskRows.ID+ "));");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}


