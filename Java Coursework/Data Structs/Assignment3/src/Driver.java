import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) throws FileNotFoundException {
		// Once you complete the TODO code, your code should pass the tests.
		if (LinkedList.testClass()) {
			System.err.println("Code passes all tests.  You should still make sure that the reported accuracy is 80.138%.\n" +
					"Otherwise there may be an error in your predictAuthor method.\n");
		}
		else {
			System.err.println("Please fix code and try again.");
			return;
		}

		// Process the input
		Scanner sc = new Scanner(new File("input.txt"));
		int phraseCount = Integer.valueOf(sc.nextLine());
		Phrase[] phrases = new Phrase[phraseCount];
		for (int i = 0; i < phraseCount; i++) {
			String line = sc.nextLine();
			String[] tokens = line.split("\t");
			phrases[i] = new Phrase(Integer.valueOf(tokens[0]),tokens[1],Integer.valueOf(tokens[2]));
		}
		sc.close();

		// Build the phrase matcher
		long startTime = System.currentTimeMillis();
		PhraseMatcher phraseMatcher = new PhraseMatcher(4);
		for (int i = 0; i < phraseCount; i++) {
			phraseMatcher.insertNgramsFromPhrase(phrases[i]);
		}
		phraseMatcher.scaleWeightsByLength();

		// Assess the accuracy of the system
		int correct = 0;
		for (int i = 0; i < phraseCount; i++) {
			int bestMatch = phraseMatcher.predictAuthor(phrases[i]);
			if (bestMatch == phrases[i].getAuthor()) correct++;
		}
		System.out.printf("System accuracy: %.3f%%%n", 100.0*correct/phraseCount);

		System.out.println("Elapsed time: " +(System.currentTimeMillis() - startTime));

	}
}

/**
 * A spooky phrase object
 */
class Phrase {
	private int id;
	private int author; // 0 for Edgar Allen Poe, 1 for H.P. Lovecraft, and 3 for Mary W. Shelly
	private String text; // The text of the phrase

	public Phrase(int id, String text, int author) {
		this.id = id;
		this.text = text;
		this.author = author;
	}

	/*
	 * Getter Methods
	 */
	public int getId() { return id; }
	public int getAuthor() { return author; }
	public String getText() { return text; }
}

/**
 * The PhraseMatcher stores phrases for the purpose of finding similar phrases
 */
class PhraseMatcher {
	private static final int LOG_CHARSET_SIZE = 5;
	private final int N;
	private LinkedList[] ngrams;
	private int[] mappings = new int[127];

	PhraseMatcher(int n) {
		this.N = n;

		int ndx = 0;
		char[] punct = " !.\"',".toCharArray(); 
		for (char c : punct) {
			mappings[c] = ndx++;
		}
		for (int c = 'a'; c <= 'z'; c++) {
			mappings[c] = ndx++;
		}

		ngrams = new LinkedList[1<<(LOG_CHARSET_SIZE*N)];
	}

	/**
	 * Add n-grams for a phrase to the appropriate linked list
	 * 
	 * Extra credit: You can speed up the process of obtaining the mapping of the 
	 * substring to an index in the ngram array, by more than a factor of N. Note
	 * that this is a small component of the overall running time, so you may or
	 * may not see a speed up in the elapsed time measure.             
	 * 
	 * @param phrase the phrase to add
	 */
	void insertNgramsFromPhrase(Phrase phrase) {
		for (int i = 0; i < phrase.getText().length() - N + 1; i++) {
			int index = 0;
			for (int j = i; j < i+N; j++) {
				index = index * 32 + mappings[phrase.getText().charAt(j)];
			}
			if (ngrams[index] == null) ngrams[index] = new LinkedList();
			ngrams[index].addNode(phrase, 1);
		}
	}

	/**
	 * Scale the weights in the ngram lists by dividing them by the length of the lists
	 */
	public void scaleWeightsByLength() {
		for (LinkedList list: ngrams) {
			if (list != null) {
				list.scaleWeights();
			}
		}
	}
	
