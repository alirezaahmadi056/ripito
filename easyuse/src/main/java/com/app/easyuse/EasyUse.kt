import android.util.Log
import kotlinx.coroutines.*
import org.json.JSONObject
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

@OptIn(DelicateCoroutinesApi::class)
object EasyUse {

    fun json(jsonString: String): JSONObject {
        return JSONObject(jsonString)
    }

    fun get(url: String, params: Map<String, String>? = null, callback: (String) -> Unit) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val queryString = params?.entries
                    ?.joinToString("&") { "${it.key}=${it.value}" }
                    ?.takeIf { it.isNotEmpty() }
                    ?.let { "?$it" } ?: ""
                val formattedUrl = if (queryString.isNotEmpty() && url.endsWith("/")) {
                    url.dropLast(1) + queryString
                } else {
                    url + queryString
                }
                Log.i("EU", formattedUrl)
                val connection = URL(formattedUrl).openConnection() as HttpURLConnection
                connection.requestMethod = "GET"
                val response = connection.inputStream.bufferedReader().use { it.readText() }
                withContext(Dispatchers.Main) {
                    callback(response)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    callback("Error: ${e.message}")
                }
            }
        }
    }

    fun post(url: String, params: Map<String, String>? = null, callback: (String) -> Unit) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val connection = URL(url).openConnection() as HttpURLConnection
                connection.requestMethod = "POST"
                connection.doOutput = true
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
                val postData = params?.entries
                    ?.joinToString("&") { "${it.key}=${it.value}" }
                    ?: ""
                OutputStreamWriter(connection.outputStream).use { it.write(postData) }

                val response = connection.inputStream.bufferedReader().use { it.readText() }

                withContext(Dispatchers.Main) {
                    callback(response)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    callback("Error: ${e.message}")
                }
            }
        }
    }

}