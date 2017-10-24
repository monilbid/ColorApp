package edu.temple.colorapp;


import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaletteFragment extends Fragment {


    private OnFragmentInteractionListener listener;

    public PaletteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_palette, container, false);

        // Find the grid view that will display the colors
        GridView gridView = (GridView) view.findViewById(R.id.gridView);

        // Get the activity's context
        Context context = getActivity();

        // Get the resources from the context
        Resources resources = context.getResources();

        // Store the color values and names in strings
        String[] colorValuesFromXml = resources.getStringArray(R.array.colorValues);
        String[] colorNamesFromXml = resources.getStringArray(R.array.colorNames);

        // Instantiate the color adapter
        ColorAdapter colorAdapter = new ColorAdapter(context, colorValuesFromXml, colorNamesFromXml);

        // Set the adapter to make the gridView display all the colors
        gridView.setAdapter(colorAdapter);

        // On click of an item in the gridView change the color of the canvas to the
        // corresponding color
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listener.displayNewColor(adapterView.getItemAtPosition(i).toString());
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    // Interface that must be implemented by the main activity
    // to allow interaction in this fragment to be communicated
    // to the activity and other fragments using the activity
    public interface OnFragmentInteractionListener {
        void displayNewColor(String colorValue);
    }
}
