package com.example.recipemagic.presenter;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.example.recipemagic.view.MainActivity;

import java.lang.ref.WeakReference;


public class DownloadRecipes extends AsyncTask<Void, Void, Void> {

    private WeakReference<MainPresenter> presenter;

    public DownloadRecipes(WeakReference<MainPresenter> presenter) {
        this.presenter = presenter;
    }

    protected void onPreExecute(){

    }

    protected Void doInBackground(Void... voids) {
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20and%20Mustard%20Pie", "Beef");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20and%20Oyster%20pie", "Beef");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20Bourguignon", "Beef");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20Brisket%20Pot%20Roast", "Beef");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20Dumpling%20Stew", "Beef");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20Lo%20Mein", "Beef");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20stroganoff", "Beef");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20Sunday%20Roast", "Beef");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20Wellington", "Beef");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Braised%20Beef%20Chilli", "Beef");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Irish%20stew", "Beef");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Jamaican%20Beef%20Patties", "Beef");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Ma%20Po%20Tofu", "Beef");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Massaman%20Beef%20curry", "Beef");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Minced%20Beef%20Pie", "Beef");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Montreal%20Smoked%20Meat", "Beef");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Oxtail%20with%20broad%20beans", "Beef");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Pate%20Chinois", "Beef");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Red%20Peas%20Soup", "Beef");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Spaghetti%20Bolognese", "Beef");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Steak%20and%20Kidney%20Pie", "Beef");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Steak%20Diane", "Beef");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Szechuan%20Beef", "Beef");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Brown%20Stew%20Chicken", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Chicken%20&%20mushroom%20Hotpot", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Chicken%20Alfredo%20Primavera", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Chicken%20Basquaise", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Chicken%20Congee", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Chicken%20Couscous", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Chicken%20Enchilada%20Casserole", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Chicken%20Fajita%20Mac%20and%20Cheese", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Chicken%20Ham%20and%20Leek%20Pie", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Chicken%20Handi", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Chicken%20Karaage", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Chicken%20Marengo", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Chicken%20Parmentier", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Coq%20au%20vin", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Crock%20Pot%20Chicken%20Baked%20Tacos", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=General%20Tso's%20Chicken", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Jerk%20chicken%20with%20rice%20&%20peas", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Katsu%20Chicken%20curry", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Kentucky%20Fried%20Chicken", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Kung%20Pao%20Chicken", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Lamb%20tomato%20and%20sweet%20spices", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Mediterranean%20Pasta%20Salad", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Nutty%20Chicken%20Curry", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Pad%20See%20Ew", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Potato%20Gratin%20with%20Chicken", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Rappie%20Pie", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Tandoori%20chicken", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Teriyaki%20Chicken%20Casserole", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Thai%20Green%20Curry", "Chicken");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Apple%20&%20Blackberry%20Crumble", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Apple%20Frangipan%20Tart", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Bakewell%20tart", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Banana%20Pancakes", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Battenberg%20Cake", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=BeaverTails", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Blackberry%20Fool", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Bread%20and%20Butter%20Pudding", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Budino%20Di%20Ricotta", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Canadian%20Butter%20Tarts", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Carrot%20Cake", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Cashew%20Ghoriba%20Biscuits", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Chelsea%20Buns", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Chinon%20Apple%20Tarts", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Choc%20Chip%20Pecan%20Pie", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Chocolate%20Avocado%20Mousse", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Chocolate%20Caramel%20Crispy", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Chocolate%20Gateau", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Chocolate%20Raspberry%20Brownies", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Chocolate%20Souffle", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Christmas%20Pudding%20Flapjack", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Dundee%20cake", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Eccles%20Cakes", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Eton%20Mess", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Hot%20Chocolate%20Fudge", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Jam%20Roly-Poly", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Key%20Lime%20Pie", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Madeira%20Cake", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Nanaimo%20Bars", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=New%20York%20cheesecake", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Pancakes", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Parkin%20Cake", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Peach%20&%20Blueberry%20Grunt", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Peanut%20Butter%20Cheesecake", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Peanut%20Butter%20Cookies", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Pear%20Tarte%20Tatin", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Pouding%20chomeur", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Pumpkin%20Pie", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Rock%20Cakes", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Rocky%20Road%20Fudge", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Salted%20Caramel%20Cheescake", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Spotted%20Dick", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Sticky%20Toffee%20Pudding", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Sticky%20Toffee%20Pudding%20Ultimate", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Sugar%20Pie", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Summer%20Pudding", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Tarte%20Tatin", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Timbits", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Treacle%20Tart", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Tunisian%20Orange%20Cake", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=White%20chocolate%20creme%20brulee", "Dessert");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Kapsalon", "Lamb");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Keleya%20Zaara", "Lamb");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Lamb%20and%20Potato%20pie", "Lamb");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Lamb%20Biryani", "Lamb");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Lamb%20Rogan%20josh", "Lamb");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Lamb%20Tagine", "Lamb");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Lancashire%20hotpot", "Lamb");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=McSinghs%20Scotch%20pie", "Lamb");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Rigatoni%20with%20fennel%20sausage%20sauce", "Lamb");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Tunisian%20Lamb%20Soup", "Lamb");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Bean%20&%20Sausage%20Hotpot", "Miscellaneous");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Callaloo%20Jamaican%20Style", "Miscellaneous");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Chakchouka%20", "Miscellaneous");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Duck%20Confit", "Miscellaneous");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=French%20Lentils%20With%20Garlic%20and%20Thyme", "Miscellaneous");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=French%20Omelette", "Miscellaneous");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Osso%20Buco%20alla%20Milanese", "Miscellaneous");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Poutine", "Miscellaneous");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Three-cheese%20souffles", "Miscellaneous");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Turkey%20Meatloaf", "Miscellaneous");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Chilli%20prawn%20linguine", "Pasta");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Fettucine%20alfredo", "Pasta");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Grilled%20Mac%20and%20Cheese%20Sandwich", "Pasta");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Lasagne", "Pasta");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Pilchard%20puttanesca", "Pasta");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Venetian%20Duck%20Ragu", "Pasta");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=%20Bubble%20&%20Squeak", "Pork");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Hot%20and%20Sour%20Soup", "Pork");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Pork%20Cassoulet", "Pork");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Sweet%20and%20Sour%20Pork", "Pork");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Toad%20In%20The%20Hole", "Pork");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Tourtiere", "Pork");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Vietnamese%20Grilled%20Pork%20(bun-thit-nuong)", "Pork");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Wontons", "Pork");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Baked%20salmon%20with%20fennel%20&%20tomatoes", "Seafood");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Cajun%20spiced%20fish%20tacos", "Seafood");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Escovitch%20Fish", "Seafood");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Fish%20pie", "Seafood");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Fish%20Stew%20with%20Rouille", "Seafood");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Garides%20Saganaki", "Seafood");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Honey%20Teriyaki%20Salmon", "Seafood");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Kedgeree", "Seafood");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Kung%20Po%20Prawns", "Seafood");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Laksa%20King%20Prawn%20Noodles", "Seafood");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Recheado%20Masala%20Fish", "Seafood");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Salmon%20Avocado%20Salad", "Seafood");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Salmon%20Prawn%20Risotto", "Seafood");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Saltfish%20and%20Ackee", "Seafood");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Seafood%20fideuà", "Seafood");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Shrimp%20Chow%20Fun", "Seafood");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Three%20Fish%20Pie", "Seafood");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Tuna%20and%20Egg%20Briks", "Seafood");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Tuna%20Nicoise", "Seafood");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Boulangère%20Potatoes", "Side");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Brie%20wrapped%20in%20prosciutto%20&%20brioche", "Side");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Fennel%20Dauphinoise", "Side");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=French%20Onion%20Soup", "Side");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Prawn%20&%20Fennel%20Bisque", "Side");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Split%20Pea%20Soup", "Side");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Broccoli%20&%20Stilton%20soup", "Starter");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Clam%20chowder", "Starter");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Cream%20Cheese%20Tart", "Starter");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Creamy%20Tomato%20Soup", "Starter");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Roast%20fennel%20and%20aubergine%20paella", "Vegan");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Vegan%20Chocolate%20Cake", "Vegan");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Vegan%20Lasagna", "Vegan");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Baingan%20Bharta", "Vegetarian");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Chickpea%20Fajitas", "Vegetarian");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Dal%20fry", "Vegetarian");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Egg%20Drop%20Soup", "Vegetarian");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Flamiche", "Vegetarian");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Kafteji", "Vegetarian");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Kidney%20Bean%20Curry", "Vegetarian");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Leblebi%20Soup", "Vegetarian");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Matar%20Paneer", "Vegetarian");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Mushroom%20&%20Chestnut%20Rotolo", "Vegetarian");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Provençal%20Omelette%20Cake", "Vegetarian");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Ratatouille", "Vegetarian");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Ribollita", "Vegetarian");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Roasted%20Eggplant%20With%20Tahini,%20Pine%20Nuts,%20and%20Lentils", "Vegetarian");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Shakshuka", "Vegetarian");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Smoky%20Lentil%20Chili%20with%20Squash", "Vegetarian");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Spanish%20Tortilla", "Vegetarian");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Spicy%20Arrabiata%20Penne", "Vegetarian");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Spicy%20North%20African%20Potato%20Salad", "Vegetarian");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Spinach%20&%20Ricotta%20Cannelloni", "Vegetarian");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Squash%20linguine", "Vegetarian");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Stovetop%20Eggplant%20With%20Harissa,%20Chickpeas,%20and%20Cumin%20Yogurt", "Vegetarian");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Summer%20Pistou", "Vegetarian");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Tahini%20Lentils", "Vegetarian");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Vegetarian%20Casserole", "Vegetarian");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Vegetarian%20Chilli", "Vegetarian");
                presenter.get().getCookBook().loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Yaki%20Udon", "Vegetarian");
    return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        presenter.get().notifyDataUsers();
   }
}