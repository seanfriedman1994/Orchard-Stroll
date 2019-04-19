// Written by Tiger Sachse.
// Part of OrchardStroll.

// A tree class that holds fruit.
class Tree {
    private int fruitWeight;
    private Fruit fruitType;

    public enum Fruit {
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
    public Tree(Fruit fruitType, int fruitWeight) {
        this.fruitType = fruitType;
        this.fruitWeight = fruitWeight;
    }

    // Get the fruit type for this tree.
    public Fruit getFruitType() {
        return fruitType;
    }

    // Get the fruit weight of this tree.
    public int getFruitWeight() {
        return fruitWeight;
    }
    
    // Return a string representation of this tree.
    @Override
    public String toString() {
        return String.format(
            "Tree of type '%s' with a total weight of %d",
            fruitType.toString(),
            fruitWeight
        ); 
    }
}
