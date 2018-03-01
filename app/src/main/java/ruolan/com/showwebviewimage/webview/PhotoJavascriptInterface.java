package ruolan.com.showwebviewimage.webview;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.Arrays;

import ruolan.com.showwebviewimage.ui.ShowPhotoActivity;

/**
 * Created by wuyinlei on 2018/3/1.
 *
 * @function
 */

public class PhotoJavascriptInterface {

    private Context context;
    private String[] imageUrls;

    public PhotoJavascriptInterface(Context context, String[] imageUrls) {
        this.context = context;
        this.imageUrls = imageUrls;
    }

    @android.webkit.JavascriptInterface
    public void openImage(String img) {
        Intent intent = new Intent(context, ShowPhotoActivity.class);
        int position = 0;
        //以下几行代码是为了获取点击的图片的position
        for (int i = 0; i < imageUrls.length; i++) {
            if (imageUrls[i].equals(img)) {
                position = i;
                break;
            }
        }
        intent.putExtra("position", position);
        ArrayList<String> images = new ArrayList<>();
        images.addAll(Arrays.asList(imageUrls));
        intent.putStringArrayListExtra("image", images);
        context.startActivity(intent);
    }

}
