package umn.ac.id.utsmobilemusique_22713;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;
//import java.util.Collections;


public class MusicPlayer extends AppCompatActivity {

    ListView listView;
    String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        showDialog();

        listView = findViewById(R.id.mySongListView);

        Dexter.withActivity(this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        display();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        if (response.isPermanentlyDenied()) {
                            showSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }

    private void showSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MusicPlayer.this, R.style.MyDialogTheme);
        builder.setTitle("Need Permissions");
        builder.setMessage("This app needs permission to use this feature. You can grant them in app settings.");
        builder.setPositiveButton("GOTO SETTINGS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();

    }

    public ArrayList<File> findSong(File root){
        ArrayList<File> at = new ArrayList<>();
        File[] files = root.listFiles();
        assert files != null;
        for(File singleFile : files){
            if(singleFile.isDirectory() && !singleFile.isHidden()){
                at.addAll(findSong(singleFile));
            }
            else{
                if(singleFile.getName().endsWith(".mp3") ||
                        singleFile.getName().endsWith(".wav")){
                    at.add(singleFile);
                }
            }
        }
        return at;
    }
    @SuppressWarnings("deprecation")
    void display(){
        final ArrayList<File> mySongs = findSong(Environment.getExternalStorageDirectory());
        items = new String[ mySongs.size() ];
        for(int i=0;i<mySongs.size();i++){
            items[i] = mySongs.get(i).getName().replace(".mp3","").replace(".wav","");
        }
        ArrayAdapter<String> adp = new
                ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adp);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int
                    position, long l) {

                String songName = listView.getItemAtPosition(position).toString();
                startActivity(new Intent(getApplicationContext(),PlayerActivity.class)

                        .putExtra("pos",position).putExtra("songs",mySongs).putExtra("songname",songName));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent profile = new Intent(MusicPlayer.this, MyProfile.class);
                startActivity(profile);
                break;
            case R.id.item2:
                //Collections.sort(items);
                updatePopup1();
                break;

            case R.id.item3:
                //Collections.reverse(items);
                updatePopup2();
                break;

            case R.id.item4:
                warningPopup();

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private void warningPopup(){
        AlertDialog.Builder alert = new AlertDialog.Builder(MusicPlayer.this, R.style.MyDialogTheme);
        alert.setTitle("LOGOUT")
                .setMessage("Are you sure?")
                .setPositiveButton("Logout", new DialogInterface.OnClickListener()                 {

                    public void onClick(DialogInterface dialog, int which) {
                        logout();
                    }
                }).setNegativeButton("Cancel", null);

        AlertDialog alertWarning = alert.create();
        alertWarning.show();
    }

    private void updatePopup1(){
        AlertDialog.Builder alert = new AlertDialog.Builder(MusicPlayer.this, R.style.MyDialogTheme);
        alert.setTitle("ANNOUNCEMENT")
                .setMessage("Aplikasi ini belum didukung untuk perintah sort Ascending hehehe")
                .setNegativeButton("OK", null);

        AlertDialog alertWarning = alert.create();
        alertWarning.show();
    }

    private void updatePopup2(){
        AlertDialog.Builder alert = new AlertDialog.Builder(MusicPlayer.this, R.style.MyDialogTheme);
        alert.setTitle("ANNOUNCEMENT")
                .setMessage("Aplikasi ini belum didukung untuk perintah sort Descending hehehe")
                .setNegativeButton("OK", null);

        AlertDialog alertWarning = alert.create();
        alertWarning.show();
    }

    private void logout() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void showDialog(){
        AlertDialog.Builder popup = new AlertDialog.Builder(
                this, R.style.MyDialogTheme);

        popup.setTitle("Selamat Datang")
                .setMessage("Richard Indra\n000000 22713")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        AlertDialog alertWelcome = popup.create();
        alertWelcome.show();
    }

}
