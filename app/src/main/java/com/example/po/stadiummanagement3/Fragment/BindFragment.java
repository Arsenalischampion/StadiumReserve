package com.example.po.stadiummanagement3.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.po.stadiummanagement3.R;
import com.example.po.stadiummanagement3.WebService.HttpService;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 13701 on 2018/1/11.
 */

public class BindFragment extends Fragment {
    @BindView(R.id.bind_button) Button button;
    @BindView(R.id.studentNum)
    EditText studentNumText;
    @BindView(R.id.phoneNumber)
    EditText phoneNumberText;
    @BindView(R.id.name)
    EditText nameText;
    @BindView(R.id.email)
    EditText emailText;

    String studentNum,phoneNumber,name,email;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bind_layout,container,false);
        ButterKnife.bind(this,v);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studentNum = studentNumText.getText().toString();
                String phoneNumber = phoneNumberText.getText().toString();
                String name = nameText.getText().toString();
                String email = emailText.getText().toString();

                RequestBody requestBody = new FormBody.Builder().add("studentNum",studentNum)
                        .add("phoneNumber",phoneNumber).add("name",name).add("email",email).build();

                HttpService.sendOkHttpPostRequest("number/bind", requestBody, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String s = response.body().string();
                        int i = 0;
                    }
                });

            }
        });
        return v;
    }
}
