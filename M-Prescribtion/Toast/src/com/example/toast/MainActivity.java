package com.example.toast;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	final Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(context);
				builder.setMessage("Test for preventing dialog close");
				builder.setPositiveButton("Test", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// Do nothing here because we override this button later to change the close behaviour.
						// However, we still need this because on older versions of Android unless we
						// pass a handler the button doesn't get instantiated
					}
				});
				final AlertDialog dialog = builder.create();
				dialog.show();
				// Overriding the handler immediately after show is probably a better approach than OnShowListener as described
				// below
				dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						Toast.makeText(getApplicationContext(), "ok",  Toast.LENGTH_LONG).show();
						Boolean wantToCloseDialog = true;
						// Do stuff, possibly set wantToCloseDialog to true then...
						
						if (wantToCloseDialog)
							dialog.dismiss();
						// else dialog stays open. Make sure you have an obvious way to close the dialog especially if you set
						// cancellable to false.
					}
				});
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
