package com.example.dz6_fragments_27;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements IFragments{

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragment = (SecondFragment) getSupportFragmentManager()
                .findFragmentById(R.id.frSecond);

        dynamicFragment();
    }

    private void dynamicFragment() {
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_dyn, new EnterFragment());
        transaction.commit();
        transaction.addToBackStack(null);
    }

    @Override
    public void onFirstFragment() {
        transaction = fragmentManager.beginTransaction();
        transaction.hide(fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onSecondFragment() {
        transaction = fragmentManager.beginTransaction();
        transaction.show(fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onSendText(String text) {
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frSecond, SecondFragment.newInstance(text,""));
        transaction.addToBackStack(null);
        transaction.commit();
    }
}