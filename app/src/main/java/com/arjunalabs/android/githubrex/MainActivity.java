package com.arjunalabs.android.githubrex;

import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import com.arjunalabs.android.githubrex.model.AssignmentData;
import com.arjunalabs.android.githubrex.model.GitHubApi;
import com.arjunalabs.android.githubrex.model.Model;
import com.arjunalabs.android.githubrex.model.Sites;
import com.arjunalabs.android.githubrex.model.VersionApp;
import com.arjunalabs.android.githubrex.model.VersionData;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    private final String REPO_USER = "ReactiveX";
    private final String REPO_NAME = "RxJava";

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView) findViewById(R.id.result);

    }

    @Override
    protected void onResume() {
        super.onResume();
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://128.199.111.113:9000")
                .setClient(new OkClient())
                .build();

        final GitHubApi gitHubApi = restAdapter.create(GitHubApi.class);

        /*

        // ini ga mungkin jalan kan, krn di main thread
        List<Contributor> contributorList = gitHubApi.contributors(REPO_USER,REPO_NAME);
        for (Contributor contributor: contributorList) {
            contributionTextView.append(contributor.contributions + "\t" +contributor.login);
            contributionTextView.append("\n");
        }
        */


//        // basic version
//        Observable<List<Contributor>> obserVableContributorList = gitHubApi.observableContributors(REPO_USER, REPO_NAME);
//        obserVableContributorList
//                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<List<Contributor>>() {
//                    @Override
//                    public void call(List<Contributor> contributors) {
//                        contributionTextView.setText("");
//                        for (Contributor contributor: contributors) {
//                            contributionTextView.append(contributor.contributions + "\t" +contributor.login);
//                            contributionTextView.append("\n");
//                        }
//                    }
//                });

/**
 * http://square.github.io/retrofit/
 * http://blog.robinchutaux.com/blog/a-smart-way-to-use-retrofit/
 * http://reactivex.io/documentation/observable.html
 */
//        Observable<Data> observableData = gitHubApi.data("1234567890");
//        Subscription subscribe = observableData.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<Data>() {
//                    @Override
//                    public void call(Data data) {
//                        Data.DataInside[] datainside = data.getData();
//                        contributionTextView.setText(datainside[0].getData1());
//
//                    }
//                });


        //http://git.samsungmsci.com/baas/baas-manado/wikis/client-spec
        Observable<AssignmentData> observableAssignmentData = gitHubApi.oAssignment("1234567890");
        observableAssignmentData.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Action1<AssignmentData>() {
                @Override
                public void call(AssignmentData assignmentData) {
                    if (assignmentData != null) {
                        StringBuilder sb = new StringBuilder();
                        AssignmentData.Assignment[] assignments = assignmentData.getAssignments();
                        sb.append(result.getText().toString());
                        sb.append("---------------------\n");
                        sb.append("      Assignment\n");
                        sb.append("---------------------\n");
                        sb.append("http code:" + assignmentData.getHttp_code() + "\n");
                        sb.append("http result:" + assignmentData.getResult() + "\n");
                        if (assignments != null) {//dapat null euy
                            for (AssignmentData.Assignment assignment : assignments) {
                                sb.append("id:" + assignment.getId() + "\n");
                                sb.append("vde:" + assignment.getIdMstUserVde() + "\n");
                                sb.append("vdo:" + assignment.getIdMstUserVdo() + "\n");
                                sb.append("vdr:" + assignment.getIdMstUserVdr() + "\n");
                                sb.append("title:" + assignment.getTitle() + "\n");
                                sb.append("periodStartDate:" + assignment.getPeriodStartDate() + "\n");
                                sb.append("periodEndDate:" + assignment.getPeriodEndDate() + "\n");
                                sb.append("state:" + assignment.getState() + "\n");
                                sb.append("createDate:" + assignment.getCreateDate() + "\n");
                                AssignmentData.TrxAssSites[] trxAssSites = assignment.getListTrxAssignmentSites();
                                if (trxAssSites != null) {
                                    for (AssignmentData.TrxAssSites sites : trxAssSites) {
                                        sb.append("  id:" + sites.getAssSitesId() + "\n");
                                        if (sites.getMstSite() != null) {
                                            sb.append("  st  id      : " + sites.getMstSite().getId() + "\n");
                                            sb.append("  st  name    : " + sites.getMstSite().getName() + "\n");
                                            sb.append("  st  phone   : " + sites.getMstSite().getPhone() + "\n");
                                            sb.append("  st  address : " + sites.getMstSite().getAddress() + "\n");
                                            if (sites.getMstSite().getMstBranchSites() != null) {
                                                sb.append("  st  branch  id     :" + sites.getMstSite().getMstBranchSites().getId() + "\n");
                                                sb.append("  st  branch  name   :" + sites.getMstSite().getMstBranchSites().getName() + "\n");
                                            }
                                            if (sites.getMstSite().getMstBranchSites() != null) {
                                                sb.append("  st  group sites    :" + sites.getMstSite().getMstGroupSites().getId() + "\n");
                                                sb.append("  st  group sites    :" + sites.getMstSite().getMstGroupSites().getName() + "\n");
                                            }
                                            if (sites.getMstSite().getMstRegionSites() != null) {
                                                sb.append("  st  reg sites    :" + sites.getMstSite().getMstGroupSites().getId() + "\n");
                                                sb.append("  st  reg sites    :" + sites.getMstSite().getMstGroupSites().getName() + "\n");
                                            }
                                            if (sites.getMstSite().getMstTierSites() != null) {
                                                sb.append("  st  tier sites    :" + sites.getMstSite().getMstGroupSites().getId() + "\n");
                                                sb.append("  st  tier sites    :" + sites.getMstSite().getMstGroupSites().getName() + "\n");
                                            }
                                        } else {
                                            sb.append("got sites.getMstSite() null" + "\n");
                                        }
                                    }
                                } else {
                                    sb.append("trxAssSites null" + "\n");
                                }
                            }
                        } else {
                            sb.append("got Data Null" + "\n");
                        }
                        result.setText(sb.toString());
                    }

                }
            });

        Observable<VersionApp> observableVersionApp = gitHubApi.oVersionApp("1234567890");
        observableVersionApp.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Action1<VersionApp>() {
                @Override
                public void call(VersionApp versionApp) {
                    VersionApp.Data vApp = versionApp.getData();
                    if (vApp != null) {
                        String version = vApp.getVersion();
                        String link = vApp.getLink();
                        StringBuilder sb = new StringBuilder();
                        sb.append(result.getText().toString());
                        sb.append("---------------------\n");
                        sb.append("    Version App\n");
                        sb.append("---------------------\n");
                        sb.append("version:" + version + "\n");
                        sb.append("link:" + link + "\n");
                        result.setText(sb.toString());
                    }
                }
            });

        Observable<VersionData> observableVersionData = gitHubApi.oVersionData("1234567890");
        observableVersionData.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Action1<VersionData>() {
                @Override
                public void call(VersionData data) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(result.getText().toString());
                    sb.append("---------------------\n");
                    sb.append("     Version Data  \n");
                    sb.append("---------------------\n");
                    sb.append("http code:" + data.getHttp_code() + "\n");
                    sb.append("status:" + data.getResult() + "\n");
                    VersionData.Data vData = data.getData();
                    if (vData != null) {
                        String lastUpdate = vData.getLastUpdate();
                        String link = vData.getLink();
                        sb.append("last update:" + lastUpdate + "\n");
                        sb.append("link:" + link + "\n");
                    }
                    result.setText(sb.toString());
                }
            }
        );

        Observable<Model> observableModelData = gitHubApi.oModel("1234567890");
        observableModelData.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Action1<Model>() {
            @Override
            public void call(Model model) {
                if (model != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(result.getText().toString());
                    sb.append("---------------------\n");
                    sb.append("        MODEL\n");
                    sb.append("---------------------\n");
                    sb.append("http code:" + model.getHttp_code() + "\n");
                    sb.append("status:" + model.getResult() + "\n");

                    if (model.getData() != null) {
                        for (Model.Data data : model.getData()) {
                            sb.append("  model id       : " + data.getId() + "\n");
                            sb.append("  model name     : " + data.getName() + "\n");
                            sb.append("  category id    : " + data.getMstCategoryModels().getId()+ "\n");
                            sb.append("  category name  : " + data.getMstCategoryModels().getName() + "\n");
                            sb.append("  type id      : "+data.getMstCategoryModels().getId()+ "\n");
                            sb.append("  type name    : " + data.getName() + "\n");
                            sb.append("  zoning id    : "+data.getMstCategoryModels().getId()+ "\n");
                            sb.append("  zoning name  : " + data.getName() + "\n");
                            sb.append("  mat group id   : " + data.getMstMaterialGroup().getId()+ "\n");
                            sb.append("  mat group name : " + data.getMstMaterialGroup().getName() + "\n");
                            if (data.getMstMaterialGroup().getListMstGroupMaterials()!=null) {
                                for (Model.MstGroupMaterials matGroup : data.getMstMaterialGroup().getListMstGroupMaterials()) {
//                id: 9,
//                idMstMaterialGroup: 3,
//                idMstMaterial: "1",
                                    sb.append("    id             : " + matGroup.getId() + "\n");
                                    sb.append("    idMstGroup     : " + matGroup.getIdMstMaterialGroup() + "\n");
                                    sb.append("    idMstMaterial  : " + matGroup.getIdMstMaterial() + "\n");
//                    id: "1",
//                    name: "Sample Material 01",
//                    idMstTypeMaterials: 1,
//                    quantity: 100,
//                    mstTypeMaterials
                                    if (matGroup.getMstMaterial()!=null) {
                                        sb.append("    mat id:" + matGroup.getMstMaterial().getId()+"\n");
                                        sb.append("    mat name:" + matGroup.getMstMaterial().getName()+"\n");
                                        sb.append("    mat qty:" + matGroup.getMstMaterial().getQuantity()+"\n");
                                        sb.append("        type id  :"+ matGroup.getMstMaterial().getMstTypeMaterials().getId()+"\n");
                                        sb.append("        type name:"+ matGroup.getMstMaterial().getMstTypeMaterials().getName()+"\n");
                                    }
                                }
                            }
                            result.setText(sb.toString());
                        }
                    }
                }
            }
        });

        Observable<Sites> observableSites = gitHubApi.oSites("1234567890");
        observableSites.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Action1<Sites>() {
                @Override
                public void call(Sites sites) {
                    if (sites != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(result.getText().toString());
                        sb.append("---------------------\n");
                        sb.append("        Sites\n");
                        sb.append("---------------------\n");
                        sb.append("http code:" + sites.getHttp_code() + "\n");
                        sb.append("status:" + sites.getResult() + "\n");
                        Sites.Data vData[] = sites.getData();
                        if (vData != null) {
                            for (Sites.Data data : vData) {
                                sb.append("id         :" + data.getId() + "\n");
                                sb.append("name       :" + data.getName() + "\n");
                                sb.append("address    :" + data.getAddress()+ "\n");
                                sb.append("phone      :" + data.getPhone() + "\n");
                                if ( data.getMstBranchSites()!=null) {
                                    sb.append("br id      :" + data.getMstBranchSites().getId() + "\n");
                                    sb.append("br name    :" + data.getMstBranchSites().getName() + "\n");
                                }
                                if ( data.getMstGroupSites()!=null) {
                                    sb.append("grp st id  :" + data.getMstGroupSites().getId() + "\n");
                                    sb.append("grp st name:" + data.getMstGroupSites().getName() + "\n");
                                }
                                if ( data.getMstRegionSites()!=null) {
                                    sb.append("reg id     :" + data.getMstRegionSites().getId() + "\n");
                                    sb.append("reg name   :" + data.getMstRegionSites().getId() + "\n");
                                }
                                if ( data.getMstTierSites()!=null) {
                                    sb.append("tier id     :" + data.getMstTierSites().getId() + "\n");
                                    sb.append("tier name   :" + data.getMstTierSites().getId() + "\n");
                                }
                                result.setText(sb.toString());
                            }
                        }
                    }
                }
            },
             new Action1<Throwable>() {
                @Override
                public void call(Throwable throwable) {
                    StringBuilder sb= new StringBuilder();
                    sb.append(result.getText().toString());
                    sb.append ("error in"+throwable.getStackTrace());
                    result.setText(sb.toString());

                }
            }

        );

