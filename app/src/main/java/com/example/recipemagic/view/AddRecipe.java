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

import java.io.File;

import static android.app.Activity.RESULT_OK;


public class AddRecipe extends Fragment {

    private OnFragmentInteractionListener mListener;

    private Button button_picture;
    private EditText recipeName;
    private ImageView imageView;
    private Uri file;

    public AddRecipe() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    @SuppressWarnings("unused")
    public static AddRecipe newInstance() {
        AddRecipe fragment = new AddRecipe();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

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
    }

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
                takePicture(v);
                recipeName.setHint("Add another recipe");
                recipeName.setText("");
            }
        });
        return view;
    }

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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void takePicture(View view) {;
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        file = Uri.fromFile(getOutputMediaFile(recipeName));
        intent.putExtra(MediaStore.EXTRA_OUTPUT, file);
        startActivityForResult(intent, 100);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                imageView.setImageURI(file);
                Toast.makeText(getContext(), "Recipe added", Toast.LENGTH_SHORT).show();
            }
        }
    }

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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
