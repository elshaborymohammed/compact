package com.compact.picker;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.provider.MediaStore;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class ImagePicker {
    public static final int REQUEST_CODE = 10001;
    public static final String[] PERMISSIONS = {
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    private static final List<Intent> intents = new ArrayList<>();

    static {
        intents.add(actionImageCapture());
    }

    public static void pick(Activity activity) {

        Intent intent = Intent.createChooser(actionPick(), null);
        if (!intents.isEmpty()) {
            intent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intents.toArray(new Parcelable[]{}));
        }
        activity.startActivityForResult(intent, REQUEST_CODE);

//        Intent intent = actionPick();
//        activity.startActivityForResult(Intent.createChooser(intent, "Pick Image"), REQUEST_CODE);
//        activity.startActivityForResult(actionGetContentChooser(), REQUEST_CODE);
    }

    public static void pick(Fragment fragment) {
        Intent intent = Intent.createChooser(actionPick(), null);
        if (!intents.isEmpty()) {
            intent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intents.toArray(new Parcelable[]{}));
        }
        fragment.startActivityForResult(intent, REQUEST_CODE);

//        Intent intent = actionPick();
//        fragment.startActivityForResult(Intent.createChooser(intent, "Pick Image"), REQUEST_CODE);
//        fragment.startActivityForResult(actionGetContentChooser(), REQUEST_CODE);
    }

    private static Intent actionPick() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        return intent;
    }

    private static Intent actionGetContent() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        String[] mimeTypes = {"image/jpeg", "image/png"};
        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
        return intent;
    }

    private static Intent actionGetContentChooser() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");

        Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickIntent.setType("image/*");

        Intent chooserIntent = Intent.createChooser(intent, "Select Image");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{pickIntent});

        return chooserIntent;
    }

    private static Intent actionImageCapture() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra("return-data", true);
        return intent;
    }
}
