package com.arjunalabs.android.githubrex.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ganda on 26/02/15.
 */

//[{
//        id: "HT-F9750W",
//        name: "HiFi Home Theater 750w",
//        mstCategoryModels: {
//            id: 3,
//            name: "AUDIO VIDEO"
//        },
//        mstMaterialGroup: {
//            id: 3,
//            name: "Group for HOME_APP 01",
//            listMstGroupMaterials: [{
//                id: 9,
//                idMstMaterialGroup: 3,
//                idMstMaterial: "1",
//                mstMaterial: {
//                    id: "1",
//                    name: "Sample Material 01",
//                    idMstTypeMaterials: 1,
//                    quantity: 100,
//                    mstTypeMaterials: {
//                      id: 1,
//                      name: "POP"
//                    }
//                }
//            },
//          ]
//        },
//        mstTypeModels: {
//            id: 11,
//            name: "HIFI"
//        },
//        mstZoningModels: {
//            id: 3,
//            name: "SMART EXPERIENCE"
//        }
//    },
//]

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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @SerializedName("data")
    public Data data;


    public class Data{
        int id;
        String name;
        MstCategoryModels mstCategoryModels;
        MstMaterialGroup mstMaterialGroup;
        MstTypeModels mstTypeModels;
        MstZoningModels mstZoningModels;

    }


    public class MstCategoryModels{
        int id;
        String name;
    }

    public class MstMaterialGroup{
        MstGroupMaterials mstGroupMaterials;
        ListMstGroupMaterials listMstGroupMaterials;
        MstMaterial mstMaterial;
    }

    public class MstGroupMaterials{
        int id;
        int idMstMaterialGroup;
        int idMstMaterial;
        MstMaterial mstMaterial;
    }

    public class ListMstGroupMaterials{

    }

    public class MstMaterial{

    }

    public class MstTypeModels{

    }

    public class MstZoningModels{

    }
}
