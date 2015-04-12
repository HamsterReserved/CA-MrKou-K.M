package k.app;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2015/3/24.
 */
public class fen {
    private Context mContext;
    private Uri uri;
    public List<Smsinfo> infos;
    private TextView info ;

    public fen(Context context, Uri uri) {
        infos= new ArrayList<Smsinfo>();
        this.mContext = context;
        this.uri = uri;
    }

    public List<Smsinfo>  getSmsInfo() {
        String[] projection = new String[]{"_id", "address", "person",
                "body", "date", "type"};
        Cursor cursor = mContext.getContentResolver().query(uri, projection, null, null,
                "date desc");
        int nameColumn = cursor.getColumnIndex("person");
        int phoneNumberColumn = cursor.getColumnIndex("address");
        int smsbodyColumn = cursor.getColumnIndex("body");
        int dateColumn = cursor.getColumnIndex("date");
        int typeColumn = cursor.getColumnIndex("type");
        if (cursor != null) {

            while (cursor.moveToNext()) {
                Smsinfo smsinfo = new Smsinfo();
                smsinfo.setName(cursor.getString(nameColumn));
                smsinfo.setDate(cursor.getString(dateColumn));
                smsinfo.setPhoneNumber(cursor.getString(phoneNumberColumn));
                smsinfo.setSmsbody(cursor.getString(smsbodyColumn));
                smsinfo.settype(cursor.getString(typeColumn));
                infos.add(smsinfo);

            }
        }
        cursor.close();

        return infos;
    }


}
