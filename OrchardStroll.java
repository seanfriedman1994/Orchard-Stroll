// Sean Friedman


public class OrchardStroll {

    //determine the largest amount of fruit possible in one run of the trees array
    public static int determineLargestHaul(Tree[] trees)
    {
        int haul; //final haul number
        int[] fruitTally = new int[11]; //int array memoizing fruit types and amounts

        //basket holding the largest amount of fruit
        Basket largeBasket = new Basket(Basket.Fruit.LIME, 0);
        //basket holding the second largest amount of fruit
        Basket smallBasket = new Basket(Basket.Fruit.PEAR, 0);

        //traverse the array of trees and fill baskets: this is O(n)
        int i;
        for(i = 0; i < trees.length; i++)
        {
            fillBaskets(fruitTally, largeBasket, smallBasket, trees[i]);
        }

        //the final haul is the sum of the two largest fruit baskets
        haul = largeBasket.getFruitWeight() + smallBasket.getFruitWeight();

        return haul;
    }

    private static void fillBaskets(int[] fruitTally, Basket largeBasket, Basket smallBasket, Tree currentTree)
    {
        //convert passed in fruit types to integers to use as an index for the array
        int currentTreeFruitType = currentTree.getFruitType().ordinal();
        int largeBasketFruitType = largeBasket.getFruitType().ordinal();

        //add the passed in fruit weight to the running tally at its proper index(fruit type)
        fruitTally[currentTreeFruitType] += currentTree.getFruitWeight();

        //if the tally at the current index holds more fruit than what's in the large basket,
        //replace what's in the large basket with that fruit
        if(fruitTally[currentTreeFruitType] > largeBasket.getFruitWeight())
        {
            //check if the fruits in the basket and current tree tally are the same
            //if not, the large basket fruit must move into the small basket
            if(currentTreeFruitType != largeBasketFruitType)
            {
                //fruit in largest basket moves to smaller basket
                smallBasket.setFruitType(largeBasketFruitType);
                smallBasket.setFruitWeight(largeBasket.getFruitWeight());
            }

            //place new fruit into large basket
            largeBasket.setFruitWeight(fruitTally[currentTreeFruitType]);
            largeBasket.setFruitType(currentTreeFruitType);
        }
        //if the tally's weight falls in-between the large and small basket's respective weights,
        //only replace the small basket with the new fruit
        else if(fruitTally[currentTreeFruitType] > smallBasket.getFruitWeight())
        {
            //place new fruit into small basket
            smallBasket.setFruitWeight(fruitTally[currentTreeFruitType]);
            smallBasket.setFruitType(currentTreeFruitType);
        }
    }


}

//Basket class mimics the Tree class with added setter functions to change which
//fruits and weights are in each basket.
class Basket
{
    private int fruitWeight;
    private Fruit fruitType;
    //maps each integer to a fruit
    private Fruit[] treeFruitToBasketFruit = {Basket.Fruit.LIME, Basket.Fruit.PEAR, Basket.Fruit.MANGO,
    Basket.Fruit.LEMON, Basket.Fruit.APPLE, Basket.Fruit.BANANA, Basket.Fruit.ORANGE, Basket.Fruit.TOMATO,
    Basket.Fruit.CHERRY, Basket.Fruit.STRAWBERRY, Basket.Fruit.WATERMELON};

    public enum Fruit
    {
        LIME,
        PEAR,
        MANGO,
        LEMON,
        APPLE,
        BANANA,
        ORANGE,
        TOMATO,
        CHERRY,
        STRAWBERRY,
        WATERMELON
    }

    // Initialize this tree with a fruit type and fruit weight.
    public Basket(Fruit fruitType, int fruitWeight)
    {
        this.fruitType = fruitType;
        this.fruitWeight = fruitWeight;
    }

    // Get the fruit type for this tree.
    public Fruit getFruitType()
    {
        return fruitType;
    }

    // Get the fruit weight of this tree.
    public int getFruitWeight()
    {
        return fruitWeight;
    }

    //Set the fruit weight in the basket
    public void setFruitWeight(int weight)
    {
        this.fruitWeight = weight;
    }

    //Set the fruit type in the basket(this will take in an integer to be used as an index later)
    public void setFruitType(int type)
    {
        this.fruitType = treeFruitToBasketFruit[type];
    }

}