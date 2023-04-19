package afleveringfravaer;

public class AfproevFravaersSystem {

    public static void main(String[] args) {
        int[][] fravaer20S = { { 2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0 }, { 1, 2, 1, 2, 1, 2, 0, 2, 0, 0, 4, 0 },
                { 5, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0 } };

        FravaersSystem fraværsSystem = new FravaersSystem();
        fraværsSystem.udskrivFravaer(fravaer20S);
        System.out.println();
        
        System.out.println("Samlet fra fravær for elev: " + fraværsSystem.samletFravaer(fravaer20S, 1));
        System.out.println();
        
        System.out.println("Gennemsnitlige fra fravær pr måned for elev: " + fraværsSystem.gennemsnit(fravaer20S, 1));
        System.out.println();
        
        System.out.println("Antal elver uden fravær: " + fraværsSystem.antalUdenFravaer(fravaer20S));
        System.out.println();
        
        
        System.out.println("Elev nummer " + fraværsSystem.mestFravaer(fravaer20S) + " har mest fravær");
        System.out.println();
        
        System.out.println("Nulstil fravær fra elev 4");
        fraværsSystem.nulstil(fravaer20S, 4);
        System.out.println();
        
        fraværsSystem.udskrivFravaer(fravaer20S);



    }
}
