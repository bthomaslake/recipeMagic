package com.example.recipemagic.presenter;

import com.example.recipemagic.model.cookBook;
import com.example.recipemagic.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter {
    cookBook book;
    private boolean bookReady;
    private List<Listener> registeredDataUsers;

    public MainPresenter(MainActivity mainActivity){
        book = new cookBook(mainActivity);
        bookReady = false;
        registeredDataUsers = new ArrayList<Listener>();
        /*
        DownloadLibraryTask task = new DownloadLibraryTask(this);
        task.execute();
        */


    }

    public MainPresenter() {

    }

    public void registerDataUser(MainPresenter.Listener dataUser){
        registeredDataUsers.add(dataUser);
        if (bookReady){
            dataUser.notifyDataReady();
        }
    }

    public cookBook getCookBook() {
        return book;
    }

    public interface Listener{
        void notifyDataReady();
    }
}