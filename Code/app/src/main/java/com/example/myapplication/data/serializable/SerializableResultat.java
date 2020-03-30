package com.example.myapplication.data.serializable;

import android.content.Context;

import com.example.myapplication.model.interfaces.SerializableObject;
import com.example.myapplication.data.stub.StubResultat;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableResultat implements SerializableObject {

    private Context context;

    private String fic = "resultats.xml";

    /**
     * Constructor
     * @param context of the activity
     */
    public SerializableResultat(Context context) {
        this.context = context;
    }

    /**
     *
     * @param o is the object to serialize
     */
    @Override
    public void writeObject(Object o) {

        FileOutputStream f;
        ObjectOutputStream output;

        try {
            f = context.openFileOutput(fic, Context.MODE_PRIVATE);
            output = new ObjectOutputStream(f);
            output.writeObject(o);
            output.close();
            f.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return an object
     * return StubResultat.chargerStats() if fic is not found
     */
    @Override
    public Object readObject() {
        FileInputStream f;
        ObjectInputStream input;
        Object o = null;

        try {
            o = new Object();
            f = context.openFileInput(fic);
            input = new ObjectInputStream(f);
            o = input.readObject();
            f.close();
            input.close();

        } catch (Exception e) {
            e.printStackTrace();
          //a tester
            StubResultat stubResultat = new StubResultat();
            return stubResultat.readObject();

        }

        return o;

    }

}
