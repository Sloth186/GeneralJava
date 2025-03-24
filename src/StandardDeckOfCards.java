public enum StandardDeckOfCards {
	ACE_OF_SPADES("1♠"),
	ACE_OF_HEARTS("1♥"),
	ACE_OF_CLUBS("1♣"),
	ACE_OF_DIAMONDS("1♦");
	
	String text;
	
	StandardDeckOfCards(String text) {
		this.text = text;
	}
}