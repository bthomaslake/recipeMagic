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
        presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20and%20Mustard%20Pie", "beef");
        presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20and%20Oyster%20pie", "beef");
        presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20Bourguignon", "beef");
        presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20Brisket%20Pot%20Roast", "beef");
        presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20Dumpling%20Stew", "v");
        presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20Lo%20Mein", "beef");
        presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20stroganoff", "beef");
        presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20Sunday%20Roast", "beef");
        presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20Wellington", "beef");
        presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Braised%20Beef%20Chilli", "beef");
        presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Irish%20stew", "beef");
        presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Jamaican%20Beef%20Patties", "beef");
        presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Ma%20Po%20Tofu", "beef");
        presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Massaman%20Beef%20curry", "beef");
        presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Minced%20Beef%20Pie", "beef");
        presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Montreal%20Smoked%20Meat", "beef");
        presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Oxtail%20with%20broad%20beans", "beef");
        presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Pate%20Chinois", "beef");
        presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Red%20Peas%20Soup", "beef");
        presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Spaghetti%20Bolognese", "beef");
        presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Steak%20and%20Kidney%20Pie", "beef");
        presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Steak%20Diane", "beef");
        presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Szechuan%20Beef", "beef");

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        presenter.get().notifyDataUsers();

   }
}