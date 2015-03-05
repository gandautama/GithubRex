package com.arjunalabs.android.githubrex.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ganda on 02/03/15.
 */
/*
{
        "result": "ok",
        "data": [
        {
            "id": 19,
            "idTrxAssignmentSites": 1,
            "report": "testuploadganda",
            "imagePath": "/home/dev/upload/1/The-real-cost-of-doing-nothing.png",
            "submitDate": "2015-03-04",
            "closeDate": null,
            "state": 0
        }
        ],
        "http_code": 200
}
*/
public class UploadPicture {
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

    public class Data{
        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIdTrxAssignmentSites() {
            return idTrxAssignmentSites;
        }

        public void setIdTrxAssignmentSites(int idTrxAssignmentSites) {
            this.idTrxAssignmentSites = idTrxAssignmentSites;
        }

        public String getReport() {
            return report;
        }

        public void setReport(String report) {
            this.report = report;
        }

        public String getImagePath() {
            return imagePath;
        }

        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }

        public String getSubmitDate() {
            return submitDate;
        }

        public void setSubmitDate(String submitDate) {
            this.submitDate = submitDate;
        }

        public String getCloseDate() {
            return closeDate;
        }

        public void setCloseDate(String closeDate) {
            this.closeDate = closeDate;
        }

        @SerializedName("id")
        int id;
        @SerializedName("idTrxAssignment")
        int idTrxAssignmentSites;
        @SerializedName("report")
        String report;
        @SerializedName("imagePath")
        String imagePath;
        @SerializedName("submitDate")
        String submitDate;
        @SerializedName("closeDate")
        String closeDate;
        @SerializedName("state")
        String state;
    }
}
