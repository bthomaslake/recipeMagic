package com.example.recipemagic.view;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.recipemagic.R;
import com.example.recipemagic.presenter.MainPresenter;

import java.io.File;

import static android.app.Activity.RESULT_OK;

/**
 * This class manages the part of the application that allows the user to
 * add recipes of their own in the form of a picture. It is a fragment that
 * displays in the main fragment. It interfaces with the camera and file storage
 * operations of android. A file name is attached to the picture
 * through user input, making it searchable in other parts of the app.
 */
public class AddRecipe extends Fragment {

    private Button button_picture;
    private EditText recipeName;
    private ImageView imageView;
    private Uri file;
    private MainPresenter presenter;

    public AddRecipe() {
        // Required empty public constructor
    }

    @SuppressWarnings("unused")
    public static AddRecipe newInstance() {
        AddRecipe fragment = new AddRecipe();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Checks for the permissions needed to use the camera and storage writing/reading. If the
     * permissions have not been granted, the permissions are requested from the user.
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(), new String[] {
                    Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE
                    }, 0);

        }

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        presenter = ((MainActivity) getActivity()).getPresenter();
    }

    /**
     * Manages what happens when the 'capture' button is clicked. Views are set, and the
     * takePicture method is called.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_recipe, container, false);
        button_picture = view.findViewById(R.id.button_image);
        recipeName = view.findViewById(R.id.editText);
        imageView = view.findViewById(R.id.imageview);
        imageView.setRotation(90);
        button_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = recipeName.getText().toString();
                if (input.equals("")) {
                    Toast.makeText(presenter.getContext(), "Please enter a recipe name and try again!", Toast.LENGTH_LONG).show();
                } else {
                    takePicture();
                    recipeName.setHint("Add another recipe");
                    recipeName.setText("");
                }
            }
        });
        return view;
    }

    /**
     * Checks for the result of requesting permissions. If permission is not granted, the user's
     * ability is restricted.
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                button_picture.setEnabled(true);
            }
        }
    }

    /**
     * Is not necessary in this fragment, but is required to be implemented.
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * Captures a picture and stores in a file using the specified recipe name.
     */
    private void takePicture() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        file = Uri.fromFile(getOutputMediaFile(recipeName));
        intent.putExtra(MediaStore.EXTRA_OUTPUT, file);
        startActivityForResult(intent, 100);
    }

    /**
     * Confirms to the user that the recipe was successfully added.
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                imageView.setImageURI(file);
                Toast.makeText(getContext(), "Recipe added", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * Takes care of naming the picture file that was created. It is saved as a JPEG and placed
     * in the pictures directtory of the RecipeMagic application.
     * @param editText The input text describing the recipe
     * @return The new file that will be created.
     */
    private static File getOutputMediaFile(EditText editText) {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "RecipeMagic");
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null;
            }
        }

        return new File(mediaStorageDir.getPath() + File.separator +
                editText.getText() + ".jpg");
    }

    @SuppressWarnings("unused")
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
