package RandomStuff;

import java.util.Random;
import java.util.Scanner;

public class HelpingGraceDecide {
	
	private static class Options {
		private static class Option {
			String description;
			int weight;
			Option next;
			
			public Option(String description) {
				this.description = description;
				weight = 0;
				next = null;
			}
		}
		
		Option head;
		Option tail;
		int length;
		
		public void addOption(String description, int weight) {
			Option newOption = new Option(description);
			
			if (head == null) {
				head = tail = newOption;
			} else {
				tail.next = newOption;
				tail = newOption;
			}
			
			++length;
		}
		
		public void addOption(String description) {
			addOption(description, 0);
		}
		
		public Option findOption(int index) {
			Option temp = head;
			
			for (int i = 0; i < index; ++i)
				temp = temp.next;
			
			return temp;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String userInput;
		int counter = 0;
		
		System.out.println("Is your name Grace?");
		while (counter == 0) {
			System.out.print("> ");
			userInput = in.nextLine().toLowerCase();
			counter = switch (userInput) {
				case "yes", "yee", "yeah", "yep", "ye", "yea", "yeee":
					System.out.println("Welcome, it is good to see you. I hope I can be helpful today!");
					yield 1;
				case "no", "nah", "nope":
					System.out.println("Get out of here then.");
					yield 2;
				default:
					System.out.println("That is not an answer I recognize.");
					yield 0;
			};
		}
		
		if (counter == 1) {
			Random rg = new Random();
			int index;
			String selection;
			
			do {
				System.out.println("How many options are there for the decision that you want help with on making?");
				System.out.print("> ");
				
				try {
					counter = in.nextInt();
					if (counter == 0) {
						break;
					} else if (counter < 0) {
						System.out.println("Not a valid number 😑");
					} else {
						Options options = new Options();
						in.nextLine();
						for (int i = 0; i < counter; ++i) {
							System.out.println("Describe option #" + i + ".");
							System.out.print("> ");
							userInput = in.nextLine();
							System.out.println("On a scale of 1 to 5, how important do you feel like this option is?");
							System.out.print("> ");
							try {
								counter = in.nextInt();
							} catch (Exception e) {
								System.setOut(System.out);
							}
							in.nextLine();
							options.addOption(userInput, counter);
						}
						
						index = rg.nextInt(options.length);
						selection = options.findOption(index).description;
						
						System.out.println("This shall be your action:\n\t" + selection);
						
						in.nextLine();
					}
				} catch (Exception e) {
					System.out.println("Not a valid number 😑");
					in.nextLine();
				}
			} while (true);
			
			System.out.println("Good bye! Have a great day!");
		}
	}
}
