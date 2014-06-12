package com.total.fragment;

import com.l33t.scrummy.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CompleteFragment {
	
	// variable declaration
	static String FRAGMENT_LAYOUT_KEY = "fragmentLayout";
	String fragmentName;
	FragmentActivity fragmentActivity;
	Fragment fragment;
	
	
	public CompleteFragment(String fragmentName, int fragmentLayout) {
		this.fragmentName = fragmentName;

		this.fragment = new mFragment();
		Bundle args = new Bundle();
		args.putInt(FRAGMENT_LAYOUT_KEY, fragmentLayout);
		this.fragment.setArguments(args);
		
		this.fragmentActivity = new mFragmentActivity(this.fragment);
	}
	
	

	private class mFragmentActivity extends FragmentActivity {
		
		// variable declaration
		Fragment fragment;
		
		public mFragmentActivity(Fragment fragment) {
			this.fragment = fragment;
		}
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_fragment);

			// savedInstanceState is non-null when there is fragment state
			// saved from previous configurations of this activity
			// (e.g. when rotating the screen from portrait to landscape).
			// In this case, the fragment will automatically be re-added
			// to its container so we don't need to manually add it.
			// For more information, see the Fragments API guide at:
			//
			// http://developer.android.com/guide/components/fragments.html
			//
			if (savedInstanceState == null) {
				// Create the election program fragment and add it to the activity
				// using a fragment transaction.
				getSupportFragmentManager().beginTransaction()
						.add(R.id.activity_fragment, this.fragment).commit();
			}
		}
	}
	
	
	static public class mFragment extends Fragment {

		/**
		 * Mandatory empty constructor for the fragment manager to instantiate the
		 * fragment (e.g. upon screen orientation changes).
		 */
		public mFragment() {
		}
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			
			if (this.getArguments().containsKey(FRAGMENT_LAYOUT_KEY)) {
			
				View view = inflater.inflate(
						this.getResources().getLayout(
								this.getArguments().getInt(FRAGMENT_LAYOUT_KEY)), container, false);
			
				// full_program_link has links specified by putting <a> tags in the string
		    	// resource.  By default these links will appear but not
		    	// respond to user input.  To make them active, you need to
		    	// call setMovementMethod() on the TextView object.
		    	//TextView fullProgramLinkTextView = (TextView) view.findViewById(R.id.full_program_link);
		    	//fullProgramLinkTextView.setMovementMethod(LinkMovementMethod.getInstance());
			
				// Inflate the placeholder
				return view;
				
			} else return null;
		}
	}
}
