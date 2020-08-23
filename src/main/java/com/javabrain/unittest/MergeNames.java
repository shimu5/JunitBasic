package com.javabrain.unittest;

import java.util.HashSet;
import java.util.Set;

public class MergeNames {
    
	public static String[] uniqueNames(String[] names1, String[] names2) {
        Set<String> hash_Set = new HashSet<String>();
        
       for(String name: names1 ){
            hash_Set.add(name);
       }
        
       for(String name: names2 ){
            hash_Set.add(name);
       }
        
        return (String[]) hash_Set.toArray();
        
      //  throw new UnsupportedOperationException("Waiting to be implemented.");
    }
    
    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        
        System.out.println(MergeNames.uniqueNames(names1, names2));
        //System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}