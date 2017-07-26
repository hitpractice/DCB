package com.hitsoft.dab;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/7/20.
 */

public class FragmentActivity extends Activity implements View.OnClickListener {

    private OrderFragment orderFragment;

    private BillFragment billFragment;

    private MyFragment myFragment;

    private View OrderLayout;

    private View BillLayout;

    private View MyLayout;

    private ImageView orderImage;

    private ImageView billImage;

    private ImageView myImage;

    private TextView orderText;

    private TextView billText;

    private TextView myText;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fragment);
        // 初始化布局元素
        initViews();
        fragmentManager = getFragmentManager();
        // 第一次启动时选中第0个tab
        setTabSelection(0);
    }

    /**
     * 在这里获取到每个需要用到的控件的实例，并给它们设置好必要的点击事件。
     */
    private void initViews() {
        OrderLayout = findViewById(R.id.order_layout);
        BillLayout = findViewById(R.id.bill_layout);
        MyLayout = findViewById(R.id.my_layout);

        orderImage = (ImageView) findViewById(R.id.order_image);
        billImage = (ImageView) findViewById(R.id.bill_image);
        myImage = (ImageView) findViewById(R.id.my_image);

        orderText = (TextView) findViewById(R.id.order_text);
        billText = (TextView) findViewById(R.id.bill_text);
        myText = (TextView) findViewById(R.id.my_text);

        OrderLayout.setOnClickListener(this);
        BillLayout.setOnClickListener(this);
        MyLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.order_layout:
                // 当点击了消息tab时，选中第1个tab
                setTabSelection(0);
                break;
            case R.id.bill_layout:
                // 当点击了联系人tab时，选中第2个tab
                setTabSelection(1);
                break;
            case R.id.my_layout:
                // 当点击了动态tab时，选中第3个tab
                setTabSelection(2);
                break;
            default:
                break;
        }
    }

    /**
     * 根据传入的index参数来设置选中的tab页。
     *            每个tab页对应的下标。0表示外卖，1表示订单，2表示我的。
     */
    private void setTabSelection(int index) {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:
                // 当点击了tab时，改变控件的图片和文字颜色
                orderImage.setImageResource(R.mipmap.if_buy_g);
                orderText.setTextColor(Color.BLACK);
                if (orderFragment == null) {
                    orderFragment = new OrderFragment();
                    transaction.add(R.id.content, orderFragment);
                } else {
                    transaction.show(orderFragment);
                }
                break;
            case 1:
                // 当点击了tab时，改变控件的图片和文字颜色
                billImage.setImageResource(R.mipmap.if_bill_g);
                billText.setTextColor(Color.BLACK);
                if (billFragment == null) {
                    billFragment = new BillFragment();
                    transaction.add(R.id.content, billFragment);
                } else {
                    transaction.show(billFragment);
                }
                break;
            case 2:
            default:
                // 当点击了tab时，改变控件的图片和文字颜色
                myImage.setImageResource(R.mipmap.if_my_g);
                myText.setTextColor(Color.BLACK);
                if (myFragment == null) {
                    myFragment = new MyFragment();
                    transaction.add(R.id.content, myFragment);
                } else {
                    transaction.show(myFragment);
                }
                break;
        }
        transaction.commit();
    }

    /**
     * 清除掉所有的选中状态。
     */
    private void clearSelection() {
        orderImage.setImageResource(R.mipmap.if_buy);
        orderText.setTextColor(Color.parseColor("#82858b"));
        billImage.setImageResource(R.mipmap.if_bill);
        billText.setTextColor(Color.parseColor("#82858b"));
        myImage.setImageResource(R.mipmap.if_my);
        myText.setTextColor(Color.parseColor("#82858b"));
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *            用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (orderFragment != null) {
            transaction.hide(orderFragment);
        }
        if (billFragment != null) {
            transaction.hide(billFragment);
        }
        if (myFragment != null) {
            transaction.hide(myFragment);
        }
    }
}