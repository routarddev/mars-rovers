package model;

/**
 * Created by routarddev on 7/08/18.
 */
public enum Instruction {

    LEFT("L"),
    RIGHT("R"),
    MOVE("M")
    ;

    private final String instructionCode;

    Instruction(String instructionCode) {
        this.instructionCode = instructionCode;
    }
}
