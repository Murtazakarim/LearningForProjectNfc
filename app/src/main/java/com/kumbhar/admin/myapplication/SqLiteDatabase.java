package com.kumbhar.admin.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqLiteDatabase extends SQLiteOpenHelper {

    SQLiteDatabase db;

    //Database name
    private static final String DATABASE_NAME="Student_info";

    //Database Version
    private static final int DATABASE_VERSION=1;

    //Database table Name
    private static final String TABLE_STUDENT="tblstudent";

    //Database table tblstudent columns
    public static final String KEY_ROWID="_id";
    public static final String KEY_FIRST_NAME="firstname";
    public static final String KEY_SECOND_NAME="secondname";

    public SqLiteDatabase( Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_STUDENT_TABLE="CREATE TABLE " +TABLE_STUDENT+ "(" +KEY_ROWID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                KEY_FIRST_NAME+ " TEXT, " +KEY_SECOND_NAME+ " TEXT);";

        db.execSQL(CREATE_STUDENT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_STUDENT);
        onCreate(db);

    }

    public long insertStudent(String firstname, String secondname) {

        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_FIRST_NAME,firstname);
        cv.put(KEY_SECOND_NAME,secondname);
        return db.insert(TABLE_STUDENT, null, cv);
    }

    public String getData() {
        db = this.getReadableDatabase();
        String [] columns = new String[]{KEY_ROWID,KEY_FIRST_NAME,KEY_SECOND_NAME};
        Cursor c = db.query(TABLE_STUDENT,columns,null,null,null,null,null);
        String result ="";

        int iRow=c.getColumnIndex(KEY_ROWID);
        int iFirstname = c.getColumnIndex(KEY_FIRST_NAME);
        int iSecondname = c.getColumnIndex(KEY_SECOND_NAME);

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext())
        {
            result = result + c.getString(iRow) + "" +c.getString(iFirstname)+ "" +c.getString(iSecondname)+ "\n";
        }

        db.close();

        return result;
    }

    public String getStudentfirstname(long l) {
        db = this.getReadableDatabase();
        String [] columns = new String[]{KEY_ROWID,KEY_FIRST_NAME,KEY_SECOND_NAME};
        Cursor c = db.query(TABLE_STUDENT,columns,KEY_ROWID + "="+ l,null,null,null,null);
        if(c != null){
            c.moveToFirst();
            String name = c.getString(1);
            return name;
        }
        return null;
    }

    public String getStudentsecondname(long l) {
        db = this.getReadableDatabase();
        String [] columns = new String[]{KEY_ROWID,KEY_FIRST_NAME,KEY_SECOND_NAME};
        Cursor c = db.query(TABLE_STUDENT,columns,KEY_ROWID + "="+ l,null,null,null,null);
        if(c != null){
            c.moveToFirst();
            String name = c.getString(2);
            return name;
        }
        return null;
    }

    public void UpdateStudent(long l, String firstname, String secondname) {
        db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_FIRST_NAME,firstname);
        cv.put(KEY_SECOND_NAME,secondname);
        db.update(TABLE_STUDENT,cv,KEY_ROWID + "=" + l,null);
        db.close();
    }

    public void deleteStudent(long l) {

        db=this.getWritableDatabase();
        db.delete(TABLE_STUDENT,KEY_ROWID + "=" +l,null);
    }
}
