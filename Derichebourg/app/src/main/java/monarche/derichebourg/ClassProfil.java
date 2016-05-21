package monarche.derichebourg;

/**
 * Created by RaveN on 18/04/2016.
 */
public class ClassProfil implements java.io.Serializable {

    ClassDefi defi= new ClassDefi(); // ajouter une classe défi au profil pour les données de dates etc
    int nbrdefi=0;  // contient le nbr de défi réalisés

    char[] def=new char[31];   // contient le tableau des défis réalisés dans le mois
    String month="Apr";    // contient le mois actuel


    char[] Mon=new char[3];   // sert à récupérer le mois ... Plus utile ici ??


    public String getndefis(){  // sert à afficher le nombre de défis
        String s;
        s=""+nbrdefi;  // aller on triche !
        return s;
    }



    public ClassProfil() { //déclaration du nouveau profil ... a servi
    }
    public void gaindefi(){  // incrémentation variable
        nbrdefi++;

    }
    public void defiquotidien(){  // BIN .... je sais plus pourquoi c'est là

    }

    /* lancé à l'écran principal (activity principale) : sert a :
    -vérifier la date
    -vérifier  le mois
    -remplir les champs de défi quotidiens non effectués
     */
    public void lancementApp(){
        String tempsmonth="";

        char[] monthtemp;
        int d;


        /* Initialisation de l'application */

        defi.IsItANewDay(); /* Vérification du jour : Savoir si c'est un nouveau jour */


        /*
        !!!!!!!!!!!!!!!!!!!!!! ATTENTION : Methode à mettre à jour pour prendre en compte la langue de l'appareil  !!!!!!!!!!!!!!!!!!!!!!!
         */

        monthtemp=defi.Compare[0].toCharArray(); // récupérer dans un char []
        Mon[0]=monthtemp[0];  // extraction dans la donnée utile ... Vraiment nécessaire ??
        Mon[1]=monthtemp[1];
        Mon[2]=monthtemp[2];
        tempsmonth=tempsmonth +Mon[0];  // récupération dans une string
        tempsmonth=tempsmonth +Mon[1];
        tempsmonth=tempsmonth +Mon[2];



        d=calculJour();  // calcul du jour actuel , Thx captain obvious


        if(tempsmonth.compareTo(month)!=0){  // comparaison mois actuel avec pré-enregistré
            new_month();


        }






        for(int i=0;i<d;i++){  // compléter les champs de défis quotidien non effectués
            if(def[i]!='g'){
                def[i]='r';
            }

        }







    }


    public void new_month(){   // action lors d'un nouveau mois : réinitialisation du tableau et enregistrement du nouveau mois dans la variable
        char[] monthtemp;
        char[] Mont=new char[3];
        month="";



        /*
        !!!!!!!!!!!!!!!!!!!!!! ATTENTION : Methode à mettre à jour pour prendre en compte la langue de l'appareil  !!!!!!!!!!!!!!!!!!!!!!!
         */
        monthtemp=defi.Compare[0].toCharArray();

        if(monthtemp[0]<60) {              // FR

            if(monthtemp[1]!=' ') {
                Mont[0] = monthtemp[3];
                Mont[1] = monthtemp[4];
                Mont[2] = monthtemp[5];
                month = month + Mont[0];
                month = month + Mont[1];
                month = month + Mont[2];


            }
            else{
                Mon[0] = monthtemp[2];
                Mon[1] = monthtemp[3];
                Mon[2] = monthtemp[4];
                month = month + Mon[0];
                month = month + Mon[1];
                month = month + Mon[2];

            }


        } else{                            // ENG


                Mon[0] = monthtemp[0];
                Mon[1] = monthtemp[1];
                Mon[2] = monthtemp[2];
                month = month + Mon[0];
                month = month + Mon[1];
                month = month + Mon[2];



        }
        for(int i=0;i<31;i++){  // compléter les champs de défis quotidien non effectués

                def[i]='n';


        }








    }


    public void defi_quotidien_reussi(){ // défi quotidien réussi

        def[calculJour()-1]='g';  // changement de rouge( non effectué )ou gris (incertain) en vert (effectué)
    }


    public int calculJour(){  // calcul du jour prenant compte la langue de l'utilisateur
        int d;
        char[] monthtemp;



        monthtemp=defi.Compare[0].toCharArray();
        if(monthtemp[0]<60) {

            if(monthtemp[1]!=' ') {  // FR
                d=(monthtemp[0]-48)*10+(monthtemp[1]-48);
            }
            else d=(monthtemp[0] - 48);

        } else{
            if(monthtemp[5]!=',') {  // ENG
                d=(monthtemp[4]-48)*10+(monthtemp[5]-48);
            }
            else d=(monthtemp[4] - 48);

        }



        return d;
    }




}
