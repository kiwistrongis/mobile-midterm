package kiwi.mobile.midterm;

// android imports
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterUrlActivity extends Activity {
	private Button show_feed;
	private EditText url_field;

	@Override
	protected void onCreate( Bundle savedInstanceState){
		super.onCreate( savedInstanceState);
		this.setContentView( R.layout.activity_enter_url);

		// set up button
		this.show_feed = (Button) findViewById( R.id.show_feed);
		this.show_feed.setOnClickListener( new View.OnClickListener(){
			public void onClick( View view){
				EnterUrlActivity.this.triggerFeedViewActivity();}
		});

		// set up url field
		this.url_field = (EditText) findViewById( R.id.url_field);}

	private void triggerFeedViewActivity(){
		String url = url_field.getText().toString();
		Util.log( url);}

	@Override
	protected void onDestroy(){
		super.onDestroy();}
}
