package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_web extends AppCompatActivity {
    private WebView webview;
    private EditText editurl;
    private Button btnForward;
    private Button btnBack;
    private Button btnGo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_web);

        editurl = (EditText)findViewById(R.id.editText);
        btnForward = (Button)findViewById(R.id.button);
        btnBack = (Button)findViewById(R.id.button2);
        btnGo = (Button)findViewById(R.id.button3);
        webview = (WebView)findViewById(R.id.webView);
        WebSettings browserSetting = webview.getSettings(); //创建WebSettings对象
        browserSetting.setSupportMultipleWindows(false);	//不支持对窗口
        browserSetting.setJavaScriptEnabled(true);		//支持JavaScript脚本
        webview.setWebChromeClient(new WebChromeClient(){
            @Override
            //重写onProgressChanged方法，实现打开页面时的进度条
            public void onProgressChanged(WebView view, int progress){
                //设置打开页面时滚动条的文字
                Activity_web.this.setTitle("Loading...");
                //设置滚动条的进度
                Activity_web.this.setProgress(progress * 100);
                if(progress == 100)
                    Activity_web.this.setTitle(R.string.app_name);
            }
        });
        webview.setWebViewClient(new WebViewClient() {
            @Override
            //重写shouldOverrideUrlLoading方法，保证在当前WebView中打开页面的链接
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //加载页面内点击链接的请求页面
                view.loadUrl(url);
                return true;
            }
        });
        //前进按钮添加监听器
        btnForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webview.goForward();		//返回当前页面下一次打开的页面
            }
        });
        //后退按钮添加监听器
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webview.goBack();			//返回当前页面上一次打开的页面
            }
        });
        //打开按钮添加监听器
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取EditText中的URL地址
                String url = editurl.getText().toString().trim();
                if(URLUtil.isNetworkUrl(url)){		//判断URL的是否正确
                    webview.loadUrl(url);			//打开当前的链接
                }
                else{
                    Toast.makeText(Activity_web.this, "The NetAddress is Error!", Toast.LENGTH_SHORT).show();			//URL不正确，给出提示
                    editurl.requestFocus();
                }
            }
        });
        //EditText添加监听器
        editurl.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_ENTER) {	//是否是ENTER键
                    String url = editurl.getText().toString().trim();
                    if(URLUtil.isNetworkUrl(url)){
                        webview.loadUrl(url);			//打开当前的链接
                        return true;
                    }
                    else{
                        Toast.makeText(Activity_web.this, "The NetAddress is Error!", Toast.LENGTH_SHORT).show();		//URL不正确，给出提示
                        editurl.requestFocus();
                    }
                }
                return false;
            }
        });
    }
}