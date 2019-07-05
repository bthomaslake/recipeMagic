package com.example.recipemagic.presenter;


import android.content.Context;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;
import com.example.recipemagic.model.CookBook;

/*
* MainPresenter is used to start the downloading process
* and to store all recipes and categories inside the cookbook
* that will be used throughout the program.
*/
public class MainPresenter {
    private CookBook book;
    private boolean bookReady;
    private List<Listener> registeredDataUsers;

    public MainPresenter(Context context, ProgressBar pb){
        book = new CookBook();
        bookReady = false;
        registeredDataUsers = new ArrayList<Listener>();
        DownloadCategories task = new DownloadCategories(this, pb, context);
        task.execute();
    }

    public void registerDataUser(MainPresenter.Listener dataUser){
        registeredDataUsers.add(dataUser);
        if (bookReady){
            dataUser.notifyDataReady();
        }
    }

    /*
    * When the cookbook is done loading, then everything is displayed.
    */
    public void notifyDataUsers() {
        bookReady = true;
        for (MainPresenter.Listener dataUser : registeredDataUsers) {
            dataUser.notifyDataReady();
        }
    }

    public CookBook getCookBook() {
        return book;
    }

    public boolean isBookReady(){
        return bookReady;
    }

    public interface Listener{
        void notifyDataReady();
    }
}