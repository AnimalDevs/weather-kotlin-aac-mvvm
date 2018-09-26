package es.animaldevs.app.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

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