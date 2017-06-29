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

package com.antonioleiva.mvpexample.app.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.antonioleiva.mvpexample.app.R;

public class MainActivity extends AppCompatActivity implements MainView {

  private MainPresenter presenter;
  private TextView txtWelcomeUser;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    txtWelcomeUser = (TextView) findViewById(R.id.txtWelcomeUser);
    presenter = new MainPresenterImpl(this, new WelcomeUserInteractorImpl());
    presenter.onCreate();
  }

  @Override
  protected void onResume() {
    super.onResume();
    presenter.onResume();
  }

  @Override
  protected void onDestroy() {
    presenter.onDestroy();
    super.onDestroy();
  }

  @Override
  public void showWelcomeMessage(String username) {
    Toast.makeText(this, username, Toast.LENGTH_LONG).show();
  }

  @Override
  public void setWelcomeMessage(String message) {
    txtWelcomeUser.setText(message);
  }

  @Override
  public String getUsername() {
    return getIntent().getExtras().getString("username");
  }
}