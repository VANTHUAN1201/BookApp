package com.example.app_readbook.activity;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
//@SuppressLint("NonConstantResourceId")
//@BindView(R.id.user) EditText txt_name;
//@BindView(R.id.pass) EditText txt_pass;
//@BindView(R.id.email) EditText txt_email;
//ApiInterface apiInterface;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//       setContentView(R.layout.dangky);
//        ButterKnife.bind(this);
//        apiInterface = ApiClient.getApiclient().create((ApiInterface.class));
//
//    }
//    public void SignUp(View view)
//    {
//        Call<ApiReponse> apiReponseCall = apiInterface.reponseCallSignIn(txt_email.getText().toString() ,
//                txt_name.getText().toString(),
//                txt_pass.getText().toString());
//        apiReponseCall.enqueue(new Callback<ApiReponse>() {
//            @Override
//            public void onResponse(Call<ApiReponse> call, Response<ApiReponse> response) {
//                if(response.isSuccessful() && response.body()!=null)
//                {
//                    ApiReponse apiReponse = response.body();
//                    if(apiReponse.isSuccess())
//                    {
//                        Toast.makeText(Register.this  , "User registered successfully ", Toast.LENGTH_LONG).show();
//                        Intent intent = new Intent(Register.this , SignIn.class);
//                        startActivity(intent);
//                    }
//                    else{
//                        Toast.makeText(Register.this  , "User could not be registered ", Toast.LENGTH_LONG).show();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ApiReponse> call, Throwable t) {
//                Toast.makeText(Register.this  , "Error , could not connect ", Toast.LENGTH_LONG).show();
//            }
//        });
//    }


}