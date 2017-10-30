import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author B0544203 石家安
 * First, we input the how many deck that I want. Next, the HW2 have two classes,class and card.
 * If the print card is correct, it will represent the Well done!
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("\nWell done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards
	 * @param nDeck
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}
		else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Description: 
 * We describe the Deck in the beginning. 
 * First, we can use nested loops to put the card into "cards".
 * quantity is the count of Deck(nDeck).
 * x  is the code of rank
 * y  is the code of suit
 * When the quantity is 1 and the program will run x = 1, and then the program will run y=1 from y=13 and so on the next program.
 * card is the field to add card into "cards".
 * Afterward, we can do the printDeck method. Create "allcards" and get the card from "cards". 
 * In the end, we can reuse the printcard method.  
 * 
 */
class Deck{
	private ArrayList<Card> cards;
	/**
	 *
	 * @param nDeck how many deck you input
	 */
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		
		for(int quantity=1; quantity<=nDeck; quantity++){
			for(int x=1; x<=4; x++){
				for(int y=1; y<=13; y++){
					Card card = new Card(x,y);
					cards.add(card); 
				}
			}
		}
	}	

	public void printDeck(){ 
		for(int i = 0; i < cards.size(); i++) {   
			Card allcards = cards.get(i);
			allcards.printCard();
		}  

	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}

/**
 * Description: First, writing the class, Card, and int the field suit and rank.
 * Furthermore, writing the constructors.
 * Next, printCard, getSuit and getRank is the method.
 * Create the two array to present the rank and suit conveniently. 
 * The first index of array is 0, so we should subtract 1 when we want to get the String from array.  
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	public void printCard(){
		String[] SuitArray={"Club","Diamond","Heart","Spade"};
		String[] RankArray={"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
		System.out.println(SuitArray[suit-1]+" "+RankArray[rank-1]);


	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
