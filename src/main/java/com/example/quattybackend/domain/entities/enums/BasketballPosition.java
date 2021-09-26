package com.example.quattybackend.domain.entities.enums;

public enum BasketballPosition {
    PG(1), SG(2), SF(3), PF(4), C(5);
    private final int code;

    private BasketballPosition(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static BasketballPosition valueOf(int code){
        for (BasketballPosition position: BasketballPosition.values()
             ) {
            if (position.getCode() == code){
                return position;
            }
        }throw new IllegalArgumentException("Invalid position code");
    }
}
