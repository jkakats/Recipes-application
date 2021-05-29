package gr.aueb.recipeapp.ui.userRecipes;

import java.util.ArrayList;

import gr.aueb.recipeapp.dao.RecipeDao;
import gr.aueb.recipeapp.dao.UserDao;
import gr.aueb.recipeapp.domain.CourseType;
import gr.aueb.recipeapp.domain.Recipe;
import gr.aueb.recipeapp.domain.RecipeIngredient;
import gr.aueb.recipeapp.domain.User;

public class UserRecipesPresenter {

    //public UserRecipesView userRecipesView;
    public UserDao userDao = new UserDao();
    public User user;
    public RecipeDao recipeDao = new RecipeDao();

    UserRecipesPresenter(User user){
        this.user = user;
    }

    public void publish(String name, CourseType courseType, int prepTime, int portion, String steps, ArrayList<RecipeIngredient> ingredients){
        Recipe r = new Recipe(Recipe.idCounter, name, courseType, prepTime, portion, steps, ingredients, user);
        userDao.publish(user, r);
        recipeDao.add(r);
        Recipe.idCounter++;
    }

    public void remove(int id){
        userDao.remove(user, id);
        recipeDao.remove(id);
    }

    public void edit(int id, String name, CourseType courseType, int prepTime, int portion, String steps, ArrayList<RecipeIngredient> ingredients){
        Recipe recipe = new Recipe(id, name, courseType, prepTime, portion, steps, ingredients, user);
        userDao.edit(user, recipe);
        recipeDao.update(recipe);
    }
}