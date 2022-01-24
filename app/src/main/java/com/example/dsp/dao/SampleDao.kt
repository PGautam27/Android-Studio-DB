package com.example.dsp.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.dsp.entity.SampleEntity

@Dao
interface SampleDao {
    @Query("SELECT * FROM `Sample Data`")
    fun getAllData(): LiveData<List<SampleEntity>>

    @Query("SELECT * FROM `Sample data` WHERE id = :id")
    fun getById(id: Int): SampleEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: List<SampleEntity>)

    @Update
    suspend fun update(item: SampleEntity)

    @Delete
    suspend fun delete(item: SampleEntity)

    @Query("DELETE FROM `Sample Data`")
    suspend fun deleteAllRecord()
}