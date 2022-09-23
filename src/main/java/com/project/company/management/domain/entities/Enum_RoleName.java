package com.project.company.management.domain.entities;

public enum Enum_RoleName {

    Admin(0), Operario(1);

    private int value;

    private Enum_RoleName(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    //Just for testing from some SO answers, but no use
    public void setValue(int value) {
        this.value = value;
    }

    public Enum_RoleName getEventStatusById(int id) {

        Enum_RoleName event = null;

        switch (id) {
            case 0:
                event = Admin;
                break;
            case 1:
                event = Operario;
                break;

            default:
                break;
        }
        return event;
    }

}
