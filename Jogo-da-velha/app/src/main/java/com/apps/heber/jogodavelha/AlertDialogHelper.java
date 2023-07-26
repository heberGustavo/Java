package com.apps.heber.jogodavelha;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

public final class AlertDialogHelper {

    public static void show(Context context, String title, String message,
                            String positiveButton, DialogInterface.OnClickListener positiveOnClick,
                            String negativeButton, DialogInterface.OnClickListener negativeOnClick) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(positiveButton, positiveOnClick);
        builder.setNegativeButton(negativeButton, negativeOnClick);
        builder.create();
        builder.setCancelable(false);
        builder.show();
    }

    public static void show(Context context, String title, String message){
        show(context, title, message,
                "OK", null, "", null);
    }
}
