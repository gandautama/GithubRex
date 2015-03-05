package com.arjunalabs.android.githubrex.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ganda on 05/03/15.
 */
public class SubmitReport {
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

    public class TrxReportModelMaterials{
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIdTrxReportModels() {
            return idTrxReportModels;
        }

        public void setIdTrxReportModels(int idTrxReportModels) {
            this.idTrxReportModels = idTrxReportModels;
        }

        public String getIdMstMaterial() {
            return idMstMaterial;
        }

        public void setIdMstMaterial(String idMstMaterial) {
            this.idMstMaterial = idMstMaterial;
        }

        public int getActual() {
            return actual;
        }

        public void setActual(int actual) {
            this.actual = actual;
        }

        @SerializedName("id")
        int id;
        @SerializedName("idTrxReportModels")
        int idTrxReportModels;
        @SerializedName("idMstMaterial")
        String idMstMaterial;
        @SerializedName("actual")
        int actual;
    }

    public class Data{
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

        public String getIdMstModel() {
            return idMstModel;
        }

        public void setIdMstModel(String idMstModel) {
            this.idMstModel = idMstModel;
        }

        public int getDisplay() {
            return display;
        }

        public void setDisplay(int display) {
            this.display = display;
        }

        public TrxReportModelMaterials[] getListTrxReportModelMaterials() {
            return listTrxReportModelMaterials;
        }

        public void setListTrxReportModelMaterials(TrxReportModelMaterials[] listTrxReportModelMaterials) {
            this.listTrxReportModelMaterials = listTrxReportModelMaterials;
        }
        @SerializedName("id")
        int id;
        @SerializedName("idTrxAssignmentSites")
        int idTrxAssignmentSites;
        @SerializedName("idMstModel")
        String idMstModel;
        @SerializedName("display")
        int display;
        @SerializedName("listTrxReportModelMaterials")
        TrxReportModelMaterials[] listTrxReportModelMaterials;
    }
}
