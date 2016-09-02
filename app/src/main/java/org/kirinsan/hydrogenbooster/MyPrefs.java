package org.kirinsan.hydrogenbooster;

import org.androidannotations.annotations.sharedpreferences.DefaultBoolean;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

@SharedPref(SharedPref.Scope.UNIQUE)
public interface MyPrefs {
    @DefaultBoolean(false)
    boolean downloaded();
}