	/** 
	 * Use a k-nearest neighbor approach to predict the author of the attached phrase
	 * 
	 * Extra credit: You can speed up the process of obtaining the mapping of the 
	 * substring to an index in the ngram array, by more than a factor of N. Note
	 * that this is a small component of the overall running time, so you may or
	 * may not see a speed up in the elapsed time measure.             
	 * 
	 * @param phrase the phrase to match
	 * @return the id corresponding to the predicted author
	 */
	int predictAuthor(Phrase phrase) {
		LinkedList matchList = null; 

		for (int i = 0; i < phrase.getText().length() - N + 1; i++) {
			int index = 0;
			for (int j = i; j < i+N; j++) {
				index = index * 32 + mappings[phrase.getText().charAt(j)];
			}
			if (matchList == null) matchList = new LinkedList(ngrams[index]);
			else matchList.merge(ngrams[index]);
		}

		return matchList.getTopAuthor(phrase);		
	}	
}

class LinkedList {
	static int K_OF_K_NEAREST_NEIGHBORS = 27;
	Node first;
	int length;

	public LinkedList() {}

	/**
	 * Create a copy of the parameter list, by creating new nodes with the same 
	 * contents of the nodes in the input list.  While you should create new Node
	 * objects, you should not create new Phrase objects
	 * 
	 * Note that this should run in time that is linear in the length of the input list.
	 * 
	 * @param that the input list
	 */
	public LinkedList(LinkedList that) {
		// TODO: Implement this method
		length = that.length;

		if (length == 0)
			return;

		Node p = that.first;
		first = new Node(p.phrase, p.weight);

		if (length == 1) {
			first.next = null;
			return;
		}

		Node q = first;

		while(p.next != null) {
			p = p.next;
			q.next = new Node(p.phrase, p.weight);
			q = q.next;
		}
		q.next = null;

	}

	/** 
	 * Replace all of the weights in the nodes with their weight divided
	 * by the length of the list
	 */
	public void scaleWeights() {
		//TODO: Implement this method
		if (length == 0)
			return;

		Node p = first;
		p.weight = p.weight / length;

		if (length == 1)
			return;

		while(p.next != null) {
			p = p.next;
			p.weight = p.weight/length;
		}
	}

	/** 
	 * Find the author of the majority of the K_OF_K_NEAREST_NEIGHBORS documents 
	 * that are closest to phrase
	 * 
	 * The running time of this algorithm should be O(n log n), where n is
	 * the length of the list
	 * 
	 * Note: We will return to this method to discuss ways to speed it up.
	 * 
	 * @param phrase the phrase for which we are predicting the author
	 * 
	 * @return the id of the predicted author
	 */
	public int getTopAuthor(Phrase phrase) {
		Node[] copyOfList = new Node[length-1];

		// TODO: Add below so that it copies the all of the nodes in the 
		//       LinkedList EXCEPT for the node containing phrase

		Node p = first;

		if (p.phrase != phrase)
		    copyOfList[0] = new Node(p.phrase, p.weight);
		else {
			p = p.next;
			copyOfList[0] = new Node (p.phrase, p.weight);
		}

		p = p.next;
		for (int i = 0; i < length - 2; i++) {
			if (p.phrase != phrase) {
				copyOfList[i+1] = new Node(p.phrase, p.weight);
				copyOfList[i].next = copyOfList[i + 1];
			}
			p = p.next;
		}

		// END TODO

		// Note that Arrays.sort runs in O(n log n) time.  We can do better to 
		// find the top documents.
		Arrays.sort(copyOfList);
		
		// Calculate most likely author based on similar documents
		int[] authorVotes = new int[3];
		for (int i = 0; i < K_OF_K_NEAREST_NEIGHBORS; i++) {
			authorVotes[copyOfList[i].phrase.getAuthor()]++;			
		}

		if (authorVotes[0] > authorVotes[1] && authorVotes[0] > authorVotes[2]) 
			return 0;
		else if (authorVotes[1] > authorVotes[2]) 
			return 1;
		else 
			return 2;
	}


