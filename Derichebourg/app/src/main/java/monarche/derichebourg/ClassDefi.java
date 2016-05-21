package monarche.derichebourg;

import java.io.File;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by RaveN on 12/04/2016.
 */

public class ClassDefi implements java.io.Serializable{
    private static final int MAX_DEFI = 31;   // utiliser pour le random defi

    private int nDefi=1;    // int pour le random ... pas forcé de le définir ici
    int length=0;  // longueur du message ... pas besoin de le définir ici





    String[] Compare=new String[2]; // servira à contenir la date pour la comparer et en tirer le jour


    Boolean YOLO=true;  // booléen du défi quotidien
    Boolean superYOLO=true; // booléen de la 1ère utilisation de l'application pour déclarer les données


    public String[] getCompare() {
        return Compare;
    }  // useless for now

    public void setCompare(String[] compare) {
        Compare = compare;
    } // useless for now


    public ClassDefi(){   // permet de déclarer un message non nul EDIT : plus de fonctions ^^




    }

    public void Initialize(){// 1ère initialisation des paramètres
        // Données utiles pour récupérer une date
        Date dateA=new Date(); // récupère la date actuelle (Trop de paramètres)
        DateFormat[] dateR= new DateFormat[]{DateFormat.getDateInstance(),DateFormat.getTimeInstance()}; // sert à compartimenter la date pour récupérer la partie interessante

        if(superYOLO){// paramètre qui ne sert qu'1 fois pour le 1er lancement de l'appli
            superYOLO=false;
            Compare[0]=dateR[0].format(dateA);


        }
        Compare[1]=dateR[0].format(dateA);



    }

    public void IsItANewDay(){ //  Est-ce un nouveau jour ?
        Initialize();  // vérifie si l'on est passé à un nouveau jour et cherche la nouvelle date à comparer en dessous
        if(Compare[0].compareTo(Compare[1])!=0){ // SI !=0 <=> oui sinon non
            Compare[0]=Compare[1];
            YOLO=true;   // nouveau jour donc True
        }
    }
    public void roll(){   // random défi
        nDefi=(int)(Math.random()*(MAX_DEFI))+1;

    }



