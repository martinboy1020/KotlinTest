package example.com.kotlintest.paserbean

import android.util.Log
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class StringBean : BaseBean() {

    val RESULT = "result"
    val RESULTS = "results"
    val LIMIT = "limit"
    val OFFSET = "offset"
    val COUNT = "count"
    val SORT = "sort"

    var limit = 0
    var offset = 0
    var count = 0
    var sort = ""
    var parkList = arrayListOf<ParkItem>()

//    var numReviews = 0
//    var helpfulcount = 0
//    var totalHelpfulNotHelpful = 0
//    var rating = 0
//    var appReviewKey = ""
//    var reviewTitle = ""
//    var review = ""
//    var dateCreated: Long = 0

    override fun toString(): String {
        return ("AbusiveBean [limit=" + limit + ", offset="
                + offset + ", count="
                + count + ", sort=" + sort
                + ", parkList=" + parkList.toString() + "]")
        return ""
    }

    companion object {

        @Throws(JSONException::class)
        fun parse(jsonString: String): StringBean {

            var bean: StringBean?

            val jRoot = JSONObject(jsonString)

            bean = StringBean()

            if(!jRoot.isNull(bean.RESULT)){

                val obj : JSONObject = jRoot.getJSONObject(bean.RESULT)

                if(!obj.isNull(bean.LIMIT)) {
                    bean.limit = obj.getInt(bean.LIMIT)
                }

                if(!obj.isNull(bean.OFFSET)) {
                    bean.offset = obj.getInt(bean.OFFSET)
                }

                if(!obj.isNull(bean.COUNT)) {
                    bean.count = obj.getInt(bean.COUNT)
                }

                if(!obj.isNull(bean.SORT)) {
                    bean.sort = obj.getString(bean.SORT)
                }

                if(!obj.isNull(bean.RESULTS)) {

                    val array : JSONArray = obj.getJSONArray(bean.RESULTS)

                    Log.d("tag1", "array${array.length()}")

                    if(array.length() > 0) {

                        for(i in 0 until array.length()) {

                            var parkItem = bean.ParkItem()
                            var parkObj: JSONObject = array.getJSONObject(i)

                            Log.d("tag1", "parkObj$parkObj")

                            if(!parkObj.isNull(parkItem.PARKING_NAME)) {
                                parkItem.parking_name = parkObj.getString(parkItem.PARKING_NAME)
                            }

                            if(!parkObj.isNull(parkItem.LATITUDE)) {
                                parkItem.latitude = parkObj.getString(parkItem.LATITUDE)
                            }

                            if(!parkObj.isNull(parkItem.LONGITUDE)) {
                                parkItem.longitude = parkObj.getString(parkItem.LONGITUDE)
                            }

                            bean.parkList.add(parkItem)

                        }

                    }

                }

            }


            return bean
        }
    }

    inner class ParkItem {

        val PARKING_NAME = "停車場名稱"
        val LATITUDE = "緯度(WGS84)"
        val LONGITUDE = "經度(WGS84)"

        var parking_name: String? = null
        var latitude: String? = null
        var longitude: String? = null

        override fun toString(): String {
            return ("ParkItem [parking_name=" + parking_name
                    + ", latitude=" + latitude
                    + ", longitude= " +  longitude + "]")
        }

    }


}


