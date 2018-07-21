package com.example.pier.animeinclone.fragment;

import android.content.Context;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.opengl.Visibility;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.pier.animeinclone.R;
import com.example.pier.animeinclone.RetrofitClientInstance;
import com.example.pier.animeinclone.interfaces.MyAnimeListAPI;
import com.example.pier.animeinclone.models.MALResponse;
import com.example.pier.animeinclone.models.MALResult;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RequestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RequestFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Unbinder unbinder;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.btnCari)
    Button btnCari3;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private List<MALResult> listSearch;
    private OnFragmentInteractionListener mListener;

    public RequestFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RequestFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RequestFragment newInstance(String param1, String param2) {
        RequestFragment fragment = new RequestFragment();
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
        View view = inflater.inflate(R.layout.fragment_request, container, false);
        unbinder = ButterKnife.bind(this, view);

        progressBar.getIndeterminateDrawable().setColorFilter(
                getResources().getColor(R.color.progressColor),
                PorterDuff.Mode.SRC_IN);
        progressBar.setVisibility(View.GONE);

        return view;
    }


    private void searchMyAnimelist() {
        progressBar.setVisibility(View.VISIBLE);
        String BASE_URL = "https://api.jikan.moe/";
        MyAnimeListAPI service = RetrofitClientInstance.getRetrofitMALInstance(BASE_URL).create(MyAnimeListAPI.class);

        Call<MALResponse> responseCall = service.searchAnime("One", 1);
        responseCall.enqueue(new Callback<MALResponse>() {
            @Override
            public void onResponse(@NonNull Call<MALResponse> call, @NonNull Response<MALResponse> response) {
                Log.e("MASUK", "asd");
                try {
                    MALResponse res = response.body();
                    if (res.getRequest_hash() != null && res.getResult().size() > 0) {
                        progressBar.setVisibility(View.GONE);
                        listSearch = new ArrayList<>(res.getResult());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<MALResponse> call, @NonNull Throwable t) {
                Log.e("GAGAL", "asd");
                t.printStackTrace();
            }
        });
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
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btnCari)
    public void onViewClicked() {
        searchMyAnimelist();
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
}