    public char[] message(){ // message du  Défi aléatoire
        char[] Text=new char[400];
        String s=null;

        switch(getnDefi()) {
            case 1:{
                s="\tDiminuer de 1 degré la température de votre bureau permet de réduire la consommation annuelle en chauffage de 5 à 10 %. (La température recommandée dans les bureaux se situe entre 19 et 21)";
                break;
            }
            case 2:{
                s="\tUn ordinateur portable consomme 50 à 80 % d’énergie en moins qu’un poste fixe";
                break;
            }
            case 3:{
                s="\tLa pratique de l’éco-conduite permet de diminuer la consommation de carburant jusqu’à 15%, de diminuer le risque d’accident de 10% à 15% et de limiter les émissions de GES qui sont à l’origine du réchauffement climatique.";
                break;
            }
            case 4:{
                s="\tUn ordinateur en veille continue de consommer entre 20% et 40% de sa consommation en marche. Il vaut mieux arrêter l’ordinateur plusieurs fois dans la même journée.";
                break;
            }
            case 5:{
                s="\tLe papier est le premier consommable au bureau : 65 kg consommés par an et par personne, soit environ 25 ramettes. Le taux de recyclage des papiers de bureau en France est de 35%. Il faut 20 fois moins de bois, 6 fois moins d’eau et 2 fois moins d’énergie pour fabriquer du papier recyclé que pour d’autre type de papier.";
                break;
            }
            case 6:{
                s="\tLes ampoules basse consommation consomment 5 fois moins d’énergie et durent 8 fois plus longtemps que les autres types d’ampoules.";
                break;
            }
            case 7:{
                s="\tLa consommation d’eau dans un immeuble de bureaux est de 15 à 20 litres par personne et par jour.";
                break;
            }
            case 8:{
                s="\tLa durée de vie d’un mouchoir en papier est de 3 mois ; d’un chewing-gum est de 5 ans ; d’une canette en aluminium est de 100 ans ; d’un sac plastique est de 450 ans ; d’une carte à puce est de 1000 ans ; du verre est de 5000 ans.";
                break;
            }
            case 9:{
                s="\tLes transports n’ont pas tous le même impact : on consomme 40 % d’énergie en moins en bus qu’en voiture. Pour le métro, c’est 104 fois moins.";
                break;
            }
            case 10:{
                s="\t10 minutes d’éclairage inutile 3 fois par jour, c’est l’équivalent de 5 jours d’éclairage en continu au bout d’un an !";
                break;
            }
            case 11:{
                s="\tJ’éteins mon matériel informatique en cas d’absence prolongée.(dés 30mn d’absence)";
                break;
            }
            case 12:{
                s="\tJe débranche mon chargeur de la prise lorsque mon téléphone est rechargé.";
                break;
            }
            case 13:{
                s="\tJ’adapte la température de mon bureau entre 19 et 21° ou 4°< à la température extérieur. En été, j’ouvre les fenêtres aux heures fraiches, je ferme les stores ou volets lors des grosses chaleurs. Je m’assure que toutes les fenêtres soient bien fermées pour que la climatisation soit efficace.";
                break;
            }
            case 14:{
                s="\tJe vérifie que les robinets soient bien fermés après usage et je signale les fuites d’eau.";
                break;
            }
            case 15:{
                s="\tJ’éteins la lumière lorsque je quitte une pièce et je privilégie la lumière du jour quand c’est possible.";
                break;
            }
            case 16:{
                s="\tJe pratique l’éco-conduite : j’anticipe mes trajets en choisissant l’itinéraire le plus efficace selon la distance, les conditions de circulation… Je ne charge pas trop ma voiture ; je conduis de manière souple (démarrage en douceur, passage des rapports supérieurs autour des 2500 tours/minute pour les véhicules essence ou 2000 tours/minute pour les véhicules diesels) ; j’utilise le frein-moteur plutôt que la pédale de frein ; j’utilise la climatisation modérément ; je maintiens une vitesse constante ; j’entretiens mon véhicule régulièrement.";
                break;
            }
            case 17:{
                s="\tJ’utilise la télé/vidéo-conférence et les plates-formes de partage d’information pour mes réunions professionnels à distance.";
                break;
            }
            case 18:{
                s="\tEn partant du bureau le soir, je fais le tour de l’étage et je vérifie que toutes les lumières soient éteintes ainsi que les photocopieur si je suis le dernier à partir";
                break;
            }
            case 19:{
                s="\tJe préfère un mode de transport alternatif (vélo, marche à pieds, transports en commun, co-voiturage, auto-partage…)";
                break;
            }
            case 20:{
                s="\tJe supprime toutes les sources de déchets inutiles car les déchets non produits sont les plus faciles à gérer…";
                break;
            }
            case 21:{
                s="\tJ’installe une multiprises à interrupteur pour brancher mes équipements.";
                break;
            }
            case 22:{
                s="\tJe colle mes stickers ";
                break;
            }
            case 23:{
                s="\tJ’utilise  des enveloppes à utilisation multiple pour le courrier interne";
                break;
            }
            case 24:{
                s="\tJe résilie les abonnements aux journaux et magazines inutiles, même gratuits. ";
                break;
            }
            case 25:{
                s="\tJ’apporte ma tasse personnelle afin de ne pas consommer de gobelet en plastique";
                break;
            }
            case 26:{
                s="\tJ’utilise du papier au grammage plus léger ou/et du papier éco-labellisé (les écolabels sont : Ecolabel européen, Ange bleu, Ecolabel nordique).";
                break;
            }
            case 27:{
                s="\tJe réutilise comme brouillon les versos blancs des documents imprimés ou photocopiés";
                break;
            }
            case 28:{
                s="\tJ’aère le bureau tous les jours 5 minutes pour renouveler l’air (je m’assure au préalable que le chauffage ou la climatisation est bien éteint).";
                break;
            }
            case 29:{
                s="\tJe dispose d’un N°de téléconférences / visioconférence ,d’une plates-formes de partage d’informations permettent la diffusion de présentations, de dossiers pour limiter mes déplacements (ex : link)";
                break;
            }
            case 30:{
                s="\tJe paramètre mon ordinateur pour imprimer par défaut  en noir et blanc et en recto verso";
                break;
            }
            case 31:{
                s="défi gratuit !";
                break;
            }
            default :{
                s="n'a pas fonctionné";
                break;
            }
        }
        length=s.length();
        Text=s.toCharArray();
          // récupération de la distance

    return Text;
    }


