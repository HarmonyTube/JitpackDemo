package com.dingyizhe.kungfu;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.dingyizhe.kungfu.ui.fragment.ClassificationFragment;
import com.dingyizhe.kungfu.ui.fragment.HomeFragment;
import com.dingyizhe.kungfu.ui.fragment.MineFragment;
import com.dingyizhe.kungfu.ui.view.moduler.NavItem;
import com.dingyizhe.kungfu.ui.view.moduler.NavViewBottomContainer;
import com.gyf.immersionbar.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_container)
    FrameLayout mainContainer;
    @BindView(R.id.nav_container)
    NavViewBottomContainer navContainer;
    private ArrayList<NavItem> navItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        StatusBarUtil.setTransparent(this);
        setContentView(R.layout.activity_main);
//        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
//        StatusBarUtil.setDarkMode(this);

        ImmersionBar.with(this)
                .transparentStatusBar()  //透明状态栏，不写默认透明色
                .statusBarDarkFont(true)
//                .statusBarColor(R.color.transparent,0)
//                .fitsSystemWindows(true)
                .navigationBarColor(R.color.navigationBarColor)
//                .autoNavigationBarDarkModeEnable(true,0.2f)
                .init();

        ButterKnife.bind(this);
        navItemList = new ArrayList<>();
        navItemList.add(new NavItem(R.string.home, R.raw.icon_home, R.color.nav_home_title_color, HomeFragment.newInstance()));
        navItemList.add(new NavItem(R.string.classification, R.raw.icon_groups, R.color.nav_category_title_color, ClassificationFragment.newInstance()));
//        navItemList.add(new NavItem(R.string.topic, R.raw.icon_home, R.color.red, TopicFragment.newInstance()));
        navItemList.add(new NavItem(R.string.mine, R.raw.icon_mine, R.color.nav_mine_title_color, MineFragment.newInstance()));
        navContainer.addItem(navItemList);
        switchContent(navItemList.get(0).getFragment(), R.id.main_container);//替换碎片
        navContainer.setOnItemClickListener(new NavViewBottomContainer.OnItemClickListener() {
            @Override
            public void onItemSelect(int newPosition, int oldPosition) {
                if (newPosition == oldPosition) {
                    return;
                }
                navContainer.setSelectedPosition(newPosition);
                switchContent(navItemList.get(newPosition).getFragment(), R.id.main_container);//替换碎片
            }
        });
        navContainer.setSelectedPosition(0);

