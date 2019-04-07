package com.example.continuity;

import java.io.ObjectOutputStream;
import java.util.ArrayList;



public class SendFilesList {

    public void sendFilesList(final ArrayList<AvatarFile> myFiles, final ObjectOutputStream out) {
        new Thread() {
            public void run() {
                try {
                    out.writeObject(myFiles);
                    out.flush();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
