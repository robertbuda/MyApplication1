package com.example.robert.myapplication1.SpaceX;

import android.support.v7.app.AppCompatActivity;

public class Headquarters extends AppCompatActivity {

        private String address;
        private String city;
        private String state;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

    }
