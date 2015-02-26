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
                     "name": "WINNJAYA",
                     "address": "Address of WINNJAYA",
                     "phone": "null",
                     "mstBranchSites": {
                         "id": 12,
                         "name": "MEDAN"
                     },
                     "mstGroupSites": {
                         "id": 9,
                         "name": "NON GROUP"
                     },
                     "mstRegionSites": {
                         "id": 4,
                         "name": "WEST"
                     },
                     "mstTierSites": {
                         "id": 9,
                         "name": "TRADITIONAL"
                     }
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @SerializedName("result")
     String result;

    public Assignment[] getAssignments() {
        return assignments;
    }

    public void setData(Assignment[] assignments) {
        this.assignments = assignments;
    }

    @SerializedName("data")
    public Assignment[] assignments;

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

    public class MstSite{
        public String getId() {
            return id;
        }

        public void setId(String mstSitesId) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String mstName) {
            this.name = mstName;
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

        public MstTierSites getMstTierSites() {
            return mstTierSites;
        }

        public void setMstTierSites(MstTierSites mstTierSites) {
            this.mstTierSites = mstTierSites;
        }

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
    }

    public class MstBranchSites{
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
            this.name=name;
        }

        @SerializedName("id")
        int id;
        @SerializedName("name")
        String name;
    }

    public class MstGroupSites{
        public int getId() {
            return id;
        }

        public void setId(int mstGroupSitesId) {
            this.id = mstGroupSitesId;
        }

        public String getName() {
            return name;
        }

        public void setName (String name) {
            this.name = name;
        }

        @SerializedName("id")
        int id;
        @SerializedName("name")
        String name;
    }

    public class MstRegionSites{
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

        @SerializedName("id")
        int id;
        @SerializedName("name")
        String name;
    }

    public class MstTierSites {
        public int getId() {
            return id;
        }

        public void setId(int mstTierSitesId) {
            this.id = mstTierSitesId;
        }

        public String getName() {
            return name;
        }

        public void setName(String mstTierSitesName) {
            this.name = mstTierSitesName;
        }

        @SerializedName("id")
        int id;
        @SerializedName("name")
        String name;
    }

}
