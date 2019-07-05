package com.example.recipemagic.presenter;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.lang.ref.WeakReference;

/*
* This class is designed to load all the categories from the database.
*/
public class DownloadCategories extends AsyncTask<Void, Void, Void> {

    private WeakReference<MainPresenter> presenter;
    private ProgressBar pb;
    private Context context;

    public DownloadCategories(MainPresenter presenter, ProgressBar pb, Context context) {
        this.presenter = new WeakReference<MainPresenter>(presenter);
        this.pb = pb;
        this.context = context;
    }

    protected Void doInBackground(Void... voids) {
        presenter.get().getCookBook().loadCategory("https://www.themealdb.com/api/json/v1/1/categories.php");
        return null;
    }

    /*
     * After the categories are finished loading, will notify the user that
     * it is going to download all the recipes and then it begins the process
     * of doing so.
     */
    @Override
    protected void onPostExecute(Void aVoid) {
        Toast.makeText(context, "Downloading Recipes...", Toast.LENGTH_LONG).show();
        DownloadRecipes task = new DownloadRecipes(presenter, pb, context);
        task.execute();
    }
}