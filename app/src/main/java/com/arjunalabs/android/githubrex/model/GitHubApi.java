package com.arjunalabs.android.githubrex.model;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by bobbyadiprabowo on 2/3/15.
 */
public interface GitHubApi {

    @GET("/rX-SBAAS-APPCODEepos/{owner}/{repo}/contributors")
    List<Contributor> contributors(
            @Path("owner") String owner,
            @Path("repo") String repo);

    @GET("/repos/{owner}/{repo}/contributors")
    Observable<List<Contributor>> observableContributors(
            @Path("owner") String owner,
            @Path("repo") String repo);

    @GET("/users/{user}")
    Observable<User> user(
            @Path("user") String user
    );

    @GET("/plugin/tests.hello")
    Observable<Data> data(@Header("X-SBAAS-APPCODE") String appcode
    );

    @GET("/plugin/menado.assignments")
    Observable<AssignmentData> oAssignment(@Header("X-SBAAS-APPCODE") String appcode
    );

    @GET("/plugin/menado.versionapp")
    Observable<VersionApp> oVersionApp(@Header("X-SBAAS-APPCODE") String appcode
    );

    @GET("/plugin/menado.versiondata")
    Observable<VersionData> oVersionData(@Header("X-SBAAS-APPCODE") String appcode
    );

    @GET("/plugin/menado.models")
    Observable<Model> oModel(@Header("X-SBAAS-APPCODE") String appcode);

    @GET("/plugin/menado.sites")
    Observable<Sites> oSites(@Header("X-SBAAS-APPCODE") String appcode);

}
