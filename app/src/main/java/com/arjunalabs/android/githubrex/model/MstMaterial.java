package com.arjunalabs.android.githubrex.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ganda on 06/03/15.
 */

public class MstMaterial {
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
    //"id": "MAT07",
//        "name": "Material 07 DEMO_CONTENT",
//        "idMstTypeMaterials": 2,
//        "quantity": 67,
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

        public int getIdMstTypeMaterials() {
            return IdMstTypeMaterials;
        }

        public void setIdMstTypeMaterials(int idMstTypeMaterials) {
            IdMstTypeMaterials = idMstTypeMaterials;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        @SerializedName("id")
        String  id;
        @SerializedName("name")
        String name;
        @SerializedName("IdMstTypeMaterials")
        int IdMstTypeMaterials;
        @SerializedName("quantity")
        int quantity;
    }

}
