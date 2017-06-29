package com.antonioleiva.mvpexample.app.login;

import android.text.TextUtils;

public class LoginInteractorImpl implements LoginInteractor {

  @Override
  public void login(final String username, final String password, final OnLoginFinishedListener listener) {
    boolean error = false;
    if (TextUtils.isEmpty(username)) {
      listener.onUsernameError();
      error = true;
      return;
    }
    if (TextUtils.isEmpty(password)) {
      listener.onPasswordError();
      error = true;
      return;
    }
    if (!error) {
      listener.onSuccess(username);
    }
  }
}
