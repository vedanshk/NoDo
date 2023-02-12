package com.example.nodo.data;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.nodo.model.NoDo;

@Database(entities = {NoDo.class} , version = 1)
public abstract class  NoDoRoomDatabase extends RoomDatabase {

    private static  volatile  NoDoRoomDatabase instance;

    public  abstract  NoDoDao noDoDao();

    public static  NoDoRoomDatabase getDatabase(final Context context){

            if(instance == null){

                synchronized (NoDoRoomDatabase.class){
                    if(instance == null){

                        instance  = Room.databaseBuilder(context.getApplicationContext() ,
                                NoDoRoomDatabase.class , "nodo_database"
                                ).build();
                    }
                }
            }

            return instance;

    }


    private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(instance).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void , Void , Void>{

        private final NoDoDao noDoDao;

        public PopulateDbAsync(NoDoRoomDatabase db){
               noDoDao = db.noDoDao();

        }




        @Override
        protected Void doInBackground(Void... voids) {
            noDoDao.deleteAll(); // removes all items form our table
            return null;
        }
    }


}