//public class AbusiveBean extends BaseBean {
//
//    public final String NUMREBIEWS = "numReviews";
//    public final String APPREVIEW_KEY = "appReviewKey";
//    public final String REVIEWTITLE = "reviewTitle";
//    public final String HELPFULCOUNT = "helpfulcount";
//    public final String TOTALHELPFULNOTHELPFUL = "totalHelpfulNotHelpful";
//    public final String DATECREATED = "dateCreated";
//    public final String REVIEW = "review";
//    public final String RATING = "rating";
//    public final String REVIEWDETAIL = "reviewDetail";
//
//    private int numReviews = 0;
//    private int helpfulcount = 0;
//    private int totalHelpfulNotHelpful = 0;
//    private int rating = 0;
//    private String appReviewKey = "";
//    private String reviewTitle = "";
//    private String review = "";
//    private long dateCreated = 0;
//
//    public static AbusiveBean parse(String jsonString) throws JSONException {
//
//        AbusiveBean bean = null;
//
//        JSONObject jRoot = new JSONObject(jsonString);
//
//        if (jRoot != null) {
//            bean = new AbusiveBean();
//
//            bean.status = jRoot.getInt(STATUS);
//
//            if (ERROR.equals(jRoot.getString(STATUS))) {
//
//                if(!jRoot.isNull(ERROR_MSG)){
//                    bean.errorMsg = jRoot.getString(ERROR_MSG);
//                }
//
//                if(!jRoot.isNull(ERROR_CODE)){
//                    bean.errorCode = jRoot.getString(ERROR_CODE);
//                }
//
//            } else if (ZERO.equals(jRoot.getString(STATUS))) {
//
//                if(!jRoot.isNull(bean.NUMREBIEWS)){
//                    bean.numReviews = jRoot.getInt(bean.NUMREBIEWS);
//                }
//
//                if(!jRoot.isNull(APP_STORE_API_VERSION)){
//                    bean.apiVersion = jRoot.getString(APP_STORE_API_VERSION);
//                }
//
//                if(!jRoot.isNull(bean.REVIEWDETAIL)){
//
//                    JSONObject obj = jRoot.getJSONObject(bean.REVIEWDETAIL);
//
//                    if(!obj.isNull(bean.HELPFULCOUNT)){
//                        bean.helpfulcount = obj.getInt(bean.HELPFULCOUNT);
//                    }
//
//                    if(!obj.isNull(bean.TOTALHELPFULNOTHELPFUL)){
//                        bean.totalHelpfulNotHelpful = obj.getInt(bean.TOTALHELPFULNOTHELPFUL);
//                    }
//
//                    if(!obj.isNull(bean.RATING)){
//                        bean.rating = obj.getInt(bean.RATING);
//                    }
//
//                    if(!obj.isNull(bean.DATECREATED)){
//                        bean.dateCreated = obj.getLong(bean.DATECREATED);
//                    }
//
//                    if(!obj.isNull(bean.APPREVIEW_KEY)){
//                        bean.appReviewKey = obj.getString(bean.APPREVIEW_KEY);
//                    }
//
//                    if(!obj.isNull(bean.REVIEWTITLE)){
//                        bean.reviewTitle = obj.getString(bean.REVIEWTITLE);
//                    }
//
//                    if(!obj.isNull(bean.REVIEW)){
//                        bean.review = obj.getString(bean.REVIEW);
//                    }
//                }
//
//            }
//        }
//
//        return bean;
//    }
//
//    public int getNumReviews() {
//        return numReviews;
//    }
//
//    public void setNumReviews(int numReviews) {
//        this.numReviews = numReviews;
//    }
//
//    public int getHelpfulcount() {
//        return helpfulcount;
//    }
//
//    public void setHelpfulcount(int helpfulcount) {
//        this.helpfulcount = helpfulcount;
//    }
//
//    public int getTotalHelpfulNotHelpful() {
//        return totalHelpfulNotHelpful;
//    }
//
//    public void setTotalHelpfulNotHelpful(int totalHelpfulNotHelpful) {
//        this.totalHelpfulNotHelpful = totalHelpfulNotHelpful;
//    }
//
//    public int getRating() {
//        return rating;
//    }
//
//    public void setRating(int rating) {
//        this.rating = rating;
//    }
//
//    public String getAppReviewKey() {
//        return appReviewKey;
//    }
//
//    public void setAppReviewKey(String appReviewKey) {
//        this.appReviewKey = appReviewKey;
//    }
//
//    public String getReviewTitle() {
//        return reviewTitle;
//    }
//
//    public void setReviewTitle(String reviewTitle) {
//        this.reviewTitle = reviewTitle;
//    }
//
//    public String getReview() {
//        return review;
//    }
//
//    public void setReview(String review) {
//        this.review = review;
//    }
//
//    public long getDateCreated() {
//        return dateCreated;
//    }
//
//    public void setDateCreated(long dateCreated) {
//        this.dateCreated = dateCreated;
//    }
//
//    @Override
//    public String toString() {
//        return "AbusiveBean [numReviews=" + numReviews + ", helpfulcount="
//        + helpfulcount + ", totalHelpfulNotHelpful="
//        + totalHelpfulNotHelpful + ", rating=" + rating
//        + ", appReviewKey=" + appReviewKey + ", reviewTitle="
//        + reviewTitle + ", review=" + review + ", dateCreated="
//        + dateCreated + ", errorCode=" + errorCode + ", errorMsg="
//        + errorMsg + ", status=" + status + "]";
//    }
//
//
//}