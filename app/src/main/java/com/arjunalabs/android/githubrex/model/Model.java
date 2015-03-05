package com.arjunalabs.android.githubrex.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ganda on 26/02/15.
 */


public class Model {
    public int getHttp_code() {
        return http_code;
    }

    public void setHttp_code(int http_code) {
        this.http_code = http_code;
    }

    @SerializedName("http_code")
    int http_code;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @SerializedName("result")
    String result;

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }

    @SerializedName("data")
    public Data[] data;


    public class Data {
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


//        "id": "75H6400",
//                "name": "75 Samsung Standard TV",
//                "idMstMaterialGroup": 2,
//                "idMstCategoryModels": 1,
//                "idMstZoningModels": 2,
//                "idMstTypeModels": 15
        @SerializedName("id")
        String id;
        @SerializedName("name")
        String name;
        mstCategoryModels;
        mstMaterialGroup



        }


    }




}
