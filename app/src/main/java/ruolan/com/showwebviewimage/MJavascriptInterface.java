package ruolan.com.showwebviewimage;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by wuyinlei on 2018/3/1.
 *
 * @function
 */

public class MJavascriptInterface {

    private Context context;
    private String [] imageUrls;

    public MJavascriptInterface(Context context,String[] imageUrls) {
        this.context = context;
        this.imageUrls = imageUrls;
    }

    @android.webkit.JavascriptInterface
    public void openImage(String img) {
        Intent intent = new Intent();
        for (int i = 0; i < imageUrls.length; i++) {
            Log.e("图片地址"+i,imageUrls[i].toString());
        }
    }

}
