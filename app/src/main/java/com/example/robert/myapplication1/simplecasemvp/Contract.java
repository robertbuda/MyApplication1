package com.example.robert.myapplication1.simplecasemvp;

public interface Contract {

    interface view {

        void showToastMessage();
    }

    interface presenter {

        void clickedToastButton();
    }

}
