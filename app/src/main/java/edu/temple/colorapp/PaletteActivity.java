package edu.temple.colorapp;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class PaletteActivity extends Activity implements PaletteFragment.OnFragmentInteractionListener{

    boolean twoPanes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        // Check if two fragments are being displayed
        twoPanes = (findViewById(R.id.canvas_fragment) != null);

        // Create a new instance of the palette fragment that displays all the colors
        Fragment paletteFragment = new PaletteFragment();
        loadFragment(R.id.main_fragment, paletteFragment, false);

        if(twoPanes){
            // If two panes are being displayed then load the second fragment
            loadFragment(R.id.canvas_fragment, new CanvasFragment(), false);
        } else {
            // Remove the canvas fragment if it is being displayed
            Fragment fragment = getFragmentManager().findFragmentById(R.id.canvas_fragment);
            if(fragment != null) {
                getFragmentManager()
                        .beginTransaction()
                        .remove(fragment)
                        .commit();
            }
        }


    }

    // Function to display a new color depending on the user's click
    @Override
    public void displayNewColor(String colorValue) {
        Fragment canvasFragment;
        if(twoPanes){
            // If two panes are being displayed then display the color on the second pane
            canvasFragment = getFragmentManager().findFragmentById(R.id.canvas_fragment);
            ((CanvasFragment) canvasFragment).changeCanvasColor(colorValue);
        } else {
            // If one pane is being displayed then display the canvas fragment on top of
            // the palette fragment
            canvasFragment = new CanvasFragment();
            loadFragment(twoPanes ? R.id.canvas_fragment : R.id.main_fragment, canvasFragment, !twoPanes);
            ((CanvasFragment) canvasFragment).changeCanvasColor(colorValue);
        }
    }

    // Load fragment in a specified frame
    private void loadFragment(int paneId, Fragment fragment, boolean placeOnBackStack){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction()
                .replace(paneId, fragment);
        if(placeOnBackStack){
            ft.addToBackStack(null);
        }
        ft.commit();
        fm.executePendingTransactions();
    }
}
