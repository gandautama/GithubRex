package com.arjunalabs.android.githubrex.model;

import java.util.List;

import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Path;
import retrofit.mime.TypedFile;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedString;
import rx.Observable;

/**
 * Created by bobbyadiprabowo on 2/3/15.
 */
public interface GitHubApi {


    @GET("/manado/data/assignments")
    Observable<AssignmentData> oAssignment(
        @Header("X-BB-SESSION") String session
    );

    @GET("/manado/version/app")
    Observable<VersionApp> oVersionApp(
         @Header("X-BB-SESSION") String session
    );

    @GET("/manado/version/data")
    Observable<VersionData> oVersionData(
         @Header("X-BB-SESSION") String session
    );

    @GET("/manado/data/models")
    Observable<Model> oModel(
         @Header("X-BB-SESSION") String session
    );

    @GET("/manado/data/sites")
    Observable<Sites> oSites(
        @Header("X-BB-SESSION") String session
    );


    @FormUrlEncoded
    @POST("/login")
    Observable<Login>
    oLogin( @Field("appcode") String appcode,
            @Field("username") String username,
            @Field("password") String password
            );

    @POST("/logout")
    Observable<Logout>
    oLogout( @Header("X-BAASBOX-APPCODE") String appcode,
             @Header("X-BB-SESSION") String session
    );

    @Multipart
    @POST("/manado/assignment/evidence")
    Observable<UploadPicture>
    oUploadPicture(
            @Header("X-BB-SESSION") String session,
            @Part("file") TypedFile fileUploaded,
            @Part("evidenceData") TypedString evidenceData
    );

    @POST("/manado/data/save")
    Observable<SubmitReport>
    oSubmitReport( @Header("X-BB-SESSION") String session,
             @Header("Content-Type") String contentType,
             @Body TypedString body
    );

    @GET("/manado/MstZoningModels/list")
    Observable<MstZoningModels> oMstZoningModelsList(
            @Header("X-BB-SESSION") String session
    );
    @GET("/manado/MstMaterialGroup/list")
    Observable<MstMaterialGroup> oMstMaterialGroupList(
            @Header("X-BB-SESSION") String session
    );
    @GET("/manado/MstGroupMaterials/list")
    Observable<MstGroupMaterials> oMstGroupMaterialsList(
            @Header("X-BB-SESSION") String session
    );
    @GET("/manado/MstCategoryModels/list")
    Observable<MstCategoryModels> MstCategoryModelsList(
            @Header("X-BB-SESSION") String session
    );
    @GET("/manado/MstMaterial/list")
    Observable<MstMaterial> oMstMaterialList(
            @Header("X-BB-SESSION") String session
    );

}
