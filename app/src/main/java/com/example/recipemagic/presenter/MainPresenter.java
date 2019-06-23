package com.example.recipemagic.presenter;

import java.util.ArrayList;
import java.util.List;
import com.example.recipemagic.model.cookBook;
import com.example.recipemagic.view.MainActivity;

public class MainPresenter {
    private cookBook book;
    private boolean bookReady;
    private List<Listener> registeredDataUsers;

    public MainPresenter(MainActivity mainActivity){
        book = new cookBook();
        bookReady = false;
        registeredDataUsers = new ArrayList<Listener>();
        DownloadLibraryTask task = new DownloadLibraryTask(this);
        task.execute();
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