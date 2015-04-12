
package k.app;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private TextView textView;
    private List<Smsinfo> infos;
  //  private List<Smsinfo> info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri uri = Uri.parse("content://sms/");
        ContentResolver cr = getContentResolver();
       //  Uri uri = Uri.parse(Allfinalinfo.SMS_URII_INBOX);

        fen sc = new fen(this, uri);
        //info = getContentResolver().query("content://sms",null,null,null,);
        infos = sc.getSmsInfo();
        ListView listView = (ListView)findViewById(R.id.listView);
    //    SimpleAdapter simpleAdapter = new SimpleAdapter(this, (List<?extends java.util.Map<String, ?>>) infos,R.layout.listitem,new String[]{"name", "smsbody"},new int[]{R.id.user_name,R.id.user_id});

      //listView.setAdapter(simpleAdapter);


       // listView = new ListView(this);
        listView.setAdapter(new SmsListAdapter(this));
      // ImageView imageView = (ImageView) this .findViewById(R.id.imageView);

       // TextView textView1 =(TextView)findViewById(R.id.list_item);
       // listView.addView(TextView,);

    }

    class SmsListAdapter extends BaseAdapter {
        private LayoutInflater layoutinflater;

        public SmsListAdapter(Context c) {
            layoutinflater = LayoutInflater.from(c);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return infos.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutinflater.inflate(R.layout.listitem, null);
            }


            TextView body = (TextView) convertView
                    .findViewById(R.id.TextView_SmsBody);
           // TextView name = (TextView) convertView
                //    .findViewById(R.id.TextView_SmsName);
            body.setText(infos.get(position).getSmsbody());
         //   name.setText(infos.get(position).getName());
            return convertView;

        }

    }


     @Override
      public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
