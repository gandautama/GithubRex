package com.arjunalabs.android.githubrex.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ganda on 06/03/15.
 */
public class MstGroupMaterials {
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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @SerializedName("data")
    public Data data;

    public class Data {
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIdMstMaterialGroup() {
            return idMstMaterialGroup;
        }

        public void setIdMstMaterialGroup(int idMstMaterialGroup) {
            this.idMstMaterialGroup = idMstMaterialGroup;
        }

        public int getIdMstMaterial() {
            return idMstMaterial;
        }

        public void setIdMstMaterial(int idMstMaterial) {
            this.idMstMaterial = idMstMaterial;
        }

        //    "id": 1,
//            "idMstMaterialGroup": 1,
//            "idMstMaterial": "MAT01",
        @SerializedName("id")
        int id;
        @SerializedName("idMstMaterialGroup")
        int idMstMaterialGroup;
        @SerializedName("idMstMaterial")
        int idMstMaterial;

    }
}
