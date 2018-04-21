package com.example.robert.myapplication1.simplecasemvp;

public class Presenter implements Contract.presenter {

    private final Contract.view view;

    public Presenter(Contract.view view) {
        this.view = view;
    }


    @Override
    public void clickedToastButton() {

        view.showToastMessage(1);
    }
}
