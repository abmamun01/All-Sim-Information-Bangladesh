package com.mamunsproject.sokol_simer_joruri_number;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import soup.neumorphism.NeumorphButton;
import soup.neumorphism.NeumorphFloatingActionButton;

import static com.facebook.ads.AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CRASH_DEBUG_MODE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView firstCard, secondCard, thirdCard;
    NeumorphFloatingActionButton shareButton, rateButton, moreButton;
    private AdView adView;
    private InterstitialAd interstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Initialize the Audience Network SDK
        AdSettings.setIntegrationErrorMode(INTEGRATION_ERROR_CRASH_DEBUG_MODE);
        AudienceNetworkAds.initialize(this);




        //===============================================FB INTERSTITIAL AD============================================

        interstitialAd = new InterstitialAd(getApplicationContext(), "420633852693951_420634086027261");


        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                // Interstitial ad displayed callback
                Log.e("TAG", "Interstitial ad displayed.");
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                // Interstitial dismissed callback
                Log.e("TAG", "Interstitial ad dismissed.");
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Log.e("TAG", "Interstitial ad failed to load: " + adError.getErrorMessage());
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Interstitial ad is loaded and ready to be displayed
                Log.d("TAG", "Interstitial ad is loaded and ready to be displayed!");
                // Show the ad
                interstitialAd.show();
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
                Log.d("TAG", "Interstitial ad clicked!");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
                Log.d("TAG", "Interstitial ad impression logged!");
            }
        };

        // For auto play video ads, it's recommended to load the ad
        // at least 30 seconds before it is shown
        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());



        ScheduledExecutorService scheduledExecutorService
                = Executors.newSingleThreadScheduledExecutor();

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if (interstitialAd.isAdInvalidated()) {
                            interstitialAd.loadAd();
                        }
//                        if (interstitialAd.isAdInvalidated()) {
//                            interstitialAd.loadAd();
//                        }

                    }
                });
            }
        },30,30, TimeUnit.SECONDS);


//===============================================FB INTERSTITIAL AD============================================


//===============================================FB BANNER AD============================================


        adView = new AdView(this, "420633852693951_420638716026798", AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();


//===============================================FB BANNER AD============================================





        firstCard = findViewById(R.id.first);
        secondCard = findViewById(R.id.second);
        thirdCard = findViewById(R.id.third);


        shareButton = findViewById(R.id.shareButton);
        rateButton = findViewById(R.id.ratingButton);
        moreButton = findViewById(R.id.moreAppButtn);

        firstCard.setOnClickListener(this::onClick);
        secondCard.setOnClickListener(this::onClick);
        thirdCard.setOnClickListener(this::onClick);


        shareButton.setOnClickListener(this::onClick);
        rateButton.setOnClickListener(this::onClick);
        moreButton.setOnClickListener(this::onClick);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.first:
                startActivity(new Intent(getApplicationContext(), AllSim.class));
                break;

            case R.id.second:
                startActivity(new Intent(getApplicationContext(), Offers.class));
                break;

            case R.id.third:
                startActivity(new Intent(getApplicationContext(), KoytiAccount.class));
                break;


            case R.id.shareButton:
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "USSD Code Of SIM Card");
                    String shareMessage = "\nThis is a very well informed about all ussd code of sim\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "Choose one"));
                } catch (Exception e) {
                    e.toString();
                }
                break;


            case R.id.ratingButton:
                final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                } catch (android.content.ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                }


                break;


            case R.id.moreAppButtn:


                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=bCreative"  )));




                break;


        }
    }
}