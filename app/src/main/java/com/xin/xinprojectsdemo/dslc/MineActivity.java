package com.xin.xinprojectsdemo.dslc;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.xin.xinprojectsdemo.R;
import com.xin.xinprojectsdemo.base.BaseActivity;
import com.xin.xinprojectsdemo.utils.SDCardUtils;
import com.xin.xinprojectsdemo.view.CircleImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MineActivity extends BaseActivity {

    private static final int CHOICEPHOTOCODE = 1001;
    private static final int TAKEPHOTOCODE = 1002;
    private static final int CROPPHOTO = 1003;
    private static String path = "/sdcard/myHead/";
    private FragmentManager mFragmentManager;
    private ViewPager mPager;


    private int currentItem = 0;
    private CircleImageView mAvatarImg;
    private PopupWindow popupWindow;
    private File file;
    private File filepath;
    private File updatefile;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_mine);
        mAvatarImg = (CircleImageView) findViewById(R.id.circleImageView);

    }


    @Override
    public void initListener() {
        mAvatarImg.setOnClickListener(this);


    }


    @Override
    public void initData() {


    }


    @Override
    public void processClick(View v) {
        switch (v.getId()) {
            //我的头像
            case R.id.circleImageView:
                changeHeaderPhoto(mAvatarImg);
                break;
        }

    }

    /**
     * 更换头像
     */
    private void changeHeaderPhoto(View v) {
        // 一个自定义的布局，作为显示的内容
        final View contentView = LayoutInflater.from(this).inflate(R.layout.change_head_photo_layout, null);
        TextView mTvChoicePhoto = (TextView) contentView.findViewById(R.id.tv_choice_photo);
        TextView mTvTakephoto = (TextView) contentView.findViewById(R.id.tv_takephoto);
        TextView mTvCanlechoice = (TextView) contentView.findViewById(R.id.tv_cancel);
        popupWindow = new PopupWindow(contentView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams
                .WRAP_CONTENT, true);
        //如果触摸的位置在popWindow范围之外就将其dismiss
        contentView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int height = contentView.findViewById(R.id.me_pop).getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        popupWindow.dismiss();
                    }
                }
                return true;
            }
        });
        //选择图片
        mTvChoicePhoto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (PackageManager.PERMISSION_GRANTED == getApplicationContext().getPackageManager().checkPermission
                        ("android" + ".permission.WRITE_EXTERNAL_STORAGE", "cn.dslc.dslc")) {
                    Intent choiceIntent = new Intent(Intent.ACTION_PICK, null);
                    choiceIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                    startActivityForResult(choiceIntent, CHOICEPHOTOCODE);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                    builder.setTitle(R.string.app_name).setMessage("当前无读写权限").setPositiveButton("去设置", new
                            DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // 跳转到系统的设置界面
                            Intent intent = new Intent();
                            intent.setAction("android.intent.action.MAIN");
                            intent.setClassName("com.android.settings", "com.android.settings.ManageApplications");
                            startActivity(intent);
                        }
                    }).setNegativeButton("暂不设置", null).show();
                }
            }
        });
        //拍照
        mTvTakephoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PackageManager.PERMISSION_GRANTED == getApplicationContext().getPackageManager().checkPermission
                        ("android" + ".permission.CAMERA", "cn.dslc.dslc") && PackageManager.PERMISSION_GRANTED ==
                        getApplicationContext().getPackageManager().checkPermission("android" + ".permission" +
                        ".WRITE_EXTERNAL_STORAGE", "cn" + ".dslc.dslc")) {
                    if (isCameraCanUse()) {
                        //调用相机拍照
                        Intent camareIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        camareIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(Environment
                                .getExternalStorageDirectory(), "head.jpg")));
                        startActivityForResult(camareIntent, TAKEPHOTOCODE);
                    } else {
                        Toast.makeText(MineActivity.this, "相机权限被拒绝", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    // TODO: 2016/8/3 change by mx
                    AlertDialog.Builder builder = new AlertDialog.Builder(MineActivity.this);
                    builder.setTitle(R.string.app_name).setMessage("当前无摄像头权限或者无读写权限").setPositiveButton("去设置", new
                            DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // 跳转到系统的网络设置界面
                            Intent intent = new Intent();
                            intent.setAction("android.intent.action.MAIN");
                            intent.setClassName("com.android.settings", "com.android.settings.ManageApplications");
                            startActivity(intent);
                        }
                    }).setNegativeButton("暂不设置", null).show();
                }
            }
        });
        mTvCanlechoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        popupWindow.setTouchable(true);
        popupWindow.showAtLocation(v, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        backgroundAlpha(0.6f);
        popupWindow.setOnDismissListener(new poponDismissListener());
    }

    /**
     * 测试当前摄像头能否被使用
     *
     * @return
     */
    public boolean isCameraCanUse() {
        boolean canUse = true;
        Camera mCamera = null;
        try {
            mCamera = Camera.open(0);
            mCamera.setDisplayOrientation(90);
        } catch (Exception e) {
            canUse = false;
        }
        if (canUse) {
            mCamera.release();
            mCamera = null;
        }
        return canUse;
    }

    private void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getWindow().setAttributes(lp);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            //在本地选择图片
            case CHOICEPHOTOCODE:
                if (null == data) {
                    return;
                }
                Uri uri = data.getData();
                if (null != uri) {
                        cropPhoto(uri);//裁剪图片
                }
                break;
            //拍照
            case TAKEPHOTOCODE:
                if (SDCardUtils.isSDCardEnable()) {
                    updatefile = new File(Environment.getExternalStorageDirectory() + "/head.jpg");
                    //裁剪图片
                    cropPhoto(Uri.fromFile(updatefile));
                } else {
                    Toast.makeText(MineActivity.this, "未找到SD卡", Toast.LENGTH_SHORT).show();
                }
                break;
            case CROPPHOTO:
                if (data != null) {
                    Bundle extras = data.getExtras();
                    if (extras != null) {
                        Bitmap head = (Bitmap) extras.get("data");
                        if (head != null) {
                            setPicToView(head);//保存在SD卡中
                            //用ImageView显示出来
                            if (popupWindow != null) {
                                popupWindow.dismiss();
                            }
                        }
                    }
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);

    }

    //将图片设置到视图
    private void setPicToView(Bitmap mBitmap) {
        String sdStatus = Environment.getExternalStorageState();
        if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) {
            // 检测sd是否可用
            return;
        }
        FileOutputStream b = null;
        file = new File(path);
        file.mkdirs();// 创建文件夹
        String fileName = path + "head.jpg";//图片名字
        filepath = new File(fileName);
        try {
            b = new FileOutputStream(filepath);
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 80, b);
            // 把数据写入文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {//关闭流
                if (b != null) {
                    b.flush();
                    b.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void cropPhoto(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROPPHOTO);
    }

    class poponDismissListener implements PopupWindow.OnDismissListener {
        @Override
        public void onDismiss() {
            backgroundAlpha(1f);
        }
    }
}