    public char[] calendrier(String a,int d){ // Défi quotidien
        char[] Text=new char[400];
        String s=null;






        switch(d) {
            case 1:{
                s="\tDiminuer de 1 degré la température de votre bureau permet de réduire la consommation annuelle en chauffage de 5 à 10 %. (La température recommandée dans les bureaux se situe entre 19 et 21)";
                break;
            }
            case 2:{
                s="\tUn ordinateur portable consomme 50 à 80 % d’énergie en moins qu’un poste fixe";
                break;
            }
            case 3:{
                s="\tLa pratique de l’éco-conduite permet de diminuer la consommation de carburant jusqu’à 15%, de diminuer le risque d’accident de 10% à 15% et de limiter les émissions de GES qui sont à l’origine du réchauffement climatique.";
                break;
            }
            case 4:{
                s="\tUn ordinateur en veille continue de consommer entre 20% et 40% de sa consommation en marche. Il vaut mieux arrêter l’ordinateur plusieurs fois dans la même journée.";
                break;
            }
            case 5:{
                s="\tLe papier est le premier consommable au bureau : 65 kg consommés par an et par personne, soit environ 25 ramettes. Le taux de recyclage des papiers de bureau en France est de 35%. Il faut 20 fois moins de bois, 6 fois moins d’eau et 2 fois moins d’énergie pour fabriquer du papier recyclé que pour d’autre type de papier.";
                break;
            }
            case 6:{
                s="\tLes ampoules basse consommation consomment 5 fois moins d’énergie et durent 8 fois plus longtemps que les autres types d’ampoules.";
                break;
            }
            case 7:{
                s="\tLa consommation d’eau dans un immeuble de bureaux est de 15 à 20 litres par personne et par jour.";
                break;
            }
            case 8:{
                s="\tLa durée de vie d’un mouchoir en papier est de 3 mois ; d’un chewing-gum est de 5 ans ; d’une canette en aluminium est de 100 ans ; d’un sac plastique est de 450 ans ; d’une carte à puce est de 1000 ans ; du verre est de 5000 ans.";
                break;
            }
            case 9:{
                s="\tLes transports n’ont pas tous le même impact : on consomme 40 % d’énergie en moins en bus qu’en voiture. Pour le métro, c’est 104 fois moins.";
                break;
            }
            case 10:{
                s="\t10 minutes d’éclairage inutile 3 fois par jour, c’est l’équivalent de 5 jours d’éclairage en continu au bout d’un an !";
                break;
            }
            case 11:{
                s="\tJ’éteins mon matériel informatique en cas d’absence prolongée.(dés 30mn d’absence)";
                break;
            }
            case 12:{
                s="\tJe débranche mon chargeur de la prise lorsque mon téléphone est rechargé.";
                break;
            }
            case 13:{
                s="\tJ’adapte la température de mon bureau entre 19 et 21° ou 4°< à la température extérieur. En été, j’ouvre les fenêtres aux heures fraiches, je ferme les stores ou volets lors des grosses chaleurs. Je m’assure que toutes les fenêtres soient bien fermées pour que la climatisation soit efficace.";
                break;
            }
            case 14:{
                s="\tJe vérifie que les robinets soient bien fermés après usage et je signale les fuites d’eau.";
                break;
            }
            case 15:{
                s="\tJ’éteins la lumière lorsque je quitte une pièce et je privilégie la lumière du jour quand c’est possible.";
                break;
            }
            case 16:{
                s="\tJe pratique l’éco-conduite : j’anticipe mes trajets en choisissant l’itinéraire le plus efficace selon la distance, les conditions de circulation… Je ne charge pas trop ma voiture ; je conduis de manière souple (démarrage en douceur, passage des rapports supérieurs autour des 2500 tours/minute pour les véhicules essence ou 2000 tours/minute pour les véhicules diesels) ; j’utilise le frein-moteur plutôt que la pédale de frein ; j’utilise la climatisation modérément ; je maintiens une vitesse constante ; j’entretiens mon véhicule régulièrement.";
                break;
            }
            case 17:{
                s="\tJ’utilise la télé/vidéo-conférence et les plates-formes de partage d’information pour mes réunions professionnels à distance.";
                break;
            }
            case 18:{
                s="8.\tEn partant du bureau le soir, je fais le tour de l’étage et je vérifie que toutes les lumières soient éteintes ainsi que les photocopieur si je suis le dernier à partir";
                break;
            }
            case 19:{
                s="9.\tJe préfère un mode de transport alternatif (vélo, marche à pieds, transports en commun, co-voiturage, auto-partage…)";
                break;
            }
            case 20:{
                s="10.\tJe supprime toutes les sources de déchets inutiles car les déchets non produits sont les plus faciles à gérer…";
                break;
            }
            case 21:{
                s="1.\tJ’installe une multiprises à interrupteur pour brancher mes équipements.";
                break;
            }
            case 22:{
                s="2.\tJe colle mes stickers ";
                break;
            }
            case 23:{
                s="3.\tJ’utilise  des enveloppes à utilisation multiple pour le courrier interne";
                break;
            }
            case 24:{
                s="4.\tJe résilie les abonnements aux journaux et magazines inutiles, même gratuits. ";
                break;
            }
            case 25:{
                s="5.\tJ’apporte ma tasse personnelle afin de ne pas consommer de gobelet en plastique";
                break;
            }
            case 26:{
                s="6.\tJ’utilise du papier au grammage plus léger ou/et du papier éco-labellisé (les écolabels sont : Ecolabel européen, Ange bleu, Ecolabel nordique)." ;
                break;
            }
            case 27:{
                s="7.\tJe réutilise comme brouillon les versos blancs des documents imprimés ou photocopiés";
                break;
            }
            case 28:{
                s="8.\tJ’aère le bureau tous les jours 5 minutes pour renouveler l’air (je m’assure au préalable que le chauffage ou la climatisation est bien éteint).";
                break;
            }
            case 29:{
                s="9.\tJe dispose d’un N°de téléconférences / visioconférence ,d’une plates-formes de partage d’informations permettent la diffusion de présentations, de dossiers pour limiter mes déplacements (ex : link)";
                break;
            }
            case 30:{
                s="10.\tJe paramètre mon ordinateur pour imprimer par défaut  en noir et blanc et en recto verso";
                break;
            }
            case 31:{
                s="";
                break;
            }
            default :{
                s="n'a pas fonctionné";
                break;
            }
        }
        s=s+" "+a+" " +Compare[0]; // à enlever à la fin

        Text=s.toCharArray();

        length=s.length();

        return Text;
    }



