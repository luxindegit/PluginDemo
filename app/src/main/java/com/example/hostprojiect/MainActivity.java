package com.example.hostprojiect;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.pluginlib.PlugLibBean;

public class MainActivity extends Activity {
    LinearLayout llMainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llMainLayout = (LinearLayout) findViewById(R.id.content);

    }


    public void open(View view) {
        llMainLayout.removeAllViews();
        attachPlugin(findPlugins());
    }


    private List<PlugLibBean> findPlugins() {


        List<PlugLibBean> plugins = new

                ArrayList<PlugLibBean>();


        PackageManager pm = getPackageManager();

        List<PackageInfo> pkgs = pm
                .getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);

        for (PackageInfo pkg : pkgs) {


            String packageName = pkg.packageName;

            String sharedUserId = pkg.sharedUserId;


            if (!"com.chinatransinfo.plugin".equals(sharedUserId)
                    || packageName.equals("com.example.hostprojiect"))
                continue;
            String prcessName = pkg.applicationInfo.processName;
            String label = pm.getApplicationLabel(pkg.applicationInfo)
                    .toString();
            PlugLibBean plug = new

                    PlugLibBean();

            plug.label = label;

            plug.pakageName = packageName;

            plugins.add(plug);

        }

        return plugins;

    }

    /**
     * ���ز���б�
     */

    private void attachPlugin(final List<PlugLibBean> plugins) {


        for (final PlugLibBean plugin : plugins) {

            System.out.println(plugin.pakageName);

            Button btn = new Button(this);

            btn.setTextColor(Color.RED);

            btn.setText(plugin.pakageName);
            btn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    llMainLayout.removeAllViews();
                    Intent it = new Intent();
                    Bundle Bundle = new Bundle();
                    it.putExtra("key", "我是传递过来的值");
                    PlugLibBean PlugLibBean=null;
                    it.putExtra("bean",plugin);
                    it.setAction(plugin.pakageName);
                    startActivityForResult(it,1);
                  //  llMainLayout.addView(Decor);

                }
            });
            llMainLayout.addView(btn);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            Toast.makeText(this, "接受到返回值", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