	/**
	 * Merge nodes from the parameter list.  The nodes in the merged list should be
	 * sorted by list id in decreasing order. 
	 * 
	 * If the other list contains a node with the same phrase as in this list, 
	 * increase the weight of the node in this list by the weight of the other node.
	 * 
	 * If the other list contains a node with a phrase that does not appear in 
	 * this list, create a new node in this list, which is a copy of the other list's
	 * node (with the exception of the next field.
	 * 
	 * Notes:
	 * - This list and the argument list will have phrases sorted by list id in decreasing
	 * order
	 * 
	 * - This method should run in time that is linear in the length of the two
	 * lists.
	 * 
	 * @param that the other list
	 */
	public void merge(LinkedList that) {
		if (that == null) return;

		// TODO: Complete the implementation of this method for a non-null argument
        boolean inList = false;
        Node p = that.first;

        while(true) {
            if (first == null) {
                addNode(p.phrase, p.weight);
                if (p.next == null) // if last node in that list
                    return;
                p = p.next;
            }
            else {
                Node q = first;
                while (q != null) { // check if already in list
                    if (p.phrase == q.phrase) {
                        q.weight++;
                        inList = true;
                        if (p.next == null) // if last node in that list
                            return;
                        p = p.next;
                        break;
                    }
                    q = q.next;
                }
                q = first;
                if (!inList) { // else add it in appropriate spot
                    while (q.next != null) {
                        if (first.phrase.getId() < p.phrase.getId()) {
                            addNode(p.phrase, p.weight);
                            if (p.next == null) // if last node in that list
                                return;
                            p = p.next;
                        }
                        else if (q.next.phrase.getId() < p.phrase.getId()) {
                            if (p.next == null) { // if last node in that list
                                p.next = q.next;
                                q.next = p;
                                return;
                            }
                            Node temp = p.next;
                            p.next = q.next;
                            q.next = p;
                            p = temp;

                        }
                        q = q.next;
                    }
                }
                inList = false;
            }
        }
	}

	/**
	 * Add a new node to the beginning of the linked list
	 * with the data field equal to phrase, if and only if
	 * there is not already a node with this phrase at the
	 * beginning of the list.  If a node with this phrase
	 * already exists, then add one to the weight of the node.
	 * 
	 * Note that this should run in O(1) time.
	 * 
	 * @param phrase
	 */
	public void addNode(Phrase phrase, double weight) {
		// TODO: Complete the implementation of this method
		if (length == 0) {
			Node newFirst = new Node(phrase, weight);
			first = newFirst;
			first.next = null;
			length++;
			return;
		}

		if (first.phrase == phrase) {
			first.weight++;
			return;
		}

		Node newFirst = new Node(phrase, weight);
		newFirst.next = first;
		first = newFirst;
		length++;
	}

	/**
	 * A node in the linked list
	 *
	 */
	private static class Node implements Comparable<Node>{
		Phrase phrase;
		double weight;
		Node next;

		public Node(Phrase phrase, double weight) {
			this.phrase = phrase;
			this.weight = weight;
		}

