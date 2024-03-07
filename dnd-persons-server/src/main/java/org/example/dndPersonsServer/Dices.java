package org.example.dndPersonsServer;

public enum Dices {
    D20(20),
    D12(12),
    D10(10),
    D8(8),
    D6(6),
    D4(4);

    private int max;

    Dices(int max) {
        this.max = max;
    }

    public int roll(){
        return (int) ((Math.random())*max+1);
    }
}
