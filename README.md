# bmobLibrary
[![](https://jitpack.io/v/reyreyrey/library.svg)](https://jitpack.io/#reyreyrey/library)
</br>

##引入
<p>在项目的build.gradle中添加如下代码</p>
<pre>
  <code>
    allprojects{
      repositories {
          jcenter()
          maven { url "https://jitpack.io" }
      }
    }
  </code>
</pre>

<p>在Module的build.gradle中添加如下代码</p>
<pre>
  <code>
  //加号替换为jitpack版本号
    compile 'com.github.reyreyrey:library:+'
  </code>
</pre>

##使用
<p>
	1.复制<a href="https://github.com/reyreyrey/library/blob/master/keys/"
		title="">签名文件</a>到Module，复制<a
		href="https://github.com/reyreyrey/library/blob/master/gradle/common_gradle.gradle"
		title="">common.gradle</a>、<a
		href="https://github.com/reyreyrey/library/blob/master/gradle/global.gradle"
		title="">global.gradle</a>和<a
		href="https://github.com/reyreyrey/library/blob/master/gradle/simple.gradle"
		title="">simple.gradle</a>到项目的gradle文件夹中
</p>
<p>2.修改Module的build.gradle</p>
<pre>
  <code>
    apply from: '../gradle/common_gradle.gradle'
    dependencies {
        compile fileTree(include: ['*.jar'], dir: 'libs')
        //加号替换为jitpack版本号
        compile 'com.github.xinruzhou:library:+'
    }
  </code>
</pre>
<p>3.在项目的Application中添加代码</p>
<pre>
  <code>
    @Override
    public void onCreate() {
        super.onCreate();
        Library.init(this, BuildConfig.DEBUG);
    }
  </code>
</pre>
<p>4.新建SplashActivity继承SplashBaseActivity,并复写以下方法</p>
<pre>
  <code>
    public class SplashActivity extends SplashBaseActivity{
        @Override
            protected void toMain() {
                //跳转到主界面
                startActivity(new Intent(this, MainActivity.class));
                finish();
            }
            @Override
            protected String getAppID() {
                //返回在后台添加的appid
                return "2";
            }
            @Override
            protected int getSplashImageRes() {
                //无需修改
                return ResourceUtil.getDrawableId(this, BuildConfig.SPLASH_PIC);
            }
            @Override
            protected boolean isShowGuide() {
                //是否显示引导页（开关开启的时候才会读这个配置）
                return false;
            }
            @Override
            protected int[] guideRess() {
                //引导页图片资源数组
                return null;
            }
    }
  </code>
</pre>
<p>5.配置AndroidManifest.xml</p>
<pre>
  <code>
        //配置应用的图标
       android:icon="${app_icon}"
       //将你的SplashActivity配置为启动Activity
  </code>
</pre>
<p>6.删除string.xml中的app_name和colors.xml中的colorPrimary</p>
<p>7.编译运行</p>

##其他
<p>1.最近开奖页面</p>
<pre>
  <code>
        startActivity(new Intent(context, TrendChartActivity.class));
  </code>
 </pre>

<p>2.走势图页面</p>
<pre>
   <code>
        startActivity(new Intent(context, LottoTrendActivity.class));
   </code>
</pre>
<p>3.画展瀑布流页面</p>
<pre>
   <code>
        startActivity(new Intent(context, ArtActivity.class));
   </code>
</pre>
<p>4.聊天页面</p>
<pre>
   <code>
        ChatActivity.chat(ChatListActivity.this, username);
   </code>
</pre>
<p>5.福利美女页面</p>
<pre>
  <code>
        startActivity(new Intent(context, FuliActivity.class));
  </code>
</pre>
<p>6.鬼故事页面</p>
<pre>
	<code>
        startActivity(new Intent(context, GuigushiActivity.class));
    </code>
</pre>
<p>7.幸运转盘页面</p>
<pre>
    <code>
        startActivity(new Intent(context, LuckPanelActivity.class));
    </code>
</pre>
<p>8.漫画页面</p>
<pre>
    <code>
        startActivity(new Intent(context, ManhualistActivity.class));
    </code>
</pre>
<p>8.微信文章页面</p>
<pre>
    <code>
        startActivity(new Intent(context, WXMeiwenActivity.class));
    </code>
</pre>
<p>9.笑话页面</p>
<pre>
    <code>
        startActivity(new Intent(context, XiaohuaActivity.class));
    </code>
</pre>

<p>10.webview</p>
<pre>
    <code>
        //isShowBack： false:不显示toolbar,点击返回键退出页面  true:显示toolbar，可以返回之前的页面
        WebViewActivity.load(context, url, isShowBack);
        //isShowBack是false
        WebViewActivity.load(context, url);
        //isShowBack是true
        WebViewActivity.openWebViewUrl(context, url, title);
   </code>
</pre>
<p>11.toast</P>
<pre>
     <code>
        ToastUtils.toastError(context, message);
    </code>
</pre>
<p>12.Progress</P>
<pre>
    <code>
        ProgressDialogUtils.showProgress(context);
        ProgressDialogUtils.dismissProgress();
    </code>
</pre>

<p>
    13.下拉刷新使用参考<a
		href="https://github.com/reyreyrey/library/blob/master/app/src/main/java/com/android/bmoblibrary/ui/TrendChartActivity.java"
		title="TrendChartActivity">TrendChartActivity</a>
</P>
<p>
	14.library提供<a
		href="https://github.com/reyreyrey/library/blob/master/app/src/main/java/com/android/bmoblibrary/base/UIActivity.java"
		title="UIActivity">UIActivity</a>和<a
		href="https://github.com/reyreyrey/library/blob/master/app/src/main/java/com/android/bmoblibrary/base/UIBaseFragment.java"
		title="UIBaseFragment">UIBaseFragment</a>
</p>
<p>
	15.如果需要混淆，请将<a
		href="https://github.com/reyreyrey/library/blob/master/app/proguard-rules.pro"
		title="proguard-rules.pro">proguard-rules.pro</a>文件拷贝到项目中
</p>