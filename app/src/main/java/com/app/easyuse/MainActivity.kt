package com.app.easyuse

import EasyUse.json
import EasyUse.post
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.app.easyuse.databinding.ActivityMainBinding
import org.json.JSONException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val params = mapOf(
            "to" to "FKoJiAd12Y1a4Lk0tCtnPaLO4csc6OGQndText1m",
            "text" to "Hello! and welcome"
        )

        post("https://notificator.ir/api/v1/send", params) { response ->
            try {
                val json = json(response)
                val success = json.getInt("success")
                val ok = json.getBoolean("ok")
                val message = json.getString("message")

                Log.i("EU", "Success: $success")
                Log.i("EU", "OK: $ok")
                Log.i("EU", "Message: $message")

            } catch (e: JSONException) {
                Log.e("EU", "Error parsing JSON: ${e.message}")
            }
        }
    }
}
