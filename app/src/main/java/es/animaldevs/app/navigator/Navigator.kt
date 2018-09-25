package es.animaldevs.app.navigator

/**
 * Created by vanadisdevmicro on 7/8/18.
 */
import android.app.Activity
import android.content.Intent
import es.animaldevs.app.ui.weather.WeatherListActivity

class Navigator {

    fun navigateToHome(activity: Activity) {
        val intent = Intent(activity, WeatherListActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        activity.startActivity(intent)
    }

    /*fun navigateToDetail(activity: Activity, modelExample: ModelExample) {
        val intent = Intent(activity, WeatherDetailActivity::class.java)
        intent.putExtra(EXTRA_CLUE, modelExample)
        ActivityCompat.startActivity(activity, intent, null)
    }*/
}