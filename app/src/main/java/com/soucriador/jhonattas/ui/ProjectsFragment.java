package com.soucriador.jhonattas.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.soucriador.jhonattas.Config;
import com.soucriador.jhonattas.R;
import com.soucriador.jhonattas.adapter.CardAdapter;
import com.soucriador.jhonattas.io.AppController;
import com.soucriador.jhonattas.model.Project;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProjectsFragment extends Fragment {

    // TODO: I still want to change the imageview corners

    String TAG = ProjectsFragment.class.getSimpleName();
    LinearLayoutManager layoutManager;
    CardAdapter cardAdapter;
    RecyclerView recyclerView;
    ProgressDialog progressDialog;
    ArrayList<Project> projects = new ArrayList<Project>();

    public static ProjectsFragment newInstance() {
        ProjectsFragment fragment = new ProjectsFragment();
        return fragment;
    }

    public ProjectsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_projects, container, false);
        recyclerView = (RecyclerView) rootview.findViewById(R.id.projects_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(rootview.getContext());
        recyclerView.setLayoutManager(layoutManager);
        cardAdapter = new CardAdapter(projects);
        recyclerView.setAdapter(cardAdapter);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage(getString(R.string.loading) + "...");
        progressDialog.show();

        JsonArrayRequest projectsRequest = new JsonArrayRequest(Config.json_url_projects, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, response.toString());
                Log.d(TAG, "tamanho: " + response.length());

                for(int i = 0; i < response.length(); i++){
                    try{

                        JSONObject o = response.getJSONObject(i);
                        JSONObject o2 = o.getJSONObject("Project");

                        Project p = new Project();
                        p.setTitle(         o2.getString("title"));
                        p.setResume(        o2.getString("resume"));
                        p.setDescription(   o2.getString("description"));
                        p.setLink(          o2.getString("link"));
                        p.setThumbnailUrl(  o2.getString("image"));
                        projects.add(p);

                    } catch (JSONException e){
                        e.printStackTrace();
                    } finally {
                        hideProgressDialog();
                    }
                }

                cardAdapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                VolleyLog.d(TAG, "Error: "+volleyError.getMessage());
                hideProgressDialog();
            }
        });

        AppController.getInstance().addToRequestQueue(projectsRequest);

        return rootview;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        hideProgressDialog();
    }

    private void hideProgressDialog(){
        if(progressDialog != null){
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

}
