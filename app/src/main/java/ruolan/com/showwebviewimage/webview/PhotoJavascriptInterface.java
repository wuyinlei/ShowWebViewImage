package ruolan.com.showwebviewimage.webview;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

import ruolan.com.showwebviewimage.ui.ShowPhotoActivity;

/**
 * Created by wuyinlei on 2018/3/1.
 *
 * @function
 */

public class PhotoJavascriptInterface {

    private Context context;
    private List imageUrls;

    public PhotoJavascriptInterface(Context context, List imageUrls) {
        this.context = context;
        this.imageUrls = imageUrls;
    }

    @android.webkit.JavascriptInterface
    public void openImage(String img) {
        Intent intent = new Intent(context, ShowPhotoActivity.class);
        int position = 0;
        position = imageUrls.indexOf(img);
        intent.putExtra("position", position);
        intent.putStringArrayListExtra("image", (ArrayList<String>) imageUrls);
        context.startActivity(intent);
    }

}
