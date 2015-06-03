package com.acarolabs.a3dent.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import com.acarolabs.a3dent.R;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class ContactActivity extends ActionBarActivity  implements View.OnClickListener{
    private String Tag_Store_Facebook = "facebook";
    private String Tag_Store_Twitter = "twitter";
    private String Tag_Store_Phone = "phone";
    private String Tag_Store_Web = "web";
    private String Tag_Store_Email = "email";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        // in Activity Context
        ImageView icon = new ImageView(this); // Create an icon
        icon.setImageResource(R.drawable.ic_add_white_36dp);


        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(icon)

                .setBackgroundDrawable(R.drawable.selector_button)
                .build();



        ImageView facebook = new ImageView(this); // Create an icon
        facebook.setImageResource(R.drawable.facebook_white);

        ImageView twitter = new ImageView(this); // Create an icon
        twitter.setImageResource(R.drawable.twitter_white);

        ImageView phone = new ImageView(this); // Create an icon
        phone.setImageResource(R.drawable.phonewhite);

        ImageView web = new ImageView(this); // Create an icon
        web.setImageResource(R.drawable.webwhite);

        ImageView email = new ImageView(this); // Create an icon
        email.setImageResource(R.drawable.email_white);

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(85, 85, Gravity.TOP|Gravity.LEFT );
        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
        itemBuilder.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle));
        itemBuilder.setLayoutParams(params );
        SubActionButton buttonFacebook = itemBuilder.setContentView(facebook).build();
        SubActionButton buttonPhone = itemBuilder.setContentView(phone).build();
        SubActionButton buttonWeb = itemBuilder.setContentView(web).build();
        SubActionButton buttonEmail = itemBuilder.setContentView(email).build();
        SubActionButton buttonTwitter = itemBuilder.setContentView(twitter).build();

        buttonFacebook.setTag(Tag_Store_Facebook);
        buttonTwitter.setTag(Tag_Store_Twitter);
        buttonPhone.setTag(Tag_Store_Phone);
        buttonEmail.setTag(Tag_Store_Email);
        buttonWeb.setTag(Tag_Store_Web);



        buttonFacebook.setOnClickListener(this);
        buttonTwitter.setOnClickListener(this);
        buttonEmail.setOnClickListener(this);
        buttonPhone.setOnClickListener(this);
        buttonWeb.setOnClickListener(this);


        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(buttonFacebook)
                .addSubActionView(buttonTwitter)
                .addSubActionView(buttonWeb)
                .addSubActionView(buttonPhone)
                .addSubActionView(buttonEmail)
                        // ...
                .attachTo(actionButton)
                .build();

    }
    @Override
    public void onClick(View v) {
        if(v.getTag().equals(Tag_Store_Facebook)){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.facebook.com/acarolabs"));
            startActivity(intent);
        }
        if(v.getTag().equals(Tag_Store_Phone)){
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:7208538"));
            startActivity(intent);
        }
        if(v.getTag().equals(Tag_Store_Twitter)){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://twitter.com/acarolabs"));
            startActivity(intent);
        }
        if(v.getTag().equals(Tag_Store_Web)){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://www.acarolabs.com"));
            startActivity(intent);
        }
        if(v.getTag().equals(Tag_Store_Email)){
            sendEmail();
        }
    }
    protected void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {"contacto@acarolabs.org"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
        try {
            //startActivity(Intent.createChooser(emailIntent, "Email to Friend"));
            startActivity(Intent.createChooser(emailIntent, "sending email"));
            finish();
            Log.i("Finished sending email.", "df");
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(ContactActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
