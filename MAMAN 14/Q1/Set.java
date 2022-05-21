
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Set<T> {
    private ArrayList<T> set;


    public Set() {
        this.set = new ArrayList<>();
    }


    public Set(T[] array) {
        set = new ArrayList<>();

        this.set.addAll(Arrays.asList(array));
    }
    /*
    * adds to the set every element in otherSet that doesnt exists already
    *@param otherSet is a generic set
     */

    public void union(Set<T> otherSet){
        for(int i=0;i<otherSet.set.size();i++){
            if(!(this.set.contains(otherSet.set.get(i)))){
                this.set.add(otherSet.set.get(i));
            }

        }
    }

    /*
     * intersecting between 2 sets
     *@param otherSet is a generic set
     */
    public void intersect(Set<T> otherSet){
        for(int i=this.set.size()-1;i>=0;i--){
            if(!otherSet.set.contains(this.set.get(i))){
                this.set.remove(i);
            }

        }
    }
    /*
     * checks if otherSet contains all elements of the set.
     *@param otherSet is a generic set
     */
    public boolean isSubset(Set<T> otherSet) {

        return otherSet.set.containsAll(this.set);

    }
    /*
     * checks if set contains other
     *@param other is a generic element
     */
    public boolean isMember(T other) {

        return this.set.contains(other);

    }
    /*
     * insert element to the set.
     *@param other is a generic element
     */
    public void insert(T other) {

        if(!this.set.contains(other)){
            this.set.add(other);
        }

    }
    /*
     * delete element from the set
     *@param other is a generic element
     */
    public void delete(T other) {

        this.set.remove(other);

    }
    /*
     * iterates the set
     */
    public Iterator<T> iterator(){
        return set.iterator();
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("{");


        for (int i=0;i<this.set.size();i++) {
            sb.append(this.set.get(i));

            if(i!=this.set.size()-1)
                sb.append(", ");


        }
        sb.append("}");
        return sb.toString();
    }




}
