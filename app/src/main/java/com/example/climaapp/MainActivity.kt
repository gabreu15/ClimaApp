package com.example.climaapp

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import org.json.JSONObject
import java.lang.Exception
import java.net.URL
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    val CITY: String = "curitiba,br"
    val API: String = "06c921750b9a82d8f5d1294e1586276f"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weatherTask().execute()
    }
    inner class  weatherTask : AsyncTask<String, Void, String>()
    {
        override fun onPreExecute() {
            super.onPreExecute()
            findViewById<ProgressBar>(R.id.loader).visibility = View.VISIBLE
            findViewById<RelativeLayout>(R.id.mainContainer).visibility = View.GONE
            findViewById<TextView>(R.id.errortext).visibility = View.GONE
        }

        override fun doInBackground(vararg p0: String?): String? {
            var response:String?
            try
            {
                response = URL("https://api.openweathermap.org/data/2.5/weather?q=$CITY&units=metric&appid=$API")
                    .readText(Charsets.UTF_8)
            }
            catch (e: Exception)
            {
                response = null
            }
            return response

        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            try {
                val jsonObj = JSONObject(result)
                val main  = jsonObj.getJSONObject("main")
                val sys = jsonObj.getJSONObject("sys")
                val wind = jsonObj.getJSONObject("wind")
                val weather = jsonObj.getJSONArray("weather").getJSONObject(0)
                val updatedAt = jsonObj.getLong("dt")
                val updatedAtTimestamp = updatedAt - (3 * 3600)

                val updateAtText = "Atualizado em: "+SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.ENGLISH).format(Date(updatedAtTimestamp*1000))

                val temp = main.getString("temp")
                val temperatureUnit = temp.substring(0, 2)+"°C"

                val tempMin = main.getString("temp_min")
                val temperatureMinUnit = "Mínima: "+tempMin.substring(0, 2)+"°C"

                val tempMax = main.getString("temp_max")
                val temperatureMaxUnit = "Máxima: "+tempMax.substring(0, 2)+"°C"

                val pressure = main.getString("pressure")+" mb"
                val humidity = main.getString("humidity")+"%"

                val sunrise = sys.getLong("sunrise")
                val sunriseTimestamp = sunrise - (3 * 3600)

                val sunset = sys.getLong("sunset")
                val sunsetTimestamp = sunset - (3 * 3600)

                val windSpeed = wind.getString("speed")+" km/h"
                val weatherDescription = weather.getString("description")
                val address = jsonObj.getString("name")+", "+sys.getString("country")


                val weatherIcon = weather.getString("icon")
                val imageView = findViewById<ImageView>(R.id.weatherIcon)

                val weatherIcons = mapOf(
                    "01d" to R.drawable.d01,
                    "01n" to R.drawable.n01,
                    "02d" to R.drawable.d02,
                    "02n" to R.drawable.n02,
                    "03d" to R.drawable.d03,
                    "03n" to R.drawable.n03,
                    "04d" to R.drawable.d04,
                    "04n" to R.drawable.n04,
                    "09d" to R.drawable.d09,
                    "09n" to R.drawable.n09,
                    "10d" to R.drawable.d10,
                    "10n" to R.drawable.n10,
                    "11d" to R.drawable.d11,
                    "11n" to R.drawable.n11
                )

                val iconResourceID = weatherIcons[weatherIcon]

                if (iconResourceID != null) {
                    // Carregue e exiba a imagem do ícone diretamente pelo ID
                    imageView.setImageResource(iconResourceID)
                } else {
                    // Caso não haja um ícone correspondente, você pode definir uma imagem padrão ou tratar de outra forma
                    imageView.setImageResource(R.drawable.not_available)
                }


                findViewById<TextView>(R.id.address).text = address
                findViewById<TextView>(R.id.updated_at).text = updateAtText
                findViewById<TextView>(R.id.status).text = weatherDescription.capitalize()
                findViewById<TextView>(R.id.temp).text = temperatureUnit
                findViewById<TextView>(R.id.temp_min).text = temperatureMinUnit
                findViewById<TextView>(R.id.temp_max).text = temperatureMaxUnit
                findViewById<TextView>(R.id.sunrise).text = SimpleDateFormat("HH:mm", Locale.ENGLISH).format(Date(sunriseTimestamp * 1000))
                findViewById<TextView>(R.id.sunset).text = SimpleDateFormat("HH:mm", Locale.ENGLISH).format(Date(sunsetTimestamp * 1000))
                findViewById<TextView>(R.id.wind).text = windSpeed
                findViewById<TextView>(R.id.pressure).text = pressure
                findViewById<TextView>(R.id.humidity).text = humidity

                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                findViewById<RelativeLayout>(R.id.mainContainer).visibility = View.VISIBLE
            }
            catch (e: Exception)
            {
                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                findViewById<TextView>(R.id.errortext).visibility = View.VISIBLE
            }
        }
    }
}