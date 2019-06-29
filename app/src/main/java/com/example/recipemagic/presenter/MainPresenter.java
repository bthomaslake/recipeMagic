package com.example.recipemagic.presenter;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import com.example.recipemagic.model.CookBook;
import com.example.recipemagic.view.MainActivity;

public class MainPresenter {
    private CookBook book;
    private boolean bookReady;
    private List<Listener> registeredDataUsers;

    public MainPresenter(Context context){
        book = new CookBook();
        bookReady = false;
        registeredDataUsers = new ArrayList<Listener>();
        DownloadCategories task = new DownloadCategories(this, context);
        task.execute();
    }

    public void registerDataUser(MainPresenter.Listener dataUser){
        registeredDataUsers.add(dataUser);
        if (bookReady){
            dataUser.notifyDataReady();
        }
    }

    public void notifyDataUsers() {
        bookReady = true;
        for (MainPresenter.Listener dataUser : registeredDataUsers) {
            dataUser.notifyDataReady();
        }
    }

    public CookBook getCookBook() {
        return book;
    }

    public interface Listener{
        void notifyDataReady();
    }
}