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


        //        id: "HT-F9750W",
//        name: "HiFi Home Theater 750w",
//        mstCategoryModels: {
//        mstMaterialGroup: {
//        mstTypeModels: {
//        mstZoningModels: {
        @SerializedName("id")
        String id;
        @SerializedName("name")
        String name;
        @SerializedName("mstCategoryModels")
        MstCategoryModels mstCategoryModels;
        @SerializedName("mstMaterialGroup")
        MstMaterialGroup mstMaterialGroup;
        @SerializedName("mstTypeModels")
        MstTypeModels mstTypeModels;

        public MstZoningModels getMstZoningModels() {
            return mstZoningModels;
        }

        public void setMstZoningModels(MstZoningModels mstZoningModels) {
            this.mstZoningModels = mstZoningModels;
        }

        public MstTypeModels getMstTypeModels() {
            return mstTypeModels;
        }

        public void setMstTypeModels(MstTypeModels mstTypeModels) {
            this.mstTypeModels = mstTypeModels;
        }

        public MstMaterialGroup getMstMaterialGroup() {
            return mstMaterialGroup;
        }

        public void setMstMaterialGroup(MstMaterialGroup mstMaterialGroup) {
            this.mstMaterialGroup = mstMaterialGroup;
        }

        public MstCategoryModels getMstCategoryModels() {
            return mstCategoryModels;
        }

        public void setMstCategoryModels(MstCategoryModels mstCategoryModels) {
            this.mstCategoryModels = mstCategoryModels;
        }

        @SerializedName("mstZoningModels")
        MstZoningModels mstZoningModels;

    }


    public class MstCategoryModels {
        //      id: 3,
//      name: "AUDIO VIDEO"
        @SerializedName("id")
        int id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @SerializedName("name")
        String name;
    }

    public class MstMaterialGroup {
//            id: 3,
//            name: "Group for HOME_APP 01",
//            listMstGroupMaterials: [{

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public MstGroupMaterials[] getListMstGroupMaterials() {
            return listMstGroupMaterials;
        }

        public void setListMstGroupMaterials(MstGroupMaterials[] listMstGroupMaterials) {
            this.listMstGroupMaterials = listMstGroupMaterials;
        }

        @SerializedName("id")
        int id;
        @SerializedName("name")
        String name;
        @SerializedName("listMstGroupMaterials")
        MstGroupMaterials[] listMstGroupMaterials;
    }

    public class MstGroupMaterials {
        //                id: 9,
//                idMstMaterialGroup: 3,
//                idMstMaterial: "1",
//                mstMaterial: {
        @SerializedName("id")
        int id;
        @SerializedName("idMstMaterialGroup")
        int idMstMaterialGroup;

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

        public MstMaterial getMstMaterial() {
            return mstMaterial;
        }

        public void setMstMaterial(MstMaterial mstMaterial) {
            this.mstMaterial = mstMaterial;
        }

        @SerializedName("idMstMaterial")
        int idMstMaterial;
        @SerializedName("mstMaterial")
        MstMaterial mstMaterial;
    }

    public class MstMaterial {
        //                    id: "1",
//                    name: "Sample Material 01",
//                    idMstTypeMaterials: 1,
//                    quantity: 100,
//                    mstTypeMaterials
        @SerializedName("id")
        int id;
        @SerializedName("name")
        String name;
        @SerializedName("idMstTypeMaterial")
        int idMstTypeMaterial;
        @SerializedName("quantity")
        int quantity;
        @SerializedName("mstTypeMaterials")
        MstTypeMaterials mstTypeMaterials;

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getIdMstTypeMaterial() {
            return idMstTypeMaterial;
        }

        public void setIdMstTypeMaterial(int idMstTypeMaterial) {
            this.idMstTypeMaterial = idMstTypeMaterial;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }



        public MstTypeMaterials getMstTypeMaterials() {
            return mstTypeMaterials;
        }

        public void setMstTypeMaterials(MstTypeMaterials mstTypeMaterials) {
            this.mstTypeMaterials = mstTypeMaterials;
        }


    }

    public class MstTypeMaterials {
        //                      id: 1,
//                      name: "POP"
        @SerializedName("id")
        int id;

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @SerializedName("name")
        String Name;
    }

    public class MstTypeModels {
        //            id: 11,
//            name: "HIFI"
        @SerializedName("id")
        int id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @SerializedName("name")
        String name;
    }

    public class MstZoningModels {
        //            id: 3,
//            name: "SMART EXPERIENCE"
        @SerializedName("id")
        int id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @SerializedName("name")
        String name;
    }
}
