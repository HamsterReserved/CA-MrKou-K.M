package k.app;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2015/3/24.
 */
public class fen {
    private Activity activity;
    private Uri uri;
    public List<Smsinfo> infos;
    private TextView info ;

    public fen(Activity activity, Uri uri) {
        infos= new ArrayList<Smsinfo>();
        this.activity = activity;
        this.uri = uri;
    }

    public List<Smsinfo>  getSmsInfo() {
        String[] projection = new String[]{"_id", "address", "person",
                "body", "date", "type"};
        Cursor cusor = activity.managedQuery(uri, projection, null, null,
                "date desc");
        int nameColumn = cusor.getColumnIndex("person");
        int phoneNumberColumn = cusor.getColumnIndex("address");
        int smsbodyColumn = cusor.getColumnIndex("body");
        int dateColumn = cusor.getColumnIndex("date");
        int typeColumn = cusor.getColumnIndex("type");
        if (cusor != null) {

            while (cusor.moveToNext()) {
                Smsinfo smsinfo = new Smsinfo();
                smsinfo.setName(cusor.getString(nameColumn));
                smsinfo.setDate(cusor.getString(dateColumn));
                smsinfo.setPhoneNumber(cusor.getString(phoneNumberColumn));
                smsinfo.setSmsbody(cusor.getString(smsbodyColumn));
                smsinfo.settype(cusor.getString(typeColumn));
                infos.add(smsinfo);

            }
        }
        cusor.close();

        return infos;
    }


}
