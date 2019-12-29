package example.com.kotlintest.paserbean

import org.json.JSONObject


open class BaseBean {

    var errorCode: String? = null
    var errorMsg: String? = null
    var status = -1
    var apiVersion: String? = null

    protected fun parseErrorCode(jObj: JSONObject) {
        try {
            errorCode = jObj.getString(ERROR_CODE)
        } catch (e: Exception) {
            errorCode = null
            //e.printStackTrace();
        }

        try {
            errorMsg = jObj.getString(ERROR_MSG)
        } catch (e: Exception) {
            errorMsg = null
            //e.printStackTrace();
        }

    }

    companion object {

        val ERROR_CODE_UNKNOWN_ERROR = "1"
        val ERROR_CODE_INVALID_OR_MISSING_PARAMETERS = "4"
        val ERROR_CODE_KID_NOT_SIGNED_IN = "7"
        val ERROR_CODE_INVALID_OR_MISSING_JSON_INPUT = "9"
        val ERROR_CODE_TOO_MANY_FAILED_ATTEMPTS_WHILE_VALIDATING_PASSWORD = "10"
        val ERROR_CODE_UNABLE_TO_VALIDATE_PASSWORD_OR_PASSWORD_INCORRECT = "11"
        val ERROR_CODE_USER_ACCOUNT_DISABLED_OR_INVALID_USER = "12"
        val ERROR_CODE_AN_ERROR_OCCURRED_WHILE_TRYING_TO_RETRIEVE_USER_SETTINGS = "13"
        val ERROR_CODE_UNABLE_TO_SAVE_SESSION = "103"
        val ERROR_CODE_UNABLE_TO_SAVE_KIDS_LOGIN_TIMESTAMP = "104"
        val ERROR_CODE_UNABLE_TO_SAVE_KIDS_LOGOUT_TIMESTAMP = "105"
        val ERROR_CODE_INVALID_EXTERNAL_PROVIDER = "107"
        val ERROR_CODE_THE_EMAIL_ADDRESS_IS_ALREADY_USED_BY_ANOTHER_ACCOUNT = "202"
        val ERROR_CODE_INVALID_USER_NAME = "205"
        val ERROR_CODE_THE_USERNAME_IS_ALREADY_USED_BY_ANOTHER_ACCOUNT = "208"
        val ERROR_CODE_USERNAME_NOT_FOUND = "209"
        val ERROR_CODE_EMAIL_ADDRESS_NOT_FOUND = "210"
        val ERROR_CODE_UNABLE_TO_SET_VIEWED_STATUS = "213"
        val ERROR_CODE_AN_ERROR_OCCURED_WHILE_TRYING_TO_CREATE_PARENT_ACCOUNT = "215"
        val ERROR_CODE_AN_ERROR_OCCURED_WHILE_TRYING_TO_CREATE_KID_ACCOUNT = "216"
        val ERROR_CODE_AN_ERROR_OCCURED_WHILE_TRYING_TO_ADD_KID = "217"
        val ERROR_CODE_AN_ERROR_OCCURED_WHILE_TRYING_TO_DISPATCH_SIGNUP_EMAIL = "221"
        val API_VERSION = "appStoreAPIVersion"

        val STATUS = "status"
        val ERROR_CODE = "error_code"
        val ERROR = "error"
        val OK = "ok"
        val ERROR_MSG = "error_msg"
        val MSG = "msg"
        val SESSION_KEY = "session_key"
        val ZERO = "0"
        val APP_STORE_API_VERSION = "appStoreAPIVersion"

        /*used together*/
        val BALANCE = "balance"
        val CURRENCE = "currence"
        val CURRENCY = "currency"

        /*not sure but used together*/
        val REASON_CODE = "reasonCode"
        val CYBERSOURCE_SESSIONKEY = "cyberSourceSessionKey"

        var NOVERSION = "noVersion"
    }


}



