package edu.temple.colorapp;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class CanvasFragment extends Fragment {

    FrameLayout canvasFragment;
    public CanvasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_canvas, container, false);
        // Find the canvas fragment that will display the color
        canvasFragment = (FrameLayout) view.findViewById(R.id.canvas_fragment);
        return view;
    }

    // Function to change the background color of the canvas
    public void changeCanvasColor(String colorValue){
        // Change the color of the canvas to the new color
        canvasFragment.setBackgroundColor(Color.parseColor(colorValue));
    }

}
