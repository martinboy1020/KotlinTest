package example.com.kotlintest.volleytool;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class JavaVolley  {

    private Context mCtx;
    private String url = "http://secondhandbs.000webhostapp.com/Fubon/PunchIn.php?account=michael&fbclid=IwAR1WxqKQPpzzhOqeA_Kvl7atRk_eMtVW3Jik7qdaBbVXMhbS-bjG_VAajgo";

    public void runNetApi(Context context) {
        mCtx = context;
        useStringRequest();
    }

    public void useStringRequest() {

        RequestQueue mQueue = Volley.newRequestQueue(mCtx);
        StringRequest stringRequest =
                new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.i("tag123", response);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("tag123", error.getMessage(), error);
                    }
                });

        mQueue.add(stringRequest);

    }

}
