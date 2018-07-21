package com.example.pier.animeinclone.helper;

import android.content.Context;

import com.example.pier.animeinclone.fragment.RequestFragment;

public class TopAnimeHelper {

    private RequestFragment rF;
    private Context context;

    public TopAnimeHelper(Context context, RequestFragment requestFragment) {
        this.rF = requestFragment;
        this.context = context;
    }

    public void showTopAnime()
    {
       /* String searchtext = txtSearch.getText().toString();
        if (!isSearching && searchtext.length() >= 3) {
            removeTxtFocus();
            hideKeyboard();
            isSearching = true;
            recyclerMal.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
            String BASE_URL = "https://api.jikan.moe/";
            MyAnimeListAPI service = RetrofitClientInstance.getRetrofitMALInstance(BASE_URL).create(MyAnimeListAPI.class);

            Call<MALResponse> responseCall = service.searchAnime(searchtext, 1);
            responseCall.enqueue(new Callback<MALResponse>() {
                @Override
                public void onResponse(@NonNull Call<MALResponse> call, @NonNull Response<MALResponse> response) {
                    Log.e("MASUK", "asd");
                    try {
                        MALResponse res = response.body();
                        if (res.getRequest_hash() != null && res.getResult().size() > 0) {
                            progressBar.setVisibility(View.GONE);
                            listSearch = new ArrayList<>(res.getResult());
                            recycle();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<MALResponse> call, @NonNull Throwable t) {
                    progressBar.setVisibility(View.GONE);
                    t.printStackTrace();
                }
            });
        }*/
    }
}
