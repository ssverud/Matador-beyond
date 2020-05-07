import java.util.ArrayList;
import java.util.Collections;

public class CardOfChanceDeck {

    static CardOfChanceDeck cardOfChanceDeck = new CardOfChanceDeck();
    //Creates the deck as a singleton, so all chancefields uses the same deck
    public static CardOfChanceDeck getInstance(){
        return cardOfChanceDeck;
    }

    private int numberOfDraws = 0;

    private  String textOfCard;
    ArrayList<Card> cards;

    /**
     * Constructor for the full deck with cards.
     */


    private CardOfChanceDeck(){
        cards.add(new Card("FÆNGSEL","Gå i fængsel. Ryk direkte til fængslet. Selv om De passerer “Start”, indkasserer de ikke kr. 4.000." ));
        cards.add(new Card("FÆNGSEL","Gå i fængsel. Ryk direkte til fængslet. Selv om De passerer “Start”, indkasserer de ikke kr. 4.000." ));
        cards.add(new Card("REPERATION","Betal kr. 3.000 for reparation af Deres vogn." ));
        cards.add(new Card("REPERATION","Betal kr. 3.000 for reparation af Deres vogn." ));
        cards.add(new Card("AKTIER", "Modtag udbytte af Deres aktier kr. 1.000."));
        cards.add(new Card("AKTIER", "Modtag udbytte af Deres aktier kr. 1.000."));
        cards.add(new Card("REDERI","Ryk brikken frem til det nærmeste rederi og betal ejeren to gange den leje, han ellers er berettiget til. Hvis selskabet ikke ejes af nogen kan De købe det af banken."));
        cards.add(new Card("REDERI","Ryk brikken frem til det nærmeste rederi og betal ejeren to gange den leje, han ellers er berettiget til. Hvis selskabet ikke ejes af nogen kan De købe det af banken."));
        cards.add(new Card("KONGENS FØDSELSDAG","I anledning af kongens fødselsdag benådes De herved for fængsel. Dette kort kan opbevares, indtil De får brug for det, eller De kan sælge det."));
        cards.add(new Card("KONGENS FØDSELSDAG","I anledning af kongens fødselsdag benådes De herved for fængsel. Dette kort kan opbevares, indtil De får brug for det, eller De kan sælge det."));
        cards.add(new Card("PRÆMIE", "Deres præmieobligation er kommet ud. De modtager kr. 1.000 af banken."));
        cards.add(new Card("PRÆMIE", "Deres præmieobligation er kommet ud. De modtager kr. 1.000 af banken."));
        cards.add(new Card("VÆRDIG TRÆNGENDE", "De modtager “Matador-legatet for værdig trængende”, stort kr. 40.000. Ved værdig trængende forstås, at Deres formue, d.v.s. Deres kontante penge + skøder + bygninger ikke overstiger kr. 15.000."));
        cards.add(new Card("PARKERINGSBØDE", "De har måttet vedtage en parkeringsbøde. Betal kr. 200 i bøde."));
        cards.add(new Card("RYK TILBAGE", "Ryk tre felter tilbage."));
        cards.add(new Card("FORSIKRING","Betal Deres bilforsikring kr. 1.000."));
        cards.add(new Card("AKTIER","De modtager Deres aktieudbytte. Modtag kr. 1.000 af banken."));
        cards.add(new Card("TIPNING","De havde en række med elleve rigtige i tipning. Modtag kr. 1.000."));
        cards.add(new Card("DYRTIDEN", "Grundet dyrtiden har De fået gageforhøjelse. Modtag kr. 1.000."));
        cards.add(new Card("TANDLÆGEREGNING","De har modtaget Deres tandlægeregning. Betal kr. 2.000."));
        cards.add(new Card("FÆRGE","Tag med den nærmest færge - Flyt brikken frem, og hvis De passerer “Start”, inkassér da kr. 4.000."));
        cards.add(new Card("KLASSELOTTERIET", "De har vundet i Klasselotteriet. Modtag kr. 500."));
        cards.add(new Card("RÅDHUSPLADSEN", "Tag ind på Rådhuspladsen."));
        cards.add(new Card("EJENDOMSSKAT", "Ejendomsskatterne er steget, ekstraudgifterne er: kr. 800 pr. hus, kr. 2.300 pr. hotel."));
        cards.add(new Card("START","Ryk frem til “Start”."));
        cards.add(new Card("CIGARRETTER","De har været en tur i udlandet og haft for mange cigaretter med hjem. Betal told kr. 200."));
        cards.add(new Card("EFTERSKAT", "Kommunen har eftergivet et kvartals skat. Hæv i banken kr. 3.000."));
        cards.add(new Card("OLIEPRISER", "Oliepriserne er steget, og De skal betale: kr. 500 pr. hus, kr. 2.000 pr. hotel."));
        cards.add(new Card("GRØNNINGEN","Ryk frem til Grønningen. Hvis De passerer “Start”, indkassér da kr. 4.000."));
        cards.add(new Card("FREDERIKSBERG","Ryk frem til Frederiksberg Allé. Hvis De passerer “Start” indkassér kr. 4.000."));
        cards.add(new Card("BØDE","De har kørt frem for “Fuld Stop”. Betal kr. 1.000 i bøde."));
        cards.add(new Card("AVL","Værdien af egen avl fra nyttehaven udgør kr. 200, som De modtager af banken."));
        cards.add(new Card("FØDSELSDAG", "Det er Deres fødselsdag. Modtag af hver medspiller kr. 200."));

    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public String draw(){
        numberOfDraws = numberOfDraws + 1;
        return cards.get(0).getTextOfCard();
    }

    public void putToBottom(){
        cards.add(cards.get(0));
        cards.remove(cards.get(0));
        numberOfDraws = numberOfDraws + 1;
    }
}