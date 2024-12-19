package com.singlepointsol.sqliteassignment

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DBHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {
    companion object {
        const val DATABASE_NAME = "cricketers.db"
        const val DATABASE_VERSION = 1
        const val DATABASE_TABLE = "cri_table"
        const val KEY_ID = "_Id"
        const val KEY_NAME = "NAME"
        const val KEY_TEAMNAME = "TEAMNAME"
        const val KEY_CATEGORY = "CATEGORY"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable =
            "create table $DATABASE_TABLE($KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT,$KEY_NAME TEXT,$KEY_TEAMNAME TEXT,$KEY_CATEGORY TEXT)"
        db?.execSQL(createTable)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("drop table if exists $DATABASE_TABLE")
    }

    fun addCricketer(cricketer:  Cricketer): Long{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_NAME, cricketer.name)
        contentValues.put(KEY_TEAMNAME, cricketer.teamname)
        contentValues.put(KEY_CATEGORY, cricketer.category)
        return db.insert(DATABASE_TABLE, null, contentValues)
    }

    fun getcricketers(): ArrayList<Cricketer> {
        val cricketersArrayList: ArrayList<Cricketer> = ArrayList()
        val db = this.readableDatabase
        val cursor: Cursor = db.rawQuery("select * from $DATABASE_TABLE", null)
        while (cursor.moveToNext()) {
            val name = cursor.getString(1)
            val teamname = cursor.getString(2)
            val category = cursor.getString(3)
            val cri = Cricketer(name, teamname, category)
            cricketersArrayList.add(cri)
        }
        cursor.close()
        db.close()
        return cricketersArrayList
    }
    fun updateCricketer(  id:String,name:String,teamname:String,category:String):Boolean{
        val db = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_ID,id)
        contentValues.put(KEY_NAME,name)
        contentValues.put(KEY_TEAMNAME,teamname)
        contentValues.put(KEY_CATEGORY,category)
        db.update(DATABASE_TABLE,contentValues,"$KEY_ID=?", arrayOf(id))
        return true

    }
    fun deleteCricketer(id:String):Int{
        val db = writableDatabase
        return db.delete(DATABASE_TABLE,"$KEY_ID=?", arrayOf(id))
    }
}



