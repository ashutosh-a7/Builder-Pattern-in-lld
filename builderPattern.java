import java.io.*;

class Cake{
  private final double sugar;
  private final double butter;
  private final int eggs;
  private final int vanilla;
  private final double flour;
  private final double bakingPowder;  
  private final double milk;  
  private final int cherry;

    private Cake(cakeBuilder cakeBuilderObj)
    {
      this.flour = cakeBuilderObj.flour;
      this.bakingPowder = cakeBuilderObj.bakingPowder;
      this.milk = cakeBuilderObj.milk;
      this.sugar = cakeBuilderObj.sugar;
      this.butter = cakeBuilderObj.butter;
      this.eggs = cakeBuilderObj.eggs;
      this.vanilla = cakeBuilderObj.vanilla;
      this.cherry = cakeBuilderObj.cherry;
    }

   static class cakeBuilder{
            private double sugar;
            private double butter;
            private int eggs;
            private int vanilla;
            private final double flour;
            private final double bakingPowder;  
            private final double milk;  
            private int cherry;

            public cakeBuilder(double flour,double bakingPowder,double milk){         // initializing the madatory ingredients using static inner
                this.flour = flour;                                                   // class constructor
                this.bakingPowder = bakingPowder;
                this.milk = milk;
            }

            cakeBuilder setSugar(double sugar){
                this.sugar = sugar;
                return this;
            }
            cakeBuilder setButter(double butter){
                this.butter = butter;
                return this;
            }
            cakeBuilder setEggs(int eggs){
                this.eggs = eggs;
                return this;
            }
            
            cakeBuilder setCherry(int cherry){
                this.cherry = cherry;
                return this;
            }

            cakeBuilder setVanilla(int vanilla)
            {
                if(this.sugar==0.0){
                    System.out.println("Hey, you must have sugar before vanilla \n");
                    return null;                                                  
                }
                else{
                    this.vanilla = vanilla;
                    return this;
                }
            }
                
            Cake makeMyCake(){
                    Cake cake = new Cake(this);            /// creating instance of main Cake class using only private
                    return cake;                           /// constuctor so that no one will be allowed to do it outside the class
            }
                
    }


    void showCakeIngrdients()
    {
       /* if(this==null){
            System.out.println("Its not valid");
            return;
        }*/
        System.out.println("Your ingrdients are: ");
        System.out.println("Flour: "+this.flour);
        System.out.println("Baking Powder: "+this.bakingPowder);
        System.out.println("Milk : "+this.milk);
        System.out.println("Sugar : "+this.sugar);
    }

}



public class builderPattern {
    public static void main(String[] args)
    {
        System.out.println();
        System.out.println("its a Builder PAttern \n \n");
        Cake cake1 =  new Cake.cakeBuilder(1.25,2.0,3.0)
        .setSugar(2.5)
        .setVanilla(3)
        .setEggs(3)
        .setButter(7.5)
        .setCherry(4)
        .makeMyCake();
        cake1.showCakeIngrdients();
        
        System.out.println();
        Cake cake2 =  new Cake.cakeBuilder(1.25,2.0,3.0)
        .setVanilla(3)
        .setSugar(2.5)
        .setEggs(3)
        .setButter(7.5)
        .setCherry(4)
        .makeMyCake();
        cake2.showCakeIngrdients();
        
        System.out.println();
        
    } 
}
