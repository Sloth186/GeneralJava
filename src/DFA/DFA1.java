package DFA;

import java.util.HashMap;
import java.util.Scanner;
import static DFA.STATE.*;

public class DFA1 {
	final STATE[] states;
	final Character[] alphabet;
	final STATE startState;
	final STATE[] acceptStates;
	final HashMap<STATE, HashMap<Character, STATE>> transition;
	
	public DFA1(STATE[] states, Character[] alphabet, STATE startState, STATE[] acceptStates, STATE[][] transition) {
		this.states = states;
		this.alphabet = alphabet;
		this.startState = startState;
		this.acceptStates = acceptStates;
		this.transition = new HashMap<STATE, HashMap<Character, STATE>>();
		int i, j;
		HashMap<Character, STATE> temp;
		for (i = 0; i < states.length; ++i) {
			temp = new HashMap<>();
			for (j = 0; j < alphabet.length; ++j)
				temp.put(alphabet[j], transition[i][j]);
			this.transition.put(states[i], temp);
		}
	}
	
	public boolean read(String input) {
		Character[] inputChar = input.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
		STATE currentState = startState;
		for (Character character : inputChar)
			currentState = transition.get(currentState).get(character);
		for (STATE as : acceptStates)
			if (currentState == as) return true;
		return false;
	}
	
	public static void main(String[] args) {
		DFA1 dfa = new DFA1(new STATE[]{Q1, Q2, Q3}, new Character[]{'0', '1'}, Q1, new STATE[]{Q2}, new STATE[][]{{Q1, Q2}, {Q3, Q2}, {Q2, Q2}});
		Scanner in = new Scanner(System.in);
		String userInput;
		while (true) {
			userInput = in.nextLine();
			if (userInput.equalsIgnoreCase("quit")) break;
			if (dfa.read(userInput))
				System.out.println("Accepted");
			else
				System.out.println("Rejected");
		}
	}
}