    public int Imagechange(int d){  // récupérer l'image à afficher en fonction de la date


        int FileINT=R.drawable.change; // donnée contenant le code de l'image à afficher




        switch(d) {
            case 1:{
                if(YOLO){
                FileINT=R.drawable.date01;

                }
                else FileINT=R.drawable.date01b;
                break;
            }
            case 2:{
                if(YOLO){
                    FileINT=R.drawable.date02;

                }
                else FileINT=R.drawable.date02b;
                break;
            }
            case 3:{
                if(YOLO){
                    FileINT=R.drawable.date03;

                }
                else FileINT=R.drawable.date03b;
                break;
            }
            case 4:{
                if(YOLO){
                    FileINT=R.drawable.date04;

                }
                else FileINT=R.drawable.date04b;
                break;
            }
            case 5:{
                if(YOLO){
                    FileINT=R.drawable.date05;

                }
                else FileINT=R.drawable.date05b;
                break;
            }
            case 6:{
                if(YOLO){
                    FileINT=R.drawable.date06;

                }
                else FileINT=R.drawable.date06b;
                break;
            }
            case 7:{
                if(YOLO){
                    FileINT=R.drawable.date07;

                }
                else FileINT=R.drawable.date07b;
                break;
            }
            case 8:{
                if(YOLO){
                    FileINT=R.drawable.date08;

                }
                else FileINT=R.drawable.date08b;
                break;
            }
            case 9:{
                if(YOLO){
                    FileINT=R.drawable.date09;

                }
                else FileINT=R.drawable.date09b;
                break;
            }
            case 10:{
                if(YOLO){
                    FileINT=R.drawable.date10;

                }
                else FileINT=R.drawable.date10b;
                break;
            }
            case 11:{
                if(YOLO){
                    FileINT=R.drawable.date11;

                }
                else FileINT=R.drawable.date11b;
                break;
            }
            case 12:{
                if(YOLO){
                    FileINT=R.drawable.date12;

                }
                else FileINT=R.drawable.date12b;
                break;
            }
            case 13:{
                if(YOLO){
                    FileINT=R.drawable.date13;

                }
                else FileINT=R.drawable.date13b;
                break;
            }
            case 14:{
                if(YOLO){
                    FileINT=R.drawable.date14;

                }
                else FileINT=R.drawable.date14b;
                break;
            }
            case 15:{
                if(YOLO){
                    FileINT=R.drawable.date15;

                }
                else FileINT=R.drawable.date15b;
                break;
            }
            case 16:{
                if(YOLO){
                    FileINT=R.drawable.date16;

                }
                else FileINT=R.drawable.date16b;
                break;
            }
            case 17:{
                if(YOLO){
                    FileINT=R.drawable.date17;

                }
                else FileINT=R.drawable.date17b;
                break;
            }
            case 18:{
                if(YOLO){
                    FileINT=R.drawable.date18;

                }
                else FileINT=R.drawable.date18b;
                break;
            }
            case 19:{
                if(YOLO){
                    FileINT=R.drawable.date19;

                }
                else FileINT=R.drawable.date19b;
                break;
            }
            case 20:{
                if(YOLO){
                    FileINT=R.drawable.date20;

                }
                else FileINT=R.drawable.date20b;
                break;
            }
            case 21:{
                if(YOLO){
                    FileINT=R.drawable.date21;

                }
                else FileINT=R.drawable.date21b;
                break;
            }
            case 22:{
                if(YOLO){
                    FileINT=R.drawable.date22;

                }
                else FileINT=R.drawable.date22b;
                break;
            }
            case 23:{
                if(YOLO){
                    FileINT=R.drawable.date23;

                }
                else FileINT=R.drawable.date23b;
                break;
            }
            case 24:{
                if(YOLO){
                    FileINT=R.drawable.date24;

                }
                else FileINT=R.drawable.date24b;
                break;
            }
            case 25:{
                if(YOLO){
                    FileINT=R.drawable.date25;

                }
                else FileINT=R.drawable.date25b;
                break;
            }
            case 26:{
                if(YOLO){
                    FileINT=R.drawable.date26;

                }
                else FileINT=R.drawable.date26b;
                break;
            }
            case 27:{
                if(YOLO){
                    FileINT=R.drawable.date27;

                }
                else FileINT=R.drawable.date27b;
                break;
            }
            case 28:{
                if(YOLO){
                    FileINT=R.drawable.date28;

                }
                else FileINT=R.drawable.date28b;
                break;
            }
            case 29:{
                if(YOLO){
                    FileINT=R.drawable.date29;

                }
                else FileINT=R.drawable.date29b;
                break;
            }
            case 30:{
                if(YOLO){
                    FileINT=R.drawable.date30;

                }
                else FileINT=R.drawable.date30b;
                break;
            }
            case 31:{
                if(YOLO){
                    FileINT=R.drawable.date31;

                }
                else FileINT=R.drawable.date31b;
                break;
            }
        }



        return FileINT;
    }

    public int getnDefi() {
        return nDefi;
    }  // useless now

    public void setnDefi(int nDefi) {
        this.nDefi = nDefi;
    }  // useless now






    }


