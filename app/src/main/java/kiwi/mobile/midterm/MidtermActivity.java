package kiwi.mobile.midterm;

// standard library imports
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

// android imports
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.AsyncTask;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

// javatuples imports
import org.javatuples.Triplet;

// json-simple imports
//import org.json.simple.*;
//import org.json.simple.parser.*;

// json-simpler imports
//import kuro.json.JSONAdapter;

public class MidtermActivity extends Activity {
	// constants
	private static final String TAG = "Midterm";
	private static final String APP_IDENT = "kiwi.mobile.midterm";
	private static final String SERVER_ADDR = "192.168.0.113";
	private static final int SERVER_PORT = 9680;

	// members
	private Button launch_button;
	private TextView log_view;

	@Override
	protected void onCreate( Bundle savedInstanceState){
		super.onCreate( savedInstanceState);
		this.setContentView( R.layout.activity_midterm);

		// set up log
		this.log_view = (TextView) findViewById( R.id.log_view);
		this.log_view.setMovementMethod( new ScrollingMovementMethod());
		this.log_view.setTypeface( Typeface.MONOSPACE);

		// set up button
		this.launch_button = (Button) findViewById( R.id.launch_button);
		this.launch_button.setOnClickListener( new View.OnClickListener(){
			public void onClick( View view){
				MidtermActivity.this.triggerUrlActivity();}
		});}

	@Override
	protected void onDestroy(){
		super.onDestroy();}

	@Override
	public boolean onCreateOptionsMenu( Menu menu){
		super.onCreateOptionsMenu( menu);
		MenuInflater inflater = this.getMenuInflater();
		inflater.inflate( R.menu.main, menu);
		return true;}

	@Override
	public boolean onOptionsItemSelected( MenuItem item){
		int id = item.getItemId();
		if( R.id.action_test == id){
			//triggerAsdf();
			return true;}
		return super.onOptionsItemSelected( item);}

	public void triggerUrlActivity(){
		this.log( "triggering url activity...");
		Intent intent = new Intent( this, EnterUrlActivity.class);
		startActivity( intent);
		this.log( "url activity triggered");}

	/** Write a format string to the logs **/
	private void log( String fmt, Object... params){
		String content = String.format( fmt, params);
		Util.log( content);
		log_view.append( "\n");
		log_view.append( content);

		// scroll to bottom
		int scrollAmount = log_view.getLayout().getLineTop(
			log_view.getLineCount()) - log_view.getHeight();
		if( scrollAmount > 0)
			log_view.scrollTo( 0, scrollAmount);
		else
			log_view.scrollTo( 0, 0);}

	protected static class Datetime {
		public int year;
		public int day;
		public long milli;

		public Datetime( int year, int day, long milli){
			this.year = year;
			this.day = day;
			this.milli = milli;}

		public static final Datetime nowUtc(){
			TimeZone utc = TimeZone.getTimeZone( "UTC");
			Calendar calendar = new GregorianCalendar( utc);
			int year = calendar.get( Calendar.YEAR);
			int day = calendar.get( Calendar.DAY_OF_YEAR);
			long hour = calendar.get( Calendar.HOUR_OF_DAY);
			long minute = 60*hour + calendar.get( Calendar.MINUTE);
			long second = 60*minute + calendar.get( Calendar.SECOND);
			long milli = 1000*second + calendar.get( Calendar.MILLISECOND);
			return new Datetime( year, day, milli);}

		public String toString(){
			return String.format(
				"%03x.%03x.%07x",
				this.year, this.day, this.milli);}
	}
}
