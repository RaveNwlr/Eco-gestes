package monarche.derichebourg;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Serialization {
    // For debug only
    private static final String TAG = "SERIALIZATION";
    // Name of the configuration file
    private static final String FILENAME = "profil.dat";

    public static void serialize(ClassProfil profil, Context ctx) {
        try {
            // MODE_PRIVATE makes it so that only your app can read the file
            // Also you can't pass a path. Android will decide for you.
            FileOutputStream fos = ctx.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(profil);
            // Don't forget to close your files
            oos.close();
            fos.close();
        } catch (IOException e) {
            Log.d(TAG, e.getMessage());
        }
    }

    public static ClassProfil deserialize(Context ctx) {
        ClassProfil profil = null;
        try {
            FileInputStream fis = ctx.openFileInput(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            profil = (ClassProfil) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            Log.d(TAG, e.getMessage());
        }
        return (profil);
    }

}