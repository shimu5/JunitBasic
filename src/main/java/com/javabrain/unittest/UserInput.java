package com.javabrain.unittest;

public class UserInput {

    public static class TextInput{
    	
    	protected String numerstr="";
    	
        void add(char c) {
        	this.numerstr +=c;
        }

		public String getValue() {
			return numerstr;
		}
    }

    public static class NumericInput  extends TextInput{
  
        public void add(char val){    
        	boolean flag = false;
        	try { 
        		Integer.parseInt(String.valueOf(val));
        		flag = true;
            } catch(NumberFormatException e) { 
                System.out.println(String.valueOf(val) + " not a integer");   
            }  
        	if(flag)
        	      this.numerstr+=String.valueOf(val);
        	
        }
        
    	public String getValue() {
    		return this.numerstr;
    	}
    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}
