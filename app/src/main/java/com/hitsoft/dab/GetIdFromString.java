package com.hitsoft.dab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class GetIdFromString {
    public int getID(String string) {
        String id = "";
        char[] c = string.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '[') {
                for (int j = i + 1; j < c.length; j++) {
                    if (c[j] == ']')
                        break;
                    else
                        id += c[j];
                }
            }
        }
        return Integer.parseInt(id);
    }
}
//jjgh