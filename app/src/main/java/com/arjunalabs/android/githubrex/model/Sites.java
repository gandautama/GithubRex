package com.arjunalabs.android.githubrex.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ganda on 27/02/15.
 */
//{
//        data: [
//            {
//                id: "C002882554",
//                name: "WINNJAYA",
//                address: "Address of WINNJAYA",
//                phone: "null",
//                mstBranchSites: {
//                    id: 12,
//                    name: "MEDAN"
//                },
//                mstGroupSites: {
//                    id: 9,
//                    name: "NON GROUP"
//                },
//                mstRegionSites: {
//                    id: 4,
//                    name: "WEST"
//                },
//                mstTierSites: {
//                    id: 9,
//                    name: "TRADITIONAL"
//                }
//            },
//        ]
//        http_code: 200,
//        result: "ok"
//        }
public class Sites {

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
        @SerializedName("id")
        String id;
        @SerializedName("name")
        String name;
        @SerializedName("address")
        String address;
        @SerializedName("phone")
        String phone;
        @SerializedName("mstBranchSites")
        MstBranchSites mstBranchSites;
        @SerializedName("mstGroupSites")
        MstGroupSites mstGroupSites;
        @SerializedName("mstRegionSites")
        MstRegionSites mstRegionSites;
        @SerializedName("mstTierSites")
        MstTierSites mstTierSites;

        public MstTierSites getMstTierSites() {
            return mstTierSites;
        }

        public void setMstTierSites(MstTierSites mstTierSites) {
            this.mstTierSites = mstTierSites;
        }

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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public MstBranchSites getMstBranchSites() {
            return mstBranchSites;
        }

        public void setMstBranchSites(MstBranchSites mstBranchSites) {
            this.mstBranchSites = mstBranchSites;
        }

        public MstGroupSites getMstGroupSites() {
            return mstGroupSites;
        }

        public void setMstGroupSites(MstGroupSites mstGroupSites) {
            this.mstGroupSites = mstGroupSites;
        }

        public MstRegionSites getMstRegionSites() {
            return mstRegionSites;
        }

        public void setMstRegionSites(MstRegionSites mstRegionSites) {
            this.mstRegionSites = mstRegionSites;
        }


    }

    public class MstBranchSites {
        @SerializedName("id")
        String id;
        @SerializedName("name")
        String name;

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
    }

    public class MstGroupSites {
        @SerializedName("id")
        String id;
        @SerializedName("name")
        String name;

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
    }

    public class MstRegionSites {
        @SerializedName("id")
        String id;
        @SerializedName("name")
        String name;

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
    }

    public class MstTierSites {
        @SerializedName("id")
        String id;
        @SerializedName("name")
        String name;

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
    }

}
