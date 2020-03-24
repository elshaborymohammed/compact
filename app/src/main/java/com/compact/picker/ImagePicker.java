package com.compact.picker;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class ImagePicker {
    public static final int REQUEST_CODE = 10001;
    public static final String[] PERMISSIONS = {
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    private final List<Intent> intents = new ArrayList<>();

    private ImagePicker() {
        intents.add(actionImageCapture());
        intents.add(actionGetContent());
    }

    public static void build(Activity activity) {
        ImagePicker picker = new ImagePicker();
        activity.startActivityForResult(picker.actionChooser(), REQUEST_CODE);
    }

    public static void build(Fragment fragment) {
        ImagePicker picker = new ImagePicker();
        fragment.startActivityForResult(picker.actionChooser(), REQUEST_CODE);
    }

    public static void build(BottomSheetDialogFragment fragment) {
        ImagePicker picker = new ImagePicker();
        fragment.startActivityForResult(picker.actionChooser(), REQUEST_CODE);
    }

    private Intent actionChooser() {
        Intent chooserIntent = Intent.createChooser(actionPick(), "Select Image");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intents.toArray(new Parcelable[]{}));
        return chooserIntent;
    }

    private Intent actionGetContent() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        String[] mimeTypes = {"image/jpeg", "image/png"};
        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
        return intent;
    }

    private Intent actionPick() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        return intent;
    }

    private Intent actionImageCapture() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        return intent;
    }

    public static void setImage(@NonNull ImageView view, @NonNull Intent data) {
        try {
            if (data.hasExtra("data")) {
                view.setImageBitmap((Bitmap) data.getExtras().get("data"));
            } else if (null != data.getData()) {
                view.setImageURI(data.getData());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
