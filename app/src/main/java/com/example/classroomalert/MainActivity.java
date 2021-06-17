package com.example.classroomalert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private OnboardAdapter onboardAdapter;
    private LinearLayout layoutOnboardingIndicators;
    private Button buttonOnboardingAction2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOnboardingAction2 = findViewById(R.id.buttonOnboardingAction2);
        layoutOnboardingIndicators = findViewById(R.id.layoutOnboardingIndicators);
        setupOnboardingItems();

        ViewPager2 onboardingViewPager = findViewById(R.id.onboardingPager);
        onboardingViewPager.setAdapter(onboardAdapter);

        setupOnboardingIndicators();
        setCurrentOnboardActivated(0);
        buttonOnboardingAction2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onboardingViewPager.getCurrentItem() < onboardAdapter.getItemCount() - 1) {
                    onboardingViewPager.setCurrentItem(onboardingViewPager.getCurrentItem() + 1);
                } else {
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    finish();
                }
            }
        });

        onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardActivated(position);
                if(position == 2) {
                    buttonOnboardingAction2.setText("START");
                } else {
                    buttonOnboardingAction2.setText("NEXT");
                }
            }
        });
    }

    private void setupOnboardingItems() {
        List<OnboardingItem> onboardingItems = new ArrayList<>();

        OnboardingItem aboutThisApp = new OnboardingItem();
        aboutThisApp.setTitle("PASTE, QUICKLY AND SAFELY");
        aboutThisApp.setDescription("With GlueClass you can create rooms and manage who can join and share questions");
        aboutThisApp.setImage(R.drawable.test_online);

        OnboardingItem aboutTheFriend  = new OnboardingItem();
        aboutTheFriend.setTitle("FRIENDS AND PRIVACY");
        aboutTheFriend.setDescription("On GlueClass you can connect with your friends to paste and quickly and without getting caught!\n" +
                "(Unless you hesitate)");
        aboutTheFriend.setImage(R.drawable.teste);

        OnboardingItem aboutTheAnonymous  = new OnboardingItem();
        aboutTheAnonymous.setTitle("YOUR ANON#MI#Y");
        aboutTheAnonymous.setDescription("Your privacy is the most important. After all, you can't find someone who doesn't exist...\n" +
                "\n" +
                "Welcome to GlueClas");
        aboutTheAnonymous.setImage(R.drawable.anonymous);

        onboardingItems.add(aboutThisApp);
        onboardingItems.add(aboutTheFriend);
        onboardingItems.add(aboutTheAnonymous);

        onboardAdapter = new OnboardAdapter(onboardingItems);
    }
    
    private void setupOnboardingIndicators() {
        ImageView[] indicators = new ImageView[onboardAdapter.getItemCount()];

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8, 0, 8, 0);

        for(int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.onboarding_indicator_inactive
            ));
            indicators[i].setLayoutParams(layoutParams);
            System.out.println(indicators[i]);
            layoutOnboardingIndicators.addView(indicators[i]);

        }
    }

    private void setCurrentOnboardActivated(int index) {
        int childCount = layoutOnboardingIndicators.getChildCount();
        for(int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView)layoutOnboardingIndicators.getChildAt(i);
            if(i == index) {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicator_active)
                );
            } else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicator_inactive)
                );
            }
        }
    }
}