//public class BaseBean {
//
//    public static final String ERROR_CODE_UNKNOWN_ERROR=											"1";
//    public static final String ERROR_CODE_INVALID_OR_MISSING_PARAMETERS=							"4";
//    public static final String ERROR_CODE_KID_NOT_SIGNED_IN=										"7";
//    public static final String ERROR_CODE_INVALID_OR_MISSING_JSON_INPUT=							"9";
//    public static final String ERROR_CODE_TOO_MANY_FAILED_ATTEMPTS_WHILE_VALIDATING_PASSWORD=		"10";
//    public static final String ERROR_CODE_UNABLE_TO_VALIDATE_PASSWORD_OR_PASSWORD_INCORRECT=		"11";
//    public static final String ERROR_CODE_USER_ACCOUNT_DISABLED_OR_INVALID_USER=					"12";
//    public static final String ERROR_CODE_AN_ERROR_OCCURRED_WHILE_TRYING_TO_RETRIEVE_USER_SETTINGS=	"13";
//    public static final String ERROR_CODE_UNABLE_TO_SAVE_SESSION=									"103";
//    public static final String ERROR_CODE_UNABLE_TO_SAVE_KIDS_LOGIN_TIMESTAMP=						"104";
//    public static final String ERROR_CODE_UNABLE_TO_SAVE_KIDS_LOGOUT_TIMESTAMP=						"105";
//    public static final String ERROR_CODE_INVALID_EXTERNAL_PROVIDER=								"107";
//    public static final String ERROR_CODE_THE_EMAIL_ADDRESS_IS_ALREADY_USED_BY_ANOTHER_ACCOUNT=		"202";
//    public static final String ERROR_CODE_INVALID_USER_NAME=										"205";
//    public static final String ERROR_CODE_THE_USERNAME_IS_ALREADY_USED_BY_ANOTHER_ACCOUNT=			"208";
//    public static final String ERROR_CODE_USERNAME_NOT_FOUND=										"209";
//    public static final String ERROR_CODE_EMAIL_ADDRESS_NOT_FOUND=									"210";
//    public static final String ERROR_CODE_UNABLE_TO_SET_VIEWED_STATUS=								"213";
//    public static final String ERROR_CODE_AN_ERROR_OCCURED_WHILE_TRYING_TO_CREATE_PARENT_ACCOUNT=	"215";
//    public static final String ERROR_CODE_AN_ERROR_OCCURED_WHILE_TRYING_TO_CREATE_KID_ACCOUNT=		"216";
//    public static final String ERROR_CODE_AN_ERROR_OCCURED_WHILE_TRYING_TO_ADD_KID=					"217";
//    public static final String ERROR_CODE_AN_ERROR_OCCURED_WHILE_TRYING_TO_DISPATCH_SIGNUP_EMAIL=	"221";
//    public static final String API_VERSION = "appStoreAPIVersion";
//
//    public static final String STATUS="status";
//    public static final String ERROR_CODE="error_code";
//    public static final String ERROR="error";
//    public static final String OK="ok";
//    public static final String ERROR_MSG="error_msg";
//    public static final String MSG="msg";
//    public static final String SESSION_KEY="session_key";
//    public static final String ZERO="0";
//    public static final String APP_STORE_API_VERSION="appStoreAPIVersion";
//
//    /*used together*/
//    public static final String BALANCE = "balance";
//    public static final String CURRENCE = "currence";
//    public static final String CURRENCY = "currency";
//
//    /*not sure but used together*/
//    public static final String REASON_CODE = "reasonCode";
//    public static final String CYBERSOURCE_SESSIONKEY = "cyberSourceSessionKey";
//
//    public static String apiVersion;
//
//    public String errorCode= null;
//    public String errorMsg= null;
//    public int status = -1;
//
//    public static String NOVERSION = "noVersion";
//
//
//    protected void parseErrorCode(JSONObject jObj){
//        try {
//            errorCode=jObj.getString(ERROR_CODE);
//        } catch (Exception e) {
//            errorCode=null;
//            //e.printStackTrace();
//        }
//        try {
//            errorMsg=jObj.getString(ERROR_MSG);
//        } catch (Exception e) {
//            errorMsg=null;
//            //e.printStackTrace();
//        }
//    }
//
//}