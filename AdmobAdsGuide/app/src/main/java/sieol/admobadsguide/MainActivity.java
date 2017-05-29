package sieol.admobadsguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button top_banner_ad_btn, bottom_banner_ad_btn, interstitial_banner_ad_btn, get_codes_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        top_banner_ad_btn = (Button) findViewById(R.id.top_banner_ad_btn);
        bottom_banner_ad_btn = (Button) findViewById(R.id.bottom_banner_ad_btn);
        interstitial_banner_ad_btn = (Button) findViewById(R.id.interstitial_banner_ad_btn);
        get_codes_btn = (Button) findViewById(R.id.get_codes_btn);

        top_banner_ad_btn.setOnClickListener(this);
        bottom_banner_ad_btn.setOnClickListener(this);
        interstitial_banner_ad_btn.setOnClickListener(this);
        get_codes_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == top_banner_ad_btn.getId()) {
            Intent adsActivity = new Intent(MainActivity.this, AdsActivity.class);
            adsActivity.setAction("Top");
            startActivity(adsActivity);
        } else if (view.getId() == bottom_banner_ad_btn.getId()) {
            Intent adsActivity = new Intent(MainActivity.this, AdsActivity.class);
            adsActivity.setAction("Bottom");
            startActivity(adsActivity);
        } else if (view.getId() == interstitial_banner_ad_btn.getId()) {
            Intent adsActivity = new Intent(MainActivity.this, AdsActivity.class);
            adsActivity.setAction("Interstitial");
            startActivity(adsActivity);
        } else {
            return;
        }
    }
}
