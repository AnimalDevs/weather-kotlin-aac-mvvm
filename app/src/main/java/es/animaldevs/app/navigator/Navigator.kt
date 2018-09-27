package es.animaldevs.app.navigator

import android.app.Activity
import android.content.Intent
import es.animaldevs.app.ui.weather.WeatherDayListActivity

class Navigator {

    fun navigateToHome(activity: Activity) {
        val intent = Intent(activity, WeatherDayListActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        activity.startActivity(intent)
    }

    /*fun navigateToDetail(activity: Activity, item: Item) {
        val intent = Intent(activity, WeatherDetailActivity::class.java)
        intent.putExtra(EXTRA_CLUE, modelExample)
        ActivityCompat.startActivity(activity, intent, null)
    }*/
}