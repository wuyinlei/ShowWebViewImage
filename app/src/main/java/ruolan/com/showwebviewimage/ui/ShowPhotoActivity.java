package ruolan.com.showwebviewimage.ui;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ruolan.com.showwebviewimage.R;

public class ShowPhotoActivity extends AppCompatActivity {

    private TextView mTvPage;

    //当前查看的位置
    private int position = 0;
    //图片集合
    private List<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_photo);
        position = getIntent().getIntExtra("position", 0);
        mImageUrls = getIntent().getStringArrayListExtra("image");
        mTvPage = findViewById(R.id.tv_page);
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new SamplePagerAdapter(mImageUrls));
        viewPager.setCurrentItem(position);
        mTvPage.setText(++position + "/" + mImageUrls.size());

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTvPage.setText(++position + "/" + mImageUrls.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    class SamplePagerAdapter extends PagerAdapter {

        private List<String> imageUrls = new ArrayList<>();

        public SamplePagerAdapter(List<String> imageUrls) {
            this.imageUrls = imageUrls;
        }

        @Override
        public int getCount() {
            return imageUrls.size();
        }

        @Override
        public View instantiateItem(ViewGroup container, int position) {
            PhotoView photoView = new PhotoView(container.getContext());

            //采用了picasso加载图片
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
