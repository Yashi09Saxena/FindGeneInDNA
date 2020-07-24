
/**
 * Write a description of Part2 here.
 * Find the occurance of stringa in stringb.
 * @author (Yashi Saxena) 
 * @version (23/072020)
 */
public class Part2 {
   public int HowMany(String stringa,String stringb){
      int count = 0;
      int aindex= stringb.indexOf(stringa);
      if(aindex==-1)
      {
          System.out.println("Not found");
      }
      while(aindex!=-1)
      {
         count= count+1;
         aindex= stringb.indexOf(stringa,aindex+stringa.length());
        }
      return count;
    }
    
   public void TestHowMany(){
      int result;
      result = HowMany("GAA","ATGAACGAATTGAATC");
      System.out.println("The occrances are " +result);
      
      result = HowMany("AA","ATGAACGAATTGATC");
      System.out.println("The occrances are "+result);
      
      result = HowMany("AA","AAAAAA");
      System.out.println("The occrances are "+result);
    } 
}
