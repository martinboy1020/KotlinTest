package example.com.kotlintest.volleytool

import android.content.Context
import android.util.Log
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import example.com.kotlintest.paserbean.StringBean
import org.json.JSONException
import org.json.JSONObject



class VolleyTool {

    private var mCtx : Context? = null
    private var urlParkingArea : String = "https://data.taipei/opendata/datalist/apiAccess?scope=resourceAquire&rid=a880adf3-d574-430a-8e29-3192a41897a5"
//    private var urlParkingArea : String = "https://cloud.culture.tw/frontsite/trans/SearchShowAction.do?method=doFindTypeJ&category=6"

    fun runNetApi(context : Context) {
        mCtx = context
        useStringRequest()
    }

    private fun useStringRequest() {
        val mQueue : RequestQueue = Volley.newRequestQueue(mCtx)
        val stringRequest = StringRequest(
                urlParkingArea,
                Response.Listener<String> { response ->
                    Log.d("tag", "response = $response")
                    parserStringJson(response)
                },
                Response.ErrorListener { error -> Log.e("tag", "error : $error") }
        )

//        val stringRequest = StringRequest(urlParkingArea,
//                Response.Listener<String> { response ->
//                    Log.d("tag", "response = $response")
//                    if (response != null) {
//                        parserStringJson(response)
//                    }
//                },
//                Response.ErrorListener { })
        mQueue.add(stringRequest)
    }

    private fun useJsonObjectRequest() {
        val jsonObjectRequest = JsonObjectRequest(
                urlParkingArea,
                Response.Listener<JSONObject> { response ->
                    Log.d("tag", "response = $response")
                    parserJsonObject(response)
                },
                Response.ErrorListener { error -> Log.e("tag", "error : $error") }
        )
        Volley.newRequestQueue(mCtx).add(jsonObjectRequest)
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
//                urlParkingArea,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.d(TAG, "response = " + response.toString());
//                        parserJson(response);
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.e(TAG, "error : " + error.toString());
//                    }
//                }
//        );
    }

    private fun parserJsonObject(jsonObject: JSONObject) {
        try {
            val data = jsonObject.getJSONObject("result").getJSONArray("results")
            Log.d("parserJson", "data$data")
            for (i in 0 until data.length()) {
                val o = data.getJSONObject(i)
//                mMap.addMarker(MarkerOptions()
//                        .position(LatLng(o.getDouble("緯度(WGS84)"), o.getDouble("經度(WGS84)")))
//                        .title(o.getString("停車場名稱"))
//                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.parking))
//                )
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }

    private fun parserStringJson(jsonString: String) {
        var testBean = StringBean.parse(jsonString)
        Log.d("parserStringJson", testBean.toString())
    }

}