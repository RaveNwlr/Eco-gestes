package monarche.derichebourg;




import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class defi extends Activity  {
    ClassProfil profil= new ClassProfil();  // l'instance profil contient toutes les données utiles

    // sert à déclarer les éléments graphiques
    TextView Text;
    Button fab;
    ImageView pic;
    Button button;





    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        profil = Serialization.deserialize(getApplicationContext());

        if (profil == null) {
            // That way it won't crash. However that's not the best way of doing things
            profil = new ClassProfil();

        }

        profil.lancementApp(); // déclenche une suite de fonctions initialisat les variables utiles




        setContentView(R.layout.activity_defi); // déclaration élements graphiques
        pic    = (ImageView) findViewById ( R.id.imageView );
        button = (Button)    findViewById ( R.id.button );
        Text   = (TextView)  findViewById ( R.id.textView );
        fab    = (Button)    findViewById ( R.id.fab );





        button.setBackground(getResources().getDrawable(R.drawable.ecogestev)); // bouton validation


        fab.setBackground(getResources().getDrawable(R.drawable.change)); // bouton profil

        affichage(); // affiche le premier message et la 1ère image (Penser à désactiver la validation automatique du défi... (normalement fait !))


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {   // ouvrir le profil
                startActivity(new Intent(defi.this,userprofil.class));





            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {  // valisation du défi en cours
                profil.gaindefi();  // défi +1
                if(profil.defi.YOLO){  // vérification défi quotidien et désactivation
                    profil.defi.YOLO=false;
                    profil.defi_quotidien_reussi();
                }


                affichage();






            }
        });




}
    public void affichage(){ // gère l'affichage et le réaffichage
        if(profil.defi.YOLO){  // sert pour le defi quotidien
            Text.setText(profil.defi.calendrier(profil.month,profil.calculJour()), 0, profil.defi.length);

        }
        else{ // sert pour le reste du temps
            profil.defi.roll();
            Text.setText(profil.defi.message(), 0, profil.defi.length);
        }

        pic.setImageDrawable(getResources().getDrawable(profil.defi.Imagechange(profil.calculJour())));
        Serialization.serialize(profil, getApplicationContext());
    }

}