//        Observable<List<Contributor>> observableContributorList = gitHubApi.observableContributors(REPO_USER, REPO_NAME);
//        observableContributorList
//                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
//                .lift(new Observable.Operator<Contributor, List<Contributor>>() {
//                    @Override
//                    public Subscriber<? super List<Contributor>> call(final Subscriber<? super Contributor> subscriber) {
//
//                        return new Subscriber<List<Contributor>>() {
//                            @Override
//                            public void onCompleted() {
//                                subscriber.onCompleted();
//                            }
//
//                            @Override
//                            public void onError(Throwable e) {
//                                subscriber.onError(e);
//                            }
//
//                            @Override
//                            public void onNext(List<Contributor> contributors) {
//                                for (Contributor contributor: contributors) {
//                                    subscriber.onNext(contributor);
//                                }
//                            }
//                        };
//                    }
//                })
//                .forEach(new Action1<Contributor>() {
//                    @Override
//                    public void call(Contributor contributor) {
//                        Log.i("contributor", contributor.login);
//                        contributionTextView.append(contributor.contributions + "\t" + contributor.login);
//                        contributionTextView.append("\n");
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        contributionTextView.setText(throwable.getMessage());
//                    }
//                });


        //more advanced but sometimes is forbidden by the gitHub API 403
