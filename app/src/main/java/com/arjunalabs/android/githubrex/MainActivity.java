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
import retrofit.mime.TypedString;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import com.arjunalabs.android.githubrex.model.AssignmentData;
import com.arjunalabs.android.githubrex.model.GitHubApi;
import com.arjunalabs.android.githubrex.model.Login;
import com.arjunalabs.android.githubrex.model.Logout;
import com.arjunalabs.android.githubrex.model.Model;
import com.arjunalabs.android.githubrex.model.Sites;
import com.arjunalabs.android.githubrex.model.VersionApp;
import com.arjunalabs.android.githubrex.model.VersionData;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    private final String REPO_USER = "ReactiveX";
    private final String REPO_NAME = "RxJava";

    private TextView result;

    String xBbSession = "";
    final String appCode = "manado";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView) findViewById(R.id.result);

    }

    public interface INext {
        public void Finish(final GitHubApi api);

        public void Error(Throwable t);
    }

    public void FoundError(GitHubApi api, Throwable throwable) {
        doLogout(api, new INext() {
            @Override
            public void Finish(GitHubApi api) {
                StringBuilder sb = new StringBuilder();
                sb.append(result.getText().toString());
                sb.append("finished getting data");
                result.setText(sb.toString());
            }

            @Override
            public void Error(Throwable t) {
                StringBuilder sb = new StringBuilder();
                sb.append(result.getText().toString());
                sb.append("error, " + t.getMessage());
                result.setText(sb.toString());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://107.102.182.83:9000")
                .setClient(new OkClient())
                .build();

        final GitHubApi gitHubApi = restAdapter.create(GitHubApi.class);


/**
 * http://square.github.io/retrofit/
 * http://blog.robinchutaux.com/blog/a-smart-way-to-use-retrofit/
 * http://reactivex.io/documentation/observable.html
 */


//http://git.samsungmsci.com/baas/baas-manado/wikis/client-spec

        doLogin(gitHubApi, new INext() {
            //login
            @Override
            public void Finish(GitHubApi api) {
//get version data
                doGetVersionApp(api, new INext() {
                    @Override
                    public void Finish(GitHubApi api) {
//get version app
                        doGetVersionData(api, new INext() {
                            @Override
                            public void Finish(GitHubApi api) {
//get assignment
                                doGetAssignment(api, new INext() {
                                    @Override
                                    public void Finish(GitHubApi api) {
//get material
                                        doGetModel(api, new INext() {
                                            @Override
                                            public void Finish(GitHubApi api) {
//get sites
                                                doGetSites(api, new INext() {
                                                    @Override
                                                    public void Finish(GitHubApi api) {
//logout
                                                        doLogout(api, new INext() {
                                                            @Override
                                                            public void Finish(GitHubApi api) {
                                                                StringBuilder sb = new StringBuilder();
                                                                sb.append(result.getText().toString());
                                                                sb.append("finished getting data");
                                                                result.setText(sb.toString());
                                                            }

                                                            @Override
                                                            public void Error(Throwable t) {
                                                                StringBuilder sb = new StringBuilder();
                                                                sb.append(result.getText().toString());
                                                                sb.append("error, " + t.getMessage());
                                                                result.setText(sb.toString());
                                                            }
                                                        });
                                                    }

                                                    @Override
                                                    public void Error(Throwable t) {
                                                        FoundError(gitHubApi, t);
                                                    }
                                                });
                                            }

                                            @Override
                                            public void Error(Throwable t) {
                                                FoundError(gitHubApi, t);
                                            }
                                        });
                                    }

                                    @Override
                                    public void Error(Throwable t) {
                                        FoundError(gitHubApi, t);
                                    }
                                });
                            }

                            @Override
                            public void Error(Throwable t) {
                                FoundError(gitHubApi, t);
                            }
                        });
                    }

                    @Override
                    public void Error(Throwable t) {
                        FoundError(gitHubApi, t);
                    }

                });
            }

            @Override
            public void Error(Throwable t) {
                StringBuilder sb = new StringBuilder();
                sb.append("error, " + t.getMessage());
                result.setText(sb.toString());
            }

        });


    }


    private void doGetSites(final GitHubApi gitHubApi, final INext next) {
        final GitHubApi api = gitHubApi;
        Observable<Sites> observableSites = gitHubApi.oSites(xBbSession/*,"1234567890"*/);
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
                                               sb.append("address    :" + data.getAddress() + "\n");
                                               sb.append("phone      :" + data.getPhone() + "\n");
                                               if (data.getMstBranchSites() != null) {
                                                   sb.append("br id      :" + data.getMstBranchSites().getId() + "\n");
                                                   sb.append("br name    :" + data.getMstBranchSites().getName() + "\n");
                                               }
                                               if (data.getMstGroupSites() != null) {
                                                   sb.append("grp st id  :" + data.getMstGroupSites().getId() + "\n");
                                                   sb.append("grp st name:" + data.getMstGroupSites().getName() + "\n");
                                               }
                                               if (data.getMstRegionSites() != null) {
                                                   sb.append("reg id     :" + data.getMstRegionSites().getId() + "\n");
                                                   sb.append("reg name   :" + data.getMstRegionSites().getId() + "\n");
                                               }
                                               if (data.getMstTierSites() != null) {
                                                   sb.append("tier id     :" + data.getMstTierSites().getId() + "\n");
                                                   sb.append("tier name   :" + data.getMstTierSites().getId() + "\n");
                                               }
                                               result.setText(sb.toString());
                                           }
                                       }
                                   }
                               }
                           }, new Action1<Throwable>() {
                               @Override
                               public void call(Throwable throwable) {
                                   next.Error(throwable);
                               }
                           },
                        new Action0() {
                            @Override
                            public void call() {
                                next.Finish(gitHubApi);
                            }
                        }

                );
    }

    private void doGetModel(final GitHubApi gitHubApi, final INext next) {
        Observable<Model> observableModelData = gitHubApi.oModel(xBbSession);
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
                                               sb.append("  category id    : " + data.getMstCategoryModels().getId() + "\n");
                                               sb.append("  category name  : " + data.getMstCategoryModels().getName() + "\n");
                                               sb.append("  type id      : " + data.getMstCategoryModels().getId() + "\n");
                                               sb.append("  type name    : " + data.getName() + "\n");
                                               sb.append("  zoning id    : " + data.getMstCategoryModels().getId() + "\n");
                                               sb.append("  zoning name  : " + data.getName() + "\n");
                                               sb.append("  mat group id   : " + data.getMstMaterialGroup().getId() + "\n");
                                               sb.append("  mat group name : " + data.getMstMaterialGroup().getName() + "\n");
                                               if (data.getMstMaterialGroup().getListMstGroupMaterials() != null) {
                                                   for (Model.MstGroupMaterials matGroup : data.getMstMaterialGroup().getListMstGroupMaterials()) {

                                                       sb.append("    id             : " + matGroup.getId() + "\n");
                                                       sb.append("    idMstGroup     : " + matGroup.getIdMstMaterialGroup() + "\n");
                                                       sb.append("    idMstMaterial  : " + matGroup.getIdMstMaterial() + "\n");

                                                       if (matGroup.getMstMaterial() != null) {
                                                           sb.append("    mat id:" + matGroup.getMstMaterial().getId() + "\n");
                                                           sb.append("    mat name:" + matGroup.getMstMaterial().getName() + "\n");
                                                           sb.append("    mat qty:" + matGroup.getMstMaterial().getQuantity() + "\n");
                                                           sb.append("        type id  :" + matGroup.getMstMaterial().getMstTypeMaterials().getId() + "\n");
                                                           sb.append("        type name:" + matGroup.getMstMaterial().getMstTypeMaterials().getName() + "\n");
                                                       }
                                                   }
                                               }
                                               result.setText(sb.toString());
                                           }
                                       }
                                   }
                               }
                           }, new Action1<Throwable>() {
                               @Override
                               public void call(Throwable throwable) {
                                   next.Error(throwable);
                               }
                           },
                        new Action0() {
                            @Override
                            public void call() {
                                next.Finish(gitHubApi);
                            }
                        });
    }

    private void doGetVersionData(final GitHubApi gitHubApi, final INext next) {
        Observable<VersionData> observableVersionData = gitHubApi.oVersionData(xBbSession/*,"1234567890"*/);
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
                           }, new Action1<Throwable>() {
                               @Override
                               public void call(Throwable throwable) {
                                   next.Error(throwable);
                               }
                           },
                        new Action0() {
                            @Override
                            public void call() {
                                next.Finish(gitHubApi);
                            }
                        }
                );
    }

    private void doGetVersionApp(final GitHubApi gitHubApi, final INext next) {
        Observable<VersionApp> observableVersionApp = gitHubApi.oVersionApp(xBbSession/*"1234567890"*/);
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
                           },
                        new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                next.Error(throwable);
                            }
                        },
                        new Action0() {
                            @Override
                            public void call() {
                                next.Finish(gitHubApi);
                            }
                        });
    }

    private void doGetAssignment(final GitHubApi gitHubApi, final INext next) {
        Observable<AssignmentData> observableAssignmentData = gitHubApi.oAssignment(/*appCode,*/ xBbSession);
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
                           },
                        new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                next.Error(throwable);
                            }
                        },
                        new Action0() {
                            @Override
                            public void call() {
                                next.Finish(gitHubApi);
                            }
                        }
                );
    }

    private void doLogin(final GitHubApi gitHubApi, final INext next) {
        Observable<Login> observableLogin = gitHubApi.oLogin(appCode, "ihsan.t", "password");
        observableLogin.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Action1<Login>() {
                            @Override
                            public void call(Login login) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(result.getText().toString());
                                sb.append("---------------------\n");
                                sb.append("     Login info \n");
                                sb.append("---------------------\n");
                                sb.append("http code:" + login.getHttp_code() + "\n");
                                sb.append("status:" + login.getResult() + "\n");

                                Login.Data vData = login.getData();
                                if (vData != null) {
                                    xBbSession = vData.getxBbSession();
                                    sb.append("session:" + xBbSession + "\n");
                                    Login.User user = vData.getUser();
                                    if (vData != null) {
                                        sb.append("user name:" + user.getName() + "\n");
                                        sb.append("user status:" + user.getStatus() + "\n");

                                        if (user.getRoles() != null) {
                                            for (Login.Role role : user.getRoles()) {
                                                sb.append("role name:" + user.getStatus() + "\n");
                                            }
                                        }
                                    }
                                }

                                result.setText(sb.toString());
                            }
                        },
                        new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                next.Error(throwable);
                            }
                        },
                        new Action0() {
                            @Override
                            public void call() {
                                next.Finish(gitHubApi);
                            }
                        }
                );
    }

    private void doLogout(final GitHubApi gitHubApi, final INext nextAction) {
        Observable<Logout> observableLogout = gitHubApi.oLogout(xBbSession, appCode);
        observableLogout.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Action1<Logout>() {
                            @Override
                            public void call(Logout logout) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(result.getText().toString());
                                sb.append("---------------------\n");
                                sb.append("     Logout info \n");
                                sb.append("---------------------\n");
                                sb.append("http code:" + logout.getHttp_code() + "\n");
                                sb.append("status:" + logout.getResult() + "\n");
                                sb.append("data:" + logout.getData() + "\n");

                                result.setText(sb.toString());
                            }
                        },
                        new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                nextAction.Error(throwable);
                            }
                        },
                        new Action0() {
                            @Override
                            public void call() {
                                nextAction.Finish(gitHubApi);
                            }
                        }

                );

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
