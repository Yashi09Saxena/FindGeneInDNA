
/**
 * Write a description of Part1 here.
 * Find the valid Genes in a Dna Strand.
 * @author (Yashi Saxena) 
 * @version (23/072020)
 */
public class Part1 {
  public int findStopCodon(String dna, int StartIndex, String StopCodon)
  {
      int currIndex = dna.indexOf(StopCodon, StartIndex+3);
      while(currIndex!=-1)
      {
          int dff= currIndex-StartIndex;
          if(dff%3==0)
          {
              return currIndex;
          }
          else{
             currIndex = dna.indexOf(StopCodon, currIndex+1);
            }
        }
        return dna.length();   
    }
   public String findGene(String dna, int where)
   {
       int StartIndex= dna.indexOf("ATG",where);
       if(StartIndex==-1)
       {
           
           return "";
        }
        int taaIndex= findStopCodon(dna, StartIndex, "TAA");
        int tagIndex= findStopCodon(dna, StartIndex, "TAG");
        int tgaIndex= findStopCodon(dna, StartIndex, "TGA");
        int minIndex=0;
        if(taaIndex==-1||(tgaIndex!=-1&&tgaIndex<taaIndex))
        {
           minIndex=tgaIndex;
        }
        else
        {
            minIndex=taaIndex;
        }
        if(minIndex==-1||(tagIndex!=-1&&tagIndex<minIndex))
        {
           minIndex=tagIndex;
        }
        if(minIndex==-1||minIndex==dna.length())
        {
            return "";
        }
        return  dna.substring(StartIndex, minIndex+3);
    }
    public void printAllGenes(String dna)
    {
        int StartIndex=0;
        while(true){
            String currGene =findGene(dna,StartIndex);
            if(currGene.isEmpty())
            {
                break;
            }
            System.out.println(currGene);
            StartIndex= dna.indexOf(currGene,StartIndex)+currGene.length();
        }
    }
    public void test()
    {
       teston("ATCGTATAA");
       teston("ATGCTGTATGATTGACGTAA");
       teston("ATGCTATAGTGACTCTAA");
       teston("ATGCGTTCTAA");
       teston("");
        
       
    }
     public void teston(String dna)
    {
       System.out.println("Testing on this " +dna); 
       printAllGenes(dna);
    }
}
