package com.arjunalabs.android.githubrex;

import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import com.arjunalabs.android.githubrex.model.AssignmentData;
import com.arjunalabs.android.githubrex.model.Contributor;
import com.arjunalabs.android.githubrex.model.Data;
import com.arjunalabs.android.githubrex.model.GitHubApi;
import com.arjunalabs.android.githubrex.model.User;
import com.arjunalabs.android.githubrex.model.VersionData;
import com.google.gson.annotations.SerializedName;

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
                .setEndpoint("http://107.102.182.83:9000")
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
        Observable<AssignmentData> observableAssignmentData = gitHubApi.assignment("1234567890");
        Subscription subscribe = observableAssignmentData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<AssignmentData>() {
                    @Override
                    public void call(AssignmentData assignmentData) {
                        StringBuilder sb = new StringBuilder();
                        if (assignmentData != null) {
                            AssignmentData.Assignment[] assignments = assignmentData.getAssignments();
                            sb.append("http code:"+assignmentData.getHttp_code()+"\n");
                            sb.append("http result:"+assignmentData.getResult()+"\n");
                            if (assignments!=null) {//dapat null euy
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
                                        if (trxAssSites!=null){
                                            for (AssignmentData.TrxAssSites sites: trxAssSites){
                                                sb.append("  id:" + sites.getAssSitesId()+ "\n");
                                                if (sites.getMstSite()!=null) {
                                                    sb.append("  st  id      : " + sites.getMstSite().getId()+ "\n");
                                                    sb.append("  st  name    : " + sites.getMstSite().getName()+ "\n");
                                                    sb.append("  st  phone   : " + sites.getMstSite().getPhone()+ "\n");
                                                    sb.append("  st  address : " + sites.getMstSite().getAddress()+ "\n");
                                                    if (sites.getMstSite().getMstBranchSites()!= null) {
                                                        sb.append("  st  branch  id     :" + sites.getMstSite().getMstBranchSites().getId()+ "\n");
                                                        sb.append("  st  branch  name   :" + sites.getMstSite().getMstBranchSites().getName()+ "\n");
                                                    }
                                                    if (sites.getMstSite().getMstBranchSites()!= null) {
                                                        sb.append("  st  group sites    :" + sites.getMstSite().getMstGroupSites().getId()+ "\n");
                                                        sb.append("  st  group sites    :" + sites.getMstSite().getMstGroupSites().getName()+ "\n");
                                                    }
                                                    if (sites.getMstSite().getMstRegionSites()!= null) {
                                                        sb.append("  st  reg sites    :" + sites.getMstSite().getMstGroupSites().getId()+ "\n");
                                                        sb.append("  st  reg sites    :" + sites.getMstSite().getMstGroupSites().getName()+ "\n");
                                                    }
                                                    if (sites.getMstSite().getMstTierSites()!=null) {
                                                        sb.append("  st  tier sites    :" + sites.getMstSite().getMstGroupSites().getId()+ "\n");
                                                        sb.append("  st  tier sites    :" + sites.getMstSite().getMstGroupSites().getName()+ "\n");
                                                    }
                                                }else{
                                                    sb.append("got sites.getMstSite() null"+ "\n");
                                                }
                                            }
                                        }
                                        else{
                                            sb.append("trxAssSites null"+ "\n");
                                        }
                                }
                            } else {
                                sb.append("got Data Null"+ "\n");
                            }
                        }
                        result.setText(sb.toString());
                    }
                });

                Observable<VersionData> observableVersion = gitHubApi.version("1234567890");
                Subscription subscribe2 = observableVersion.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<VersionData>() {
                    @Override
                    public void call(VersionData data) {
                        VersionData.Data vData = data.getData();
                        if (vData!=null) {
                            String version=vData.getVersion();
                            String link = vData.getLink();
                            StringBuilder sb = new StringBuilder();
                            sb.append( result.getText().toString());
                            sb.append("---------------------\n");
                            sb.append("version:"+version+"\n");
                            sb.append("link:"+link+"\n");
                            result.setText(sb.toString());
                        }
                    }
                });


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
                                for (Contributor contributor: contributors) {
                                    subscriber.onNext(contributor);
                                }
                            }
                        };
                    }
                })
                .forEach(new Action1<Contributor>() {
                    @Override
                    public void call(Contributor contributor) {
                        Log.i("contributor", contributor.login);
                        contributionTextView.append(contributor.contributions + "\t" + contributor.login);
                        contributionTextView.append("\n");
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        contributionTextView.setText(throwable.getMessage());
                    }
                });

*/
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
