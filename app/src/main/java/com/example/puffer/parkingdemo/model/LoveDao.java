package com.example.puffer.parkingdemo.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface LoveDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insert(Love item);

    @Query("SELECT * FROM Table_Love WHERE id LIKE :id")
    Single<Love> getByID(String id);

    @Query("SELECT * FROM Table_Love INNER JOIN Table_Parking ON Table_Love.id = Table_Parking.id")
    Single<Park[]> getLoveList();

    @Query("DELETE FROM Table_Love WHERE id LIKE :id")
    Completable deleteByID(String id);
}
