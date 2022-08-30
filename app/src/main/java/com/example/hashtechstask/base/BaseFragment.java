package com.example.hashtechstask.base;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;

import com.example.hashtechstask.R;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment{

    public Dialog mDialog;

    public void showLoading(Context mContext) {
        mDialog= new Dialog(mContext);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.custom_progress);
        mDialog.findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        mDialog.setCancelable(true);
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.show();
    }

    public void hideProgress() {
        if (mDialog!= null) {
            mDialog.dismiss();
            mDialog= null;
        }
    }

    public void showErrorAlert(Context context , String message){

    }

    public void showExceptionError(Throwable throwable) {
//        try {
//            if (throwable instanceof JsonEncodingException) { //JSON_ERROR
//                showErrorAlert(this, "", getString(R.string.unexpected_error));
//            } else if (throwable instanceof IOException) { //NETWORK_ERROR
//                showErrorAlert(this, "", getString(R.string.check_your_internet_connection));
//            } else {//UNEXPECTED_ERROR
//                showErrorAlert(this, "", getString(R.string.unexpected_error));
//            }
//        }catch (Exception e){
//
//        }

    }
}
