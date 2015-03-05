package com.arjunalabs.android.githubrex.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ganda on 25/02/15.
 *
 *
"data":
 [
     {
         "id": 1,
         "idMstUserVde": "tommy.t",
         "idMstUserVdo": "pitoyo.s",
         "idMstUserVdr": "ihsan.t",
         "title": "Assignment 01",
         "periodStartDate": "2015-01-01",
         "periodEndDate": "2015-03-31",
         "state": 1,
         "createDate": "2015-01-01",
         "closeDate": null,
         "listTrxAssignmentSites":
          [
             {
             "id": 1,
                "mstSite": {
                     "id": "C002882554",
                     "address": "Address of WINNJAYA",
                     "name": "WINNJAYA",
                     "phone": "null",
                     "idMstBranchSites": 12,
                     "idMstGroupSites": 9,
                     "idMstRegionSites": 4,
                     "idMstTierSites": 9,
                     "idMstChannelSites": 1,
                     "idMstPrioritySites": 1,
                     "idMstCitySites": 9
                }
            }
         ]
    }
 ]
 */
public class AssignmentData {
    public int getHttp_code() {
        return http_code;
    }

    public void setHttp_code(int http_code) {
        this.http_code = http_code;
    }

    @SerializedName("http_code")
     int http_code;
    @SerializedName("result")
    String result;
    @SerializedName("data")

    public Assignment[] assignments;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Assignment[] getAssignments() {
        return assignments;
    }

    public void setData(Assignment[] assignments) {
        this.assignments = assignments;
    }

    public class Assignment {
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getIdMstUserVde() {
            return idMstUserVde;
        }

        public void setIdMstUserVde(String idMstUserVde) {
            this.idMstUserVde = idMstUserVde;
        }

        public String getIdMstUserVdo() {
            return idMstUserVdo;
        }

        public void setIdMstUserVdo(String idMstUserVdo) {
            this.idMstUserVdo = idMstUserVdo;
        }

        public String getIdMstUserVdr() {
            return idMstUserVdr;
        }

        public void setIdMstUserVdr(String idMstUserVdr) {
            this.idMstUserVdr = idMstUserVdr;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPeriodStartDate() {
            return periodStartDate;
        }

        public void setPeriodStartDate(String periodStartDate) {
            this.periodStartDate = periodStartDate;
        }

        public String getPeriodEndDate() {
            return periodEndDate;
        }

        public void setPeriodEndDate(String periodEndDate) {
            this.periodEndDate = periodEndDate;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getCloseDate() {
            return closeDate;
        }

        public void setCloseDate(String closeDate) {
            this.closeDate = closeDate;
        }

        public TrxAssSites[] getListTrxAssignmentSites() {
            return listTrxAssignmentSites;
        }

        public void setListTrxAssignmentSites(TrxAssSites[] listTrxAssignmentsSites) {
            this.listTrxAssignmentSites = listTrxAssignmentsSites;
        }

        @SerializedName("id")
        int      id;                        //  "id": 1,
        @SerializedName("idMstUserVde")
        String   idMstUserVde;              //  "idMstUserVde": "tommy.t",
        @SerializedName("idMstUserVdo")
        String   idMstUserVdo;              //  "idMstUserVdo": "pitoyo.s",
        @SerializedName("idMstUserVdr")
        String   idMstUserVdr;              //  "idMstUserVdo": "ihsan.t",
        @SerializedName("title")
        String   title;                     //  "title": "Assignment 01",
        @SerializedName("periodStartDate")
        String   periodStartDate;           //  "periodStartDate": "2015-01-01",
        @SerializedName("periodEndDate")
        String   periodEndDate;             //  "periodEndDate": "2015-03-31",
        @SerializedName("state")
        int      state;                     //  "state": 1,
        @SerializedName("createDate")
        String   createDate;                //  "createDate": "2015-01-01",
        @SerializedName("closeDate")
        String   closeDate;                 //  "closeDate": null,
        @SerializedName("listTrxAssignmentSites")
        TrxAssSites[] listTrxAssignmentSites;   //  "listTrxAssignmentSites":

    }

    public class TrxAssSites {
        public int getAssSitesId() {
            return AssSitesId;
        }

        public void setAssSitesId(int assSitesId) {
            AssSitesId = assSitesId;
        }

        public MstSite getMstSite() {
            return mstSite;
        }

        public void setMstSite(MstSite mstSite) {
            this.mstSite = mstSite;
        }

        @SerializedName("id")
        int AssSitesId;
        @SerializedName("mstSite")
        MstSite mstSite;
    }
  /*  "mstSite": {
        "id": "C002882554",
        "address": "Address of WINNJAYA",
        "name": "WINNJAYA",
        "phone": "null",

    }*/

    public class MstSite{
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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
        @SerializedName("address")
        String address;
        @SerializedName("name")
        String name;
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
