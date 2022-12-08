
package DSA;
import java.util.*;//using vector, hashmap, scanner
import java.io.*;//using the file, filewriter.


public class unique_words_in_text_file {

   
    public static void main(String[] args) {
        LinkedHashMap <String,Integer> mp=new LinkedHashMap<>();
        Vector <String>v=new Vector();
        Vector <String>ans=new Vector();
         
             
        try{
            //Creating txt file and writing to it
            File obj=new File("data.txt");
            if(obj.createNewFile()){
                System.out.println("file created");
            }
            else{
                System.out.println("already Exists");
            }
            FileWriter mywrite=new FileWriter("data.txt",false);//append true
            mywrite.write("Hello i am bishal this is how i make my file.i can make a java program.");
            mywrite.close();
            System.out.println("Successfully wrote to the file.");
            //reads the file
            Scanner reader=new Scanner(obj);
            
            
            //gets every line and splits with " " or "." then adds to array
            while(reader.hasNextLine()){
                  String []arr=reader.nextLine().split("[ .-]");//multiple delimiters use the characters and then - within []
                  for(int i=0;i<arr.length;i++){
                      //every element of the current array is added to the vector
                      v.add(arr[i]);
                      //at last the vector will contain all the words in the text file
                  }
            }
            
            
            //adds key as word and value as freq of word 
            for(String word:v){
                int count=mp.containsKey(word)?mp.get(word):0;
                mp.put(word, count+1);
                
            }
            
            
            //iterate over the Linked hash map
            mp.forEach((key,value)->
            {
                if(value==1)
                    //adding the word with freq as 1 to a new vector ans
                    ans.add(key);
                    //at last ans vector will have only the unique words
            }
            );
            
            
            //prints the elements of ans vector
            for(String i:ans)
                System.out.print(i+"\t");
            System.out.println();   
        }
        
        catch(IOException e){
            System.out.println(e);
        }
        
    }
    
}
