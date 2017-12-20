# bmobLibrary
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
    compile 'com.github.reyreyrey:library:1.0.1'
  </code>
</pre>

##使用
<p>1.复制<a href="https://github.com/reyreyrey/library/blob/master/keys/" title="">签名文件</a>到Module，复制<a href="https://github.com/reyreyrey/library/blob/master/gradle/common_gradle.gradle" title="">common.gradle</a>、<a href="https://github.com/reyreyrey/library/blob/master/gradle/global.gradle" title="">global.gradle</a>和<a href="https://github.com/reyreyrey/library/blob/master/gradle/flavors.gradle" title="">flavors.gradle</a>到项目的gradle文件夹中</p>
<p>2.修改Module的build.gradle</p>
<pre>
  <code>
    apply from: '../gradle/common_gradle.gradle'
    dependencies {
        compile fileTree(include: ['*.jar'], dir: 'libs')
        compile 'com.github.xinruzhou:library:1.0.0'
    }
  </code>
</pre>
<p>3.在项目的Application中添加代码</p>
<pre>
  <code>
    @Override
    public void onCreate() {
        super.onCreate();
        //BuildConfig.BMOB_KEY是根据global.gradle中配置的bmobkey自动生成的
        Library.init(this, BuildConfig.BMOB_KEY, BuildConfig.DEBUG);
    }
  </code>
</pre>
<p>4.新建SplashActivity继承SplashBaseActivity,并复写以下方法</p>
<pre>
  <code>
    public class SplashActivity extends SplashBaseActivity{
        @Override
        protected void toMain() {
            //需要跳转到主界面
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }

        @Override
        protected int getSplashImageRes() {
            //配置启动图，BuildConfig.SPLASH_PIC是根据global.gradle中配置的启动图自动生成的
            return ResourceUtil.getDrawableId(this, BuildConfig.SPLASH_PIC);
        }
    }
  </code>
</pre>
<p>5.配置AndroidManifest.xml</p>
<pre>
  <code>
        //配置应用的图标
       android:icon="@mipmap/你的logo图"
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

 <p>3.webview</p>
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
 <p>4.toast</P>
  <pre>
     <code>
            ToastUtils.toastError(context, message);
    </code>
  </pre>
<p>4.Progress</P>
    <pre>
       <code>
              ProgressDialogUtils.showProgress(context);
              ProgressDialogUtils.dismissProgress();
      </code>
</pre>

<p>5.下拉刷新使用参考<a href="https://github.com/reyreyrey/library/blob/master/app/src/main/java/com/android/bmoblibrary/ui/TrendChartActivity.java" title="TrendChartActivity">TrendChartActivity</a></P>
<p>6.根据接口检测的方法，参考<a href="https://github.com/reyreyrey/library/blob/master/test/src/main/java/module/com/test/ui/SplashInterfaceCheckActivity.java" title="SplashInterfaceCheckActivity">SplashInterfaceCheckActivity</a></p>
<p>7.library提供<a href="https://github.com/reyreyrey/library/blob/master/app/src/main/java/com/android/bmoblibrary/base/UIActivity.java" title="UIActivity">UIActivity</a>和<a href="https://github.com/reyreyrey/library/blob/master/app/src/main/java/com/android/bmoblibrary/base/UIBaseFragment.java" title="UIBaseFragment">UIBaseFragment</a></p>