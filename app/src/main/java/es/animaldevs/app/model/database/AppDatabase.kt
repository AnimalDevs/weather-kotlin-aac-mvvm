package es.animaldevs.app.model.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import es.animaldevs.app.model.ModelExample
import es.animaldevs.app.model.ModelExampleDao

@Database(entities = arrayOf(ModelExample::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun modelExampleDao(): ModelExampleDao
}