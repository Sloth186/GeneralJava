import java.util.LinkedList;
import java.util.Scanner;

public class SamProject1ToDoList {
	private static final Scanner in = new Scanner(System.in);
	private static final StackLL stateStack = new StackLL();
	private static String userInput = "";
	
	// To Do List - same every day
	// Generate graph at the end of each week indicating how many items had been accomplished each day
	// Random Motivational Message
	public static void main(String[] args) {
		stateStack.push(0);
		
		while (!stateStack.isEmpty()) {
			switch (stateStack.top()) {
				case 0 -> menu("Main Menu ~ choose an action:", "Check off/uncheck item from active to-do list", "End current day for active to-do list", "Change active to-do list", "View to-do list", "Create a to-do list", "View motivational list", "Change active motivational list", "Create motivational list", "View manual");
				case 1 -> { // Check off/uncheck item from active to-do list
				
				}
				case 2 -> { // End current day for active to-do list
				
				}
				case 3 -> { // Change active to-do list
				
				}
				case 4 -> { // View to-do list
				
				}
				case 5 -> { // Create a to-do list
				
				}
				case 6 -> { // View motivational list
				
				}
				case 7 -> { // Change active motivational list
				
				}
				case 8 -> { // Create motivational list
				
				}
				case 9 -> { // View manual
				
				}
			}
			
			System.out.println();
		}
	}
	
	public static void menu(String question, String... items) {
		int oldTop = stateStack.top();
		
		System.out.println(question);
		for (int i = 0; i < items.length; ++i)
			System.out.println(" " + (i + 1) + " - " + items[i]);
		System.out.print(">> ");
		
		while (stateStack.top() == oldTop) {
			userInput = in.nextLine();
			try {
				int menuChoice = Integer.parseInt(userInput);
				if (menuChoice < 1 || menuChoice > items.length)
					System.out.println("""
									 Invalid choice.
									>> """);
				else
					stateStack.push(menuChoice);
			} catch (Exception e) {
				System.out.println("""
								 Invalid choice.
								>> """);
			}
		}
	}
	
	private static class ToDoList {
		private static final class Item {
		
		}
		
		private final String name;
		private final SinglyLinkedList toDoList;
		private int day;
		
		public ToDoList(String name) {
			this.name = name;
			toDoList = new SinglyLinkedList();
		}
	}
}