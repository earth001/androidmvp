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

public class MainPresenterImpl implements MainPresenter, WelcomeUserInteractor.OnLoadHomeUserListener {

  private MainView mainView;
  private WelcomeUserInteractor welcomeUserInteractor;
  private String username;

  public MainPresenterImpl(MainView mainView, WelcomeUserInteractor welcomeUserInteractor) {
    this.mainView = mainView;
    this.welcomeUserInteractor = welcomeUserInteractor;
  }

  @Override
  public void onCreate() {
    this.username = mainView.getUsername();
    welcomeUserInteractor.setWelcomeMessage(username, this);
  }

  @Override
  public void onResume() {
    if (mainView != null) {
      welcomeUserInteractor.showWelcomeMessage(username, this);
    }
  }

  @Override
  public void onDestroy() {
    mainView = null;
  }

  @Override
  public void showWelcomeMessage(String message) {
    mainView.showWelcomeMessage(message);
  }

  @Override
  public void setWelcomeMessage(String message) {
    mainView.setWelcomeMessage(message);
  }

}