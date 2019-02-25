package com.devhwang.a84974.pettogether.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.devhwang.a84974.pettogether.helper.DATABASE_NAME
import com.devhwang.a84974.pettogether.model.PetProfile

@Database(entities = [PetProfile::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase:RoomDatabase() {
    abstract fun petDao():PetDao

    companion object {
        @Volatile private var instance:AppDatabase? = null

        fun getInstance(context: Context):AppDatabase{
            return instance ?: synchronized(this){
                instance?:buildDatabase(context).also { instance = it }
            }
        }
        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context,AppDatabase::class.java,DATABASE_NAME).allowMainThreadQueries().build()
        }
    }
}