package com.example.menuutama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       initSlider();
        ButterKnife.bind(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_center_navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.product:
                Product();
                return true;
            case R.id.map:
                location();
//            case R.id.user:
//                profile();
//            case R.id.cart:
//                keranjang();
//                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }





    private void initSlider() {
        for (int i = 0; i < IMAGES.length; i++)
            ImagesArray.add(IMAGES[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new Imageslider(MainActivity.this, ImagesArray));

        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        indicator.setViewPager(mPager);
        final float density = getResources().getDisplayMetrics().density;
        indicator.setRadius(5 * density);

        NUM_PAGES = IMAGES.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });
    }

    @OnClick(R.id.cv_lokasi_menu)
    public void location(){
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?daddr=-6.931547, 107.717056"));
        startActivity(intent);
    }

    @OnClick(R.id.cv_product)
    public void Product(){
       
    }

//    @OnClick(R.id.cv_artikel)
//    public void listMenu(){
//        Intent intent = new Intent(getApplicationContext(), ListMenuActivity.class);
//        startActivity(intent);
//    }
//    @OnClick(R.id.cv_artikel)
//    public void profile(){
//        Intent intent = new Intent(getApplicationContext(), ListMenuActivity.class);
//        startActivity(intent);
//    }
//
//    @OnClick(R.id.cv_artikel)
//    public void keranjang(){
//        Intent intent = new Intent(getApplicationContext(), ListMenuActivity.class);
//        startActivity(intent);
//    }
}
