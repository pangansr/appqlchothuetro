package com.example.qlphongtro;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.example.qlphongtro.databinding.ActivityMainBinding;
import com.example.qlphongtro.ui.gallery.GalleryFragment;
import com.example.qlphongtro.ui.home.HomeFragment;
import com.example.qlphongtro.ui.slideshow.SlideshowFragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    private ActivityMainBinding binding;
    MenuItem menuItemHome, menuItemChucNang, menuItemUser,menuItemHomeNav, menuItemChucNangNav,menuItemUserNav;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setControl();
        setEvent();

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
//               Toast.makeText(MainActivity.this, "dddd", Toast.LENGTH_SHORT).show();
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference2 = firebaseDatabase.getReference("Students/name");

                databaseReference2.removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Xóa dữ liệu thành công
                        Toast.makeText(getApplicationContext(), "Xóa dữ liệu thành công", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Xóa dữ liệu thất bại
                        Toast.makeText(getApplicationContext(), "Xóa dữ liệu thất bại", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
      //  DrawerLayout drawer = binding.drawerLayout;
       // NavigationView navigationView = binding.navView;

//        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow).setOpenableLayout(drawer).build();
//         NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);

    }

    private void setEvent() {
        //mediaPlayer = MediaPlayer.create(this, R.raw.nhacnen);
        //mediaPlayer.start();
        menuItemHome.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem item) {
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, new HomeFragment()).commit();
                return true;
            }
        });
        menuItemChucNang.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem item) {
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, new GalleryFragment()).commit();
                return true;
            }
        });
        menuItemUser.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem item) {
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, new SlideshowFragment()).commit();
                return true;
            }
        });
//        menuItemHomeNav.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(@NonNull MenuItem item) {
//                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, new HomeFragment()).commit();
//                return true;
//            }
//        });
//        menuItemChucNangNav.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(@NonNull MenuItem item) {
//                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, new GalleryFragment()).commit();
//                return true;
//            }
//        });
//        menuItemUserNav.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(@NonNull MenuItem item) {
//                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, new SlideshowFragment()).commit();
//                return true;
//            }
//        });
    }

    private void setControl() {
        Menu menu =  binding.appBarMain.navView2.getMenu();
         menuItemHome = menu.findItem(R.id.navigation_Home);
         menuItemChucNang = menu.findItem(R.id.navigation_ChucNang);
         menuItemUser = menu.findItem(R.id.navigation_User);
         //Menu menu1 = binding.navView.getMenu();
//        menuItemHomeNav = menu1.findItem(R.id.nav_home);
//        menuItemChucNangNav = menu1.findItem(R.id.nav_gallery);
//        menuItemUserNav = menu1.findItem(R.id.nav_slideshow);

    }


}