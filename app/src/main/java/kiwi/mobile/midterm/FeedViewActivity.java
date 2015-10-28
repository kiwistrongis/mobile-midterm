package kiwi.mobile.midterm;

// android imports
import android.app.Activity;
import android.os.Bundle;

public class FeedViewActivity extends Activity {
	@Override
	protected void onCreate( Bundle savedInstanceState){
		super.onCreate( savedInstanceState);
		this.setContentView( R.layout.activity_enter_url);}

	@Override
	protected void onDestroy(){
		super.onDestroy();}
}
