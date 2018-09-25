package es.animaldevs.app.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

/**
 * Class which provides a model for Example
 * @constructor Sets all properties of the ModelExample
 * @property image the title of the ModelExample
 * @property title the title of the ModelExample
 * @property description the content of the ModelExample
 */
@Entity
@Parcelize
@JsonClass(generateAdapter = true)
data class ModelExample(
        @PrimaryKey
        val id:Int,
        val total_points:Int,
        val image: String,
        val title: String,
        val description: String,
        val points: Int
) : Parcelable