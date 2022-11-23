package com.example.appprototipe.ui.shopping;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ShoppsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ShoppsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragmento para la vista Compras");
    }

    public LiveData<String> getText() {
        return mText;
    }
}