//        setLightNavigationBar(this, true);
//        setLightNavigationBarLine(this, true);
    }


    /**
     *     * 修改NavigationBar按键颜色 两色可选【黑，白】
     *     *
     */
    @TargetApi(Build.VERSION_CODES.O)
    public void setLightNavigationBar(Activity activity, boolean light) {
        int vis = activity.getWindow().getDecorView().getSystemUiVisibility();
        if (light) {
            // 黑色
            vis |= View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
        } else {
            //白色
            vis &= ~View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
        }
        activity.getWindow().getDecorView().setSystemUiVisibility(vis);
    }

    @TargetApi(Build.VERSION_CODES.P)
    public void setLightNavigationBarLine(Activity activity, boolean light) {
        activity.getWindow().setNavigationBarDividerColor(getColor(R.color.main_color));
    }


    public void test() {

        /**
         * 通过Environment获取
         */
        //获得根目录/data内部存储路径
        System.out.println("Environment.getDataDirectory(): " + Environment.getDataDirectory().getPath());
        //获得缓存目录/cache
        System.out.println("Environment.getDownloadCacheDirectory(): " + Environment.getDownloadCacheDirectory().getPath());
        //获得SD卡目录/mnt/sdcard（获取的是手机外置sd卡的路径）
        System.out.println("Environment.getExternalStorageDirectory(): " + Environment.getExternalStorageDirectory().getPath());
        //获得系统目录/system
        System.out.println("Environment.getRootDirectory(): " + Environment.getRootDirectory().getPath());

        /**
         * 通过Context获取
         */
        //用于获取APP的cache目录 /data/data/<application
        System.out.println("getCacheDir(): " + getCacheDir().getPath());
        //用于获取APP的在SD卡中的cache目
        System.out.println("getExternalCacheDir(): " + getExternalCacheDir().getPath());
        //用于获取APP的files目录 /data/data/<application
        System.out.println("getFilesDir(): " + getFilesDir());
        //用于获取APPSDK中的obb目录
        System.out.println("getObbDir: " + getObbDir().getPath());
        //用于获取APP的所在包目录
        System.out.println("getPackageName: " + getPackageName());
        //来获得当前应用程序对应的 apk 文件的路径
        System.out.println("getPackageCodePath: " + getPackageCodePath());
        //获取该程序的安装包路径
        System.out.println("getPackageResourcePath: " + getPackageResourcePath());

//        Environment.getDataDirectory() = /data
//        Environment.getDownloadCacheDirectory() = /cache
//        Environment.getExternalStorageDirectory() = /mnt/sdcard
//        Environment.getExternalStoragePublicDirectory(“test”) = /mnt/sdcard/test
//        Environment.getRootDirectory() = /system
//        getPackageCodePath() = /data/app/com.my.app-1.apk
//        getPackageResourcePath() = /data/app/com.my.app-1.apk
//        getCacheDir() = /data/data/com.my.app/cache
//        getDatabasePath(“test”) = /data/data/com.my.app/databases/test
//        getDir(“test”, Context.MODE_PRIVATE) = /data/data/com.my.app/app_test
//        getExternalCacheDir() = /mnt/sdcard/Android/data/com.my.app/cache
//        getExternalFilesDir(“test”) = /mnt/sdcard/Android/data/com.my.app/files/test
//        getExternalFilesDir(null) = /mnt/sdcard/Android/data/com.my.app/files
//        getFilesDir() = /data/data/com.my.app/files


//
//各个路径
//最长用到的就这三个位置
//
///data/data/包名/
///sdcard/Android/data/包名/
///sdcard/xxx
//前两个是应用内部存储, 会随着app的卸载而自动删除, sdcard中其他的文件夹不会自动删除, 除非用户手动删除, 否则会一直存在, 换句话说就是垃圾.
//Google官方建议把数据存储在 /sdcard/Android/data/包名/ 下.
//
//路径获取方法
//前两个应用内部存储通过 Context 来获取, 第三个作为外部存储是通过 Environment 类来获取. 注释为返回值.
//
///data/data/包名/
//
//context.getFilesDir();    // /data/data/包名/files
//context.getCacheDir();    // /data/data/包名/cache
//1
//2
///sdcard/Android/data/包名/
//
//context.getExternalFilesDir();    // /sdcard/Android/data/包名/files
//context.getExternalCacheDir();    // /sdcard/Android/data/包名/cache
//1
//2
///sdcard/xxx
//
//// /storage/emulated/0
//Environment.getExternalStorageDirectory();
//
//// /storage/emulated/0/DCIM, 另外还有MOVIE/MUSIC等很多种标准路径
//Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
//1
//2
//3
//4
//5
//注意, 根据源码文档中说明, 获取外部存储时, 有可能会因为各种问题导致获取失败, 建议先使用 getExternalStorageState 来判断外部存储状态, 如果已挂载的话再存储.
//
//设置中清除的数据
//在手机设置中的应用设置里有 清除数据 和 清除缓存 两个选项, 它们清除的位置是:
//清除数据 清除的是 /Android/data/包名/ 和 /data/data/包名/ 下的所有内容;
//清除缓存 会清除 /sdcard/Android/data/包名/cache/ 和 /data/data/包名/cache/ 内的内容.
///sdcard/xxx 下的内容会依然存在.

    }

    /**
     * 切换fragment
     */
    @SuppressLint("RestrictedApi")
    protected void switchContent(Fragment fragment, int fragmentId) {
        if (fragment == null) {
            return;
        } else {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            List<Fragment> fragments = fragmentManager.getFragments();
//            log.debug("fragments>" + fragments);
//            log.debug("fragment>" + fragment);
            if (fragments == null) {
                //fragment 默认是显示的
                transaction.add(fragmentId, fragment).commitAllowingStateLoss();
                return;
            }
            if (!fragments.contains(fragment)) {
//                log.debug("add>" + fragment);
                transaction.add(fragmentId, fragment).commitAllowingStateLoss();
            }
            transaction = fragmentManager.beginTransaction();
            fragments = fragmentManager.getFragments();
            for (int i = 0; i < fragments.size(); i++) {
                //先隐藏再显示
                transaction.hide(fragments.get(i));
            }
            transaction.show(fragment).commitAllowingStateLoss();
        }
    }

    //    /**
//     * 添加或者显示碎片
//     *
//     * @param transaction
//     * @param fragment
//     */
//    private void addOrShowFragment(FragmentTransaction transaction,
//                                   Fragment fragment) {
//        if (fragment == null)
//            return;
//        if (!fragment.isAdded()) { // 如果当前fragment未被添加，则添加到Fragment管理器中
//            transaction.hide(fragment)
//                    .add(R.id.fragement_content, fragment).commit();
//            transaction.show(fragment).commitAllowingStateLoss();
//        } else {
//            transaction.hide(fragment).show(fragment).commit();
//        }
//    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //返回桌面
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent home = new Intent(Intent.ACTION_MAIN);
            home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            home.addCategory(Intent.CATEGORY_HOME);
            startActivity(home);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}
