package es.animaldevs.app.model

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface ModelExampleDao {
    @get:Query("SELECT * FROM ModelExample")
    val all: List<ModelExample>

    @Query("SELECT * FROM ModelExample WHERE id == :modelExampleId")
    fun getModelExample(modelExampleId: Int): List<ModelExample>

    @Insert
    fun insertAll(vararg modelExamples: ModelExample)

    @Insert
    fun insert(modelExample: ModelExample)

    @Query("DELETE FROM ModelExample")
    fun removeAllModelExamples()
}