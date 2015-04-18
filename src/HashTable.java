import java.util.Hashtable;

public class HashTable {
	static int num_entries = 0;
	static int hashtable_size;
	static Hashtable<Integer, String> dictionary;
	static int total_collisions = 0;
	public static String[] flagged = new String[100];
	static int total_flagged = 0;
	static int flagged_sent = 0;
	static int longest_chain = 0;
	static int chain = 0;
	String[] dictionary_array;
	public HashTable(){
		//Constructor for a hash table of default size
		int default_size = 1000;
		Hashtable dictionary = new Hashtable(default_size);
	}
	static boolean Contains(String S) {
		//Returns true if S is in the hash table
		int hash_value = GetHashValue(S);
		int array_index = ArrayIndex(hash_value, hashtable_size);
		while(dictionary.containsKey(array_index)){
			String temp = dictionary.remove(array_index);
			if(S.toLowerCase().equals(temp.toLowerCase())){
				dictionary.put(array_index, temp);
				return true;
			}
			dictionary.put(array_index, temp);
			array_index++;
		}
		return false;
	}
	static void AddFlagged(String S){
		flagged[total_flagged] = S;
		total_flagged++;
	}
	int NumEntries( ) {
		//returns the number of strings stored in the hash table
		return num_entries;
	}
	static String GetFlagged(){
		String flagged_text = null;
		while(total_flagged != flagged_sent ){
			if(flagged_sent == 0) flagged_text =flagged[flagged_sent];
			else if(flagged_sent != 0) flagged_text = flagged_text + " \n" + flagged[flagged_sent];
			flagged_sent++;
		}
		return flagged_text;
	}
	static void Insert (String S) {
		int hash_value = GetHashValue(S);
		num_entries++;
		chain = 0;
		int array_index = ArrayIndex(hash_value, hashtable_size);
		while(dictionary.containsKey(array_index)){
			array_index++;
			total_collisions++;
			chain++;
		}
		if (chain > longest_chain) longest_chain = chain;
		dictionary.put(array_index, S);
	}
	static int ArrayIndex(int hash_value, int hashtable_size) {
		int array_index = hash_value % hashtable_size;
		return array_index;
	}
	static boolean isPrime(int n) {
		if (n%2==0)
		return false; 
		else
			for(int i=3; i*i<=n; i+=2) { 
				if(n%i==0)
				return false; 
			}
	return true; 
	}
	static int GetHashValue(String S) {
		//Returns the hash value for String S
		int length = S.length();
		int hash_value;
		int total_hash = 0;
		int char_number;
		int mult_three = 29791;
		int mult_two = 961;
		int mult_one = 31;
		int mult_zero = 1;
		while(length > 0){
			if(length > 0){
				char_number = GetCharNum(S.charAt(length - 1));
				hash_value = char_number * mult_zero;
				total_hash = total_hash + hash_value;
				length--;
			}
			if(length > 0){
				char_number = GetCharNum(S.charAt(length - 1));
				hash_value = char_number * mult_one;
				total_hash = total_hash + hash_value;
				length--;
			}
			if(length > 0){
				char_number = GetCharNum(S.charAt(length - 1));
				hash_value = char_number * mult_two;
				total_hash = total_hash + hash_value;
				length--;
			}
			if(length > 0){
				char_number = GetCharNum(S.charAt(length - 1));
				hash_value = char_number * mult_three;
				total_hash = total_hash + hash_value;
				length--;
			} 
		}
		return total_hash;
	}
	static int GetCharNum(char l) {
		int value = 0;
		if(l == "a".charAt(0) || l == "A".charAt(0)) value = 2;
		if(l == "b".charAt(0) || l == "B".charAt(0)) value = 15;
		if(l == "c".charAt(0) || l == "C".charAt(0)) value = 9;
		if(l == "d".charAt(0) || l == "D".charAt(0)) value = 8;
		if(l == "e".charAt(0) || l == "E".charAt(0)) value = 7;
		if(l == "f".charAt(0) || l == "F".charAt(0)) value = 11;
		if(l == "g".charAt(0) || l == "G".charAt(0)) value = 14;
		if(l == "h".charAt(0) || l == "H".charAt(0)) value = 17;
		if(l == "i".charAt(0) || l == "I".charAt(0)) value = 23;
		if(l == "j".charAt(0) || l == "J".charAt(0)) value = 20;
		if(l == "k".charAt(0) || l == "K".charAt(0)) value = 22;
		if(l == "l".charAt(0) || l == "L".charAt(0)) value = 25;
		if(l == "m".charAt(0) || l == "M".charAt(0)) value = 21;
		if(l == "n".charAt(0) || l == "N".charAt(0)) value = 16;
		if(l == "o".charAt(0) || l == "O".charAt(0)) value = 24;
		if(l == "p".charAt(0) || l == "P".charAt(0)) value = 27;
		if(l == "q".charAt(0) || l == "Q".charAt(0)) value = 1;
		if(l == "r".charAt(0) || l == "R".charAt(0)) value = 12;
		if(l == "s".charAt(0) || l == "S".charAt(0)) value = 5;
		if(l == "t".charAt(0) || l == "T".charAt(0)) value = 13;
		if(l == "u".charAt(0) || l == "U".charAt(0)) value = 19;
		if(l == "v".charAt(0) || l == "V".charAt(0)) value = 10;
		if(l == "w".charAt(0) || l == "W".charAt(0)) value = 6;
		if(l == "x".charAt(0) || l == "X".charAt(0)) value = 4;
		if(l == "y".charAt(0) || l == "Y".charAt(0)) value = 18;
		if(l == "z".charAt(0) || l == "Z".charAt(0)) value = 3;
		if(l == "'".charAt(0)) value = 28;
		if(l == ".".charAt(0)) value = 26;
		if(l == "-".charAt(0)) value = 29;
		return value;
	}
	public static void HashTable(int n) {
		//Constructor for a hash table of size n
		n = 3 * n;
		while(isPrime(n) == false){
			n++;
		}
		hashtable_size = n;
		dictionary = new Hashtable<Integer, String>(n);
		return;
	}
}
