package sieol.admobadsguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by akbar on 29/05/2017.
 */

public class AdsActivity extends AppCompatActivity {


    private AdView mAdViewTop, mAdViewBottom;
    private RelativeLayout banner_top_rl, banner_bottom_rl;
    private InterstitialAd interstitial;
    private Button full_screen_ad;


    @Override
    protected void onPause() {
        mAdViewTop.pause();
        mAdViewBottom.pause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdViewTop.resume();
        mAdViewBottom.resume();
    }


    private void showInterestial() {

        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId(getString(R.string.interstitial_id));

        AdRequest adRequest = new AdRequest.Builder().addTestDevice(getString(R.string.deviceID)).build();

        interstitial.loadAd(adRequest);
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                displayInterstitial();
            }
        });
    }

    private void displayInterstitial() {
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ads_screen);

        Intent intent = getIntent();
        String action = intent.getAction();


        mAdViewTop = (AdView) findViewById(R.id.adView_top);
        mAdViewBottom = (AdView) findViewById(R.id.adView_bottom);
        banner_top_rl = (RelativeLayout) findViewById(R.id.banner_top_rl);
        banner_bottom_rl = (RelativeLayout) findViewById(R.id.banner_bottom_rl);
        full_screen_ad = (Button) findViewById(R.id.full_screen_ad);

        banner_top_rl.setVisibility(View.INVISIBLE);
        banner_bottom_rl.setVisibility(View.INVISIBLE);

        AdRequest adRequest = new AdRequest.Builder().addTestDevice(getString(R.string.deviceID)).build();

        mAdViewTop.loadAd(adRequest);
        mAdViewBottom.loadAd(adRequest);


        if (action.equalsIgnoreCase("top")) {
            banner_top_rl.setVisibility(View.VISIBLE);
        } else if (action.equalsIgnoreCase("bottom")) {
            banner_bottom_rl.setVisibility(View.VISIBLE);
        } else {
            showInterestial();
        }


        full_screen_ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInterestial();
            }
        });

    }


}
