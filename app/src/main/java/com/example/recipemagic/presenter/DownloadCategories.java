package com.example.recipemagic.presenter;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.example.recipemagic.view.MainActivity;

import java.lang.ref.WeakReference;


public class DownloadCategories extends AsyncTask<Void, Void, Void> {

    private WeakReference<MainPresenter> presenter;


    public DownloadCategories(MainPresenter presenter, Context context) {
        this.presenter = new WeakReference<MainPresenter>(presenter);
    }

    protected Void doInBackground(Void... voids) {
        presenter.get().getCookBook().loadCategory("https://www.themealdb.com/api/json/v1/1/categories.php");
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        presenter.get().notifyDataUsers();
        DownloadRecipes task = new DownloadRecipes(presenter);
        task.execute();
    }
}