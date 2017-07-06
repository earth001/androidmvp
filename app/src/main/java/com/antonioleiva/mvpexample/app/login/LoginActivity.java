/*
 *
 *  * Copyright (C) 2014 Antonio Leiva Gordillo.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.antonioleiva.mvpexample.app.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.antonioleiva.mvpexample.app.R;
import com.antonioleiva.mvpexample.app.main.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

  private EditText username;
  private EditText password;
  private LoginPresenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    username = (EditText) findViewById(R.id.username);
    password = (EditText) findViewById(R.id.password);
    findViewById(R.id.button).setOnClickListener(this);
    presenter = new LoginPresenterImpl(this);
  }

  @Override
  protected void onDestroy() {
    presenter.onDestroy();
    super.onDestroy();
  }

  @Override
  public void setUsernameError() {
    username.setError(getString(R.string.username_error));
  }

  @Override
  public void setPasswordError() {
    password.setError(getString(R.string.password_error));
  }

  @Override
  public void navigateToHome(Bundle bundle) {
    final Intent intent = new Intent(this, MainActivity.class);
    intent.putExtras(bundle);
    startActivity(intent);
    //finish();
  }

  @Override
  public void onClick(View v) {
    presenter.validateCredentials(username.getText().toString(), password.getText().toString());
  }
}
