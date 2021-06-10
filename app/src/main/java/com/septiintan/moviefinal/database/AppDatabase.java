package com.septiintan.moviefinal.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.septiintan.moviefinal.database.dao.FavoriteDao;
import com.septiintan.moviefinal.database.entities.Favorite;

@Database(entities = {Favorite.class}, version = 2)
public abstract class  AppDatabase extends RoomDatabase {
    public abstract FavoriteDao favoriteDao();

    private static AppDatabase instance;

    public synchronized static AppDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "Movie Source Database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }
}
