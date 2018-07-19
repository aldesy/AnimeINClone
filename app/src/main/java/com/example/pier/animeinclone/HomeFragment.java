package com.example.pier.animeinclone;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.pier.animeinclone.activity.AnimeDetail;
import com.example.pier.animeinclone.models.Anime;
import com.example.pier.animeinclone.models.AnimeCallback;
import com.example.pier.animeinclone.models.Animes;
import com.example.pier.animeinclone.models.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements AnimeCallback {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private Context context;
    private View rootView;
    private List<Animes> animes;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        context = getActivity();
        initSlider();
        //initRetrofit2();
        getAllAnimes();
        return rootView;
    }

    private void getAllAnimes() {

        AnimeInterface service = RetrofitClientInstance.getRetrofitInstance().create(AnimeInterface.class);

        Call<Result> result = service.getResultInfo();
        result.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                try {
                    Result res = response.body();
                    if(res.getSuccess())
                    {
                        animes = new ArrayList<>(res.getData());
                        recycleOne();
                        recycleTwo();
                        recycleThree();
                        recycleFour();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void recycleOne() {
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerview1);
        recyclerView.setNestedScrollingEnabled(false);

        AdapterType1 mAdapter = new AdapterType1(animes, context, this);
        // LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        GridLayoutManager mLayoutManager = new GridLayoutManager(context, 3);
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        //mAdapter.notifyDataSetChanged();
    }

    private void recycleTwo() {
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerview2);
        recyclerView.setNestedScrollingEnabled(false);

        AdapterType2 mAdapter = new AdapterType2(animes, context);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        // GridLayoutManager mLayoutManager = new GridLayoutManager(this, 3);
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

//        mAdapter.notifyDataSetChanged();
    }

    private void recycleThree() {
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerview3);
        recyclerView.setNestedScrollingEnabled(false);

        AdapterType1 mAdapter = new AdapterType1(animes, context, this);
        // LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        GridLayoutManager mLayoutManager = new GridLayoutManager(context, 3);
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        //mAdapter.notifyDataSetChanged();
    }

    private void recycleFour() {
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerview4);
        recyclerView.setNestedScrollingEnabled(false);

        AdapterType2 mAdapter = new AdapterType2(animes, context);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        // GridLayoutManager mLayoutManager = new GridLayoutManager(this, 3);
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

//        mAdapter.notifyDataSetChanged();
    }

    private void initSlider() {
        SliderLayout sliderShow = rootView.findViewById(R.id.slider);

        HashMap<String,String> url_maps = new HashMap<>();
        url_maps.put("Sword Art Online", "https://ae01.alicdn.com/kf/HTB16Xa3jCfD8KJjSszhq6zIJFXaw/DIY-frame-Sword-Art-Online-Light-Novel-Japan-Hot-Comics-Anime-Poster-Landscape-Fabric-Silk-Posters.jpg_640x640.jpg");
        url_maps.put("Bleach", "https://ae01.alicdn.com/kf/HTB1KwuvjBDH8KJjSspnq6zNAVXac/DIY-frame-Bleach-Japan-Classic-Comics-Anime-Poster-Moon-Landscape-Fabric-Silk-Posters-And-Prints-For.jpg_640x640.jpg");

        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(context);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            //    .setOnSliderClickListener(this);

            //add your extra information
            //   textSliderView.bundle(new Bundle());
            //   textSliderView.getBundle()
            //          .putString("extra",name);

            sliderShow.addSlider(textSliderView);
        }
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void OnClickItem(int animeid) {
        Intent i = new Intent(context.getApplicationContext(),AnimeDetail.class);
        Bundle bundle = new Bundle();
        bundle.putInt("animeid",animeid);
        i.putExtras(bundle);
        startActivity(i);
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            //Restore the fragment's state here
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Save the fragment's state here
    }
}
