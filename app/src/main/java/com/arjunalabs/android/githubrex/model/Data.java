package com.arjunalabs.android.githubrex.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ganda on 25/02/15.
 *
 * http://square.github.io/retrofit/
 *
 * JASON DATA
 *
 "result": "ok",
 "data":
 "http_code": 200
*/
public class Data {
    @SerializedName("http_code")
    public int http_code;
    @SerializedName("result")
    public String result;
    @SerializedName("data")
    public DataInside[] data;


    public int getHttp_code() {
        return http_code;
    }

    public void setHttp_code(int http_code) {
        this.http_code = http_code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public DataInside[] getData() {
        return data;
    }

    public void setData(DataInside[] data) {
        this.data = data;
    }
    public class DataInside{
        @SerializedName("data1")
        String data1;

        public String getData1() {
            return data1;
        }

        public void setData1(String data1) {
            this.data1 = data1;
        }
    }
}
