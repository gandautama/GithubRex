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

import java.lang.Override;
import java.lang.Throwable;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private final String REPO_USER = "ReactiveX";
    private final String REPO_NAME = "RxJava";

    private TextView result;

    static String xBbSession = "";
    final String appCode = "manado";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView) findViewById(R.id.result);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://107.102.182.83:9000")
                .setClient(new OkClient())
                .build();
            final GitHubApi gitHubApi = restAdapter.create(GitHubApi.class);
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
    ////get assignment
                                    doGetAssignment(api, new INext() {
                                        @Override
                                        public void Finish(GitHubApi api) {

                                            doGetModel(api, new INext() {
                                                @Override
                                                public void Finish(GitHubApi api) {
                                                   doGetSites(api, new INext() {
                                                       @Override
                                                       public void Finish(GitHubApi api) {
                                                           doLogout(api, new INext() {
                                                               @Override
                                                               public void Finish(GitHubApi api) {
                                                                   result.append("finished getting data");
                                                                   xBbSession = "";
                                                               }

                                                               @Override
                                                               public void Error(Throwable t) {
                                                                   result.append("error, " + t.getMessage());
                                                               }
                                                           });
                                                       }

                                                       @Override
                                                       public void Error(Throwable t) {
                                                           result.append("error, " + t.getMessage());
                                                       }
                                                   });
                                                }

                                                @Override
                                                public void Error(Throwable t) {
                                                    result.append("error, " + t.getMessage());
                                                }
                                            });
                                        }
                                        @Override
                                        public void Error (Throwable t){
                                            FoundError(gitHubApi, t);
                                        }
                                    });
                                }
                                @Override
                                public void Error (Throwable t){
                                    FoundError(gitHubApi, t);
                                }
                            });
                        }

                        @Override
                        public void Error (Throwable t){
                            result.append("error, " + t.getMessage());
                        }
                    });
                }

                @Override
                public void Error(Throwable t) {
                    result.append("error, " + t.getMessage());
                }

            });


    }

    public interface INext {
        public void Finish(final GitHubApi api);

        public void Error(Throwable t);
    }

    public void FoundError(GitHubApi api, Throwable throwable) {
        doLogout(api, new INext() {
            @Override
            public void Finish(GitHubApi api) {
                result.append(result.getText().toString());
                result.append("finished getting data");
            }

            @Override
            public void Error(Throwable t) {
                result.append(result.getText().toString());
                result.append("error, " + t.getMessage());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    private void doGetSites(final GitHubApi gitHubApi, final INext next) {
        final GitHubApi api = gitHubApi;
        Observable<Sites> observableSites = gitHubApi.oSites(xBbSession);
        observableSites.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Sites>() {
                               @Override
                               public void call(Sites sites) {
                                   if (sites != null) {
                                       result.append("---------------------\n");
                                       result.append("        Sites\n");
                                       result.append("---------------------\n");
                                       result.append("http code:" + sites.getHttp_code() + "\n");
                                       result.append("status:" + sites.getResult() + "\n");
                                       Sites.Data vData[] = sites.getData();
                                       if (vData != null) {
                                           for (Sites.Data data : vData) {
                                               result.append("id         :" + data.getId() + "\n");
                                               result.append("name       :" + data.getName() + "\n");
                                               result.append("address    :" + data.getAddress() + "\n");
                                               result.append("phone      :" + data.getPhone() + "\n");
                                               if (data.getMstBranchSites() != null) {
                                                   result.append("br id      :" + data.getMstBranchSites().getId() + "\n");
                                                   result.append("br name    :" + data.getMstBranchSites().getName() + "\n");
                                               }
                                               if (data.getMstGroupSites() != null) {
                                                   result.append("grp st id  :" + data.getMstGroupSites().getId() + "\n");
                                                   result.append("grp st name:" + data.getMstGroupSites().getName() + "\n");
                                               }
                                               if (data.getMstRegionSites() != null) {
                                                   result.append("reg id     :" + data.getMstRegionSites().getId() + "\n");
                                                   result.append("reg name   :" + data.getMstRegionSites().getId() + "\n");
                                               }
                                               if (data.getMstTierSites() != null) {
                                                   result.append("tier id     :" + data.getMstTierSites().getId() + "\n");
                                                   result.append("tier name   :" + data.getMstTierSites().getId() + "\n");
                                               }
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
        gitHubApi.oModel(xBbSession)
        .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Model>() {
                               @Override
                               public void call(Model model) {
                                   if (model != null) {
                                       result.append("---------------------\n");
                                       result.append("        MODELS\n");
                                       result.append("---------------------\n");
                                       result.append("http code:" + model.getHttp_code() + "\n");
                                       result.append("status:" + model.getResult() + "\n");

                                       if (model.getData() != null) {
                                           for (Model.Data data : model.getData()) {
                                               result.append("  model id       : " + data.getId() + "\n");
                                               result.append("  model name     : " + data.getName() + "\n");
                                               result.append("  category id    : " + data.getMstCategoryModels().getId() + "\n");
                                               result.append("  category name  : " + data.getMstCategoryModels().getName() + "\n");
                                               result.append("  type id      : " + data.getMstCategoryModels().getId() + "\n");
                                               result.append("  type name    : " + data.getName() + "\n");
                                               result.append("  zoning id    : " + data.getMstCategoryModels().getId() + "\n");
                                               result.append("  zoning name  : " + data.getName() + "\n");
                                               result.append("  mat group id   : " + data.getMstMaterialGroup().getId() + "\n");
                                               result.append("  mat group name : " + data.getMstMaterialGroup().getName() + "\n");
                                               if (data.getMstMaterialGroup().getListMstGroupMaterials() != null) {
                                                   for (Model.MstGroupMaterials matGroup : data.getMstMaterialGroup().getListMstGroupMaterials()) {

                                                       result.append("    id             : " + matGroup.getId() + "\n");
                                                       result.append("    idMstGroup     : " + matGroup.getIdMstMaterialGroup() + "\n");
                                                       result.append("    idMstMaterial  : " + matGroup.getIdMstMaterial() + "\n");

                                                       if (matGroup.getMstMaterial() != null) {
                                                           result.append("    mat id:" + matGroup.getMstMaterial().getId() + "\n");
                                                           result.append("    mat name:" + matGroup.getMstMaterial().getName() + "\n");
                                                           result.append("    mat qty:" + matGroup.getMstMaterial().getQuantity() + "\n");
                                                           result.append("        type id  :" + matGroup.getMstMaterial().getMstTypeMaterials().getId() + "\n");
                                                           result.append("        type name:" + matGroup.getMstMaterial().getMstTypeMaterials().getName() + "\n");
                                                       }
                                                   }
                                               }
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
                                   result.append("---------------------\n");
                                   result.append("     Version Data  \n");
                                   result.append("---------------------\n");
                                   result.append("http code:" + data.getHttp_code() + "\n");
                                   result.append("status:" + data.getResult() + "\n");
                                   VersionData.Data vData = data.getData();
                                   if (vData != null) {
                                       String lastUpdate = vData.getLastUpdate();
                                       String link = vData.getLink();
                                       result.append("last update:" + lastUpdate + "\n");
                                       result.append("link:" + link + "\n");
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

    private void doGetVersionApp(final GitHubApi gitHubApi, final INext next) {
        Observable<VersionApp> observableVersionApp = gitHubApi.oVersionApp(xBbSession);
        observableVersionApp.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<VersionApp>() {
                               @Override
                               public void call(VersionApp versionApp) {
                                   VersionApp.Data vApp = versionApp.getData();
                                   if (vApp != null) {
                                       String version = vApp.getVersion();
                                       String link = vApp.getLink();
                                       result.append("---------------------\n");
                                       result.append("    Version App\n");
                                       result.append("---------------------\n");
                                       result.append("version:" + version + "\n");
                                       result.append("link:" + link + "\n");
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
        Observable<AssignmentData> observableAssignmentData = gitHubApi.oAssignment(xBbSession);
        observableAssignmentData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<AssignmentData>() {
                               @Override
                               public void call(AssignmentData assignmentData) {
                                   if (assignmentData != null) {
                                       AssignmentData.Assignment[] assignments = assignmentData.getAssignments();
                                       result.append("---------------------\n");
                                       result.append("      Assignment\n");
                                       result.append("---------------------\n");
                                       result.append("http code:" + assignmentData.getHttp_code() + "\n");
                                       result.append("http result:" + assignmentData.getResult() + "\n");
                                       if (assignments != null) {//dapat null euy
                                           for (AssignmentData.Assignment assignment : assignments) {
                                               result.append("id:" + assignment.getId() + "\n");
                                               result.append("vde:" + assignment.getIdMstUserVde() + "\n");
                                               result.append("vdo:" + assignment.getIdMstUserVdo() + "\n");
                                               result.append("vdr:" + assignment.getIdMstUserVdr() + "\n");
                                               result.append("title:" + assignment.getTitle() + "\n");
                                               result.append("periodStartDate:" + assignment.getPeriodStartDate() + "\n");
                                               result.append("periodEndDate:" + assignment.getPeriodEndDate() + "\n");
                                               result.append("state:" + assignment.getState() + "\n");
                                               result.append("createDate:" + assignment.getCreateDate() + "\n");
                                               AssignmentData.TrxAssSites[] trxAssSites = assignment.getListTrxAssignmentSites();
                                               if (trxAssSites != null) {
                                                   for (AssignmentData.TrxAssSites sites : trxAssSites) {
                                                       result.append("  id:" + sites.getAssSitesId() + "\n");
                                                       if (sites.getMstSite() != null) {
                                                           result.append("  st  id      : " + sites.getMstSite().getId() + "\n");
                                                           result.append("  st  name    : " + sites.getMstSite().getName() + "\n");
                                                           result.append("  st  phone   : " + sites.getMstSite().getPhone() + "\n");
                                                           result.append("  st  address : " + sites.getMstSite().getAddress() + "\n");
                                                           if (sites.getMstSite().getMstBranchSites() != null) {
                                                               result.append("  st  branch  id     :" + sites.getMstSite().getMstBranchSites().getId() + "\n");
                                                               result.append("  st  branch  name   :" + sites.getMstSite().getMstBranchSites().getName() + "\n");
                                                           }
                                                           if (sites.getMstSite().getMstBranchSites() != null) {
                                                               result.append("  st  group sites    :" + sites.getMstSite().getMstGroupSites().getId() + "\n");
                                                               result.append("  st  group sites    :" + sites.getMstSite().getMstGroupSites().getName() + "\n");
                                                           }
                                                           if (sites.getMstSite().getMstRegionSites() != null) {
                                                               result.append("  st  reg sites    :" + sites.getMstSite().getMstGroupSites().getId() + "\n");
                                                               result.append("  st  reg sites    :" + sites.getMstSite().getMstGroupSites().getName() + "\n");
                                                           }
                                                           if (sites.getMstSite().getMstTierSites() != null) {
                                                               result.append("  st  tier sites    :" + sites.getMstSite().getMstGroupSites().getId() + "\n");
                                                               result.append("  st  tier sites    :" + sites.getMstSite().getMstGroupSites().getName() + "\n");
                                                           }
                                                       } else {
                                                           result.append("got sites.getMstSite() null" + "\n");
                                                       }
                                                   }
                                               } else {
                                                   result.append("trxAssSites null" + "\n");
                                               }
                                           }
                                       } else {
                                           result.append("got Data Null" + "\n");
                                       }
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
        gitHubApi.oLogin(appCode, "tommy.t", "password")
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Action1<Login>() {
                            @Override
                            public void call(Login login) {
                                result.append("---------------------\n");
                                result.append("     Login info \n");
                                result.append("---------------------\n");
                                result.append("http code:" + login.getHttp_code() + "\n");
                                result.append("status:" + login.getResult() + "\n");

                                Login.Data vData = login.getData();
                                if (vData != null) {
                                    xBbSession = vData.getxBbSession();
                                    result.append("session:" + xBbSession + "\n");
                                    Login.User user = vData.getUser();
                                    if (vData != null) {
                                        result.append("user name:" + user.getName() + "\n");
                                        result.append("user status:" + user.getStatus() + "\n");

                                        if (user.getRoles() != null) {
                                            for (Login.Role role : user.getRoles()) {
                                                result.append("role name:" + user.getStatus() + "\n");
                                            }
                                        }
                                    }
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

    private void doLogout(final GitHubApi gitHubApi, final INext next) {
        gitHubApi.oLogout(appCode, xBbSession)
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Action1<Logout>() {
                            @Override
                            public void call(Logout logout) {
                                result.append("---------------------\n");
                                result.append("     Logout info \n");
                                result.append("---------------------\n");
                                result.append("http code:" + logout.getHttp_code() + "\n");
                                result.append("status:" + logout.getResult() + "\n");
                                result.append("data:" + logout.getData() + "\n");
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