		public int compareTo(Node that) {
			if (this.weight < that.weight) return 1;
			if (this.weight > that.weight) return -1;
			return 0;
		}
	}
	
	
	/** 
	 * A small routine to test the code that you are writing
	 * @return
	 */
	static boolean testClass() {
		System.err.println("Creating a small list...");
		LinkedList list1 = new LinkedList();
		Phrase[] phrases = {new Phrase(100,"abc",0), new Phrase(10,"bcd",1),new Phrase(1,"efg",2)};
		list1.addNode(phrases[2], 9.0);
		list1.addNode(phrases[1], 3.0);
		list1.addNode(phrases[0], 27.0);
		if (list1.length != 3) {
			System.err.println("Length not correctly updated after calls to addNode.");
			return false;			
		}
		Node p = list1.first;
		for (int i = 0; i < phrases.length; i++) {
			if (p == null) {
				System.err.println("Missing the node at position " + i + ". Check the addNode method.");
				return false;
			}
			else if (p.phrase != phrases[i]) {
				System.err.println("Wrong phrase found at position " + i + ". Check the addNode method.");
				return false;
			}
			p = p.next;
		}

		System.err.println("Testing copy constructor...");
		LinkedList list2 = new LinkedList(list1);
		Node p1 = list1.first, p2 = list2.first;
		if (list2.length != 3) {
			System.err.println("Length not correctly updated after copy Constructor.");
			return false;			
		}
		for (int i = 0; i < phrases.length; i++) {
			if (p1 == null) {
				System.err.println("The input list changed in call to the copy constructor, and we lost a node.");
				return false;
			}
			if (p2 == null) {
				System.err.println("We are missing the node at position " + i + " in the newly created list.");
				return false;
			}
			if (p1 == p2) {
				System.err.println("The copy constructor is supposed to create copies of nodes, not reuse the existing nodes in the input list.");
				return false;
			}
			if (p1.phrase != p2.phrase) {
				System.err.println("The copy constructor is supposed to reuse the phrase objects in same order as they appear in the input list.");
				return false;
			}
			if (p1.weight != p2.weight) {
				System.err.println("The copy constructor is supposed to copy the weights .");
				return false;
			}
			p1 = p1.next;
			p2 = p2.next;
		}

		System.err.println("Testing the scaleWeights method...");
		list1.scaleWeights();
		if (list1.length != 3) {
			System.err.println("Length not correct after scaleWeights invocation.");
			return false;			
		}
		p1 = list1.first; p2 = list2.first;
		for (int i = 0; i < phrases.length; i++) {
			if (p1.weight * 3!= p2.weight) {
				System.err.println("The scaleWeights method did not change the weights correctly.");
				return false;
			}
			p1 = p1.next;
			p2 = p2.next;
		}

		System.err.println("Testing the merge method...");
		Phrase[] phrases4 = {new Phrase(1001,"bar",0), 
				new Phrase(103,"baz",1),
				new Phrase(100,"abc",2),
				new Phrase(10,"bcd",1),
				new Phrase(1,"efg",2)};
		Phrase[] phrases5 = {new Phrase(2000,"bar",0), 
				phrases4[2],
				phrases4[3],
				new Phrase(5,"qwerty",2)};
		LinkedList list4 = new LinkedList();
		list4.addNode(phrases4[4], 4.0);
		list4.addNode(phrases4[3], 3.0);
		list4.addNode(phrases4[2], 2.0);
		list4.addNode(phrases4[1], 1.0);
		list4.addNode(phrases4[0], 0.5);
		LinkedList list5 = new LinkedList();
		list5.addNode(phrases5[3], 3.0);
		list5.addNode(phrases5[2], 2.0);
		list5.addNode(phrases5[1], 1.0);
		list5.addNode(phrases5[0], 0.5);

		list4.merge(list5);
		if (list4.length != 7) {
			System.err.println("Length not correct after merge.");
			return false;			
		}
		p = list4.first;
		if (p == null || p.phrase != phrases5[0] ||
				p.weight != 0.5) {
			System.err.println("Incorrect first node after merge.");
			return false;
		}
		p = p.next;
		if (p == null || p.phrase != phrases4[0] ||
				p.weight != 0.5) {
			System.err.println("Incorrect second node after merge.");
			return false;
		}
		p = p.next;
		if (p == null || p.phrase != phrases4[1] ||
				p.weight != 1.0) {
			System.err.println("Incorrect third node after merge.");
			return false;
		}
		p = p.next;
		if (p == null || p.phrase != phrases4[2] ||
				p.weight != 3.0) {
			System.err.println("Incorrect fourth node after merge.");
			return false;
		}
		p = p.next;
		if (p == null || p.phrase != phrases4[3] ||
				p.weight != 5.0) {
			System.err.println("Incorrect fifth node after merge.");
			return false;
		}
		p = p.next;
		if (p == null || p.phrase != phrases5[3] ||
				p.weight != 3.0) {
			System.err.println("Incorrect sixth node after merge.");
			return false;
		}
		p = p.next;
		if (p == null || p.phrase != phrases4[4] ||
				p.weight != 4.0) {
			System.err.println("Incorrect seventh node after merge.");
			return false;
		}
		return true;
	}

}