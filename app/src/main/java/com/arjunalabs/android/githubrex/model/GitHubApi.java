package com.arjunalabs.android.githubrex.model;

import java.util.List;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Path;
import retrofit.mime.TypedFile;
import retrofit.mime.TypedString;
import rx.Observable;

/**
 * Created by bobbyadiprabowo on 2/3/15.
 */
public interface GitHubApi {


    @GET("/menado/data/assignment")
    Observable<AssignmentData> oAssignment(//@Header("X-BAASBOX-APPCODE") String appcode,
                                           @Header("X-BB-SESSION") String session
    );

    @GET("/manado/version/app")
    Observable<VersionApp> oVersionApp(//@Header("X-BAASBOX-APPCODE") String appcode,
                                       @Header("X-BB-SESSION") String session
    );

    @GET("/manado/version/data")
    Observable<VersionData> oVersionData(//@Header("X-BAASBOX-APPCODE") String appcode,
                                         @Header("X-BB-SESSION") String session
    );

    @GET("/manado/data/models")
    Observable<Model> oModel(//@Header("X-BAASBOX-APPCODE") String appcode,
                             @Header("X-BB-SESSION") String session);

    @GET("/manado/data/sites")
    Observable<Sites> oSites(//@Header("X-BAASBOX-APPCODE") String appcode,
                             @Header("X-BB-SESSION") String session);


    @FormUrlEncoded
    @POST("/login")
    Observable<Login>
    oLogin( @Field("username") String username,
            @Field("password") String password,
            @Field("appcode") String appcode
            );

    @POST("/logout")
    Observable<Logout>
    oLogout( @Header("X-BAASBOX-APPCODE") String appcode,
             @Header("X-BB-SESSION") String session
    );

    @Multipart
    @POST("/file")
    Observable<UploadPicture>
    oPicture(@Part("file") TypedFile fileUploaded,
             @Part("attachedData") TypedString infostring,
             @Part("acl") TypedString acl,
             @Header("X-BAASBOX-APPCODE") String appcode,
             @Header("X-BB-SESSION") String session);

}
