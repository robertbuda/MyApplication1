package com.example.robert.myapplication1.retrofit;

import java.util.List;

public interface RocketContract {

    interface Presenter {
        void refreshRocketData();
    }

    interface View {

        void setButtonRocketVisible();

        void setProgressBarInvisible();

        void showData(List<Rocket> body);
    }
}
