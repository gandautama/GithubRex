package com.arjunalabs.android.githubrex.model;

import rx.Observable;
import rx.functions.Action1;


/**
 * Created by ganda on 25/02/15.
 */
public class helloworld {


    public static void hello(String... names) {
        Observable.from(names).subscribe(new Action1() {
            public void call(Object s) {
                System.out.println("Hello " + s.toString() + "!");
            }
        });
    }

    public static void main(String[] args) {
        hello(new String[]{"ganda", "derry", "anda", "dio"});
    }
}