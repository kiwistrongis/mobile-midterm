package kiwi.mobile.midterm;

// standard library imports
import java.util.ArrayList;

// android imports
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class StoryAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<Story> data;

	public StoryAdapter( Context context, ArrayList<Story> data){
		this.data = data;
		this.context = context;}

	public int getCount(){
		return data.size();}

	public Object getItem( int position){
		return data.get( position);}

	public long getItemId( int position){
		return position;}

	public View getView( int position, View convertView, ViewGroup parent){
		Story storyToDisplay = data.get( position);

		Util.log(
			"Story:\n" + 
			"  Title:   %s\n" +
			"  Author:  %s\n" +
			"  Content: %s\n",
			storyToDisplay.getTitle(),
			storyToDisplay.getAuthor(),
			storyToDisplay.getContent());

		if( convertView == null){
			// create the layout
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(
				Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(
				R.layout.list_view_story_item, parent, false);}

		// populate the views with the data from story
		TextView label_title =
			(TextView) convertView.findViewById( R.id.label_title);
		label_title.setText( storyToDisplay.getTitle());

		TextView label_author =
			(TextView) convertView.findViewById( R.id.label_author);
		label_author.setText( storyToDisplay.getAuthor());

		TextView label_content =
			(TextView) convertView.findViewById( R.id.label_content);
		label_content.setText( storyToDisplay.getContent());

		return convertView;}
}
