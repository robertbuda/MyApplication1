package com.example.robert.myapplication1.async;

public interface BackgroundTaskContract {

    interface View {
        void showProgress();
        void hideProgress();
        void updateProgress(Integer progress);
        void showOutput(String output);

    }

    interface Task {
        void count(Integer from, Integer to);

    }

}
