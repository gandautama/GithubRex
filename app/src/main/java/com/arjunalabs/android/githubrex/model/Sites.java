package com.arjunalabs.android.githubrex.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ganda on 27/02/15.
 */

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

        public int getIdMstBranchSites() {
            return idMstBranchSites;
        }

        public void setIdMstBranchSites(int idMstBranchSites) {
            this.idMstBranchSites = idMstBranchSites;
        }

        public int getIdMstGroupSites() {
            return idMstGroupSites;
        }

        public void setIdMstGroupSites(int idMstGroupSites) {
            this.idMstGroupSites = idMstGroupSites;
        }

        public int getIdMstRegionSites() {
            return idMstRegionSites;
        }

        public void setIdMstRegionSites(int idMstRegionSites) {
            this.idMstRegionSites = idMstRegionSites;
        }

        public int getIdMstTierSites() {
            return idMstTierSites;
        }

        public void setIdMstTierSites(int idMstTierSites) {
            this.idMstTierSites = idMstTierSites;
        }

        public int getIdMstChannelSites() {
            return idMstChannelSites;
        }

        public void setIdMstChannelSites(int idMstChannelSites) {
            this.idMstChannelSites = idMstChannelSites;
        }

        public int getIdMstPrioritySites() {
            return idMstPrioritySites;
        }

        public void setIdMstPrioritySites(int idMstPrioritySites) {
            this.idMstPrioritySites = idMstPrioritySites;
        }

        public int getIdMstCitySites() {
            return idMstCitySites;
        }

        public void setIdMstCitySites(int idMstCitySites) {
            this.idMstCitySites = idMstCitySites;
        }

        @SerializedName("id")
        String id;
        @SerializedName("name")
        String name;
        @SerializedName("address")
        String address;
        @SerializedName("phone")
        String phone;
        @SerializedName("idMstBranchSites")
        int idMstBranchSites;
        @SerializedName("idMstGroupSites")
        int idMstGroupSites;
        @SerializedName("idMstRegionSites")
        int idMstRegionSites;
        @SerializedName("idMstTierSites")
        int idMstTierSites;
        @SerializedName("idMstChannelSites")
        int idMstChannelSites;
        @SerializedName("idMstPrioritySites")
        int idMstPrioritySites;
        @SerializedName("idMstCitySites")
        int idMstCitySites;

    }


}