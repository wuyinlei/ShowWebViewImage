package ruolan.com.showwebviewimage.ui;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ruolan.com.showwebviewimage.R;

public class ShowPhotoActivity extends AppCompatActivity {

    private int position = 0;
    private List<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_photo);
        position = getIntent().getIntExtra("position",0);
        mImageUrls = getIntent().getStringArrayListExtra("image");
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new SamplePagerAdapter(mImageUrls));
        viewPager.setCurrentItem(position);
    }


    class SamplePagerAdapter extends PagerAdapter {

        private List<String> imageUrls = new ArrayList<>();

        public SamplePagerAdapter(List<String> imageUrls) {
            this.imageUrls = imageUrls;
        }

        //        private static final int[] sDrawables = { R.drawable.wallpaper, R.drawable.wallpaper, R.drawable.wallpaper,
//                R.drawable.wallpaper, R.drawable.wallpaper, R.drawable.wallpaper };

        @Override
        public int getCount() {
            return imageUrls.size();
        }

        @Override
        public View instantiateItem(ViewGroup container, int position) {
            PhotoView photoView = new PhotoView(container.getContext());
//            photoView.set(mImageUrls.get(position));

            Picasso.with(ShowPhotoActivity.this)
                    .load(imageUrls.get(position))
                    .into(photoView);

            // Now just add PhotoView to ViewPager and return it
            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

            return photoView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

    }

}
