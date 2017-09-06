package come.newbula.xing.ui.video;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import come.newbula.xing.R;


public class VideoFragment extends Fragment
{

    /**
     * context
     */
    private Context context;


    /**
     * view
     */
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_video, container, false);

        context = getActivity();
        return view;

    }


}
