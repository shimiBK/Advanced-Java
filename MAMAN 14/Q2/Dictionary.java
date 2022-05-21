

import java.io.Serializable;
import java.util.TreeMap;

public class Dictionary implements Serializable {
    private TreeMap<String, String> dictionary = new TreeMap<String, String>();


    /*
    * gets a dictionary and replaces it with the old one , main purpose is the load option
    * @param dictionary is the new Dictionary
     */
    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary.getDictionary();
    }

    /*
     * returns the dictionary
     */
    public TreeMap<String,String> getDictionary(){
        return dictionary;
    }

    /*
     * adds word to the dictionary , word or definition cannot be empty
     * @param word is the word
     * @param definition is the definition of the word
     */
    public void add(String word , String definition) throws Exception {
        if(dictionary.containsKey(word)){
            throw new Exception("This Word Already Exists");
        }
        else if(word.length() < 1 || definition.length() < 1) {
            throw new Exception("Word Or Definition cannot be empty");
        }
        else{
            dictionary.put(word,definition);

        }
    }
    /*
     * updates a word definition
     * @param word is the word
     * @param newDefinition is the definition to update
     */

    public void update(String word, String newDefinition) throws Exception {
        if(!dictionary.containsKey(word)){
            throw new Exception(word + "Doesnt Exist");
        }
        else{
            dictionary.put(word, newDefinition);
        }

    }
    /*
     * deletes a word from the
     * @param word is the word
     * @param newDefinition is the definition to update
     */

    public void delete(String word) throws Exception{
        if(!dictionary.containsKey(word)){
            throw new Exception(word + "Doesnt Exist");
        }
        else{
            dictionary.remove(word);
        }

    }
    /*
     * search a specific word in the dictionary
     * @param word is the word to search
     * @returns TreeMap dictionary if it doesn't exist
     * @returns TreeMap with the word if it does exists
     */


    public TreeMap<String, String> search(String word){
        if (!dictionary.containsKey(word)) {
            return new TreeMap<String,String>();
        }
        return new TreeMap<String, String>() {{put(word, dictionary.get(word));}};
    }






}
