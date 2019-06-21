package com.example.recipemagic.presenter;

import android.os.AsyncTask;

import java.lang.ref.WeakReference;

public class DownloadLibraryTask extends AsyncTask<Void, Void, Void> {

    private WeakReference<MainPresenter> presenter;

    public DownloadLibraryTask(MainPresenter presenter) {
        this.presenter = new WeakReference<MainPresenter>(presenter);
    }

    protected Void doInBackground(Void... voids) {
        presenter.get().getCookBook().loadCategory("https://www.themealdb.com/api/json/v1/1/categories.php");
        return null;
    }
}