/*
        Observable<List<Contributor>> observableContributorList = gitHubApi.observableContributors(REPO_USER, REPO_NAME);
        observableContributorList
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .lift(new Observable.Operator<Contributor, List<Contributor>>() {
                    @Override
                    public Subscriber<? super List<Contributor>> call(final Subscriber<? super Contributor> subscriber) {

                        return new Subscriber<List<Contributor>>() {
                            @Override
                            public void onCompleted() {
                                subscriber.onCompleted();
                            }

                            @Override
                            public void onError(Throwable e) {
                                subscriber.onError(e);
                            }

                            @Override
                            public void onNext(List<Contributor> contributors) {
                                for (Contributor contributor : contributors) {
                                    subscriber.onNext(contributor);
                                }
                            }
                        };
                    }
                })
                .flatMap(new Func1<Contributor, Observable<User>>() {
                    @Override
                    public Observable<User> call(Contributor contributor) {
                        Log.i("contributor", contributor.login);
                        return gitHubApi.user(contributor.login).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
                    }
                })
                .subscribe(new Observer<User>() {
                    @Override
                    public void onCompleted() {
                        contributionTextView.append("Done");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("error", e.getMessage());
                        contributionTextView.append(e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(User user) {
                        Log.i("user", user.name);
                        contributionTextView.append(user.name);
                        contributionTextView.append("\n");
                    }
                });
*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
