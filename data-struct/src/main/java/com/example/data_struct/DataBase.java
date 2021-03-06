package com.example.data_struct;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

import java.lang.reflect.Array;
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
        public static final String url = "urlCol";
        public static final String serverId = "serverIdCol";
        public static final String taskInd = "taskIndCol";
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

    public void addPhoto(Task task,  String field, Long serverId, int ind, Uri img) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PhotoRows.taskId, task.id);
        contentValues.put(PhotoRows.field, field);
        contentValues.put(PhotoRows.serverId, serverId);
        contentValues.put(PhotoRows.taskInd, ind);
        contentValues.put(PhotoRows.url, img.getPath());
        db.insert(photoTable, null, contentValues);
    }

    public void updatePhoto(Task task,  String field, Long serverId, int ind, Uri img) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PhotoRows.taskId, task.id);
        contentValues.put(PhotoRows.field, field);
        contentValues.put(PhotoRows.serverId, serverId);
        contentValues.put(PhotoRows.taskInd, ind);
        contentValues.put(PhotoRows.url, img.getPath());
        db.update(photoTable, contentValues, PhotoRows.url + "=" + img.toString(), null);
    }
    public void addTask(Task task) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        Log.d("DB", "added task id " + task.id);
        contentValues.put(TaskRows.ID, task.id);
        contentValues.put(TaskRows.operator, task.operator);
        contentValues.put(TaskRows.name, task.name) ;
        contentValues.put(TaskRows.description, task.description);
        if (task.createTime != null) contentValues.put(TaskRows.createTime, task.createTime.getTime());
        if (task.receiveDate != null) contentValues.put(TaskRows.receiveDate, task.receiveDate.getTime());
        if (task.startDate != null) contentValues.put(TaskRows.startDate, task.startDate.getTime());
        if (task.prepareStartTime != null) contentValues.put(TaskRows.prepareStartTime, task.prepareStartTime.getTime()) ;
        if (task.prepareEndTime != null) contentValues.put(TaskRows.prepareEndTime, task.prepareEndTime.getTime()) ;
        if (task.endManeuresTime != null) contentValues.put(TaskRows.endManeuresTime, task.endManeuresTime.getTime());
        if (task.readyWatchTime != null) contentValues.put(TaskRows.readyWatchTime, task.readyWatchTime.getTime());
        if (task.endWatchTime != null) contentValues.put(TaskRows.endWatchTime, task.endWatchTime.getTime()) ;
        if (task.acceptTime != null) contentValues.put(TaskRows.acceptTime, task.acceptTime.getTime()) ;
        if (task.endConnectionTime != null) contentValues.put(TaskRows.endConnectionTime, task.endConnectionTime.getTime());
        if (task.readyFillTime != null) contentValues.put(TaskRows.readyFillTime, task.readyFillTime.getTime()) ;
        if (task.startFillTime != null) contentValues.put(TaskRows.startFillTime, task.startFillTime.getTime()) ;
        if (task.endDisconnectionTime != null) contentValues.put(TaskRows.endDisconnectionTime, task.endDisconnectionTime.getTime()) ;
        if (task.endProbeTime != null) contentValues.put(TaskRows.endProbeTime,  task.endProbeTime.getTime()) ;
        if (task.readyWatchTime2 != null) contentValues.put(TaskRows.readyWatchTime2, task.readyWatchTime2.getTime());
        if (task.acceptTime2 != null) contentValues.put(TaskRows.acceptTime2, task.acceptTime2.getTime()) ;
        if (task.prepareEndTime2 != null) contentValues.put(TaskRows.prepareEndTime2, task.prepareEndTime2.getTime()) ;
        if (task.endManeuresTime2 != null) contentValues.put(TaskRows.endManeuresTime2, task.endManeuresTime2.getTime()) ;
        if (task.finishTime != null) contentValues.put(TaskRows.finishTime, task.finishTime.getTime()) ;
        contentValues.put(TaskRows.finishTime, task.finishTime.getTime()) ;
        contentValues.put(TaskRows.isDeleted, task.isDeleted) ;
        db.insert(taskTable, null, contentValues);
    }

    public void updateTask(Task task) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TaskRows.operator, task.operator);
        contentValues.put(TaskRows.name, task.name) ;
        contentValues.put(TaskRows.description, task.description);
        if (task.createTime != null) contentValues.put(TaskRows.createTime, task.createTime.getTime());
        if (task.receiveDate != null) contentValues.put(TaskRows.receiveDate, task.receiveDate.getTime());
        if (task.startDate != null) contentValues.put(TaskRows.startDate, task.startDate.getTime());
        if (task.prepareStartTime != null) contentValues.put(TaskRows.prepareStartTime, task.prepareStartTime.getTime()) ;
        if (task.prepareEndTime != null) contentValues.put(TaskRows.prepareEndTime, task.prepareEndTime.getTime()) ;
        if (task.endManeuresTime != null) contentValues.put(TaskRows.endManeuresTime, task.endManeuresTime.getTime());
        if (task.readyWatchTime != null) contentValues.put(TaskRows.readyWatchTime, task.readyWatchTime.getTime());
        if (task.endWatchTime != null) contentValues.put(TaskRows.endWatchTime, task.endWatchTime.getTime()) ;
        if (task.acceptTime != null) contentValues.put(TaskRows.acceptTime, task.acceptTime.getTime()) ;
        if (task.endConnectionTime != null) contentValues.put(TaskRows.endConnectionTime, task.endConnectionTime.getTime());
        if (task.readyFillTime != null) contentValues.put(TaskRows.readyFillTime, task.readyFillTime.getTime()) ;
        if (task.startFillTime != null) contentValues.put(TaskRows.startFillTime, task.startFillTime.getTime()) ;
        if (task.endDisconnectionTime != null) contentValues.put(TaskRows.endDisconnectionTime, task.endDisconnectionTime.getTime()) ;
        if (task.endProbeTime != null) contentValues.put(TaskRows.endProbeTime,  task.endProbeTime.getTime()) ;
        if (task.readyWatchTime2 != null) contentValues.put(TaskRows.readyWatchTime2, task.readyWatchTime2.getTime());
        if (task.acceptTime2 != null) contentValues.put(TaskRows.acceptTime2, task.acceptTime2.getTime()) ;
        if (task.prepareEndTime2 != null) contentValues.put(TaskRows.prepareEndTime2, task.prepareEndTime2.getTime()) ;
        if (task.endManeuresTime2 != null) contentValues.put(TaskRows.endManeuresTime2, task.endManeuresTime2.getTime()) ;
        if (task.finishTime != null) contentValues.put(TaskRows.finishTime, task.finishTime.getTime()) ;
        contentValues.put(TaskRows.isDeleted, task.isDeleted) ;
        db.update(taskTable, contentValues, TaskRows.ID+"=" + task.id, null);
    }

    public Task getTask(Long id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = db.query(taskTable, null, TaskRows.ID+"=" + id, null, null, null, null);
        Log.d("DB", "search id " + id);
        cursor.moveToFirst();
        Task task =  getTaskFromCursor(db, cursor);

        cursor.close();
        return task;
    }

    Task getTaskFromCursor(SQLiteDatabase db, final Cursor cursor) {
        Task task = new Task();
        task.id = cursor.getInt(cursor.getColumnIndex(TaskRows.ID));
        task.operator = cursor.getString(cursor.getColumnIndex(TaskRows.operator));
        task.name = cursor.getString(cursor.getColumnIndex(TaskRows.name));
        task.description = cursor.getString(cursor.getColumnIndex(TaskRows.description));
        task.createTime = new Date(cursor.getLong(cursor.getColumnIndex(TaskRows.createTime)));
        task.receiveDate = new Date(cursor.getLong(cursor.getColumnIndex(TaskRows.receiveDate)));
        task.startDate = new Date(cursor.getLong(cursor.getColumnIndex(TaskRows.startDate)));
        task.prepareStartTime = new Date(cursor.getLong(cursor.getColumnIndex(TaskRows.prepareStartTime)));
        task.endManeuresTime = new Date(cursor.getLong(cursor.getColumnIndex(TaskRows.endManeuresTime)));
        task.readyWatchTime = new Date(cursor.getLong(cursor.getColumnIndex(TaskRows.readyWatchTime)));
        task.endWatchTime = new Date(cursor.getLong(cursor.getColumnIndex(TaskRows.endWatchTime)));
        task.acceptTime = new Date(cursor.getLong(cursor.getColumnIndex(TaskRows.acceptTime)));
        task.endConnectionTime = new Date(cursor.getLong(cursor.getColumnIndex(TaskRows.endConnectionTime)));
        task.readyFillTime = new Date(cursor.getLong(cursor.getColumnIndex(TaskRows.readyFillTime)));
        task.startFillTime = new Date(cursor.getLong(cursor.getColumnIndex(TaskRows.startFillTime)));
        task.endDisconnectionTime = new Date(cursor.getLong(cursor.getColumnIndex(TaskRows.endDisconnectionTime)));
        task.endProbeTime = new Date(cursor.getLong(cursor.getColumnIndex(TaskRows.endProbeTime)));
        task.readyWatchTime2 = new Date(cursor.getLong(cursor.getColumnIndex(TaskRows.readyWatchTime2)));
        task.acceptTime2 = new Date(cursor.getLong(cursor.getColumnIndex(TaskRows.acceptTime2)));
        task.prepareEndTime2 = new Date(cursor.getLong(cursor.getColumnIndex(TaskRows.prepareEndTime2)));
        task.endManeuresTime2 = new Date(cursor.getLong(cursor.getColumnIndex(TaskRows.endManeuresTime2)));
        task.finishTime = new Date(cursor.getLong(cursor.getColumnIndex(TaskRows.finishTime)));
        int prebool = cursor.getInt(cursor.getColumnIndex(TaskRows.isDeleted));
        task.isDeleted = (prebool > 0) ? true : false;
        String selection = PhotoRows.taskId + "=?";
        String[] args = {Long.toString(task.id)};
        Cursor pcursor = db.query(photoTable, null, selection, args, null, null, null);
        if (pcursor.moveToFirst()) {
            while (!pcursor.isAfterLast()) {
                String field = pcursor.getString(pcursor.getColumnIndex(PhotoRows.field));
                Uri purl = new Uri.Builder().path(pcursor.getString(pcursor.getColumnIndex(PhotoRows.url))).build();
                Integer ind = pcursor.getInt(pcursor.getColumnIndex(PhotoRows.taskInd));
                Long serverId = pcursor.getLong(pcursor.getColumnIndex(PhotoRows.serverId));
                switch (field) {
                    case "prepareImg":task.prepareImg.add(ind, purl);
                        if (serverId != null) {
                            task.prepareImgId.add(ind, serverId);
                        }
                        break;
                    case "acceptImg":task.acceptImg.add(ind, purl);
                        if (serverId != null) {
                            task.acceptImgId.add(ind, serverId);
                        }
                        break;
                    case "numbersImg":task.numbersImg.add(ind, purl);
                        if (serverId != null) {
                            task.numbersImgId.add(ind, serverId);
                        }
                        break;
                    case "prepareImg2":task.prepareImg2.add(ind, purl);
                        if (serverId != null) {
                            task.prepareImgId2.add(ind, serverId);
                        }
                        break;
                    case "acceptImg2":task.acceptImg2.add(ind, purl);
                        if (serverId != null) {
                            task.acceptImgId2.add(ind, serverId);
                        }
                        break;
                }
                pcursor.moveToNext();
            }
        }
        pcursor.close();
        return task;
    }

    public ArrayList<Task> getAll() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query(taskTable, null, null, null, null, null, null);
        ArrayList<Task> ret = new ArrayList<>();
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                ret.add(getTaskFromCursor(db, cursor));
                cursor.moveToNext();
            }
        }
        cursor.close();
        return ret;
    }

    public Boolean isTaskIn(long tid) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String[] columns = {TaskRows.ID};
        String selection = TaskRows.ID + " =" + tid;
        Cursor cursor = db.query(taskTable, columns, selection, null, null, null, null);
        if (cursor.getCount() == 1) {
            cursor.close();
            return Boolean.TRUE;
        } else {
            cursor.close();
            return Boolean.FALSE;
        }
    }

    /*
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
    */

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
                    + TaskRows.ID + " integer primary key,"+
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

            db.execSQL("create table " + photoTable + " ("
                    + PhotoRows.url + " text primary key,"+
                    PhotoRows.serverId + " integer, " +
                    PhotoRows.taskInd + " integer, " +
            PhotoRows.taskId + " integer, " +
            PhotoRows.field + " text," +
            "FOREIGN KEY(" +PhotoRows.taskId + ") REFERENCES " + taskTable + "(" + TaskRows.ID+ "));");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}


