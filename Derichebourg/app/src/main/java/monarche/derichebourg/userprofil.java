package monarche.derichebourg;


import android.os.Bundle;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class userprofil extends Activity  {

    // sert à déclarer les élements graphiques
    final Button[] date=new Button[31];
    TextView aff_ndefis;
    ClassProfil profil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        profil = Serialization.deserialize(getApplicationContext());
        if (profil == null) {
            // That way it won't crash. However that's not the best way of doing things
            profil = new ClassProfil();
        }
        setContentView(R.layout.activity_userprofil);
        date[0] = (Button)findViewById(R.id.date1);  // déclaration des boutons de dates pour les achievements
        date[1] = (Button)findViewById(R.id.date2);
        date[2] = (Button)findViewById(R.id.date3);
        date[3] = (Button)findViewById(R.id.date4);
        date[4] = (Button)findViewById(R.id.date5);
        date[5] = (Button)findViewById(R.id.date6);
        date[6] = (Button)findViewById(R.id.date7);
        date[7] = (Button)findViewById(R.id.date8);
        date[8] = (Button)findViewById(R.id.date9);
        date[9] = (Button)findViewById(R.id.date10);
        date[10] = (Button)findViewById(R.id.date11);
        date[11] = (Button)findViewById(R.id.date12);
        date[12] = (Button)findViewById(R.id.date13);
        date[13] = (Button)findViewById(R.id.date14);
        date[14] = (Button)findViewById(R.id.date15);
        date[15] = (Button)findViewById(R.id.date16);
        date[16] = (Button)findViewById(R.id.date17);
        date[17] = (Button)findViewById(R.id.date18);
        date[18] = (Button)findViewById(R.id.date19);
        date[19] = (Button)findViewById(R.id.date20);
        date[20] = (Button)findViewById(R.id.date21);
        date[21] = (Button)findViewById(R.id.date22);
        date[22] = (Button)findViewById(R.id.date23);
        date[23] = (Button)findViewById(R.id.date24);
        date[24] = (Button)findViewById(R.id.date25);
        date[25] = (Button)findViewById(R.id.date26);
        date[26] = (Button)findViewById(R.id.date27);
        date[27] = (Button)findViewById(R.id.date28);
        date[28] = (Button)findViewById(R.id.date29);
        date[29] = (Button)findViewById(R.id.date30);
        date[30] = (Button)findViewById(R.id.date31);

        aff_ndefis= (TextView)findViewById(R.id.textView6);  // Déclaration de la ressource affichant le score
        aff_ndefis.setText(profil.getndefis());    // récupération du score et affichage


        affichageCAL();    // affichage des couleurs sur les dates
        Serialization.serialize(profil, getApplicationContext());   // enregistrement de la configuration actuelle












    }
    public void affichageCAL(){  // affichage de la couleur des boutons

        for (int i=0;i<31;i++){

            if(profil.def[i]=='g'){ //Color green =effectué

                date[i].setBackgroundColor(getResources().getColor(R.color.Green));





            }
            else if(profil.def[i]=='r'){ //Color Red = raté

                date[i].setBackgroundColor(getResources().getColor(R.color.Red));

               

            }


        }
    }


}
